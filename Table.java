/*n 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bjfx;

/**
 *static has one copy in memory
 * final variable is made before the constructor or class is created
 * @author Felix
 */

 
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.text.*;
import javafx.scene.Parent;
import bjfx.Main.MainFrame;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;


public class Table extends Parent {
    private static final MainFrame mainFrame = Main.getMainFrame();
    private double wager;
    private String wagerStr;
    private int tableState;
    private Card cDeck ;
    private Group group;
    private Button bet ; 
    private TextField betField;
    private Canvas c ;
    private Canvas c2;
    private  int numOfCardsDealt = 0;
    private int dNumOfCards = 3;
    private  int  cardsDealt []  ;
    // X increases by 17 each card;
    private int dPosXy [] = {Config.SCREEN_WIDTH / 2 - 140,Config.SCREEN_HEIGHT / 2 - 260};
    private int pPosXy [] = {Config.SCREEN_WIDTH / 2 - 140,Config.SCREEN_HEIGHT / 2 + 60};
    Table(int state){
        done = false;
        cDeck = new Card();
        c = new Canvas(cDeck.canvas.getWidth(),cDeck.canvas.getHeight());
    c2 = new Canvas(cDeck.canvas.getWidth(),cDeck.canvas.getHeight());
     // c = new Canvas(cDeck.canvas.getWidth(),cDeck.canvas.getHeight());
         cardsDealt = new int [30]; // was cDeck.totalCards
        group = new Group();
        getChildren().add(group);
        if(mainFrame.getBetAgain()){
            mainFrame.decreaseStack();
            state = 2;
            System.out.println("new State in initTable");
        }
        initTable( state);
    }
     
    // Determine if the user requires a bet or not and set the table as required by state
    private  void initTable(int state)
    { 
        
        if( state < 2){
        setupTable(); 
        System.out.println("setupTable");
        
        }
        else if(state > 1) {   
           
        System.out.println("deal");   
           deal();
           payInsurance();
           play();
        }
    }
    private double pStack= 0;
    private int pTotal = 0;
    private String strPstack = "";
    private String strPtotal = "";
    private int dTotal = 0;
    private String strDtotal = "";
    private int pSoftTotal = 10;
    private String strPsoftTotal = "";
    private int dSoftTotal = 10;
    private String strDsoftTotal = "";  
    private Boolean pIsSoft = false;
    private Boolean pWentOverSoft = false;
    private Boolean pIsStay = false;
    private Boolean pIsDbl = false;
    private Boolean dIsSoft = false;
    private Boolean done ;
    private Boolean newGame = false;
    // font and text
    private Text textPstack= new Text();
    private Text  textPtotal = new Text();
    private Text  textPsoft = new Text();
    private Text  textDtotal = new Text();
    private Text  textDsoft = new Text();
  
    /*Calculate the players hand*/
    public int calcPhand()
    {
        int total = 0;
        
       
        int pLength = numOfCardsDealt - 2;
        for(int i = 0; i < pLength; i++){
            total = total + playerCards[i].value;
            if(playerCards[i].value == 1){
                for(int ii = 0; ii < pLength; ii++){
                    pSoftTotal = pSoftTotal + playerCards[ii].value;
                }
                pIsSoft = true;
                pWentOverSoft = true;
            }
            
        }
        System.out.println("length: " + playerCards.length);
        System.out.println("softTotal: "+ pSoftTotal);    
        System.out.println("total: " + total);
        return total;
    }
    /*Calculate the dealer's cards*/
    public int calcDhand()
    {
        int total = 0;
        
        int dLength = dNumOfCards ;
        for(int i = 1; i < dLength; i++){
            total = total + dealerCards[i].value; 
        }
        if(dealerCards[1].value == 1 || dealerCards[2].value == 1){
                dSoftTotal = 10;
                for(int ii = 1; ii < dLength; ii++){
                    dSoftTotal = dSoftTotal + dealerCards[ii].value;
                } 
                dIsSoft = true;
                dWentOverSoft = true;
            }
        System.out.println("Dealer's length: " + playerCards.length);
        System.out.println("Dealers softTotal: "+ dSoftTotal);    
        System.out.println("dealer's total: " + total);
        return total;
    }
    
    private   java.util.Random RANDOM = new java.util.Random(); // was static final
    // Returns random integer number from 0 to max for the player
    private  int random(int max) {
        // cardsDealt = new int[numOfCardsDealt];
        int i = RANDOM.nextInt(max) ;
        if(cardsDealt != null){
        for(int f = 0; f < numOfCardsDealt; f++){
            int h = cardsDealt[f];
                if (i == h ){
                    System.out.println("recursion i" + i +"h" + h);
                   return  random(cDeck.randomMax);
                }
            }
        }
        cardsDealt[numOfCardsDealt] = i;
        numOfCardsDealt = numOfCardsDealt + 1;
        System.out.println("Random: "+i);
        System.out.println("Cards Dealt "+numOfCardsDealt);
        return i;
    }
    // Returns random integer number from 0 to max for the dealer
    private  int randomD(int max) {
        int i = RANDOM.nextInt(max) ;
        if(cardsDealt != null){
        for(int f = 0; f < numOfCardsDealt; f++){
            int h = cardsDealt[f];
                if (i == h ){
                    System.out.println("recursion i" + i +"h" + h);
                   return  randomD(cDeck.randomMax);
                }
            }
        }
        cardsDealt[numOfCardsDealt] = i;
        numOfCardsDealt = numOfCardsDealt + 1;
        dNumOfCards = dNumOfCards + 1;
        System.out.println("Random: "+i);
        System.out.println("Cards Dealt "+numOfCardsDealt);
        return i;
    }
    // Setup the table for bet input
    private  void setupTable()
    {
        updateStack();
        betField = new TextField();
        betField.setPrefSize(50, 50);
        betField.setTranslateX(Config.SCREEN_WIDTH / 2 - 50);
        betField.setTranslateY(Config.SCREEN_HEIGHT / 2);
        bet = new Button("Bet");
        bet.setPrefSize(50,50);
        bet.setTranslateX(Config.SCREEN_WIDTH / 2);
        bet.setTranslateY(Config.SCREEN_HEIGHT / 2);
        bet.setOnAction(new EventHandler<ActionEvent>(){
      @Override
      public void handle(ActionEvent e){
         wagerStr = betField.getText();
        System.out.println(wagerStr);  
        try{
           wager = Double.parseDouble(wagerStr);
           mainFrame.setBet(wager);
           mainFrame.decreaseStack();
           textPstack.setVisible(false);
           group.getChildren().remove(textPstack);
           betField.setVisible(false);
           bet.setVisible(false);
           mainFrame.changeState(2);
        }
        catch(NumberFormatException nf){
            betField.clear();
        }                                        
        }                                                      
      });
        
        group.getChildren().addAll(bet, betField);
        
        
    }
    private int handIndex;
    private int playerHand, dealerHand;
    Card currentCard = new Card() ;
    private Card playerCards [] = new Card [25];
    private Card dealerCards [] = new Card [25];
    
    // Deal first two cards
    private void deal()
    {
        
        dealerCards[0] = cDeck.deck[cDeck.randomMax];
        // Assign random element numbers of deck to player and dealer arrays
        for (int i =0; i < 2; i++ ){
            handIndex = random(cDeck.randomMax);
            currentCard = cDeck.deck[handIndex];
            playerCards[i] = currentCard;
        }
        for(int i =1; i<3; i++){
            handIndex = random(cDeck.randomMax);
            currentCard = cDeck.deck[handIndex];
            dealerCards[i] = currentCard;
        }
        // Test for null if null reassign card until not null.
        for(int i = 0; i < 2; i++){
        if(playerCards[i] == null){
            System.out.println("Null player: " + i); 
            deal();
        }
        }
        for(int i = 0; i < 3; i++){
        if(dealerCards[i] == null){
            System.out.println("Null dealer: " + i);
            deal();
        }
        }
        // Set the x and y coordinates for the cards
        for(int i = 0; i < 2; i++){
            int incX = 17 * i;
            playerCards[i].canvas.setTranslateX(pPosXy[0]+incX);
            playerCards[i].canvas.setTranslateY(pPosXy[1]);
        }
        for(int i = 0; i < 2; i++){
            int incX = 17 * i;
            dealerCards[i].canvas.setTranslateX(dPosXy[0]+incX);
            dealerCards[i].canvas.setTranslateY(dPosXy[1]);
        }
        // show stack
        updateStack();
        // Calculate and show hand amount with text onscreen
        //Hardtotal
        hardTotal();
        //Up Card
        upCard();
        // SoftTotal
        softTotal();
        // TopCards
        firstTwo();
    }
    // show first Two Cards
    private void firstTwo()
    {
        for(int i = 0; i < 2; i++){
     group.getChildren().addAll(playerCards[i].canvas, dealerCards[i].canvas);
     System.out.println("player value: " + playerCards[i].value);
     System.out.println("dealer value: " + dealerCards[i].value);
       }
    }
    // Show soft total
    private void softTotal()
    {
        if(pSoftTotal > 21){
            pIsSoft = false;
            
            group.getChildren().remove(textPsoft);
        }
        if(textPsoft != null){
            group.getChildren().remove(textPsoft);
        }
        if(pIsSoft == true){
     strPsoftTotal = Integer.toString(pSoftTotal);
     textPsoft.setText("  /  " + strPsoftTotal);
     textPsoft.setX(pPosXy[0]+56); // was 58 50
     textPsoft.setY(pPosXy[1]-20);
     textPsoft.setFont(Font.font("Family", 20));
     textPsoft.setFill(Color.WHITE);
     group.getChildren().add(textPsoft);   
     } 
     
    }
    // show up card
    private void upCard()
    {
        dTotal = dealerCards[1].value;
     strDtotal = Integer.toString(dTotal);
     textDtotal.setText(strDtotal);
     textDtotal.setX(dPosXy[0]+90);
     textDtotal.setY(dPosXy[1]+145);
     textDtotal.setFont(Font.font("Family", 20));
     textDtotal.setFill(Color.WHITE);
     group.getChildren().add(textDtotal);
    }
    // show hard total
    private void hardTotal()
    {
        if(textPtotal != null){
            group.getChildren().remove(textPtotal);
        }
     pTotal = calcPhand(); strPtotal = Integer.toString(pTotal);
     textPtotal.setX(pPosXy[0]+40);
     textPtotal.setY(pPosXy[1]-20);
     textPtotal.setText(strPtotal);
     textPtotal.setFont(Font.font("Family", 20));
     textPtotal.setFill(Color.WHITE);   
     group.getChildren().add(textPtotal);
    }
     // show stack
    private void updateStack(){
        if(textPstack != null){
            group.getChildren().remove(textPstack);
        }
     double pStack = mainFrame.getStack();
     strPstack = Double.toString(pStack);
     textPstack.setText("Stack: " + strPstack);
     textPstack.setX(dPosXy[0] - 200);
     textPstack.setY(dPosXy[1]+500);
     textPstack.setFont(Font.font("Family", 20));
     textPstack.setFill(Color.WHITE);
     group.getChildren().add(textPstack);                                                                                                                                 
    }
    
    
    // Test to see if player wants insurance
    private final Text ask = new Text("Would you like Insurance?");
    private final Button yes = new Button("Yes");
    private final Button no = new Button("No");
    private void payInsurance()
    {
        if( dealerCards[1].value == 1 ){
            ask.setX(350);
            ask.setY(300);
            ask.setFont(Font.font("Family", 25));
            ask.setFill(Color.WHITE);
            yes.setTranslateX(360);
            yes.setTranslateY(320);
            yes.setPrefSize(50,50);
            no.setTranslateX(580);
            no.setTranslateY(320);
            no.setPrefSize(50,50);
            group.getChildren().addAll(no,yes,ask);
        }
        yes.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent e){
            mainFrame.setInsurance();
            updateStack();
            group.getChildren().removeAll(no,yes,ask);
        }
    });
        no.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent e){
            group.getChildren().remove(no);
            group.getChildren().remove(yes);
            group.getChildren().remove(ask);
        }
    });
        
    }
    
    // Test to see what options the player has
    private void analyze()
    {
        if(pTotal <12){
            cDeck.setDbl(true);
        }
       if(pTotal <= 20){
           
            cDeck.setHit(true);
            cDeck.setStay(true);
         }
       if(playerCards[0].value == 10 && playerCards[1].value == 1 || playerCards[1].value == 10 && playerCards[0].value == 1){
            cDeck.setBj(true);
        }
        
       if(pTotal > 21){
            cDeck.setBust(true);
            done = true;
        }
    }
 
    // Setup the table to play the game
    private void play()
    {
        analyze();
        playTable();
    }    
    private final Button hitBtn = new Button("Hit");
    private final Button stayBtn = new Button("Stay");
    private final Button dblBtn = new Button("Double");
    // Hit for player
    private void hit(){
            handIndex = random(cDeck.randomMax);
            currentCard = cDeck.deck[handIndex];
            playerCards[numOfCardsDealt - 2] = currentCard; 
            if(pTotal <= 10 && pWentOverSoft){
                pSoftTotal = pSoftTotal + playerCards[numOfCardsDealt - 2].value;
                return;
            }
            if(pTotal <= 10 ){ 
                if(playerCards[numOfCardsDealt - 2].value == 1 ){
                pIsSoft = true;
                pWentOverSoft = true;
                for(int i = 0; i < numOfCardsDealt -3; i++){
                    pSoftTotal = pSoftTotal + playerCards[i].value;
                }
                }
            }
    }
    private Boolean dWentOverSoft  = false;
    // Hit for dealer
    private void hitD(){
        
            handIndex = randomD(cDeck.randomMax);
            currentCard = cDeck.deck[handIndex];
            dealerCards[dNumOfCards - 1] = currentCard; 
            if(dTotal <= 10 && dWentOverSoft){
                dSoftTotal = dSoftTotal + dealerCards[dNumOfCards - 1].value;
                return;
            }
            if(dTotal <= 10 ){
                
                if(dealerCards[dNumOfCards - 1].value == 1 ){
                dIsSoft = true;
                dWentOverSoft = true;
                for(int i = 0; i < dNumOfCards -2; i++){
                    dSoftTotal = dSoftTotal + dealerCards[i].value;
                }
                }
            }
            
            currentCard.canvas.setTranslateX(dPosXy[0] + (17 * (dNumOfCards -1)));
            currentCard.canvas.setTranslateY(dPosXy[1]);
            group.getChildren().add(dealerCards[dNumOfCards - 1].canvas);
            group.getChildren().remove(textDtotal);
            dTotal = calcDhand();
            strDtotal = Integer.toString(dTotal);
            textDtotal.setText(strDtotal);
            group.getChildren().add(textDtotal);
        
            
    }
    // Soft hit for dealer
    private void softDhit()
    {
        
      System.out.println("softDhit() dSoftTotal: " + dSoftTotal);
      
      System.out.println("dIsSoft = " + dIsSoft);
      System.out.println("finish - " + finish);
       
        if(getDsoftTotal() > 17){ 
            setDisSoft(false);
            finish = true;
        }
        if(textDsoft != null){
            group.getChildren().remove(textDsoft);
        }
        if(getDisSoft()){
            handIndex = randomD(cDeck.randomMax);
            currentCard = cDeck.deck[handIndex];
            dealerCards[dNumOfCards - 1] = currentCard; 
            currentCard.canvas.setTranslateX(dPosXy[0] + (17 * (dNumOfCards -1)));
            currentCard.canvas.setTranslateY(dPosXy[1]);
            group.getChildren().add(dealerCards[dNumOfCards - 1].canvas);
            dTotal = calcDhand();  
            strDsoftTotal = Integer.toString(dSoftTotal);
            textDsoft.setText("  /  " + strDsoftTotal);
            textDsoft.setX(dPosXy[0]+56); // was 58 50
            textDsoft.setY(dPosXy[1]-20);
            textDsoft.setFont(Font.font("Family", 20));
            textDsoft.setFill(Color.WHITE);
            group.getChildren().add(textDsoft);   
     } 
            
    }
        
    private void updateCount(){
        softTotal();
            pTotal = pTotal + playerCards[numOfCardsDealt - 2].value; 
            strPtotal = Integer.toString(pTotal);
            if(textPtotal != null){
                group.getChildren().remove(textPtotal);
            }
            textPtotal.setX(pPosXy[0]+40);
            textPtotal.setY(pPosXy[1]-20);
            textPtotal.setText(strPtotal);
            textPtotal.setFont(Font.font("Family", 20));
            textPtotal.setFill(Color.WHITE);
            group.getChildren().add(textPtotal);
    }
    private void playTable()
    {
        
                analyze();
        if(cDeck.getStay()){
               
                stayBtn.setTranslateX(Config.SCREEN_WIDTH / 2  +130);
                stayBtn.setTranslateY(Config.SCREEN_HEIGHT / 2 + 200);
                stayBtn.setPrefSize(50,50);
                group.getChildren().add(stayBtn);
            }
        else
            group.getChildren().remove(stayBtn);
        if(cDeck.getHit()){
            hitBtn.setPrefSize(50, 50);
            hitBtn.setTranslateX(Config.SCREEN_WIDTH / 2  +330); // 330 - 150
            hitBtn.setTranslateY(Config.SCREEN_HEIGHT / 2 + 200); // 560
            group.getChildren().add(hitBtn);
        }
        else
            group.getChildren().remove(hitBtn);
        if(cDeck.getDbl()){
            dblBtn.setPrefSize(50, 50);
            dblBtn.setTranslateX(Config.SCREEN_WIDTH / 2  +30);
            dblBtn.setTranslateY(Config.SCREEN_HEIGHT / 2 + 200); // 560
            group.getChildren().add(dblBtn);
        }
        else
            group.getChildren().remove(dblBtn);
        dblBtn.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent e){
            double newStack = mainFrame.getStack();
            newStack = newStack - mainFrame.getBet();
            mainFrame.setStack(newStack);
            double newBet = mainFrame.getBet() * 2 ;
            mainFrame.setBet(newBet);
            updateStack();
            handIndex = random(cDeck.randomMax);
            currentCard = cDeck.deck[handIndex];
            playerCards[numOfCardsDealt - 2] = currentCard;
            currentCard.canvas.setTranslateX(pPosXy[0] + 17 * (numOfCardsDealt - 3));
            currentCard.canvas.setTranslateY(pPosXy[1]);
            updateCount();
            group.getChildren().add(playerCards[numOfCardsDealt - 2].canvas);
            group.getChildren().remove(dblBtn);                                                                      
            done = true;
            if (done){
                flipOver();
                autoDealer();
        }
            else
                analyze();
        }
    }); 
        
        hitBtn.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent e){
            hit();
            currentCard.canvas.setTranslateX(pPosXy[0] + 17 * (numOfCardsDealt - 3));
            currentCard.canvas.setTranslateY(pPosXy[1]);
            pTotal = pTotal + playerCards[numOfCardsDealt - 2].value; 
            strPtotal = Integer.toString(pTotal);
            if(textPtotal != null){
                group.getChildren().remove(textPtotal);
            }
            if(textPsoft != null){
                group.getChildren().remove(textPsoft);
            }
            textPtotal.setX(pPosXy[0]+40);
            textPtotal.setY(pPosXy[1]-20);
            textPtotal.setText(strPtotal);
            textPtotal.setFont(Font.font("Family", 20));
            textPtotal.setFill(Color.WHITE);   
            if(pIsSoft){
                pSoftTotal = pSoftTotal + playerCards[numOfCardsDealt - 2].value;
                strPsoftTotal = Integer.toString(pSoftTotal);
                textPsoft.setText("  /  " + strPsoftTotal);
                textPsoft.setX(pPosXy[0]+56); // was 58 50
                textPsoft.setY(pPosXy[1]-20);
                textPsoft.setFont(Font.font("Family", 20));
                textPsoft.setFill(Color.WHITE);
                group.getChildren().add(textPsoft);
                if(pSoftTotal > 21){
                    group.getChildren().remove(textPsoft);
                    pIsSoft = false;
                    
                }
                System.out.println("Player Went Soft on hit" + strPsoftTotal);
            }
            System.out.println("pSoftTotal- " + pSoftTotal);
            group.getChildren().add(textPtotal);
            group.getChildren().add(playerCards[numOfCardsDealt - 2].canvas);
             analyze();
            if (done){
                flipOver();
                autoDealer();
        }
           System.out.println("Hit: Ptotal: " + pTotal);
        }
         
    }); 
            stayBtn.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent e){
           // done = true;
           if(pSoftTotal < 22 && pWentOverSoft.equals(true) ){
               pTotal = pSoftTotal;
               group.getChildren().remove(textPsoft);
           }
                flipOver();
                autoDealer();
        }
    }); 
            /*
            if (done){
                flipOver();
                autoDealer();
        }
            else
                analyze();
*/
            
           // group.getChildren().addAll(theWinner,end);
    }
    // Flip over the dealer cards and begin the dealers process
    private void flipOver()
    {
        group.getChildren().remove(hitBtn);
        group.getChildren().remove(stayBtn);
        group.getChildren().remove(dblBtn);
        group.getChildren().remove(dealerCards[0].canvas);
        group.getChildren().remove(textDtotal);
        dealerCards[2].canvas.setTranslateX(dPosXy[0]+ (17*2));
        dealerCards[2].canvas.setTranslateY(dPosXy[1]);
        group.getChildren().add(dealerCards[2].canvas);
        dTotal = calcDhand();
        strDtotal = Integer.toString(dTotal);
        textDtotal.setText(strDtotal);
        group.getChildren().add(textDtotal);
        if(dIsSoft){
             group.getChildren().remove(textDsoft);
            strDsoftTotal = Integer.toString(dSoftTotal);
            textDsoft.setText(strDsoftTotal);
            textDsoft.setX(dPosXy[0]+146);
                textDsoft.setY(dPosXy[1]+165);
                textDsoft.setFont(Font.font("Family", 20));
                textDsoft.setFill(Color.WHITE);
            group.getChildren().add(textDsoft);
        }
    }
    // automatically do what the dealer does
    private int dealerState = 0;
    private void autoDeal(int state)
    {
        if(state == 0){
            System.out.println("State = 0 whoWon()");
            return;
            
        }
        if(state == 1){
        if(dSoftTotal <= 17){
            System.out.println("State = 1: dSoftTotal <= 17");
            softDhit();
            autoDeal(dealerState);
        }
        if(dSoftTotal >= 22){
            dIsSoft = false;
            group.getChildren().remove(textDsoft);
           // hitD();
            dealerState = 2;
            System.out.println("State = 1: dSoftTotal >= 22");
            autoDeal(dealerState);
        }
        // problem with bj does not show two counts
        if(dSoftTotal > 17 && dSoftTotal < 22){
            dealerState = 0;
            System.out.println("State = 1: dSoftTotal > 17 && dSoftTotal < 22");
            dTotal = dSoftTotal;
            autoDeal(dealerState);
        }
        }
        if(state == 2){
            if(dTotal < 17){
            System.out.println("State = 2: dTotal < 17");    
            hitD();
            autoDeal(dealerState);
            }
            if(dTotal > 17){
                System.out.println("State = 2: dTotal > 17");
                dealerState = 0;
                autoDeal(dealerState);
            }
        }
        
    }
    private void autoDealer()
    {
        if(dTotal <= 10 && dealerCards[dNumOfCards -1].value == 1 && dIsSoft == false ){
            setDisSoft(true);
        }
        System.out.println("dSoftTotal- " + dSoftTotal);
        if(dIsSoft){
            System.out.println("autoDealer dIsSoft = true");
            dealerState = 1;
            autoDeal(dealerState);
        }
        if(dIsSoft.equals(false)){
            System.out.println("autoDealer dIsSoft = false");
            dealerState = 2;
            if(dTotal < 17){
            autoDeal(dealerState);
            }
            if(dTotal >= 17 ){
                System.out.println("autoDealer dTotal >= 17");
                finish = true;
                dealerState = 0;
                autoDeal(dealerState);
            }
        }
        if(dealerState == 0){
            mainFrame.whoWon(dTotal, pTotal, cDeck.getBj(), dBust, cDeck.getBust(), dPosXy, pPosXy, group);
        }
}
    private boolean finish = false;
    private boolean hitAvailable = false;
    private boolean dBust = false;
    boolean avail = false;
    private boolean isHitAvailable()
    {
        dTotal = calcDhand();
        if(dIsSoft){
            if(dSoftTotal <= 17){
                avail = true;
            }
            if(dSoftTotal > 21){
            dIsSoft = false;
            group.getChildren().remove(textDsoft);
        }
            if(dSoftTotal <= 21 && dSoftTotal >= 18){
                finish = true;
                dTotal = dSoftTotal;
                avail = false;
                group.getChildren().remove(textDtotal);
                return avail;
            }
        }
        if(dTotal < 17){
            avail = true;
        }
        if (dTotal > 16){
            finish = true;
            avail = false;
            if(dTotal > 21){
                dBust = true;
            }
        }
        return avail;
    }
    
    
    /*
    private Text theWinner = new Text();
    private String WINNER = "You Won - $";
    private String LOSER = "You Lost - $";
    private String PUSH = "Push - $";
    private String finalMessage;
    private Button end = new Button("Play Again");
    private void whoWon()
    { 
      double originalBet = mainFrame.getBet();
      System.out.println("Who WOn");
      if(dTotal > 21){
          cDeck.setBustD(true);
      }
      if(pTotal > 21)
          cDeck.setBust(true);
      /*
      if(dSoftTotal > 17){
```````````````````````````````````          if(dSoftTotal < 22){
              finalDtotal = dSoftTotal;
              
          }
      }
      else if(dSoftTotal < 17)
          finalDtotal = dTotal;
      if(pSoftTotal > 1){
          if(pSoftTotal < 22){
              finalPtotal = pSoftTotal;
          }
      }
      else if(pSoftTotal < 1){
          finalPtotal = pTotal;
      }
*/
      /*
      System.out.println("dTotal - " + dTotal);
      System.out.println("ptotal - " + pTotal);
      System.out.println("original bet - " + originalBet);
      System.out.println("getBet() - " + mainFrame.getBet());
      
      
      System.out.println("Dealer bust- " + cDeck.getBustD());
      System.out.println("Player bust- " + cDeck.getBust());
      
      
      String strWager = Double.toString(originalBet * 2);
      // won
      if(cDeck.getBust() != true && pTotal > dTotal || cDeck.getBust() != true && cDeck.getBustD() == true && pTotal < dTotal ){
          finalMessage = WINNER + strWager;
          mainFrame.increaseStack();
          
          theWinner.setX(pPosXy[0]-100);
          theWinner.setY(pPosXy[1]+ 160);
          theWinner.setFont(Font.font("Family", 40));
          theWinner.setFill(Color.WHITE);
          theWinner.setText(finalMessage);
         
          
      }
      // Lost
     else if (dTotal > pTotal){
          finalMessage = LOSER + strWager;
          theWinner.setX(pPosXy[0]-100);
          theWinner.setY(pPosXy[1] + 160);
          theWinner.setFont(Font.font("Family", 30));
          theWinner.setFill(Color.WHITE);
          theWinner.setText(finalMessage);
          
          
      }
      // Push
     else if(pTotal == dTotal){
          finalMessage = PUSH + strWager;
          mainFrame.pushStack();
          theWinner.setX(dPosXy[0]);
          theWinner.setY(dPosXy[1]+ 200);
          theWinner.setFont(Font.font("Family", 40));
          theWinner.setFill(Color.WHITE);
          theWinner.setText(finalMessage);
          
          
      }
      end.setTranslateX(10);
      end.setTranslateY(10);
      end.setPrefSize(50,50);
      
      end.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent e){
            group.getChildren().remove(theWinner);
             mainFrame.changeState(4);
        }
    }); 
      //group.getChildren().add(theWinner);
      
}
    */
    // Delete
    private void autoD()
    {
        // Test to see if hit is avaialable for dealer
        hitAvailable = isHitAvailable();
        // if hit is available for soft or hard: state 1 is soft state 2 is not soft state 0 is no hit available
        
        if(hitAvailable){
            if(dIsSoft){
                dealerState = 1;
                autoState(dealerState);
            }
            else if(dIsSoft == false){
                dealerState = 2;
                autoState(dealerState);
            }
                
        }
        // if no hit is avialable for soft or hard for dealer
        if (hitAvailable == false){
            dealerState = 0;
            autoState(dealerState);
        }
        
    }
    // Delete
    private void autoState(int state)
    {
        
        switch (state){
            case 1:
                softDhit();
                autoD();
                
            case 2:
                hitD();
                autoD();
                
            case 0:
                //whoWon();
                    
        }
        
        
    }                                                                
    
    private void setDsoftTotal(int dSoftTotal){
        this.dSoftTotal = dSoftTotal;
    }
    private int getDsoftTotal(){
        return this.dSoftTotal;
    }
    private boolean getDisSoft(){
        return this.dIsSoft;
    }
    private void setDisSoft(boolean dIsSoft){
        this.dIsSoft = dIsSoft;
    }
    
    
    
    }                                                                             
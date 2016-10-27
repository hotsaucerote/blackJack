/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bjfx;

/**
 *
 * @author Felix
 */


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    private static MainFrame mainFrame;

    public static MainFrame getMainFrame() {
        return mainFrame;
    }
    
    @Override 
    public void start(Stage stage) {
      //System.out.println( "Path: " + getClass().getResource("splashTitle.png").toExternalForm());
     Config c = new Config();
     c.initialize();
        Group root = new Group();
        mainFrame = new MainFrame(root);
        stage.setTitle("BlackJack");
        
        
        
        long totalMem = Runtime.getRuntime().totalMemory();
        long freeMem = Runtime.getRuntime().freeMemory();
        long totFree = totalMem - freeMem;
        long totBytes = totFree/8;
        long totKiloBytes = totBytes/1024;
        long megaBytes = totBytes/1048576;
        long megOtherBytes = totBytes/totKiloBytes;
        System.out.println("free mem" + freeMem);
        System.out.println("total mem" + totalMem);
        System.out.println("tot Free mem" + totFree);
        System.out.println("tot Bjytes" + totBytes);
        System.out.println("tot megaBytes" + megaBytes);
        System.out.println("tot kilobytes" + totKiloBytes); 
        System.out.println("tot megaB ytes" + megOtherBytes);
        
        
        stage.setResizable(false);
        stage.setWidth(Config.SCREEN_WIDTH + 2*Config.WINDOW_BORDER);
        stage.setHeight(Config.SCREEN_HEIGHT+ 2*Config.WINDOW_BORDER + Config.TITLE_BAR_HEIGHT);
        Scene scene = new Scene(root);
        scene.setFill(Color.GREEN);
        stage.setScene(scene);
        mainFrame.changeState(MainFrame.SPLASH);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    public class MainFrame {
        // Instance of scene root node
        private Group root;

        // Instance of splash (if exists)
        private Splash splash;

        // Instance of level (if exists)
        private Table table;

        // Current bet
        private double bet;

        // Current score
        private double stack;
        
        // Bj Winnings
        private final double THREETO2 = 1.5;
        private final double SIXTO5 = 1.2;
        

        private MainFrame(Group root) {
            this.root = root;
        }
        public void setInsurance(){
            double inBet = bet / 2;
            stack = stack - inBet;
        }
        public void getInsuranceWin(){
            double inBet = bet /2 ;
            stack = stack +inBet +(inBet * 2);
        }
        

        public int getState() {
            return state;
        }

        public double getStack() {
            return stack;
        }

        public void setStack(double stack) {
            this.stack = stack;
        }
        public void setBet(double bet){
            this.bet = bet;
        }
        public double getBet() {
            return bet;
        }

        public void increaseStack() {
            stack = stack + (bet*2);
        }
        
        public void increaseBj3to2(){
            double winnings = bet + (bet * THREETO2);
            stack = stack + winnings;
        }
        public void increaseBj6to5(){
            double winnings = bet + (bet * SIXTO5);
            stack = stack + winnings;
        }
        

        public void decreaseStack() {
            stack = stack - bet;
        }
        public void pushStack() {
            stack = stack + bet;
        }

        // Initializes game (bet, stack etc)
        public void startGame() {
            stack = splash.dblBuy;
            bet = 0;
            changeState(1);
        }

        // Current state of the game. The next values are available
        // 0 - Splash
        public static final int SPLASH = 0;
        // 1..Table
        private int state = SPLASH;

        public void changeState(int newState) {
            this.state = newState;
            // Go to splash
         if (state < 1 ){
             splash = null;
                splash = new Splash();
            root.getChildren().add(splash);
         }
         // 1.. go bet setup in table  2.. play the game
         else if(state > 0 && state < 3){
            // if(splash != null){
            System.out.println("The Bet state 1: " + getBet());
             root.getChildren().remove(splash);
             splash = null;
             //}
             table = new Table(state);
             root.getChildren().add(table);
             // 4.. reset the table & put state back to 1
         }else{
             System.out.println("The Bet state 4: " + mainFrame.getBet());
             root.getChildren().remove(table);
             table = null;
             state = 1;
             changeState(state); 
             // Update player class & prepare 
         }
             
            
            /*
            this.state = newState;
            if (splash != null) {
                splash.stop();
            }
            if (level != null) {
                level.stop();
            }
            // Back to spash menu from table
            if (state < 1 || state > LevelData.getLevelsCount()) {
                root.getChildren().remove(level);
                level = null;
                splash = new Splash();
                root.getChildren().add(splash);
                splash.start();
                /// Go into table
            } else {
                root.getChildren().remove(splash);
                splash = null;
                level = new Level(state);
                root.getChildren().add(level);
                level.start();
*/
           // splash = new Splash();
          //  root.getChildren().add(splash);
            }
    private Text theWinner = new Text();
    private String BJ = "Black Jack ";
    private String WINNER = "Win - $";
    private String LOSER = "Lose - $";
    private String PUSH = "Push - $";
    private String finalMessage;
    private Button end = new Button("New Bet");
    private Button reBet= new Button("Rebet");
    private Boolean betAgain = false;
    public Boolean getBetAgain()
    {
        return betAgain;
    }
    public void whoWon(int dTotal, int pTotal,Boolean bjP,  Boolean bustD, Boolean bustP, int [] dPosXy, int [] pPosXy, Group group)
    { 
      double originalBet = mainFrame.getBet();
      System.out.println("Who WOn");
      if(dTotal > 21){
          bustD = true;
      }
      if(pTotal > 21)
          bustP  = true;
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
      System.out.println("dTotal - " + dTotal);
      System.out.println("ptotal - " + pTotal);
      System.out.println("original bet - " + originalBet);
      System.out.println("getBet() - " + mainFrame.getBet()); 
      System.out.println("Dealer bust- " + bustD);
      System.out.println("Player bust- " + bustP); 
      String strWager = Double.toString(originalBet);
      String strWin = Double.toString(originalBet *2);
      String strBj = Double.toString(originalBet + (originalBet * THREETO2));
      // won5 
      if(bjP){
          finalMessage = BJ + WINNER + strBj;
          mainFrame.increaseBj3to2(); 
          theWinner.setX(pPosXy[0]-100);                                                                                                                                                                                                                                                                                         
          theWinner.setY(pPosXy[1]+ 160);
          theWinner.setFont(Font.font("Family", 40));
          theWinner.setFill(Color.WHITE);
          theWinner.setText(finalMessage); 
      }
      else if(bustP.equals(false)&& pTotal > dTotal || bustP.equals(false) && bustD.equals(true) ){
          finalMessage = WINNER + strWin;
          mainFrame.increaseStack(); 
          theWinner.setX(pPosXy[0]-100);
          theWinner.setY(pPosXy[1]+ 160);
          theWinner.setFont(Font.font("Family", 40));
          theWinner.setFill(Color.WHITE);
          theWinner.setText(finalMessage); 
      }
      // Lost
     else if (dTotal > pTotal && bustD.equals(false)){
          finalMessage = LOSER + strWager;
          theWinner.setX(pPosXy[0]-100);
          theWinner.setY(pPosXy[1] + 160);
          theWinner.setFont(Font.font("Family", 30));
          theWinner.setFill(Color.WHITE);
          theWinner.setText(finalMessage); 
      }
     else if (pTotal > dTotal && bustP.equals(true)){
          finalMessage = LOSER + strWager;
          theWinner.setX(pPosXy[0]-100);
          theWinner.setY(pPosXy[1] + 160);
          theWinner.setFont(Font.font("Family", 30));
          theWinner.setFill(Color.WHITE);
          theWinner.setText(finalMessage); 
      }
      // Push
     else if(pTotal == dTotal && bustP.equals(false)){
          finalMessage = PUSH + strWager;
          mainFrame.pushStack();
          theWinner.setX(dPosXy[0]);
          theWinner.setY(dPosXy[1]+ 200);
          theWinner.setFont(Font.font("Family", 40));
          theWinner.setFill(Color.WHITE);
          theWinner.setText(finalMessage); 
      }
      end.setTranslateX(Config.SCREEN_WIDTH / 2  +330); 
      end.setTranslateY(Config.SCREEN_HEIGHT / 2 + 200);
      end.setPrefSize(50,50);
      end.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent e){
            if(betAgain){
            betAgain = false;
            }
            group.getChildren().removeAll(end,reBet,theWinner);
            mainFrame.setBet(0);
            mainFrame.changeState(4);
        }
    });
      reBet.setTranslateX(Config.SCREEN_WIDTH / 2  +130);
      reBet.setTranslateY(Config.SCREEN_HEIGHT / 2 + 200);
      reBet.setPrefSize(50,50);
      reBet.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent e){ 
            group.getChildren().removeAll(end,reBet,theWinner); 
            betAgain = true;
            mainFrame.changeState(4);
        }
    });
      group.getChildren().addAll(end, reBet, theWinner);
}
        }
    }



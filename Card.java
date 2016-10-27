/* FG
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bjfx;

 
import java.util.Objects;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
/**
 *
 * @author Felix
 */
public class Card {
   
public Canvas canvas;   
public String suit ;
public  int value;

private boolean hit = false; 
private boolean stay = false; 
private boolean dbl = false; 
private boolean split = false; 
private boolean insurance = false; 
private boolean bj = false;
private boolean dBj = false;
private boolean bust = false;
private boolean bustDealer = false;
private boolean evenMoney = false;

public boolean getEvenMoney(){
    return evenMoney;
}
public void setEvenMoney(boolean evenMoney){
    this.evenMoney = evenMoney;
}
public boolean getDbJ(){
    return dBj;
}
public void setDbJ(boolean dBj){
    this.dBj = dBj;
}
public boolean getBust(){
    return bust;
}
public boolean getBustD(){
    return bustDealer;
}
public boolean getBj(){
    return bj;
}
public boolean getHit(){
    return hit;
}
public boolean getStay(){
    return stay;
}
public boolean getDbl(){
    return dbl;
}
public boolean getSplit(){
    return split;
}
public boolean getInsurance(){
    return insurance;
}
public void setHit(boolean hit){
    this.hit = hit;
}
public void setStay(boolean stay){
    this.stay = stay;
}
public void setDbl(boolean dbl){
    this.dbl = dbl;
}
public void setSplit(boolean split){
    this.split = split;
}
public void setInsurance(boolean insurance){
    this.insurance = insurance;
}
public void setBj(boolean bj){
    this.bj = bj;
}
public void setBust(boolean bust){
    this.bust = bust;
}
public void setBustD(boolean bustD){
    this.bustDealer = bustD;
}


private static enum cardCord{
    CLUBS2 (0,0),
    DIAMONDS2 (182, 0),
    HEARTS2 (364, 0),
    SPADES2 (546, 0),
    CLUBS3 (728, 0),
    DIAMONDS3 (910, 0),
    HEARTS3 (1092, 0),
    SPADE3 (1274,0),
    CLUBS4 (0,251),
    DIAMONDS4 (182, 251),
    HEARTS4 (364, 251),
    SPADES4 (546, 251),
    CLUBS5 (728, 251),
    DIAMONDS5 (910, 251),
    HEARTS5 (1092, 251),
    SPADES5 (1274,251),
    CLUBS6 (0,502),
    DIAMONDS6 (182, 502),
    HEARTS6 (364, 502),
    SPADES6 (546, 502),
    CLUBS7 (728, 502),
    DIAMONDS7 (910, 502),
    HEARTS7 (1092, 502),
    SPADE7 (1274,502),
    CLUBS8 (0,753),
    DIAMONDS8 (182, 753),
    HEARTS8 (364, 753),
    SPADES8 (546, 753),
    CLUBS9 (728, 753),
    DIAMONDS9 (910, 753),
    HEARTS9 (1092, 753),
    SPADES9 (1274,753),
    CLUBS10 (0,1004),
    DIAMONDS10 (182, 1004),
    HEARTS10 (364, 1004),
    SPADES10 (546, 1004),
    CLUBSA (728, 1004),
    DIAMONDSA (910, 1004),
    HEARTSA (1092, 1004),
    SPADEA (1274,1004),
    CLUBSJ (0,1255),
    DIAMONDSJ (182, 1255),
    HEARTSJ (364, 1255),
    SPADESJ (546, 1255),
    CLUBSK (728, 1255),
    DIAMONDSK (910, 1255),
    HEARTSK (1092, 1255),
    SPADESK (1274,1255),
    CLUBSQ (0,1506),
    DIAMONDSQ (182, 1506),
    HEARTSQ (364, 1506),
    SPADESQ (546, 1506),
    BACKSIDE (728, 1506)
    ;
    
    private final int x, y;
    cardCord(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    private int getX()
    {
        return x;
    }
    private int getY()
    {
        return y;
    }
}



   
    
    /* returns value field*/
    public int getValue()
    {
        return value;
    }
    
     
    //public Card backSide = new Card();
    public Canvas returnCanvas()
    {
        return this.canvas;
    }
    private Card c ;
    private  final int shoe = 1; // 7 ended 299 / 6 - 5 decks / 5 - did 4 decks / 10 - did 8 decks
    public final int totalCards = 52 * shoe;
    public  final int randomMax = totalCards ;
    public final  Card deck [] = new Card[totalCards + 1];
    private final int suits = shoe * 4;
    private  int currentCardAmount = 0;
    
    Card()
    {
         
        
        // init card values      
      String cSuit ;
      String spades = "spades";  
      String clubs = "clubs";
      String diamonds = "diamonds";
      String hearts = "hearts";
      String jack = " jack";
      String queen = " queen";
      String king = " king";
      String backSide = "back";
      int val;
      int y ;
     
      for(y = 1; y <= 14; y++)
      {
          if(y == 1)
          {
              val = y;
              for(int x = 0; x < suits; x++)
              {
                  if (x < suits){
                      val = y;
                      cSuit = hearts;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.HEARTSA.getX(),cardCord.HEARTSA.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      currentCardAmount = currentCardAmount + 1;
                      x++;
                  }
                  if ( x < suits ){
                      cSuit = diamonds;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.DIAMONDSA.getX(),cardCord.DIAMONDSA.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if ( x < suits){
                      cSuit = clubs;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.CLUBSA.getX(),cardCord.CLUBSA.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if (x < suits){
                      cSuit = spades;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.SPADEA.getX(),cardCord.SPADEA.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      currentCardAmount = currentCardAmount + 1;
                      x++;
                      
                  }
              }
          }
          
          if(y == 2)
          {
              val = y;
              for(int x = 0; x < suits; x++)
              {
                  if (x < suits){
                    //  if (currentCardAmount != suits * y)
                    //  {currentCardAmount = adjust;}
                      cSuit = hearts;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.HEARTS2.getX(),cardCord.HEARTS2.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      currentCardAmount = currentCardAmount + 1;
                      x++;
                  }
                  if ( x < suits){
                      cSuit = diamonds;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.DIAMONDS2.getX(),cardCord.DIAMONDS2.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      currentCardAmount = currentCardAmount + 1;
                      x++;
                  }
                  if ( x < suits){
                      cSuit = clubs;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.CLUBS2.getX(),cardCord.CLUBS2.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      currentCardAmount = currentCardAmount + 1;
                      x++;
                  }
                  if (x < suits){
                      cSuit = spades;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.SPADES2.getX(),cardCord.SPADES2.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      currentCardAmount = currentCardAmount + 1;
                   
                      x++;
                  }       
              }
          }
          if(y == 3)
          {
              val = y;
              for(int x = 0; x < suits; x++)
              {
                  if (x < suits ){
                      cSuit = hearts;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.HEARTS3.getX(),cardCord.HEARTS3.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if ( x < suits){
                      cSuit = diamonds;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.DIAMONDS3.getX(),cardCord.DIAMONDS3.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if ( x < suits){
                      cSuit = clubs;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.CLUBS3.getX(),cardCord.CLUBS3.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if (x < suits){
                      cSuit = spades;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.SPADE3.getX(),cardCord.SPADE3.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      currentCardAmount = currentCardAmount + 1;
                      x++;
                      
                  }
                      
              }
          }
          if(y == 4)
          {
              val = y;
              for(int x = 0; x < suits; x++)
              {
                  if (x < suits){
                      cSuit = hearts;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.HEARTS4.getX(),cardCord.HEARTS4.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if ( x < suits ){
                      cSuit = diamonds;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.DIAMONDS4.getX(),cardCord.DIAMONDS4.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if ( x < suits){
                      cSuit = clubs;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.CLUBS4.getX(),cardCord.CLUBS4.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if (x < suits){
                      cSuit = spades;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.SPADES4.getX(),cardCord.SPADES4.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      currentCardAmount = currentCardAmount + 1;
                      x++;
                    
                  }
                      
              }
          }
          
          if(y == 5)
          {
              val = y;
              for(int x = 0; x < suits; x++)
              {
                  if (x < suits){
                      cSuit = hearts;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.HEARTS5.getX(),cardCord.HEARTS5.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if ( x < suits ){
                      cSuit = diamonds;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.DIAMONDS5.getX(),cardCord.DIAMONDS5.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if ( x < suits){
                      cSuit = clubs;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.CLUBS5.getX(),cardCord.CLUBS5.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if (x < suits){
                      cSuit = spades;
                     canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.SPADES5.getX(),cardCord.SPADES5.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      currentCardAmount = currentCardAmount + 1;
                      x++;
                     
                  }
                      
              }
          }
          
          if(y == 6)
          {
              val = y;
              for(int x = 0; x < suits; x++)
              {
                  if (x < suits){
                      cSuit = hearts;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.HEARTS6.getX(),cardCord.HEARTS6.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                   deck [currentCardAmount]  = c;
                   x++;   
                   currentCardAmount = currentCardAmount + 1;
                  }
                  if ( x < suits){
                      cSuit = diamonds;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.DIAMONDS6.getX(),cardCord.DIAMONDS6.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                   x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if ( x < suits){
                      cSuit = clubs;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.CLUBS6.getX(),cardCord.CLUBS6.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if (x < suits){
                      cSuit = spades;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.SPADES6.getX(),cardCord.SPADES6.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                      
              }
          }
          
          if(y == 7)
          {
              val = y;
              for(int x = 0; x < suits; x++)
              {
                  if (x < suits){
                      cSuit = hearts;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.HEARTS7.getX(),cardCord.HEARTS7.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if ( x < suits ){
                      cSuit = diamonds;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.DIAMONDS7.getX(),cardCord.DIAMONDS7.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if ( x < suits){
                      cSuit = clubs;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.CLUBS7.getX(),cardCord.CLUBS7.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if (x < suits){
                      cSuit = spades;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.SPADE7.getX(),cardCord.SPADE7.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                      
              }
          }
          if(y == 8)
          {
              val = y;
              for(int x = 0; x < suits; x++)
              {
                  if (x < suits){
                      cSuit = hearts;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.HEARTS8.getX(),cardCord.HEARTS8.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if ( x < suits ){
                      cSuit = diamonds;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.DIAMONDS8.getX(),cardCord.DIAMONDS8.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if ( x < suits){
                      cSuit = clubs;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.CLUBS8.getX(),cardCord.CLUBS8.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if (x < suits){
                      cSuit = spades;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.SPADES8.getX(),cardCord.SPADES8.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
               x++;
                      deck [currentCardAmount]  = c;
                      currentCardAmount = currentCardAmount + 1;
                  }
                      
              }
          }
          
          if(y == 9)
          {
              val = y;
              for(int x = 0; x < suits; x++)
              {
                  if (x < suits){
                      cSuit = hearts;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.HEARTS9.getX(),cardCord.HEARTS9.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if ( x < suits){
                      cSuit = diamonds;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.DIAMONDS9.getX(),cardCord.DIAMONDS9.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if ( x < suits){
                      cSuit = clubs;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.CLUBS9.getX(),cardCord.CLUBS9.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if (x < suits){
                      cSuit = spades;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.SPADES9.getX(),cardCord.SPADES9.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                      
              }
          }
          
          if(y == 10)
          {
              val = y;
              for(int x = 0; x < suits; x++)
              {
                  if (x < suits){
                      cSuit = hearts;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.HEARTS10.getX(),cardCord.HEARTS10.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if ( x < suits ){
                      cSuit = diamonds;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.DIAMONDS10.getX(),cardCord.DIAMONDS10.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if ( x < suits){
                      cSuit = clubs;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.CLUBS10.getX(),cardCord.CLUBS10.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if (x < suits){
                      cSuit = spades;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.SPADES10.getX(),cardCord.SPADES10.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }           
              }
          }
          if(y == 11)
          {
              val = 10;
              for(int x = 0; x < suits; x++)
              {
                  if (x < suits){
                      cSuit = hearts+jack;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.HEARTSJ.getX(),cardCord.HEARTSJ.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if ( x < suits){
                      cSuit = diamonds+jack;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.DIAMONDSJ.getX(),cardCord.DIAMONDSJ.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if ( x < suits){
                      cSuit = clubs+jack;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.CLUBSJ.getX(),cardCord.CLUBSJ.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if (x < suits){
                      cSuit = spades+jack;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.SPADESJ.getX(),cardCord.SPADESJ.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                      
              }
          }
          
          if(y == 12)
          {
              val = 10;
              for(int x = 0; x < suits; x++)
              {
                  if (x < suits){
                      cSuit = hearts+queen;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.HEARTSQ.getX(),cardCord.HEARTSQ.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if ( x < suits ){
                      cSuit = diamonds+queen;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.DIAMONDSQ.getX(),cardCord.DIAMONDSQ.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if ( x < suits){
                      cSuit = clubs+queen;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.CLUBSQ.getX(),cardCord.CLUBSQ.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if (x < suits){
                      cSuit = spades+queen;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.SPADESQ.getX(),cardCord.SPADESQ.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                      
              }
          }
          if(y == 13)
          {
              val = 10;
              for(int x = 0; x < suits; x++)
              {
                  if (x < suits){
                      cSuit = hearts+king;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.HEARTSK.getX(),cardCord.HEARTSK.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                   x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if ( x < suits ){
                      cSuit = diamonds+king;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.DIAMONDSK.getX(),cardCord.DIAMONDSK.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if ( x < suits){
                      cSuit = clubs+king;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.CLUBSK.getX(),cardCord.CLUBSK.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                  if (x < suits){
                      cSuit = spades+king;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.SPADESK.getX(),cardCord.SPADESK.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      x++;
                      currentCardAmount = currentCardAmount + 1;
                  }
                      
              }
          }
          
          if (y  == 14){
              val = y;
              cSuit = backSide;
                      canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
                      canvas.getGraphicsContext2D().drawImage(Config.getCardImages().get(Config.CARD_IMGS), 
                              cardCord.BACKSIDE.getX(),cardCord.BACKSIDE.getY(),
                              Config.SOURCE_CARD_WIDTH, Config.SOURCE_CARD_HEIGHT,
                              0,0,Config.DESTINATION_CARD_WIDTH, Config.DESTINATION_CARD_HEIGHT);
                      c = new Card(cSuit, val, canvas);
                      deck [currentCardAmount]  = c;
                      currentCardAmount = currentCardAmount + 1;
          }

      }
      //currentCardAmount = 0;
    }
    

    Card(String suit, int value, Canvas c)
    {
        
       // this.canvas = Objects.requireNonNull(c);
        this.canvas = c;
        this.suit = suit;
        this.value = value;
    }
    
   
}

 

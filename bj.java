/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bjfx;



import java.util.*;

/**
 *
 * @author Felix
 */
public abstract class bj {
int cardsDealt = 0;
Card [] deck = new Card[52];
boolean input = true ;
/*
// Display a brief description of the game in each child class
    public abstract void displayDescription();

// Display the rules of the current child class game
    public abstract void displayRules();
// Keep the score of the current child class game
    public abstract void keepScore();

  */
// Deal the card from the deck to the player
    public abstract void deal();
// Randomly arranges positions of cards in array
  public final void shuffle(){
      Collections.shuffle(Arrays.asList(deck));
  }
  // set/Get user input to have  a card dealt
  public boolean getInput()
  {
      return input;
  }
  public void setInput(boolean b)
  {
      b = input;
  }
  // Set/Get cards dealt to player
  public void setCardsDealt()
  {
      cardsDealt = cardsDealt + 1;
  }
  public int getCardsDealt()
  {
      return cardsDealt;
  }
  // the user gui to get user input
  public void userGui()
    {
        Card c;
        
        System.out.println("Would you like a card sir?");
        System.out.println("Press 1 for yes or zero for no:");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        boolean b;
        
        if(i == 1){
            input = true;    
            
        }
        else if(i == 0)
        {
            input = false;
        }
        
        
       
    
        
    }
}
    /*
//"Get the game started" - init card values in the deck and shuffle the deck
  public  bj(){
      
   
      // init card values      
      String suit = "";
      String spades = "spades";
      String clubs = "clubs";
      String diamonds = "diamonds";
      String hearts = "hearts";
      int val = 0;
      Card c = new Card(suit, val);
        //Init cards
        
      for(int y = 1; y <= 13; y++)
      {
          
          if(y == 1)
          {
              val = y;
              for(int x = 0; x <= 3; x++)
              {
                  if (x == 0){
                      suit = hearts;
                      c = new Card(suit, val);
                      deck [0] = c;
                  }
                  if ( x == 1 ){
                      suit = diamonds;
                      c = new Card(suit, val);
                      deck [1] = c;
                  }
                  if ( x == 2){
                      suit = clubs;
                      c = new Card(suit, val);
                      deck [2] = c;
                  }
                  if (x == 3){
                      suit = spades;
                      c = new Card(suit, val);
                      deck [3] = c;
                  }
                      
              }
          }
          
          if(y == 2)
          {
              val = y;
              for(int x = 0; x <= 3; x++)
              {
                  if (x == 0){
                      suit = hearts;
                      c = new Card(suit, val);
                      deck [4] = c;
                  }
                  if ( x == 1 ){
                      suit = diamonds;
                      c = new Card(suit, val);
                      deck [5] = c;
                  }
                  if ( x == 2){
                      suit = clubs;
                      c = new Card(suit, val);
                      deck [6] = c;
                  }
                  if (x == 3){
                      suit = spades;
                      c = new Card(suit, val);
                      deck [7] = c;
                  }
                      
              }
          }
          
          if(y == 3)
          {
              val = y;
              for(int x = 0; x <= 3; x++)
              {
                  if (x == 0){
                      suit = hearts;
                      c = new Card(suit, val);
                      deck [8] = c;
                  }
                  if ( x == 1 ){
                      suit = diamonds;
                      c = new Card(suit, val);
                      deck [9] = c;
                  }
                  if ( x == 2){
                      suit = clubs;
                      c = new Card(suit, val);
                      deck [10] = c;
                  }
                  if (x == 3){
                      suit = spades;
                      c = new Card(suit, val);
                      deck [11] = c;
                  }
                      
              }
          }
          
          
          if(y == 4)
          {
              val = y;
              for(int x = 0; x <= 3; x++)
              {
                  if (x == 0){
                      suit = hearts;
                      c = new Card(suit, val);
                      deck [12] = c;
                  }
                  if ( x == 1 ){
                      suit = diamonds;
                      c = new Card(suit, val);
                      deck [13] = c;
                  }
                  if ( x == 2){
                      suit = clubs;
                      c = new Card(suit, val);
                      deck [14] = c;
                  }
                  if (x == 3){
                      suit = spades;
                      c = new Card(suit, val);
                      deck [15] = c;
                  }
                      
              }
          }
          
          if(y == 5)
          {
              val = y;
              for(int x = 0; x <= 3; x++)
              {
                  if (x == 0){
                      suit = hearts;
                      c = new Card(suit, val);
                      deck [16] = c;
                  }
                  if ( x == 1 ){
                      suit = diamonds;
                      c = new Card(suit, val);
                      deck [17] = c;
                  }
                  if ( x == 2){
                      suit = clubs;
                      c = new Card(suit, val);
                      deck [18] = c;
                  }
                  if (x == 3){
                      suit = spades;
                      c = new Card(suit, val);
                      deck [19] = c;
                  }
                      
              }
          }
          
          if(y == 6)
          {
              val = y;
              for(int x = 0; x <= 3; x++)
              {
                  if (x == 0){
                      suit = hearts;
                      c = new Card(suit, val);
                      deck [20] = c;
                  }
                  if ( x == 1 ){
                      suit = diamonds;
                      c = new Card(suit, val);
                      deck [21] = c;
                  }
                  if ( x == 2){
                      suit = clubs;
                      c = new Card(suit, val);
                      deck [22] = c;
                  }
                  if (x == 3){
                      suit = spades;
                      c = new Card(suit, val);
                      deck [23] = c;
                  }
                      
              }
          }
          
          if(y == 7)
          {
              val = y;
              for(int x = 0; x <= 3; x++)
              {
                  if (x == 0){
                      suit = hearts;
                      c = new Card(suit, val);
                      deck [24] = c;
                  }
                  if ( x == 1 ){
                      suit = diamonds;
                      c = new Card(suit, val);
                      deck [25] = c;
                  }
                  if ( x == 2){
                      suit = clubs;
                      c = new Card(suit, val);
                      deck [26] = c;
                  }
                  if (x == 3){
                      suit = spades;
                      c = new Card(suit, val);
                      deck [27] = c;
                  }
                      
              }
          }
          
          if(y == 8)
          {
              val = y;
              for(int x = 0; x <= 3; x++)
              {
                  if (x == 0){
                      suit = hearts;
                      c = new Card(suit, val);
                      deck [28] = c;
                  }
                  if ( x == 1 ){
                      suit = diamonds;
                      c = new Card(suit, val);
                      deck [29] = c;
                  }
                  if ( x == 2){
                      suit = clubs;
                      c = new Card(suit, val);
                      deck [30] = c;
                  }
                  if (x == 3){
                      suit = spades;
                      c = new Card(suit, val);
                      deck [31] = c;
                  }
                      
              }
          }
          
          if(y == 9)
          {
              val = y;
              for(int x = 0; x <= 3; x++)
              {
                  if (x == 0){
                      suit = hearts;
                      c = new Card(suit, val);
                      deck [32] = c;
                  }
                  if ( x == 1 ){
                      suit = diamonds;
                      c = new Card(suit, val);
                      deck [33] = c;
                  }
                  if ( x == 2){
                      suit = clubs;
                      c = new Card(suit, val);
                      deck [34] = c;
                  }
                  if (x == 3){
                      suit = spades;
                      c = new Card(suit, val);
                      deck [35] = c;
                  }
                      
              }
          }
          
          if(y == 10)
          {
              val = y;
              for(int x = 0; x <= 3; x++)
              {
                  if (x == 0){
                      suit = hearts;
                      c = new Card(suit, val);
                      deck [36] = c;
                  }
                  if ( x == 1 ){
                      suit = diamonds;
                      c = new Card(suit, val);
                      deck [37] = c;
                  }
                  if ( x == 2){
                      suit = clubs;
                      c = new Card(suit, val);
                      deck [38] = c;
                  }
                  if (x == 3){
                      suit = spades;
                      c = new Card(suit, val);
                      deck [39] = c;
                  }
                      
              }
          }
          
          if(y == 11)
          {
              val = y;
              for(int x = 0; x <= 3; x++)
              {
                  if (x == 0){
                      suit = hearts;
                      c = new Card(suit, val);
                      deck [40] = c;
                  }
                  if ( x == 1 ){
                      suit = diamonds;
                      c = new Card(suit, val);
                      deck [41] = c;
                  }
                  if ( x == 2){
                      suit = clubs;
                      c = new Card(suit, val);
                      deck [42] = c;
                  }
                  if (x == 3){
                      suit = spades;
                      c = new Card(suit, val);
                      deck [43] = c;
                  }
                      
              }
          }
          
          if(y == 12)
          {
              val = y;
              for(int x = 0; x <= 3; x++)
              {
                  if (x == 0){
                      suit = hearts;
                      c = new Card(suit, val);
                      deck [44] = c;
                  }
                  if ( x == 1 ){
                      suit = diamonds;
                      c = new Card(suit, val);
                      deck [45] = c;
                  }
                  if ( x == 2){
                      suit = clubs;
                      c = new Card(suit, val);
                      deck [46] = c;
                  }
                  if (x == 3){
                      suit = spades;
                      c = new Card(suit, val);
                      deck [47] = c;
                  }
                      
              }
          }
          
          if(y == 13)
          {
              val = y;
              for(int x = 0; x <= 3; x++)
              {
                  if (x == 0){
                      suit = hearts;
                      c = new Card(suit, val);
                      deck [48] = c;
                  }
                  if ( x == 1 ){
                      suit = diamonds;
                      c = new Card(suit, val);
                      deck [49] = c;
                  }
                  if ( x == 2){
                      suit = clubs;
                      c = new Card(suit, val);
                      deck [50] = c;
                  }
                  if (x == 3){
                      suit = spades;
                      c = new Card(suit, val);
                      deck [51] = c;
                  }
                      
              }
          }
      } 
      shuffle();
      
      
  }
  
  

  
}
*/
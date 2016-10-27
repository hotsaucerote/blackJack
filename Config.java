/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bjfx;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.util.Duration;

/**
 *
 * @author Felix
 */
public class Config {
    // Animation
    public static final Duration ANIMATION_TIME = Duration.millis(40);
    // Directories
    public static final String IMAGE_DIR = "images/desktop/";
    // Window sizes and characteristics
    public static final int WINDOW_BORDER = 6;
    public static final int TITLE_BAR_HEIGHT = 19;
    public static final int SCREEN_WIDTH = 960;
    public static final int SCREEN_HEIGHT = 720;
    // card sizes and characteristics
    public static final int CANVAS_WIDTH = 175;
    public static final int CANVAS_HEIGHT = 250;
    public static final double MOVING_CARD_SPEED = 30;
    public static final int DESTINATION_CARD_WIDTH = 81;
    public static final int DESTINATION_CARD_HEIGHT = 121;
    public static final int SOURCE_CARD_WIDTH = 175;
    public static final int SOURCE_CARD_HEIGHT = 245;
    // index of cards to make alligned canvas images with correct card values
    public static final int TWO_CLUBS = 0;
    public static final int TWO_DIAMONDS = 1;
    public static final int TWO_HEARTS = 2;
    public static final int TWO_SPADES = 3;
    public static final int THREE_CLUBS = 4;
    public static final int THREE_DIAMONDS = 5;
    public static final int THREE_HEARTS = 6;
    public static final int THREE_SPADES = 7;
    public static final int FOUR_CLUBS = 8;
    public static final int FOUR_DIAMONDS = 9;
    public static final int FOUR_HEARTS = 10;
    public static final int FOUR_SPADES = 11;
    public static final int FIVE_CLUBS = 12;
    public static final int FIVE_DIAMONDS = 13;
    public static final int FIVE_HEARTS = 14;
    public static final int FIVE_SPADES = 15;
    public static final int SIX_CLUBS = 16;
    public static final int SIX_DIAMONDS = 17;
    public static final int SIX_HEARTS = 18;
    public static final int SIX_SPADES = 19;
    public static final int SEVEN_CLUBS = 20;
    public static final int SEVEN_DIAMONDS = 21;
    public static final int SEVEN_HEARTS = 22;
    public static final int SEVEN_SPADES = 23;
    public static final int EIGHT_CLUBS = 24;
    public static final int EIGHT_DIAMONDS = 25;
    public static final int EIGHT_HEARTS = 26;
    public static final int EIGHT_SPADES = 27;
    public static final int NINE_CLUBS  = 28;
    public static final int NINE_DIAMONDS = 29;
    public static final int NINE_HEARTS = 30;
    public static final int NINE_SPADES = 31;
    public static final int TEN_CLUBS = 32;
    public static final int TEN_DIAMONDS = 33;
    public static final int TEN_HEARTS = 34;
    public static final int TEN_SPADES = 35;
    public static final int ACE_CLUBS = 36;
    public static final int ACE_DIAMONDS = 37;
    public static final int ACE_HEARTS = 38;
    public static final int ACE_SPADES = 39;
    public static final int J_CLUBS = 40;
    public static final int J_DIAMONDS = 41;
    public static final int J_HEARTS = 42;
    public static final int J_SPADES = 43;
    public static final int K_CLUBS = 44;
    public static final int K_DIAMONDS = 45;
    public static final int K_HEARTS = 46;
    public static final int K_SPADES = 47;
    public static final int Q_CLUBS = 48;
    public static final int Q_DIAMONDS = 49;
    public static final int Q_HEARTS = 50;
    public static final int Q_SPADES = 51;
    public static final int BACK_SIDE = 52;
    // file names and sprites for animation
    private static final String CARD_IMG_NAMES [] = new String []{
    "cardSprites.png"
   
    };
    public static final int CARD_IMGS = 0;
    private static final String SPLASH_IMG_NAMES [] = new String []{
        "splashTitle.png"
    };
    public static final int IMG_SPLASH_TITLE = 0;
    private static final String BACKGROUND_IMG_NAMES [] = new String []{
        "background.png"
    };
  
    /*make string [] for multiple image files */
    // screen space for game play
    public static final int FIELD_WIDTH = SCREEN_WIDTH - WINDOW_BORDER;
    public static final int FIELD_HEIGHT = SCREEN_HEIGHT - WINDOW_BORDER;
    public static final int BUTTON_FIELD_WIDTH = FIELD_WIDTH;
    public static final int BUTTON_FIELD_HEIGHT = FIELD_HEIGHT / 4;
    public static final int CARD_FIELD_WIDTH = FIELD_WIDTH;
    public static final int CARD_FIELD_HEIGHT = FIELD_HEIGHT - BUTTON_FIELD_HEIGHT;
    public static final int DEALER_FIELD_WIDTH = FIELD_WIDTH;
    public static final int DEALER_FIELD_HEIGHT = CARD_FIELD_HEIGHT /2;
    public static final int PLAYER_FIELD_WIDTH = DEALER_FIELD_WIDTH;
    public static final int PLAYER_FIELD_HEIGHT = DEALER_FIELD_HEIGHT;
    public static final int BET_TEXT_SPACE = 10;
    // ArrayList of images
    private static ObservableList<Image> CARD_IMAGES = javafx.collections.FXCollections.<Image>observableArrayList();
    public static ObservableList<Image> getCardImages()
    {
        return CARD_IMAGES;
    }
    // ArrayList of images for opening splash screen
    private static ObservableList<Image> SPLASH_IMAGES = javafx.collections.FXCollections.<Image>observableArrayList();
    public static ObservableList<Image> getSplashImages()
    {
        return SPLASH_IMAGES;
    }
    
    public final  void initialize() {
        
         for(String imageName : CARD_IMG_NAMES){
            
           final Image image = new Image(getClass().getResource( IMAGE_DIR +  imageName).toExternalForm());
            if (image.isError()) {
                System.out.println("Image "+imageName+" not found");
            }
        
            CARD_IMAGES.add(image); 
        }

            final Image splashImage = new Image(getClass().getResourceAsStream(IMAGE_DIR + SPLASH_IMG_NAMES[0]));
            if (splashImage.isError()) {
                System.out.println("Image "+SPLASH_IMG_NAMES[0]+" not found");
            }
            SPLASH_IMAGES.add(splashImage);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
    }

    public Config() {                                                  
        //initialize();
    }
    
    
            
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
       
}

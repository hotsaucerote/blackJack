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
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
public class Splash extends Parent{
    
    private ImageView splashTitle;
    private ImageView [] NODES;
    private TextField tf;
    private final Button b;
    private final Button startB;
    public double dblBuy;
    private String buyin;
    private Label lblBuyin;
    private boolean startGame;
    Splash(){
        startGame = false;
        splashTitle = new ImageView();
        splashTitle.setImage(Config.getSplashImages().get(Config.IMG_SPLASH_TITLE));
        splashTitle.setTranslateX(100);
       // splashTitle.setTranslateY(splashTitle.getImage().getHeight());
       // NODES = new ImageView [] {splashTitle};
        lblBuyin = new Label("$0.00");
        lblBuyin.setTranslateX(155);
        lblBuyin.setTranslateY(splashTitle.getImage().getHeight() + 25);
        tf = new TextField();
        tf.setPrefWidth(50);
        b = new Button("Buy In");
        b.setTranslateX( 180);
        b.setTranslateY(splashTitle.getImage().getHeight());
        
        
        startB = new Button("Start Game");
        startB.setVisible(false);
        tf.setTranslateX(130 );
        tf.setTranslateY(splashTitle.getImage().getHeight());
        // Get buyin Amount from user when buyin button pressed
        b.setOnAction(new EventHandler<ActionEvent>(){
      @Override
      public void handle(ActionEvent e){
         buyin = tf.getText();
        System.out.println(buyin);  
        try{
           dblBuy = Double.parseDouble(buyin);
           tf.clear();
           lblBuyin.setText("$"+buyin);
        startB.setTranslateX(150);
        startB.setTranslateY(splashTitle.getImage().getHeight()+50);   
        startB.setVisible(true);
        startGame = true;
        }
        catch(NumberFormatException nf){
            tf.clear();
            lblBuyin.setText("$");
        }
        }
      });
        if(startGame = true){
    startB.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent e){
           Main.getMainFrame().startGame();
}
    });
        }
        Group group = new Group();
        group.getChildren().addAll(tf,b,lblBuyin,startB);
        group.getChildren().add(splashTitle);
        getChildren().add(group);
}
    }
    
    



















package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;


public class FXMLDocumentController implements Initializable {

    @FXML
    private Button menu;
    @FXML
    private AnchorPane navList;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        navList.setItems(FXCollections.observableArrayList("Red","Yellow","Blue"));
        prepareSlideMenuAnimation();
    }

    private void prepareSlideMenuAnimation() {
        Rectangle clip = new Rectangle(200, 200);
        clip.translateYProperty().set(-navList.getTranslateY());
        clip.translateXProperty().set(-navList.getTranslateX());
        clip.setLayoutX(navList.getLayoutX());
        clip.setLayoutY(navList.getLayoutY());
        navList.setClip(clip);

        TranslateTransition openNav=new TranslateTransition(new Duration(350), navList);
        openNav.setToY(0);
        TranslateTransition closeNav=new TranslateTransition(new Duration(350), navList);
        menu.setOnAction((ActionEvent evt)->{
            if(navList.getTranslateY()!=0){
                clip.translateYProperty().set(-navList.getHeight());
                openNav.play();
            }else{
                closeNav.setToY(-(navList.getHeight()));
                clip.translateYProperty().set(navList.getHeight());
                closeNav.play();
            }
        });
    }

}

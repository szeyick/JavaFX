package sample;

/**
 * Created by szeyick on 5/05/2016.
 */

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * The FXMLMenuBar.
 * <p>
 * This class represents the controller for the menu bar. It
 * contains the contents of the menuBar.fxml.
 * </p>
 * <b>Warning: </b>None.
 */
public class FXMLMenuBar implements Initializable {

    /**
     * The dropdown anchor pane
     */
    @FXML
    private AnchorPane dropdown;

    /**
     * The menu button.
     */
    @FXML
    private Button menu;

    /**
     * The timeline animation to move pane down.
     */
    private Timeline timelineDown;

    /**
     * The timeline animation to move pane up.
     */
    private Timeline timelineUp;

    /**
     * Flag to indicate if the panel is up or down.
     */
    private boolean panelVisible;

    /**
     * Initialise the controller.
     * @param location - The location.
     * @param resources - The resources.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initMenuBar();
    }

    /**
     * Initialise the components of the menu bar.
     */
    private void initMenuBar() {
        panelVisible = false;
        timelineDown = new Timeline();
        timelineDown.setCycleCount(1);
        timelineDown.setAutoReverse(true);

        final KeyValue kvDwn2 = new KeyValue(dropdown.translateYProperty(), 50);
        final KeyFrame kfDwn = new KeyFrame(Duration.millis(500), kvDwn2);
        timelineDown.getKeyFrames().add(kfDwn);

        timelineUp = new Timeline();
        timelineUp.setCycleCount(1);
        timelineUp.setAutoReverse(true);

        final KeyValue kvDwn1 = new KeyValue(dropdown.translateYProperty(), -50);
        final KeyFrame kfDwn2 = new KeyFrame(Duration.millis(500), kvDwn1);
        timelineUp.getKeyFrames().add(kfDwn2);

        menu.setOnAction(new EventHandler<ActionEvent>() {

            /**
             * Manage the event.
             * @param event - The user event (button press)
             */
            @Override
            public void handle(ActionEvent event) {
                if (!panelVisible) {
                    timelineDown.play();
                    panelVisible = true;
                }
                else {
                    timelineUp.play();
                    panelVisible = false;
                }

            }
        });
    }
}

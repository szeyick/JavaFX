package com.javaFX.example.helloWorld;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

/**
 * The SampleController.
 * <p>
 * This class is responsible for responding to user
 * input actions.
 * </p>
 * <b>Warning: </b> (IntelliJ) To manage code imports alt + enter.
 */
public class SampleController {

    /**
     * The label with the id hello world as referenced
     * in the sample.fxml
     */
    public Label helloWorld;

    /**
     * The method that matches the onAction defined in the sample.fxml
     * It shows the action (method) that is executed when the button
     * is pressed.
     * @param actionEvent - The user event
     */
    public void sayHelloWorld(ActionEvent actionEvent) {
        helloWorld.setText("Hello World");
    }
}


package com.javaFX.example.helloWorld;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The Main.
 * <p>
 * This class is responsible for being the main entry
 * point into the application.
 * </p>
 * <b>Warning: </b>None.
 */
public class Main extends Application {

    /**
     * The start of the application.
     * @param primaryStage - The stage to display the content onto.
     * @throws Exception if an error occurs.
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    /**
     * The program entry point.
     * @param args - Command line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }
}

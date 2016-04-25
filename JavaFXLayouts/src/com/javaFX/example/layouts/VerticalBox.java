package com.javaFX.example.layouts;/**
 * Created by szeyick on 25/04/2016.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * The VerticalBox.
 * <p>
 * This application class is responsible for displaying the
 * functionality of a VBox.
 * </p>
 * <b>Warning: </b>None.
 */
public class VerticalBox extends Application {

    /**
     * The program main.
     * @param args - command line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Method call when the application is started.
     * @param primaryStage - The stage to display the scene.
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("VBox Layout");
        Group groupNode = new Group();

        Scene scene = new Scene(groupNode, 500, 500, Color.GRAY);
        VBox vbox = new VBox(10); // The spacing between nodes.
        vbox.setPadding(new Insets(1)); // The space between the border and child nodes.

        Rectangle rect1 = new Rectangle(10,10);
        Rectangle rect2 = new Rectangle(20,20);
        Rectangle rect3 = new Rectangle(30,30);

        vbox.getChildren().addAll(rect1, rect2, rect3);

        groupNode.getChildren().add(vbox);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

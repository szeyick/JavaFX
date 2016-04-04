/**
 * Created by szeyick on 2/04/2016.
 */
package com.javaFX.example.nodes;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * The RectangleMain.
 * <p>
 * This class is responsible for drawing a rectangle shape
 * onto the scene. It demonstrates the drawing onto the
 * canvas along with setting a couple of the properties that
 * go with the shape.
 * </p>
 * <b>Warning: </b>None.
 */
public class RectangleMain extends Application {

    /**
     * Method that is called when the application is in ready state.
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Drawing a rectangle");

        Group root = new Group();
        createRectangle(root);
        Scene scene = new Scene(root, 500, 500, Color.GRAY);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Create a rectangle and add it to the root pane.
     * @param root - The root container that holds the graphical components.
     */
    private void createRectangle(Group root) {
        Rectangle rect = new Rectangle();
        rect.setX(50);
        rect.setY(50);
        rect.setWidth(100);
        rect.setHeight(50);
        rect.setArcWidth(10);
        rect.setArcHeight(40);

        root.getChildren().add(rect);
    }

    /**
     * The program main.
     * @param args - Command line arguments.
     */
    public static void main(String[] args)
    {
        launch(args);
    }
}

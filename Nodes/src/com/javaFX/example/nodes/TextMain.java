package com.javaFX.example.nodes;/**
 * Created by szeyick on 23/04/2016.
 */

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

/**
 * The TextMain.
 * <p>
 * This is the application that demonstrates
 * the drawing of text onto the screen using
 * JavaFx.
 * </p>
 * <b>Warning: </b>None.
 */
public class TextMain extends Application {

    /**
     * The program main.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * When the application is started.
     * @param primaryStage - The primary stage.
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing Text");
        Group root = new Group();

        Scene scene = new Scene(root, 300, 250, Color.WHITE);
        Random rand = new Random(System.currentTimeMillis());
        for (int i = 0; i < 100; i++) {
            int x = rand.nextInt((int) scene.getWidth());
            int y = rand.nextInt((int) scene.getHeight());
            int red = rand.nextInt(255);
            int green = rand.nextInt(255);
            int blue = rand.nextInt(255);

            Text text = new Text(x, y, "Hello");
            int rotate = rand.nextInt(360);
            text.setFill(Color.rgb(red, green, blue, 0.99));
            text.setRotate(rotate);
            root.getChildren().add(text);
        }
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

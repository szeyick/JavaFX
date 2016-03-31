package com.javaFX.example.nodes;

/**
 * Created by szeyick on 31/03/2016.
 */

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * The LineMain.
 * <p>
 * This class is responsible for being the program main for
 * the line demo.
 * </p>
 */
public class LineMain extends Application {

    /**
     * The program main.
     * @param args - Command line arguments.
     */
    public static void main(String[] args)
    {
        launch(args);
    }

    /**
     * When the application is ready to start.
     * @param primaryStage - The stage to display our scene.
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing Lines");

        // The component container that will hold our shapes.
        Group root = new Group();

        // Create a scene that is 500x500 and filled with background colour gray.
        Scene scene = new Scene(root, 500, 500, Color.GRAY);

        // Draw a Red Line
        Line redLine = new Line(10, 10, 200, 10);

        // Setting properties for the line.
        redLine.setStroke(Color.RED);
        redLine.setStrokeWidth(10);
        redLine.setStrokeLineCap(StrokeLineCap.BUTT);

        // Create a dashed pattern.
        redLine.getStrokeDashArray().addAll(10d, 5d, 15d, 5d, 20d);
        redLine.setStrokeDashOffset(0);

        // Draw a White Line.
        Line whiteLine = new Line(10, 30, 200, 30);
        whiteLine.setStroke(Color.WHITE);
        whiteLine.setStrokeWidth(10);
        whiteLine.setStrokeLineCap(StrokeLineCap.ROUND);

        // Draw a Blue Line
        Line blueLine = new Line(10, 50, 200, 50);
        blueLine.setStroke(Color.BLUE);
        blueLine.setStrokeWidth(10);

        // Add the lines to the root.
        root.getChildren().add(redLine);
        root.getChildren().add(whiteLine);
        root.getChildren().add(blueLine);

        // Create a slider.
        Slider slider = new Slider(0, 100, 0);
        slider.setLayoutX(10);
        slider.setLayoutY(95);

        // Blind the stroke dash offset property
        redLine.strokeDashOffsetProperty().bind(slider.valueProperty());

        root.getChildren().add(slider);

        Text offsetText = new Text("Stroke Dash Offset: 0.0");
        offsetText.setX(10);
        offsetText.setY(80);
        offsetText.setStroke(Color.WHITE);

        // Display the stroke dash offset value.
        // The below should be a Java 8 Lambda Method.
        slider.valueProperty().addListener((ov, curVal, newVal) -> offsetText.setText("Stroke Dash Offset: " + slider.getValue()));
        root.getChildren().add(offsetText);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

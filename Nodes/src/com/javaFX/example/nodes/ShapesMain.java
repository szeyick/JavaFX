package com.javaFX.example.nodes;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

/**
 * Created by szeyick on 23/04/2016.
 */
public class ShapesMain extends Application {

    /**
     * Method that is called when the application is in ready state.
     * @param primaryStage - The stage where scenes are presented on.
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Drawing shapes");

        Group root = new Group();
        Rectangle rect = createRoundedRectangle();
        CubicCurve cubicCurve = createCubicCurve();
        root.getChildren().add(rect);
        root.getChildren().add(cubicCurve);
        root.getChildren().add(createCone());
        Scene scene = new Scene(root, 500, 500, Color.GRAY);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Create a rounded rectangle.
     * @return the rounded rectangle.
     */
    private Rectangle createRoundedRectangle() {
        Rectangle rect = new Rectangle();
        rect.setX(150);
        rect.setY(50);
        rect.setWidth(100);
        rect.setHeight(130);
        rect.setArcWidth(10);
        rect.setArcHeight(40);
        rect.setFill(Color.WHITE);
        return rect;
    }

    /**
     * Create a cubic curve.
     * @return an initialised cubic curve.
     */
    private CubicCurve createCubicCurve() {
        CubicCurve cubicCurve = new CubicCurve(
                50, // Start X
                75, // Start Y
                80, // Control X1 Point.
                -25, // Control Y1 Point.
                110, // Control X2 Point.
                175, // Control Y2 Point.
                140, // End X Point.
                75); // End Y Point.

        cubicCurve.setStrokeType(StrokeType.CENTERED);
        cubicCurve.setStroke(Color.BLUE);
        cubicCurve.setStrokeWidth(3);
        cubicCurve.setFill(Color.WHITE);

        return cubicCurve;
    }

    /**
     * Create a cone.
     * @return -
     */
    private Path createCone() {
        Path path = new Path();
        path.setStrokeWidth(3);

        MoveTo moveTo = new MoveTo();
        moveTo.setX(50);
        moveTo.setY(150);

        QuadCurveTo quadCurveTo = new QuadCurveTo();
        quadCurveTo.setX(150);
        quadCurveTo.setY(150);
        quadCurveTo.setControlX(100);
        quadCurveTo.setControlY(50);

        LineTo lineTo1 = new LineTo();
        lineTo1.setX(50);
        lineTo1.setY(150);

        LineTo lineTo2 = new LineTo();
        lineTo2.setX(100);
        lineTo2.setY(275);

        LineTo lineTo3 = new LineTo();
        lineTo3.setX(150);
        lineTo3.setY(150);

        path.getElements().addAll(moveTo, quadCurveTo, lineTo1, lineTo2, lineTo3);
        path.setTranslateY(30);

        return path;
    }
}

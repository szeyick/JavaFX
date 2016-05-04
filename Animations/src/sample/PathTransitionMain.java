package sample;/**
 * Created by szeyick on 4/05/2016.
 */

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * The PathTransitionMain.
 * <p>
 * This program demonstrates how to perform an animation along
 * a given path. The important components of this program are the Path
 * object and the PathTransition().
 * </p>
 * <p>
 * The Path() defines the path that the animation will travel on.
 * <br>
 * The PathTransition() performs the actual animation where we pass
 * the node (circle) that we want animated and the path.
 * </p>
 */
public class PathTransitionMain extends Application {

    /**
     * The program main.
     * @param args - Command line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * The method called when application is ready.
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Circle circle = new Circle(20, Color.LIGHTCORAL);
        root.getChildren().add(circle);

        // The path that the shape will travel on.
        Path path = new Path();
        path.getElements().addAll(new MoveTo(50, 50), new HLineTo(350), new MoveTo(350, 50), new VLineTo(400),
                new MoveTo(350, 400), new HLineTo(50));
        path.setFill(null);

        root.getChildren().add(path);

        Scene scene = new Scene(root, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.show();

        PathTransition pt = new PathTransition(Duration.millis(3000), path, circle);
        pt.setCycleCount(Animation.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play();
    }
}

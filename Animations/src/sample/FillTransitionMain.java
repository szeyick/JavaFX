package sample;


import javafx.animation.FillTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.paint.Color;

/**
 * The FillTransitionMain.
 * <p>
 * This class demonstrates how to perform a transition animation on
 * a node. In this instance the node is a Circle. The important class
 * in this example is the FillTransition(...), where we can define the
 * animation to do.
 * </p>
 * <b>Warning: </b>None.
 */
public class FillTransitionMain extends Application {

    /**
     * The method call when application is ready.
     * @param primaryStage - The stage the scene is set to.
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        Circle circle = new Circle(100, 100, 50);
        root.getChildren().add(circle);

        Scene scene = new Scene(root, 200, 200);
        primaryStage.setScene(scene);

        primaryStage.show();

        FillTransition ft = new FillTransition(Duration.millis(3000), circle, Color.RED, Color.BLUE);
        ft.setCycleCount(4);
        ft.setAutoReverse(true);
        ft.play();
    }

    /**
     * The program main.
     * @param args - Command line arguements.
     */
    public static void main(String[] args) {
        launch(args);
    }
}

package sample;/**
 * Created by szeyick on 4/05/2016.
 */

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * The TimeLineAnimationMain.
 * <p>
 * This is a demonstration of the Timeline animation in JavaFX. The
 * definition of a timeline animation is a free roaming animation where
 * we can control individual properties of the node. In this example we are
 * simply moving it along the X-Axis through a KeyValue and KeyFrame pair. If we
 * wanted to add additional animations along the Y-AXis then we could add more
 * KeyValue and KeyFrame pairs.
 * </p>
 * <b>Warning: </b>None.
 */
public class TimeLineAnimationMain extends Application {

    /**
     * The program main.
     * @param args - Command line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * The method called when the application is ready.
     * @param primaryStage - The stage to display the content.
     */
    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle(100, 100, 20);

        VBox vbox = new VBox(30);
        vbox.setPadding(new Insets(25, 25, 25, 25));

        Timeline timeline = new Timeline();

        Text currTimeText = new Text("Current time: 0 secs");
        currTimeText.setBoundsType((TextBoundsType.VISUAL));

        timeline.currentTimeProperty().addListener(new InvalidationListener() {

            /**
             * Method called when the time property changes.
             * @param observable
             */
            @Override
            public void invalidated(Observable observable) {
                int time = (int) timeline.getCurrentTime().toSeconds();
                currTimeText.setText("Current time: " + time + " secs");

            }
        });

        vbox.getChildren().addAll(circle, currTimeText);

        Scene scene = new Scene(vbox, 500, 100);
        primaryStage.setScene(scene);

        // Make the stage larger than the scene.
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();

        Duration time = new Duration(10000);
        KeyValue keyValue = new KeyValue(circle.translateXProperty(), 300);
        KeyFrame keyFrame = new KeyFrame(time, keyValue);

        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(2);
        timeline.setAutoReverse(true);
        timeline.play();

    }
}

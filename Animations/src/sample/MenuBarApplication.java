package sample;/**
 * Created by szeyick on 5/05/2016.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * The MenuBarApplication.
 * <p>
 * This application class represents the program main for
 * the menu bar demo.
 * </p>
 * <b>Warning: </b>None.
 */
public class MenuBarApplication extends Application {

    /**
     * The program main.
     * @param args - Command line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * The method called when application is started.
     * @param primaryStage - The primary stage to display.
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("menuBar.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);

        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setWidth(500);
        primaryStage.setHeight(100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

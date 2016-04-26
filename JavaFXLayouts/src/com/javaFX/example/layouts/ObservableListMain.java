package com.javaFX.example.layouts;/**
 * Created by szeyick on 26/04/2016.
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;


/**
 * The ObservableListMain.
 * <p>
 * This application class provides a demonstration of how to use
 * the observableList collection when displaying a list of items
 * graphically.
 * </p>
 * <b>Warning: None.</b>
 */
public class ObservableListMain extends Application {

    /**
     * Program main.
     * @param args - Command line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * The method called when the application is started.
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Observable List");
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 400, 250, Color.WHITE);

        // Create a grid pane.
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(5));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        ColumnConstraints column1 = new ColumnConstraints(150, 150, Double.MAX_VALUE);
        ColumnConstraints column2 = new ColumnConstraints(50);
        ColumnConstraints column3 = new ColumnConstraints(150, 150, Double.MAX_VALUE);
        column1.setHgrow(Priority.ALWAYS);
        column3.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(column1, column2, column3);

        // Candidates Label.
        Label candidatesLabel = new Label("Candidates");
        GridPane.setHalignment(candidatesLabel, HPos.CENTER);
        gridPane.add(candidatesLabel, 0, 0);

        // Heroes Label.
        Label heroesLabel = new Label("Heroes");
        gridPane.add(heroesLabel, 2, 0);
        GridPane.setHalignment(heroesLabel, HPos.CENTER);

        // Candidates
        final ObservableList<String> candidates = FXCollections.observableArrayList(
          "Superman", "Batman", "Spiderman", "Ironman", "Captain America"
        );

        final ListView<String> candidatesListView = new ListView<>(candidates);
        gridPane.add(candidatesListView, 0, 1);

        // Heroes
        final ObservableList<String> heroes = FXCollections.observableArrayList();
        final ListView<String> heroListView = new ListView<>(heroes);

        gridPane.add(heroListView, 2, 1);

        // Select Heroes
        Button sendRightButton = new Button(" > ");
        sendRightButton.setOnAction((ActionEvent event) -> {
            String potential = candidatesListView.getSelectionModel().getSelectedItem();
            if (potential != null) {
                candidatesListView.getSelectionModel().clearSelection();;
                candidates.remove(potential);
                heroes.add(potential);
            }
        });

        // Deselect Heroes
        Button sendLeftButton = new Button(" < ");
        sendLeftButton.setOnAction((ActionEvent event) -> {
            String notHero = heroListView.getSelectionModel().getSelectedItem();
            if (notHero != null) {
                heroListView.getSelectionModel().clearSelection();
                heroes.remove(notHero);
                candidates.add(notHero);
            }
        });

        VBox vbox = new VBox(5);
        vbox.getChildren().addAll(sendRightButton, sendLeftButton);

        gridPane.add(vbox, 1, 1);
        root.setCenter(gridPane);

        GridPane.setVgrow(root, Priority.ALWAYS);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

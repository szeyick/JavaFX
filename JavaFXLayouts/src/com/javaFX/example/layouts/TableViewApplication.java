package com.javaFX.example.layouts;/**
 * Created by szeyick on 26/04/2016.
 */

import com.javaFX.example.layouts.models.Person;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.paint.Color;

/**
 * The TableViewApplication.
 * <p>
 * An example application for a table view.
 * </p>
 * <b>Warning: </b>None.
 */
public class TableViewApplication extends Application {

    /**
     * The program main.
     * @param args - Command line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * The method called when application is ready.
     * @param primaryStage - The stage to present the scene.
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Bosses and Employees: Chapter 4 Working with Tables");
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 500, 250, Color.WHITE);
        // create a grid pane
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        root.setCenter(gridpane);
        // candidates label
        Label candidatesLbl = new Label("Boss");
        GridPane.setHalignment(candidatesLbl, HPos.CENTER);
        gridpane.add(candidatesLbl, 0, 0);
        // List of leaders
        ObservableList<Person> leaders = getPeople();
        final ListView<Person> leaderListView = new ListView<>(leaders);
        leaderListView.setPrefWidth(150);
        leaderListView.setMaxWidth(Double.MAX_VALUE);
        leaderListView.setPrefHeight(150);
        // display first and last name with tooltip using alias
        leaderListView.setCellFactory(new Callback<ListView<Person>, ListCell<Person>>() {
            @Override
            public ListCell<Person> call(ListView<Person> param) {
                Label leadLbl = new Label();
                Tooltip tooltip = new Tooltip();
                ListCell<Person> cell = new ListCell<Person>() {
                    @Override
                    public void updateItem(Person item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            leadLbl.setText(item.getAliasName());
                            setText(item.getFirstName() + " " + item.getLastName());
                            tooltip.setText(item.getAliasName());
                            setTooltip(tooltip);
                        } }
                }; // ListCell
                return cell;
            }
        }); // setCellFactory
        gridpane.add(leaderListView, 0, 1);

        Label emplLbl = new Label("Employees");
        gridpane.add(emplLbl, 2, 0);
        GridPane.setHalignment(emplLbl, HPos.CENTER);
        final TableView<Person> employeeTableView = new TableView<>();
        employeeTableView.setPrefWidth(300);
        final ObservableList<Person> teamMembers = FXCollections.observableArrayList();
        employeeTableView.setItems(teamMembers);
        TableColumn<Person, String> aliasNameCol = new TableColumn<>("Alias");
        aliasNameCol.setEditable(true);
        aliasNameCol.setCellValueFactory(new PropertyValueFactory("aliasName"));
        aliasNameCol.setPrefWidth(employeeTableView.getPrefWidth() / 3);
        TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory("firstName"));
        firstNameCol.setPrefWidth(employeeTableView.getPrefWidth() / 3);
        TableColumn<Person, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory("lastName"));
        lastNameCol.setPrefWidth(employeeTableView.getPrefWidth() / 3);
        employeeTableView.getColumns().setAll(aliasNameCol, firstNameCol, lastNameCol);
        gridpane.add(employeeTableView, 2, 1);
        // selection listening
        leaderListView.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends
                        Person> observable, Person oldValue, Person newValue) -> {
            if (observable != null && observable.getValue() != null) {
                teamMembers.clear();
                teamMembers.addAll(observable.getValue().employeesProperty());
            } });
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @return a list of people to display.
     */
    private ObservableList<Person> getPeople() {
        ObservableList<Person> people = FXCollections.<Person>observableArrayList();
        Person docX = new Person("Professor X", "Charles", "Xavier");
        docX.employeesProperty().add(new Person("Wolverine", "James", "Howlett"));
        docX.employeesProperty().add(new Person("Cyclops", "Scott", "Summers"));
        docX.employeesProperty().add(new Person("Storm", "Ororo", "Munroe"));

        Person magneto = new Person("Magneto", "Max", "Eisenhardt");
        // ...code to add employees
        Person biker = new Person("Mountain Biker", "Jonathan", "Gennick");
        // ...code to add employees
        people.addAll(docX, magneto, biker);
        return people;
    }
}

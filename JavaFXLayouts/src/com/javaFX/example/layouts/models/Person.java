package com.javaFX.example.layouts.models;

/**
 * Created by szeyick on 26/04/2016.
 */

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * The Person.
 * <p>
 * This class represents a person.
 * </p>
 * <b>Warning: </b> None.
 */
public class Person {

    /**
     * The alias name of the person.
     */
    private StringProperty aliasName;

    /**
     * The first name of the person.
     */
    private StringProperty firstName;

    /**
     * The last name of the person.
     */
    private StringProperty lastName;

    /**
     * An observable list for employees.
     */
    private ObservableList<Person> employees = FXCollections.observableArrayList();

    /**
     * Set the alias.
     * @param value - The value to set.
     */
    public final void setAliasName(String value) {
        aliasNameProperty().set(value);
    }

    /**
     * @return the value set to the alias.
     */
    public final String getAliasName() {
        return aliasNameProperty().get();
    }

    /**
     * Assign the alias name property.
     * @return the alias object.
     */
    public StringProperty aliasNameProperty() {
        if (aliasName == null) {
            aliasName = new SimpleStringProperty();
        }
        return aliasName;
    }

    /**
     * Set the first name to the person.
     * @param value - The first name.
     */
    public final void setFirstName(String value) {
        firstNameProperty().set(value);
    }

    /**
     * @return the first name of the person.
     */
    public final String getFirstName() {
        return firstNameProperty().get();
    }

    /**
     * Set the first name property.
     * @return the initialised StringProperty.
     */
    public StringProperty firstNameProperty() {
        if (firstName == null) {
            firstName = new SimpleStringProperty();
        }
        return firstName;
    }

    /**
     * Set the last name to the person.
     * @param value the value for the last name.
     */
    public final void setLastName(String value) {
        lastNameProperty().set(value);
    }

    /**
     * @return the last name from the last name property.
     */
    public final String getLastName() {
        return lastNameProperty().get();
    }

    /**
     * The string property representing the last name.
     * @return the last name property.
     */
    public StringProperty lastNameProperty() {
        if (lastName == null) {
            lastName = new SimpleStringProperty();
        }
        return lastName;
    }

    /**
     * The list representing the employees as a list.
     * @return the list of employees.
     */
    public ObservableList<Person> employeesProperty() {
        return employees;
    }

    /**
     * The Constructor.
     * @param alias - The alias for the name.
     * @param firstName - The first name of the person.
     * @param lastName - The last name of the person.
     */
    public Person(String alias, String firstName, String lastName) {
        setAliasName(alias);
        setFirstName(firstName);
        setLastName(lastName);
    }
}

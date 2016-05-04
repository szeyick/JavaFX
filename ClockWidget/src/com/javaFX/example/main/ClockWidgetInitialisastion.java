/*
 * Copyright (C) 2016 Thales ATM all rights reserved. This software is
 * the property of Thales ATM and may not be used, copied or disclosed
 * in any manner except under a licence agreement signed with Thales ATM.
 */
package com.javaFX.example.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * The ClockWidgetInitialisastion.
 * <p>
 * This class is responsible for being the entry point into the
 * clock widget application.
 * </p>
 * <b>Warning: </b>None.
 */
public class ClockWidgetInitialisastion extends Application {

    /**
     * The program main.
     * @param args - Command line arguments.
     */
    public static void main(String[] args) {
       Application.launch(args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        Parent root = FXMLLoader.load(getClass().getResource("clockWidgetLayout.fxml"));
        Scene myScene = new Scene(root);
        myScene.setFill(null);

        primaryStage.setScene(myScene);
        primaryStage.show();

        EffectUtilities.makeDraggable(primaryStage, root);
    }
}

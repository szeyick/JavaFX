/*
 * Copyright (C) 2016 Thales ATM all rights reserved. This software is
 * the property of Thales ATM and may not be used, copied or disclosed
 * in any manner except under a licence agreement signed with Thales ATM.
 */
package com.javaFX.example.main.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.javaFX.example.main.timer.APSTimer;
import com.javaFX.example.main.timer.Clock;
import com.javaFX.example.main.timer.IAPSTimerListener;
import com.javaFX.example.main.uiControls.MessageLabel;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

/**
 * The ClockWidgetController.
 * <p>
 * This controller class is responsible for managing the layout that
 * has been defined in the clockWidgetLayout.fxml. This class has been
 * defined in the .fxml as the controller.
 * </p>
 * <b>Warning: </b>None.
 */
public class ClockWidgetController implements Initializable, IAPSTimerListener {

    /**
     * The root border pane that holds the entire view.
     */
    @FXML
    private BorderPane rootBorderPane;

    /**
     * The label representing the time.
     */
    @FXML
    private Label timeLabel;

    /**
     * The current time to display.
     */
    private Clock currentTime;

    @FXML
    private MessageLabel menu;

    @FXML
    private AnchorPane navList;

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        currentTime = new Clock();
        APSTimer.getTimer().addTimerListener(this);
        menu.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());
    }

    /**
     * @return the root border pane for the view.
     */
    public BorderPane getRootPane() {
        return rootBorderPane;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(long dt) {
        currentTime.update(dt);
        timeLabel.setText(currentTime.toString());
    }

    /**
     *
     */
    private class MyEventHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            TranslateTransition openNav=new TranslateTransition(new Duration(350), navList);
            openNav.setToX(0);
            TranslateTransition closeNav=new TranslateTransition(new Duration(350), navList);
            if(navList.getTranslateX()!=0){
                navList.setVisible(true);
                openNav.play();
            }
            else {
                navList.setVisible(false);
                closeNav.setToX(-(navList.getWidth()));
                closeNav.play();
            }
        }
    }

}

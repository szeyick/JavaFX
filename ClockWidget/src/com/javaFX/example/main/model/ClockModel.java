/*
 * Copyright (C) 2016 Thales ATM all rights reserved. This software is
 * the property of Thales ATM and may not be used, copied or disclosed
 * in any manner except under a licence agreement signed with Thales ATM.
 */
package com.javaFX.example.main.model;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.util.Duration;

/**
 * The ClockModel.
 * <p>
 * This class is responsible for containing the data for
 * the current time.
 * </p>
 * <b>Warning: </b>If integrated into JHMI, this model would not be neccessary. Instead
 * it would be preferable to listen to updates from the clock server to take the time from
 * the message received. This is possible since the server is running on its own thread and should
 * not be an issue.
 */
public class ClockModel extends SimpleStringProperty {

    /**
     * The default start time of the simulation.
     */
    public static final int HOUR_ZERO = 8;

    /**
     * The current simulation time.
     */
    private long t = 0;

    /**
     * Constructor.
     */
    @SuppressWarnings("unchecked")
    public ClockModel() {
        setValue("00:00:00");
        Timeline timeline = new Timeline(new KeyFrame(
                        Duration.millis(1000),
                        new MyEventHandler()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }

    private String formattedTime(long t) {
        int ms = (int)(t % 60000);
        long r = t / 60000;
        int min = (int)(r % 60);
        r = r / 60;
        int hr = HOUR_ZERO + (int)(r % 24);
        int seconds = ms/1000;
        return String.format("%02d:%02d:%02d", hr, min, seconds);
    }

    /**
     * Update the internal time. Adds dt to t.
     * @param dt increment of simulated time in millisec
     */
    public void update(long dt) {
        t += dt;
        setValue(formattedTime(t));
    }

    /**
     * Returns an 12-char string representing the current simulated time of day.
     * @return eg "13:00:59.009"
     */
    @Override
    public String toString() {
        return formattedTime(t);
    }

    private class MyEventHandler implements EventHandler {

        @Override
        public void handle(Event arg0) {
            update(1000);
        }
    }

}

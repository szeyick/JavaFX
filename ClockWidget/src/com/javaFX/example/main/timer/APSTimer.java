/*
 * Copyright (C) 2007 Thales ATM all rights reserved. This software is
 * the property of Thales ATM and may not be used, copied or disclosed
 * in any manner except under a licence agreement signed with Thales ATM.
 */
package com.javaFX.example.main.timer;

import java.util.HashSet;
import java.util.Set;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class APSTimer implements IAPSTimer {

    /**
     * An instance of the timer.
     */
    private static APSTimer apsTimer;

    /**
     * A set containing a collection of timer listeners.
     */
    private final Set<IAPSTimerListener> timerListeners;

    /**
     * Constructor.
     */
    private APSTimer() {
        timerListeners = new HashSet<IAPSTimerListener>();
        Timeline timeline = new Timeline(new KeyFrame(
                        Duration.millis(100),
                        new TimerListener()));
                timeline.setCycleCount(Animation.INDEFINITE);
                timeline.play();

    }

    /**
     * Add a listener to the timer.
     */
    @Override
    public void addTimerListener(IAPSTimerListener listener) {
        timerListeners.add(listener);
    }

    /**
     * Remove a listener from the timer.
     */
    @Override
    public void removeTimerListener(IAPSTimerListener listener) {
        timerListeners.remove(listener);
    }

    /**
     * @return the instance of the timer.
     */
    public static APSTimer getTimer() {
        if (apsTimer == null) {
            apsTimer = new APSTimer();
        }
        return apsTimer;
    }

    /**
     * *
     * The TimerListener.
     * <p>
     * This class is responsible for notifying the system when a timer event is
     * triggered.
     * <p>
     */
    private class TimerListener implements EventHandler {

        @Override
        public void handle(Event arg0) {
            for (IAPSTimerListener listener : timerListeners) {
                listener.update(100);
            }
        }

    }
}

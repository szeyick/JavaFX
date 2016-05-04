/*
 * Copyright (C) 2007 Thales ATM all rights reserved. This software is
 * the property of Thales ATM and may not be used, copied or disclosed
 * in any manner except under a licence agreement signed with Thales ATM.
 */
package com.javaFX.example.main.timer;

public class Clock {

    /**
     * The default start time of the simulation.
     */
    public static final int HOUR_ZERO = 8;

    /**
     * The current simulation time.
     */
    private long t = 0;

    /**
     * Returns an 12-char string representing the simulated time of day.
     * @param t the simulated time (from 8am, in milliseconds)
     * @return eg "13:00:59.009"
     */
    public static String formattedTime(long t) {
        int ms = (int)(t % 60000);
        long r = t / 60000;
        int min = (int)(r % 60);
        r = r / 60;
        int hr = HOUR_ZERO + (int)(r % 24);
        return String.format("%02d:%02d:%02d", hr, min, ms/1000);
    }

    /**
     * Returns the current clock value in milliseconds.
     * This method is for use by very few objects that do not maintain their
     * own copy of the value, incremented by update() calls.
     */
    long getCurSimTime() {
        return t;
    }

    /**
     * Returns an 12-char string representing the current simulated time of day.
     * @return eg "13:00:59.009"
     */
    @Override
    public String toString() {
        return formattedTime(t);
    }

    /**
     * Update the internal time. Adds dt to t.
     * @param dt increment of simulated time in millisec
     */
    public void update(long dt) {
        t += dt;
    }
}

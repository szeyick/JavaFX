/*
 * Copyright (C) 2007 Thales ATM all rights reserved. This software is
 * the property of Thales ATM and may not be used, copied or disclosed
 * in any manner except under a licence agreement signed with Thales ATM.
 */
package com.javaFX.example.main.timer;

public interface IAPSTimer {

    /**
     * Add a timer listener.
     * @param listener - The object to listen for timer updates.
     */
    void addTimerListener(IAPSTimerListener listener);

    /**
     * Remove a timer listener.
     * @param listener - The object to be removed from listening to timer updates.
     */
    void removeTimerListener(IAPSTimerListener listener);

}

/*
 * Copyright (C) 2007 Thales ATM all rights reserved. This software is
 * the property of Thales ATM and may not be used, copied or disclosed
 * in any manner except under a licence agreement signed with Thales ATM.
 */
package com.javaFX.example.main.timer;

public interface IAPSTimerListener {

    /**
     * Notify an implementing class that a timer update has been received.
     * @param dt - The time passed since the last triggered event.
     */
    void update(long dt);
}

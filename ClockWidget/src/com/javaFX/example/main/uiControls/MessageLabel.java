/*
 * Copyright (C) 2007 Thales ATM all rights reserved. This software is
 * the property of Thales ATM and may not be used, copied or disclosed
 * in any manner except under a licence agreement signed with Thales ATM.
 */
package com.javaFX.example.main.uiControls;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

/**
 * The MessageLabel.
 * <p>
 * This class is a custom subclass of the label.
 * </p>
 * <b>Warning: </b> None.
 */
public class MessageLabel extends Label {

    /**
     * The method to do something.
     */
    public void doSomething() {
        Rectangle rect = new Rectangle();
        rect.setX(0);
        rect.setY(0);
        rect.setWidth(10);
        rect.setHeight(10);
        rect.setFill(Color.AQUA);

        Ellipse ellipse = new Ellipse();
        ellipse.setStrokeWidth(1);
        ellipse.setRadiusX(10);
        ellipse.setRadiusY(10);
        ellipse.setCenterX(10);
        ellipse.setCenterY(5);
        ellipse.setFill(Color.RED);

        getChildren().add(rect);
        getChildren().add(ellipse);
    }
}

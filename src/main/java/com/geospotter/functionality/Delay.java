package com.geospotter.functionality;

import javafx.scene.image.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class Delay {

    /**
     * Delays the visibility change of an ImageView for a specified duration.
     *
     * @param delay The delay duration in milliseconds before changing the visibility.
     * @param img   The ImageView whose visibility will be affected.
     */

    public void copiedDelay(int delay, ImageView img) {

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                img.setVisible(false);
            }
        }, delay);

    }

}

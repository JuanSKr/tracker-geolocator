package com.geospotter.functionality;

import javafx.scene.image.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class Delay {

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

package com.terralogic.mywallet.model;

import com.terralogic.mywallet.adapter.viewHolder.ItemViewHolder;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by trile on 4/24/2018.
 */

public class SecondTimer {

    private Timer timer;
    private int countDown;
    private int secondsLeft;
    private ItemViewHolder itemViewHolder;

    public SecondTimer(ItemViewHolder itemViewHolder) {
        timer = new Timer();
        this.itemViewHolder = itemViewHolder;
    }

    public void reset() {
        secondsLeft = countDown;
        // Decrease seconds left every 1 second.
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                secondsLeft--;

                if (secondsLeft == 0) {
                    timer.cancel();
                    itemViewHolder.getmInside().setTranslationX(0);
                    itemViewHolder.getmOutside().setTranslationX(0);
                }
            }
        }, 0, 1000);
    }

    public void setCountDown(int seconds) {
        this.countDown = seconds;
    }

//    public int getSecondsLeft() {
//        return secondsLeft;
//    }
}

package com.example.fastnfitness.fastandfitness;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SoundEffectConstants;
import android.widget.RelativeLayout;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class RandomDirectionPageActivity extends AppCompatActivity {

    private RelativeLayout myLayout;
    final int arrowImages[] = {R.drawable.random_arrow_0, R.drawable.random_arrow_1, R.drawable.random_arrow_2, R.drawable.random_arrow_3};
    final int numberOfImages = arrowImages.length;
    final int startTime = 4000;
    final int timeBetweenImages = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random_direction_page);
        myLayout = findViewById(R.id.imageViewExampleId);

        Timer timer = new Timer();
        MyTimer myTime = new MyTimer();
        timer.schedule(myTime, startTime, timeBetweenImages);
    }

    class MyTimer extends TimerTask {
        public void run() {
            runOnUiThread(new Runnable() {
                public void run() {
                    myLayout.playSoundEffect(SoundEffectConstants.CLICK);
                    myLayout.setBackgroundResource(arrowImages[getRandomNumber()]);
                }

                private int getRandomNumber() {
                    return new Random().nextInt(numberOfImages);
                }
            });
        }
    }
}
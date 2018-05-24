package com.example.fastnfitness.fastandfitness;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Random;

public class RandomDirectionPageActivity extends AppCompatActivity {

    final Random random = new Random();
    final int numberOfImages = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random_direction_page);

        final ImageView img = findViewById(R.id.imageViewExampleId);
        final String imageFileName = "random_arrow_" + random.nextInt(numberOfImages);
        final MediaPlayer blipSound = MediaPlayer.create(this, R.raw.blip_sound);

        blipSound.start();
        img.setImageDrawable(getResources().getDrawable(getResourceID(imageFileName, getApplicationContext())));
    }

    protected static int getResourceID(final String resName, final Context ctx) {
        final int ResourceID = ctx.getResources().getIdentifier(resName, "drawable", ctx.getApplicationInfo().packageName);
        if (ResourceID == 0) {
            throw new IllegalArgumentException("No resource string found with name: " + resName);
        }
        else {
            return ResourceID;
        }
    }
}

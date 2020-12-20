package com.example.android.dvoice;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class RayonActivity extends AppCompatActivity {

    MediaPlayer media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rayon);
    }

    public void play(View v){
        if (media == null){
            media = MediaPlayer.create(this,R.raw.decathlontheme);
            Toast.makeText(this,"Permanent",Toast.LENGTH_SHORT).show();
            media.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                }
            });
        }
        media.start();
    }
}

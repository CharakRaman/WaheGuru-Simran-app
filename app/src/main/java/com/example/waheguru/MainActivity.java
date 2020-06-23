package com.example.waheguru;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

      MediaPlayer player;
        MediaPlayer two;
        MediaPlayer three;
        MediaPlayer Four;
        MediaPlayer Five;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        public void One (View v){
            if (player == null) {
                player = MediaPlayer.create(this, R.raw.play);
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        StopPlayer();
                    }
                });
            }
            player.start();
            stopTwo();
            StopFour();
            StopFive();
            stop3();
        }
        public void Five(View v){
        if(Five==null){
            Five=MediaPlayer.create(this,R.raw.d);
            Five.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    StopFive();
                }
            });
        }
        Five.start();
            stopTwo();
            StopFour();
            stop3();
            StopPlayer();
        }
        public void Four(View v){
        if(Four==null){
            Four=MediaPlayer.create(this, R.raw.c);
            Four.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    StopFour();
                }
            });
        }
        Four.start();
        stop3();;
        StopPlayer();
        StopFive();
        stopTwo();
        }

        public void Two (View v) {
            if (two == null) {
                two = MediaPlayer.create(this, R.raw.a);
                two.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        stopTwo();
                    }
                });
            }
            two.start();
            StopPlayer();
            StopFive();
            StopFour();
            stop3();
        }

    public void Three(View v){
        if(three==null){
            three=MediaPlayer.create(this,R.raw.b);
            three.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stop3();
                }
            });
        }
        three.start();
        StopPlayer();
        StopFive();
        StopFour();
        stopTwo();
    }


    public void Stopone(View v){
        StopPlayer();
        stopTwo();
        stop3();
        StopFour();
        StopFive();
    }

    public void StopFive(){
        if(Five!=null){
            Five.release();
            Five=null;
            Toast.makeText(this, "Player stopped", Toast.LENGTH_SHORT).show();

        }
    }
    public void StopFour(){
        if(Four!=null){
            Four.release();
            Four=null;
            Toast.makeText(this, "Player stopped", Toast.LENGTH_SHORT).show();

        }
    }

    public void stopTwo(){
        if(two!=null){
            two.release();
            two=null;
            Toast.makeText(this, "Player stopped", Toast.LENGTH_SHORT).show();

        }
    }
    public void stop3(){
        if(three!=null){
            three.release();;
            three=null;
            Toast.makeText(this, "Player stopped", Toast.LENGTH_SHORT).show();

        }
    }

    public void StopPlayer() {
        if (player != null) {
            player.release();
            player = null;
            Toast.makeText(this, "Player stopped", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        stopTwo();
        StopPlayer();
        stop3();
        StopFive();
        StopFour();

    }
}

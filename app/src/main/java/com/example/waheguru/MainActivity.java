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
            stop3();
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
        stopTwo();
    }


    public void Stopone(View v){
        StopPlayer();
    }
    public void Stoptow(View v){
        stopTwo();
    }
    public void Stopthree(View v){
        stop3();
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

    }
}

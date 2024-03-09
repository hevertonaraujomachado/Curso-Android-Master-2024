package com.devheverton.playmusic;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
private ImageView pause,play,stop;
private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 pause = findViewById(R.id.pause);
 play = findViewById(R.id.play);
 stop = findViewById(R.id.stop);

 mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.global);

  pause.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          if (mediaPlayer.isPlaying()){
              mediaPlayer.pause();
          }

      }
  });
  play.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          if (mediaPlayer != null){
              mediaPlayer.start();
          }

      }
  });
  stop.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          if (mediaPlayer.isPlaying()){
              mediaPlayer.stop();
              mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.global);
          }

      }
  });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }

    }
}
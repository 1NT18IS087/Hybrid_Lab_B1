package com.example.lankesh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class mediaplayernew extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediaplayernew);

        int starttime = 0 ; // startime is 0s
        int stopttime = 0; // stoptime is 0s by default
        int forwardtime = 5000 ; // 5s for forward
        int backwardtime = 5000 ; // 5s for backwardtime

        TextView songtitle = findViewById(R.id.songname);
        MediaPlayer mediaplayer= MediaPlayer.create(this, R.raw.sample) ;
        songtitle.setText("sample.mp3");

        Button play = findViewById(R.id.play);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"song started",Toast.LENGTH_LONG).show();
                mediaplayer.start();
            }
        });

        Button pause = findViewById(R.id.pause);

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"song paused",Toast.LENGTH_LONG).show();
                mediaplayer.pause();
            }
        });


        Button forward = findViewById(R.id.forward);
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int curPos = mediaplayer.getCurrentPosition();
                int totalDuration = mediaplayer.getDuration();

                if(curPos + forwardtime <= totalDuration){
                    mediaplayer.seekTo(curPos + forwardtime);
                }

            }
        });


        Button rewind = findViewById(R.id.rewind);
        rewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int curPos = mediaplayer.getCurrentPosition();
                if(curPos - backwardtime >= starttime){
                    mediaplayer.seekTo(curPos - backwardtime);
                }
            }
        });

        Button restart = findViewById(R.id.reset);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Song restarted", Toast.LENGTH_SHORT).show();
                mediaplayer.reset();
            }
        });


    }
}



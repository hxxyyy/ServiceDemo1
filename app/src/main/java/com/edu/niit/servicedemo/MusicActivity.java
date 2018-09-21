package com.edu.niit.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MusicActivity extends AppCompatActivity implements View.OnClickListener {
private Button btnStartPlay;
private Button btnStopPlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        btnStartPlay=findViewById(R.id.start);
        btnStopPlay=findViewById(R.id.stop);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.start:
                intent.setClass(this,MusicService.class);
                intent.putExtra("status",0);
                startService(intent);
                btnStartPlay.setEnabled(false);
                btnStopPlay.setEnabled(true);
                break;
            case R.id.pause:
                intent.setClass(this,MusicService.class);
                intent.putExtra("status",1);
                startService(intent);
                break;
            case R.id.resume:
                intent.setClass(this,MusicService.class);
                intent.putExtra("status",2);
                startService(intent);
                break;
            case R.id.stop:
                intent.setClass(this,MusicService.class);
                intent.putExtra("status",3);
                startService(intent);
                btnStartPlay.setEnabled(true);
        }
    }
}

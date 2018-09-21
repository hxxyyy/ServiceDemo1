package com.edu.niit.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service  implements MediaPlayer.OnCompletionListener{
    private MediaPlayer player;
    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player=MediaPlayer.create(this,R.raw.youhe);
        player.setOnCompletionListener( this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int status=intent.getIntExtra("status",0);
        switch (status) {
            case 0:
                player.start();
                break;
            case 1:
                player.pause();
                break;
            case 2:
                player.start();
                break;
            case 3:
                player.stop();
                break;

        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        if (player !=null){
            player.release();
        }
        super.onDestroy();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mp.release();
    }
}

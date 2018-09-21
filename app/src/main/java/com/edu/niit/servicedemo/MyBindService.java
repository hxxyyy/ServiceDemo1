package com.edu.niit.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyBindService extends Service {
    private MyBinder myBinder=new MyBinder();
    public MyBindService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
       return myBinder;
    }
    public class MyBinder extends Binder {
        public void startDownload() {
            Log.d("MyBinder","MyBinder startDownload");
        }
    }
}

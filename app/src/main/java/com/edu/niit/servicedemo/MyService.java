package com.edu.niit.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    //构造函数
    public MyService() {
    }

    //绑定
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("MyService","MyService onBind");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MyService","MyService onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService","MyService onStartCommand");

        //多线程

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyService","MyService onDestroy");
    }
}

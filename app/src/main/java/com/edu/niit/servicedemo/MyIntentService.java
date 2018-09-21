package com.edu.niit.servicedemo;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;


public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");

    }

    @Override
    protected void onHandleIntent(Intent intent){
        Log.d("MyIntentService","MyIntentService onHandleIntent");

        }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MyIntentService","MyIntentService  onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyIntentService","MyIntentService  onDestroy");
    }
}

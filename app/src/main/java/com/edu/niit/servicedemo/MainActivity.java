package com.edu.niit.servicedemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MyBindService.MyBinder myBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart = findViewById(R.id.go);
        btnStart.setOnClickListener(this);

        Button btnStop = findViewById(R.id.stop);
        btnStop.setOnClickListener(this);

        Button btnBind = findViewById(R.id.bang);
        btnBind.setOnClickListener(this);

        Button btnUnbind = findViewById(R.id.jie);
        btnUnbind.setOnClickListener(this);

        Button btnForeground = findViewById(R.id.goService);
        btnForeground.setOnClickListener(this);

        Button btnStopFore = findViewById(R.id.stopService);
        btnStopFore.setOnClickListener(this);

        Button btnIntent = findViewById(R.id.intentService);
        btnIntent.setOnClickListener(this);
    }
        private ServiceConnection serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                myBinder = (MyBindService.MyBinder) iBinder;
                myBinder.startDownload();
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        };

        @Override
        public void onClick (View view){
            Intent intent = new Intent();
            switch (view.getId()) {
                case R.id.go:
                    intent = new Intent(this, MyService.class);
                    startService(intent);//一旦启动activity就不能控制service的运行
                    break;
                case R.id.stop:
                    intent = new Intent(this, MyService.class);
                    stopService(intent);
                    break;
                case R.id.bang:
                    intent = new Intent(this, MyBindService.class);
                    bindService(intent, serviceConnection, BIND_AUTO_CREATE);
                    break;
                case R.id.jie:
                    unbindService(serviceConnection);
                    break;
                case R.id.goService:
                    intent = new Intent(this, ForegroundService.class);
                    startService(intent);
                    break;
                case R.id.stopService:
                    intent = new Intent(this, ForegroundService.class);
                    stopService(intent);
                    break;
                case R.id.intentService:
                    intent=new Intent(this,MyIntentService.class);
                    startService(intent);
                    break;
            }
        }
    }



package com.example.asus.demmi;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {

    private static int SPLACH_TIME_OUT = 4000;
    private static boolean connected=false;
    TextView checkingInternet=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(StartActivity.this,LoginActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLACH_TIME_OUT);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                checkingInternet = (TextView)findViewById(R.id.internetcheck);

                ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                        connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                    //we are connected to a network
                    connected = true;
                    checkingInternet.setText("تم التحقق من الأنترنيت ...");
                } else {
                    checkingInternet.setText("لا يوجد اتصال ...");
                }
                finish();
            }
        },SPLACH_TIME_OUT);
    }
}

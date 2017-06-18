package com.icdronesoc.bpelicanreceiver;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.app.IntentService;
import android.app.NotificationChannel;

import android.app.NotificationManager;

import android.content.Context;

import android.os.Build;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.util.Log;

import android.view.View;

import android.widget.Button;

import android.widget.Toast;


import com.google.firebase.iid.FirebaseInstanceId;

import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationManager notificationManager =

                getSystemService(NotificationManager.class);

        FirebaseMessaging.getInstance().subscribeToTopic("command");
        String token = FirebaseInstanceId.getInstance().getToken();
        //String msg = getString(R.string.msg_subscribed);

        Log.d("Token is", token);
        this.updateText(token);
        //Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume(){
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.icdronesoc.bpelicanreceiver.onMessageReceived");
        internalBroadcastReceiver receiver = new internalBroadcastReceiver();
        registerReceiver(receiver, intentFilter);
    }
    private class internalBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle extras = intent.getExtras();
            String state = extras.getString("extra");
            updateText(state);// update your textView in the main layout
        }
    }

    private void updateText(String update) {
        EditText editText = (EditText) findViewById(R.id.editText1);
        editText.setText(editText.getText() + "\n" + update);
    }
}

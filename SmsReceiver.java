package com.example.textmessageapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.TextView;

import static com.example.textmessageapp.MainActivity.currentState;
import static com.example.textmessageapp.MainActivity.messageView;
import static com.example.textmessageapp.MainActivity.numberView;
import static com.example.textmessageapp.MainActivity.phoneNumber;
import static com.example.textmessageapp.MainActivity.receivedMessages;

public class SmsReceiver extends BroadcastReceiver {

    boolean inGreetingState = true;
    boolean inIntroductionState = false;
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d("LOGTAG", "onreceive entered");
        Bundle bundle = intent.getExtras();
        Object[] pdus =  (Object[]) bundle.get("pdus");// 'protocol data unit'
        SmsMessage[] messages = new SmsMessage[pdus.length];
        String format = bundle.getString("format");
        for(int i = 0; i < pdus.length; i++) {
            messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i], format);
        }
        String fullMessage = "";
        for(SmsMessage message: messages) {
            fullMessage += message.getMessageBody();
        }

        // Applying finite state machine
        FiniteStateMachine fsm = new FiniteStateMachine();
        final String response = fsm.respondByState(fullMessage);

        final SmsManager manager = SmsManager.getDefault();
        Handler handler = new Handler();
        // Send back appropriate message
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                manager.sendTextMessage(phoneNumber, null, response, null, null);
            }
        };
        handler.postDelayed(runnable, 4000);
    }


}

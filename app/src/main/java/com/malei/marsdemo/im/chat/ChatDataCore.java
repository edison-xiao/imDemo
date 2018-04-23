package com.malei.marsdemo.im.chat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import com.malei.marsdemo.app.MyApplication;
import com.malei.marsdemo.im.core.Constants;
import com.malei.marsdemo.ui.ChatActivity;

import java.util.Observable;

/**
 * Created by malei on 2018/4/23.
 * 接收消息监听者类
 */

public class ChatDataCore extends Observable {

    private BroadcastReceiver receiver = new RecvMessageReceiver();
    private static ChatDataCore inst = new ChatDataCore();

    public ChatDataCore() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Constants.PUSHACTION);
        MyApplication.getContext().registerReceiver(receiver, intentFilter);
    }

    public static ChatDataCore getInstance() {
        return inst;
    }

    /**
     * 发送消息和接收消息，都会触发该广播
     */
    private class RecvMessageReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction().equals(Constants.PUSHACTION)){
                String topic = intent.getStringExtra("msgtopic");
                String from = intent.getStringExtra("msgfrom");
                String text = intent.getStringExtra("msgcontent");
                ChatActivity.recMsg = text;
                //这两个方法是通知观察者类，数据已经修改
                setChanged();
                notifyObservers();
            }
        }
    }
}

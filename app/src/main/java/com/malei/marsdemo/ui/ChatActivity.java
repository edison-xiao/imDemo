package com.malei.marsdemo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.malei.marsdemo.R;
import com.malei.marsdemo.app.MyApplication;
import com.malei.marsdemo.im.chat.ChatDataCore;
import com.malei.marsdemo.im.chat.TextMessageTask;
import com.tencent.mars.sample.wrapper.remote.MarsServiceProxy;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by malei on 2018/4/16.
 * 观察者模式设计
 */
public class ChatActivity extends Activity implements Observer {

    private TextView textView;
    private EditText editText;
    private Button btnSend;
    private String mTopicName = "0" ;  //聊天频道
    public static String recMsg = "";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_chat);

        //接收消息的监听 成为观察者
        ChatDataCore.getInstance().addObserver(this);

        textView = (TextView)this.findViewById(R.id.textView);
        editText = (EditText)this.findViewById(R.id.editText);
        btnSend = (Button)this.findViewById(R.id.btn);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickBtnSend();
            }
        });
    }

    private void onClickBtnSend() {
        MyApplication.accountInfo.userName = "malei";
        MarsServiceProxy.send(new TextMessageTask("0",editText.getText().toString())
                        .onOk(new Runnable() {
                            @Override
                            public void run() {
                                Log.i("TAG","onOk");
                            }
                        }).onError(new Runnable() {
                                    @Override
                                    public void run() {
                                        Log.i("TAG","onError");
                                    }
                                }));
    }

    @Override
    public void update(Observable o, Object arg) {
        textView.setText(recMsg);
    }
}

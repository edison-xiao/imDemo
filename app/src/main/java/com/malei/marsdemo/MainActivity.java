package com.malei.marsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.malei.marsdemo.im.core.MainService;
import com.malei.marsdemo.im.modle.Main;
import com.malei.marsdemo.ui.ChatActivity;
import com.tencent.mars.sample.utils.print.BaseConstants;
import com.tencent.mars.sample.wrapper.remote.MarsServiceProxy;
import com.tencent.mars.sample.wrapper.remote.NanoMarsTaskWrapper;
import com.tencent.mars.xlog.Log;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMarsPullChat();

        button = (Button)this.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ChatActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initMarsPullChat() {
        //接收新消息的时候使用
        final MainService mainService = new MainService();
        MarsServiceProxy.setOnPushMessageListener(BaseConstants.CGIHISTORY_CMDID, mainService);
        MarsServiceProxy.setOnPushMessageListener(BaseConstants.CONNSTATUS_CMDID, mainService);
        MarsServiceProxy.setOnPushMessageListener(BaseConstants.FLOW_CMDID, mainService);
        MarsServiceProxy.setOnPushMessageListener(BaseConstants.PUSHMSG_CMDID, mainService);
        MarsServiceProxy.setOnPushMessageListener(BaseConstants.SDTRESULT_CMDID, mainService);
    }

}

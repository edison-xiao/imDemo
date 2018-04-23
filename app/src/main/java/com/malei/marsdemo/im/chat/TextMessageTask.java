package com.malei.marsdemo.im.chat;


import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.malei.marsdemo.app.MyApplication;
import com.malei.marsdemo.im.modle.Chat;
import com.malei.marsdemo.im.modle.Main;
import com.tencent.mars.sample.wrapper.TaskProperty;
import com.tencent.mars.sample.wrapper.remote.NanoMarsTaskWrapper;


/**
 * Created by malei on 2018/4/17.
 * 处理发送的消息
 */
@TaskProperty(
        host = "marsopen.cn",
        path = "/mars/sendmessage",
        cmdID = Main.CMD_ID_SEND_MESSAGE,
        longChannelSupport = true,
        shortChannelSupport = false
)
public class TextMessageTask extends NanoMarsTaskWrapper<Chat.SendMessageRequest, Chat.SendMessageResponse> {

    private Runnable mOnOk;
    private Runnable mOnError;
    private Runnable mCallback;

    private Handler uiHandler = new Handler(Looper.getMainLooper()); //创建主线程的handler

    /**
     *
     * @param topicName ： 聊天的频道，两个人聊天的时候，要保证topicName 一致
     * @param text
     */
    public TextMessageTask(String topicName, String text) {
        super(new Chat.SendMessageRequest(), new Chat.SendMessageResponse());

        request.accessToken = "test_token";
        request.from = MyApplication.accountInfo.userName;
        request.to = "all";
        request.text = text;
        request.topic = topicName;
    }

    /**
     * 发送之前的拦截
     * @param request
     */
    @Override
    public void onPreEncode(Chat.SendMessageRequest request) {
        Log.i("TAG",request.text);
    }

    /**
     * 发送完成后的回调
     * @param response
     */
    @Override
    public void onPostDecode(Chat.SendMessageResponse response) {
        if (response.errCode == Chat.SendMessageResponse.ERR_OK) {
            mCallback = mOnOk;
        } else {
            mCallback = mOnError;
        }
    }

    /**
     * 发送完成后的回调，消息已经发送给对方了
     * @param errType
     * @param errCode
     */
    @Override
    public void onTaskEnd(int errType, int errCode) {
        if (mCallback == null) {
            mCallback = mOnError;
        }
        uiHandler.post(mCallback);
    }

    public TextMessageTask onOk(Runnable onOk){
        this.mOnOk = onOk;
        return this;
    }

    public TextMessageTask onError(Runnable onError){
        this.mOnError = onError;
        return this;
    }
}

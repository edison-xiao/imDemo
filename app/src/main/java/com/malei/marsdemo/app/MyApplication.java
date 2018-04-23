package com.malei.marsdemo.app;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Environment;

import com.malei.marsdemo.im.core.ActivityEvent;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.sample.wrapper.BuildConfig;
import com.tencent.mars.sample.wrapper.remote.MarsServiceProxy;
import com.tencent.mars.sample.wrapper.service.DebugMarsServiceProfile;
import com.tencent.mars.sample.wrapper.service.MarsServiceNative;
import com.tencent.mars.sample.wrapper.service.MarsServiceProfile;
import com.tencent.mars.sample.wrapper.service.MarsServiceProfileFactory;
import com.tencent.mars.xlog.Log;
import com.tencent.mars.xlog.Xlog;

import java.util.Random;

import cat.ereza.customactivityoncrash.CustomActivityOnCrash;

/**
 * Created by malei on 2018/4/16.
 */

public class MyApplication extends Application {

    private static final String TAG = "Mars.SampleApplication";

    private static Context context;

    //APP的属性类 包括账号类和设备类
    public static AppLogic.AccountInfo accountInfo = new AppLogic.AccountInfo(
            new Random(System.currentTimeMillis() / 1000).nextInt(), "anonymous");

    public static volatile boolean hasSetUserName = false;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

        System.loadLibrary("stlport_shared");
        System.loadLibrary("marsxlog");
        openXlog();

        //启动mars服务
        MarsServiceNative.setProfileFactory(new MarsServiceProfileFactory() {
            @Override
            public MarsServiceProfile createMarsServiceProfile() {
                return new DebugMarsServiceProfile(){
                    @Override
                    public String longLinkHost() {
                        return "marsopen.cn";
                    }
                };
            }
        });

        //初始化mars服务
        MarsServiceProxy.init(this, getMainLooper(), null);
        //mars账号设置
        MarsServiceProxy.inst.accountInfo = accountInfo;

        // Auto bind all activity event
        ActivityEvent.bind(getApplicationContext());

        Log.i(TAG, "application started");

        CustomActivityOnCrash.install(this);
    }

    @Override
    public void onTerminate() {
        Log.i(TAG, "application terminated");

        super.onTerminate();

        Log.appenderClose();

    }

    public static  void openXlog() {

        int pid = android.os.Process.myPid();
        String processName = null;
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : am.getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                processName = appProcess.processName;
                break;
            }
        }

        if (processName == null) {
            return;
        }

        final String SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath();
        final String logPath = SDCARD + "/marssample/log";

        String logFileName = processName.indexOf(":") == -1 ? "MarsSample" : ("MarsSample_" + processName.substring(processName.indexOf(":") + 1));

        if (BuildConfig.DEBUG) {
            Xlog.appenderOpen(Xlog.LEVEL_VERBOSE, Xlog.AppednerModeAsync, "", logPath, logFileName, "");
            Xlog.setConsoleLogOpen(true);
        } else {
            Xlog.appenderOpen(Xlog.LEVEL_INFO, Xlog.AppednerModeAsync, "", logPath, logFileName, "");
            Xlog.setConsoleLogOpen(false);
        }
        Log.setLogImp(new Xlog());
    }

    public static Context getContext() {
        return context;
    }
}

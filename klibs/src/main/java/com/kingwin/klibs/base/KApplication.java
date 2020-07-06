package com.kingwin.klibs.base;

import android.app.Application;

import com.kingwin.klibs.context.KContextManage;

/**
 * created by KingWin
 * on 2020/7/6
 */
public class KApplication extends Application {

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        KContextManage.setAppContext(this);
    }

}

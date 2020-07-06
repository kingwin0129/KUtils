package com.kingwin.klibs.context;

import android.content.Context;

/**
 * Context 管理器
 * created by KingWin
 * on 2020/7/6
 */
public class KContextManage {

    private static Context mAppContext;

    private static Context mUIContext;


    /**
     * 设置全局APPlication Context
     * @param context  Application Context
     */
    public static void setAppContext(Context context){
        mAppContext = context;
    }

    /**
     * 获取全局Context
     * @return Application Context
     */
    public static Context getAppContext(){
        return mAppContext;
    }

    /**
     * 设置当前UI Context
     * @param context  Application Context
     */
    public static void setUIContext(Context context){
        mUIContext = context;
    }

    /**
     * 获取当前UI Context
     * @return Application Context
     */
    public static Context  getUIContext(){
        return mUIContext;
    }




}

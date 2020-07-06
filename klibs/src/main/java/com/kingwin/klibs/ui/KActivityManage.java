package com.kingwin.klibs.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.kingwin.klibs.context.KContextManage;

import java.util.Stack;

/**
 * Activity管理器
 * created by KingWin
 * on 2020/7/6
 */
public class KActivityManage {

    private static KActivityManage mInstance = null;

    /**
     * 构造函数
     * @return
     */
    public static KActivityManage getInstance(){
        if(null == mInstance){
            synchronized (KActivityManage.class){
                if(null == mInstance){
                    mInstance = new KActivityManage();
                }
            }
        }
        return mInstance;
    }

    public KActivityManage(){
        activityStack = new Stack<>();
    }

    /**
     * UI列表
     */
     private Stack<Activity> activityStack;



    /**
     * 跳转Activity
     * @param context  上下文
     * @param c 跳转Activity类
     * @param bundle 跳转Activity携带参数
     */
    public void skipUI(Context context, Class<?> c, Bundle bundle){
        launchActivityForBundle(context,c,bundle);
    }

    /**
     * 启动Activity 并且带参数
     * @param context 上下文
     * @param c 启动Activity类
     * @param bundle 启动Activity携带参数
     */
    private void launchActivityForBundle(Context context, Class<?> c, Bundle bundle){
        Intent t = new Intent(context,c);
        if( null != bundle){
            t.putExtras(bundle);
        }
        context.startActivity(t);
    }


    /**
     * 关闭Activity
     * @param activity 指定Activity  可为null，为null退出当前堆栈最后Activity
     */
    public void closeUI(AppCompatActivity activity){
        if(null != activity){
            exitActivity(activity);
        }else{
            exitCurActivity();
        }
    }

    /**
     * 退出Activity
     * @param activity  指定Activity
     */
    private void exitActivity(AppCompatActivity activity){
        if(null != activity){
            activity.finish();
        }
    }

    /**
     * 退出当前堆栈最后的Activity
     */
    private void exitCurActivity(){
        Activity activity = activityStack.lastElement();
        if(null != activity){
            activity.finish();
        }
    }


    /**
     * 添加Activity
     * @param activity Activity
     */
    public void addActivity(Activity activity){
        if(null != activity) {
            activityStack.add(activity);
            KContextManage.setUIContext(activity);
        }
    }

    /**
     * 移除Activity
     * @param activity Activity
     */
    public void removeActivity(Activity activity){
        if(null != activity) {
            activityStack.remove(activity);
            Activity lastActivity = activityStack.lastElement();
            if(null != lastActivity){
                KContextManage.setUIContext(lastActivity);
            }

        }
    }


    /**
     * 移除所有界面
     */
    public void clearActivity(){
        for (Activity activity :activityStack){
            if(null != activity){
                activity.finish();
            }
        }
        activityStack.clear();
    }






}

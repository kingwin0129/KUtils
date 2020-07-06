package com.kingwin.klibs.eventBus;


import org.greenrobot.eventbus.EventBus;

/**
 * created by KingWin
 * on 2020/7/6
 */
public class KEventBusManage {

    private static KEventBusManage mInstance = null;

    /**
     * 构造函数
     * @return
     */
    public static KEventBusManage getInstance(){
        if(null == mInstance){
            synchronized (KEventBusManage.class){
                if(null == mInstance){
                    mInstance = new KEventBusManage();
                }
            }
        }
        return mInstance;
    }

    /**
     * 注册监听
     */
    public void register(){
        EventBus.getDefault().register(this);
    }

    /**
     * 取消监听
     */
    public void unregister(){
        EventBus.getDefault().unregister(this);
    }

    /**
     * 发送事件
     */
    public void post(KMessageEvent message){
        EventBus.getDefault().post(message);
    }




}

package com.kingwin.klibs.eventBus;

/**
 * KEventBus 消息传递基础对象
 * created by KingWin
 * on 2020/7/6
 */
public class KMessageEvent<T> {

    private int code;

    private T data;

    public KMessageEvent(int code){
        this.code = code;
    }

    public KMessageEvent(int code,T data){
        this.code = code;
        this.data = data;
    }

    public int getCode(){
        return this.code;
    }


    public T getData(){
        return this.data;
    }
}

package com.kingwin.klibs.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.kingwin.klibs.eventBus.KEventBusManage;
import com.kingwin.klibs.eventBus.KMessageEvent;
import com.kingwin.klibs.ui.KActivityManage;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.EventObject;

import butterknife.ButterKnife;

/**
 * created by KingWin
 * on 2020/7/6
 */
public abstract class KBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initView();

    }

    @Override
    public void onStart() {
        super.onStart();
        KActivityManage.getInstance().addActivity(this);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
        KActivityManage.getInstance().removeActivity(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(KMessageEvent obj){
        this.receiveEvent(obj);
    }


    /**
     * 设置布局
     *
     * @return
     */
    public abstract int getLayoutId();

    /**
     * 初始化视图
     */
    public abstract void initView();

    /**
     * 接收通知事件
     */
    public abstract void receiveEvent(KMessageEvent obj);

}

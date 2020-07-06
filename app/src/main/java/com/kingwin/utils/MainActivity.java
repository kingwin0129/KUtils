package com.kingwin.utils;


import android.os.Bundle;
import android.widget.TextView;

import com.kingwin.klibs.base.KBaseActivity;
import com.kingwin.klibs.eventBus.KEventBusManage;
import com.kingwin.klibs.eventBus.KMessageEvent;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends KBaseActivity {


    @BindView(R.id.tv_name)
    TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick(R.id.tv_name)
    public void clickText(){
        KEventBusManage.getInstance().post(new KMessageEvent(1,"KingWin"));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        tvName.setText("Hello Android");
    }

    @Override
    public void receiveEvent(KMessageEvent obj) {
        if(obj.getCode() == 1){
            tvName.setText("Hello "+obj.getData());
        }
    }
}

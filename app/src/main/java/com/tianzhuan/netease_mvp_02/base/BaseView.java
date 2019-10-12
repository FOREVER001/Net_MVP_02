package com.tianzhuan.netease_mvp_02.base;

import android.app.Activity;
import android.os.Bundle;

//基类（同样他也是有契约的）
public abstract class BaseView<P extends BasePreseter,CONTRACT> extends Activity {
    //接受的用户操作需要传递到P层，所以需要P层的泛型。
    //它是有契约的，到底是登录契约还是订单契约，是需要子类才知道的，所以需要锲约泛型
    protected P p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //弱引用
        p=getPreseter();
        //绑定
        p.bindView(this);
    }
    //让P层做什么需求
    public abstract CONTRACT getContract();
    //从子类中获取具体的契约
    public abstract P getPreseter();
    //如果preseter层出现异常，需要告知View层
    public void error(Exception e){

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除绑定
        p.unBindView();
    }
}

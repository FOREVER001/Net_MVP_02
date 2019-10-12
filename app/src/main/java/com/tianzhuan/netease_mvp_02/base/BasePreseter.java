package com.tianzhuan.netease_mvp_02.base;

import java.lang.ref.WeakReference;

//preseter基类
public abstract class BasePreseter <V extends BaseView,M extends BaseModel,CONTRACT>{
    protected M m;
    //绑定view层的弱引用
    private WeakReference<V> mVWeakReference;

    public BasePreseter() {
        this.m = getModel();
    }

    public void bindView(V v) {
        mVWeakReference=new WeakReference<>(v);
    }

    public void unBindView() {
        if(mVWeakReference!=null){
            mVWeakReference.clear();
            mVWeakReference=null;
            System.gc();
        }
    }
    //获取View，P--V
    public V getView(){
        if(mVWeakReference!=null){
            return mVWeakReference.get();
        }
        return null;
    }

    //子类具体的契约（Model层和View层协商的共同业务）
    public abstract CONTRACT getContract();

    public abstract M getModel();
}

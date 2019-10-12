package com.tianzhuan.netease_mvp_02.login;

import com.tianzhuan.netease_mvp_02.bean.BaseEntitiy;

//将Model层 view层，Preseter层协商的共同业务，封装成接口
//契约，合同
public interface LoginContract {
    interface Model{
        //Model层子类完成方法的具体实现--------------2
        void executeLogin(String name,String pwd)throws Exception;
    }
    interface View<T extends BaseEntitiy>{
        //真实的项目中，请求结果往往是以javaBean-------4
        void handlerReult(T t);
    }
    interface Preseter<T extends BaseEntitiy>{
        //登录请求（接收到View层指令，可以自己做，也可以让Model层去执行）---------1
        void requestLogin(String name,String pwd);
        //结果响应（接收到Model层处理的结果，然后通知View层刷新）--------3
        void responseResult(T t);
    }
}

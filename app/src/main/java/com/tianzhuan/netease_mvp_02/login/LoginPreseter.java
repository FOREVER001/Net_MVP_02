package com.tianzhuan.netease_mvp_02.login;

import android.os.SystemClock;

import com.tianzhuan.netease_mvp_02.LoginActivity;
import com.tianzhuan.netease_mvp_02.base.BasePreseter;
import com.tianzhuan.netease_mvp_02.bean.BaseEntitiy;
import com.tianzhuan.netease_mvp_02.bean.UserInfo;
import com.tianzhuan.netease_mvp_02.http_lib.HttpEngine;

public class LoginPreseter extends BasePreseter<LoginActivity,LoginModel,LoginContract.Preseter> {

    @Override
    public LoginContract.Preseter getContract() {
        //既要履行view给他的需求，又要分配工作给model层
        return new LoginContract.Preseter<UserInfo>() {
            @Override
            public void requestLogin(String name, String pwd) {
                try {
                    //三种风格(p层很极端，要么不做事只做转发，要么就是拼命一个人干活)

                    //第一种写法：不做事情，只做转发
//                    m.getContract().executeLogin(name,pwd);


                    //第二种写法让功能的模块去工作（Library:下载，请求，图片加载）

//                    HttpEngine engine=new HttpEngine<LoginPreseter>(LoginPreseter.this);
//                    engine.post(name,pwd);


                    //第三种写法：p层自己处理

//                    if("netease".equalsIgnoreCase(name) && "163".equals(pwd)){
//                        responseResult(new UserInfo("网易","彭老师"));
//                    }else {
//                        responseResult(null);
//                    }

                    //内存泄漏测试
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            SystemClock.sleep(50000);
                        }
                    }).start();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void responseResult(UserInfo userInfo) {
                //不管谁完成需求，有结果就告知View层
                getView().getContract().handlerReult(userInfo);
            }

        };
    }

    @Override
    public LoginModel getModel() {
        return new LoginModel(this);
    }
}

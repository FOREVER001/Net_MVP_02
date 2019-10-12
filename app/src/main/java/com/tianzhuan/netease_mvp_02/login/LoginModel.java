package com.tianzhuan.netease_mvp_02.login;

import com.tianzhuan.netease_mvp_02.base.BaseModel;
import com.tianzhuan.netease_mvp_02.bean.UserInfo;

//接收到p层交给它的需求
public class LoginModel extends BaseModel<LoginPreseter,LoginContract.Model> {

    public LoginModel(LoginPreseter loginPreseter) {
        super(loginPreseter);
    }

    @Override
    public LoginContract.Model getContract() {
        return new LoginContract.Model() {
            @Override
            public void executeLogin(String name, String pwd) throws Exception {
                if("netease".equalsIgnoreCase(name) && "163".equals(pwd)){
                    p.getContract().responseResult(new UserInfo("网易","彭老师"));
                }else {
                    p.getContract().responseResult(null);
                }
            }
        };
    }
}

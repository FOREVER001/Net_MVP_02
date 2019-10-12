package com.tianzhuan.netease_mvp_02.http_lib;

import com.tianzhuan.netease_mvp_02.base.BasePreseter;
import com.tianzhuan.netease_mvp_02.bean.UserInfo;
import com.tianzhuan.netease_mvp_02.login.LoginModel;
import com.tianzhuan.netease_mvp_02.login.LoginPreseter;

/**
 * 可能是共有的model
 * @param <P>
 */
public class HttpEngine <P extends LoginPreseter>{
    private P p;

    public HttpEngine(P p) {
        this.p = p;
    }
    public void post(String name,String pwd){
        if("netease".equalsIgnoreCase(name) && "163".equals(pwd)){
            p.getContract().responseResult(new UserInfo("网易","彭老师"));
        }else {
            p.getContract().responseResult(null);
        }
    }
}

package com.tianzhuan.netease_mvp_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tianzhuan.netease_mvp_02.base.BaseView;
import com.tianzhuan.netease_mvp_02.bean.BaseEntitiy;
import com.tianzhuan.netease_mvp_02.bean.UserInfo;
import com.tianzhuan.netease_mvp_02.login.LoginContract;
import com.tianzhuan.netease_mvp_02.login.LoginPreseter;

public class LoginActivity extends BaseView<LoginPreseter, LoginContract.View>{
    private EditText name;
    private EditText pwd;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initListener();
    }
    //事件监听
    private void initListener() {

    }
    //初始化控件
    private void initView() {
        name=findViewById(R.id.et_name);
        pwd=findViewById(R.id.et_pwd);
        btn=findViewById(R.id.bt_login);
    }


    //点击事件（真正的开发不推荐这种点击事件的方式，这里为了偷懒演示，所以点击事件不是重点）
    public void doLoginAction(View view) {
        String userName = this.name.getText().toString();
        String userPwd = this.pwd.getText().toString();
        //发起需求，让Preseter处理
        p.getContract().requestLogin(userName,userPwd);
    }

    //view子类实现了契约里面的具体方法
    @Override
    public LoginContract.View getContract() {
        return new LoginContract.View<UserInfo>() {
            @Override
            public void handlerReult(UserInfo userInfo) {
                if(userInfo!=null){
                    Toast.makeText(LoginActivity.this, userInfo.toString(), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();

                }
            }
        };
    }

    @Override
    public LoginPreseter getPreseter() {
        return new LoginPreseter();
    }
}

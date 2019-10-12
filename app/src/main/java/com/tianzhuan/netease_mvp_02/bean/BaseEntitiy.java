package com.tianzhuan.netease_mvp_02.bean;

public class BaseEntitiy {
    private int code;
    private boolean sucess;
    private String err;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSucess() {
        return sucess;
    }

    public void setSucess(boolean sucess) {
        this.sucess = sucess;
    }

    public String getErr() {
        return err == null ? "" : err;
    }

    public void setErr(String err) {
        this.err = err;
    }
}

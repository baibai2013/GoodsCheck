package com.liyijiang.goodscheck.bean;

/**
 * Created by lili on 16/2/3.
 */
public class RequestBean {

    private LoginBean login;
    private String action;
    private Object data;

    public LoginBean getLogin() {
        return login;
    }

    public void setLogin(LoginBean login) {
        this.login = login;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

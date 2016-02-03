package com.liyijiang.goodscheck.bean;

import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.Table;

/**
 * Created by lili on 16/2/3.
 */
@Table(name = "LoginBean")
public class LoginBean {

    @Id
    private int id;

    private String name;
    private String pwd;

    public LoginBean(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof LoginBean))
            return false;

        LoginBean that = (LoginBean) o;

        if (id != that.id)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

}

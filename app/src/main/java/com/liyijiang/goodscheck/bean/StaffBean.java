package com.liyijiang.goodscheck.bean;

import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.Table;

/**
 * 员工bean
 * Created by lili on 16/2/3.
 */
@Table(name = "StaffBean")
public class StaffBean {

    @Id
    private int id;


    //员工编号
    private String staff_id;
    //权限
    private String login;
    //auth MD5
    private String auth;
    //名称
    private String name;

    public StaffBean(String name, String staff_id, String login, String auth) {
        this.name = name;
        this.staff_id = staff_id;
        this.login = login;
        this.auth = auth;
    }


    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof StaffBean))
            return false;

        StaffBean that = (StaffBean) o;

        if (id != that.id)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

}

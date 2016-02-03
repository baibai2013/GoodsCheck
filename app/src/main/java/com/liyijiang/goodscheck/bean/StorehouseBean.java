package com.liyijiang.goodscheck.bean;

import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.Table;

/**
 * Created by lili on 16/2/3.
 */
@Table(name = "StorehouseBean")
public class StorehouseBean {

    @Id
    private int id;


    //库房ID
    private String wid;
    //库房名称
    private String name;
    //城市
    private int area_province;

    public StorehouseBean(String wid, String name, int area_province) {
        this.wid = wid;
        this.name = name;
        this.area_province = area_province;
    }

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea_province() {
        return area_province;
    }

    public void setArea_province(int area_province) {
        this.area_province = area_province;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof StorehouseBean))
            return false;

        StorehouseBean that = (StorehouseBean) o;

        if (id != that.id)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

}

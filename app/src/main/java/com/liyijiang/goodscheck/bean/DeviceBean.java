package com.liyijiang.goodscheck.bean;

import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.Table;

/**
 * Created by lili on 16/2/3.
 */
@Table(name = "DeviceBean")
public class DeviceBean {

    @Id
    private int id;


    //设备id
    private String deviceid;
    //最大盘点数量
    private int macnumber;
    //
    private boolean isupdaload;


    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public int getMacnumber() {
        return macnumber;
    }

    public void setMacnumber(int macnumber) {
        this.macnumber = macnumber;
    }

    public boolean isupdaload() {
        return isupdaload;
    }

    public void setIsupdaload(boolean isupdaload) {
        this.isupdaload = isupdaload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof DeviceBean))
            return false;

        DeviceBean that = (DeviceBean) o;

        if (id != that.id)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

}

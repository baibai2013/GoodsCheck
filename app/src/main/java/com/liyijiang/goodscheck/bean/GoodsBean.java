package com.liyijiang.goodscheck.bean;

import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.Table;

/**
 * Created by lili on 16/2/3.
 */
@Table(name = "GoodsBean")
public class GoodsBean {

    @Id
    private int id;


    //货架号
    private String rackplace;
    //sku
    private String sku;
    //品质
    private int need_qty;

    private int keeper_id;
    //盘点数量
    private int recv_qty;


    public GoodsBean(String rackplace, String sku, int need_qty, int keeper_id, int recv_qty) {
        this.rackplace = rackplace;
        this.sku = sku;
        this.need_qty = need_qty;
        this.keeper_id = keeper_id;
        this.recv_qty = recv_qty;
    }

    public String getRackplace() {
        return rackplace;
    }

    public void setRackplace(String rackplace) {
        this.rackplace = rackplace;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getNeed_qty() {
        return need_qty;
    }

    public void setNeed_qty(int need_qty) {
        this.need_qty = need_qty;
    }

    public int getKeeper_id() {
        return keeper_id;
    }

    public void setKeeper_id(int keeper_id) {
        this.keeper_id = keeper_id;
    }

    public int getRecv_qty() {
        return recv_qty;
    }

    public void setRecv_qty(int recv_qty) {
        this.recv_qty = recv_qty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof GoodsBean))
            return false;

        GoodsBean that = (GoodsBean) o;

        if (id != that.id)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

}

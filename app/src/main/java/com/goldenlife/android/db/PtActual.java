package com.goldenlife.android.db;

import org.litepal.crud.DataSupport;

/**
 * Created by 森宇 on 2018/5/7.
 */

public class PtActual extends DataSupport {//现货铂金
    private int id;

    private float midpri;//中间价

    private float buypri;//买入价

    private float sellpri;//卖出价

    private float maxpri;//最高价

    private float minpri;//最低价

    private float todayopen;//今日开盘价;

    private float closeyes;//昨日收盘价;

    private float quantpri;//涨跌

    private String updatetime;//更新时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMidpri() {
        return midpri;
    }

    public void setMidpri(float midpri) {
        this.midpri = midpri;
    }

    public float getBuypri() {
        return buypri;
    }

    public void setBuypri(float buypri) {
        this.buypri = buypri;
    }

    public float getSellpri() {
        return sellpri;
    }

    public void setSellpri(float sellpri) {
        this.sellpri = sellpri;
    }

    public float getMaxpri() {
        return maxpri;
    }

    public void setMaxpri(float maxpri) {
        this.maxpri = maxpri;
    }

    public float getMinpri() {
        return minpri;
    }

    public void setMinpri(float minpri) {
        this.minpri = minpri;
    }

    public float getTodayopen() {
        return todayopen;
    }

    public void setTodayopen(float todayopen) {
        this.todayopen = todayopen;
    }

    public float getCloseyes() {
        return closeyes;
    }

    public void setCloseyes(float closeyes) {
        this.closeyes = closeyes;
    }

    public float getQuantpri() {
        return quantpri;
    }

    public void setQuantpri(float quantpri) {
        this.quantpri = quantpri;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
}

package com.goldenlife.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 森宇 on 2018/5/8.
 */

public class Ag {
    @SerializedName("midpri")
    public float agmidpri;//中间价

    @SerializedName("buypri")
    public float agbuypri;//买入价

    @SerializedName("sellpri")
    public float agsellpri;//卖出价

    @SerializedName("maxpri")
    public float agmaxpri;//最高价

    @SerializedName("minpri")
    public float agminpri;//最低价

    @SerializedName("todayopen")
    public float agtodayopen;//今日开盘价;

    @SerializedName("closeyes")
    public float agcloseyes;//昨日收盘价;

    @SerializedName("quantpri")
    public float agquantpri;//涨跌

    @SerializedName("time")
    public String agupdatetime;//更新时间
}

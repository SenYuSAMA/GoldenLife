package com.goldenlife.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 森宇 on 2018/5/8.
 */

public class Pd {
    @SerializedName("midpri")
    public float pdmidpri;//中间价

    @SerializedName("buypri")
    public float pdbuypri;//买入价

    @SerializedName("sellpri")
    public float pdsellpri;//卖出价

    @SerializedName("maxpri")
    public float pdmaxpri;//最高价

    @SerializedName("minpri")
    public float pdminpri;//最低价

    @SerializedName("todayopen")
    public float pdtodayopen;//今日开盘价;

    @SerializedName("closeyes")
    public float pdcloseyes;//昨日收盘价;

    @SerializedName("quantpri")
    public float pdquantpri;//涨跌

    @SerializedName("time")
    public String pdupdatetime;//更新时间
}

package com.goldenlife.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 森宇 on 2018/5/8.
 */

public class Au {
    @SerializedName("midpri")
    public float aumidpri;//中间价

    @SerializedName("buypri")
    public float aubuypri;//买入价

    @SerializedName("sellpri")
    public float ausellpri;//卖出价

    @SerializedName("maxpri")
    public float aumaxpri;//最高价

    @SerializedName("minpri")
    public float auminpri;//最低价

    @SerializedName("todayopen")
    public float autodayopen;//今日开盘价;

    @SerializedName("closeyes")
    public float aucloseyes;//昨日收盘价;

    @SerializedName("quantpri")
    public float auquantpri;//涨跌

    @SerializedName("time")
    public String auupdatetime;//更新时间
}

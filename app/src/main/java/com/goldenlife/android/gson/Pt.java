package com.goldenlife.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 森宇 on 2018/5/8.
 */

public class Pt {
    @SerializedName("midpri")
    public float ptmidpri;//中间价

    @SerializedName("buypri")
    public float ptbuypri;//买入价

    @SerializedName("sellpri")
    public float ptsellpri;//卖出价

    @SerializedName("maxpri")
    public float ptmaxpri;//最高价

    @SerializedName("minpri")
    public float ptminpri;//最低价

    @SerializedName("todayopen")
    public float pttodayopen;//今日开盘价;

    @SerializedName("closeyes")
    public float ptcloseyes;//昨日收盘价;

    @SerializedName("quantpri")
    public float ptquantpri;//涨跌

    @SerializedName("time")
    public String ptupdatetime;//更新时间
}

package com.goldenlife.android.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 森宇 on 2018/5/18.
 */

public class News {
    @SerializedName("list")
    public List<NewsList> newslist;
}

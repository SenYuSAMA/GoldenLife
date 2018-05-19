package com.goldenlife.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 森宇 on 2018/5/18.
 */

public class NewsList {

    public NewsList(String newstitle,String newstime){
        this.newstitle = newstitle;
        this.newstime = newstime;
    }

    @SerializedName("title")
    public String newstitle;

    @SerializedName("time")
    public String newstime;

    @SerializedName("url")
    public String newsurl;

    public String getNewstitle() {
        return newstitle;
    }

    public String getNewstime() {
        return newstime;
    }

    public String getNewsurl() {
        return newsurl;
    }
}

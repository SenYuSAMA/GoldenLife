package com.goldenlife.android.view;

import com.goldenlife.android.gson.News;

/**
 * Created by 森宇 on 2018/5/8.
 */

public interface ViewInt {
    public void showError();

    public void showSuccess();

    public void setNews(News news);

    public News getNews();
}

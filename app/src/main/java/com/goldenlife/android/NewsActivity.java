package com.goldenlife.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.goldenlife.android.gson.News;
import com.goldenlife.android.presenter.MyPresenter;
import com.goldenlife.android.view.ViewInt;

public class NewsActivity extends AppCompatActivity implements ViewInt{
    private News news;
    private MyPresenter myPresenter;
    private Button pricebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
       /* myPresenter = new MyPresenter(this);
        myPresenter.parseNewsJson();
        News news = getNews();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        NewsAdapter newsAdapter = new NewsAdapter(news.newslist);
        recyclerView.setAdapter(newsAdapter);*/
        pricebtn = (Button)findViewById(R.id.btn_price);
        pricebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewsActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showError() {

    }

    @Override
    public void showSuccess() {

    }

    @Override
    public void setNews(News news) {
        this.news = news;
    }

    @Override
    public News getNews() {
        return news;
    }


}

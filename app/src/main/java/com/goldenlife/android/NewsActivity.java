package com.goldenlife.android;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.SystemClock;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.goldenlife.android.gson.News;
import com.goldenlife.android.gson.NewsList;
import com.goldenlife.android.presenter.MyPresenter;
import com.goldenlife.android.view.ViewInt;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity implements ViewInt{
    private News news;
    private List<NewsList> xinwen = new ArrayList<>();
    private MyPresenter myPresenter;
    private Button pricebtn;
    private TextView titleV;
    private SwipeRefreshLayout swp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        swp = (SwipeRefreshLayout)findViewById(R.id.swipe_refresh);
        if (getSupportActionBar() != null){//隐藏标题
            getSupportActionBar().hide();
        }
        if(Build.VERSION.SDK_INT >=21){//状态栏透明
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.BLACK);
        }
        titleV = (TextView)findViewById(R.id.current_type);
        titleV.setText("财经资讯");
        myPresenter = new MyPresenter(this);
        Log.d("NewsActivity","准备调用parseNewsJson");
        myPresenter.parseNewsJson();
        SystemClock.sleep(2500);//执行网络耗时操作，一定要等一哈,否则下一行代码会报空指针错误
        News news = getNews();
        xinwen  = news.thenewslist;
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        NewsAdapter newsAdapter = new NewsAdapter(xinwen);
        recyclerView.setAdapter(newsAdapter);
        swp.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(NewsActivity.this,"刷新完成",Toast.LENGTH_SHORT).show();
                swp.setRefreshing(false);
            }
        });
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

package com.goldenlife.android;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
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
import com.goldenlife.android.util.HttpUtil;
import com.goldenlife.android.util.Utility;
import com.goldenlife.android.view.ViewInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class NewsActivity extends AppCompatActivity implements ViewInt{
    private News news;
    private MyPresenter myPresenter;
    private Button pricebtn;
    private TextView titleV;
    private SwipeRefreshLayout swp;
    private String path = "http://api.jisuapi.com/news/get?channel=财经&start=0&num=20&appkey=4e51586fe92728b8";
    private RecyclerView recyclerView;
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
     /*   Log.d("NewsActivity","准备调用parseNewsJson");*/
       /* myPresenter.parseNewsJson();
        SystemClock.sleep(2500);//执行网络耗时操作，一定要等一哈,否则下一行代码会报空指针错误
        News news = getNews();
        xinwen  = news.thenewslist;*/
       recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        new NewsAsyncTask().execute(path);

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

    class NewsAsyncTask extends AsyncTask<String,Integer,List<NewsList>>{

        @Override
        protected List<NewsList> doInBackground(String... strings) {
            return getNewsJson(strings[0]);
        }

        @Override
        protected void onPostExecute(List<NewsList> newsLists) {
            super.onPostExecute(newsLists);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(NewsActivity.this);
            recyclerView.setLayoutManager(linearLayoutManager);
            NewsAdapter newsAdapter = new NewsAdapter(newsLists);
            recyclerView.setAdapter(newsAdapter);
        }
    }

    private List<NewsList> getNewsJson(String string) {
        List<NewsList> newsList = new ArrayList<>();
        try {
            String response = readStream(new URL(string).openStream());
            Log.d("getNewsJson",response);
            News news = Utility.handleNewsResponse(response);
            newsList = news.thenewslist;
            return newsList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newsList;
    }

    private String readStream(InputStream inputStream) {
        InputStreamReader isr;
        String result = "";
        try {
            String line = "";
            isr = new InputStreamReader(inputStream, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                result += line;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
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

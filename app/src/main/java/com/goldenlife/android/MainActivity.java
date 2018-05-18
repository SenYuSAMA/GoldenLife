package com.goldenlife.android;


import android.app.ListFragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.goldenlife.android.gson.News;
import com.goldenlife.android.gson.Result;
import com.goldenlife.android.presenter.MyPresenter;
import com.goldenlife.android.presenter.UpdateDBService;
import com.goldenlife.android.util.HttpUtil;
import com.goldenlife.android.util.Utility;
import com.goldenlife.android.view.ViewInt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements ViewInt{
    MyPresenter myPresenter;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private Button newsbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*requestWindowFeature(Window.FEATURE_NO_TITLE);*/
        if (getSupportActionBar() != null){//隐藏标题
            getSupportActionBar().hide();
        }
        if(Build.VERSION.SDK_INT >=21){//状态栏透明
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.BLACK);
        }
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        initViewPager();//初始化ViewPager

        Intent intent = new Intent(this, UpdateDBService.class);
        startService(intent);
        myPresenter = new MyPresenter(this);//把自己注入MyPresenter(通过MyPresenter的构造方法)
        newsbtn = (Button)findViewById(R.id.btn_news);
        newsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NewsActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initViewPager() {
        mTabLayout = (TabLayout)findViewById(R.id.tabs);
        List<String> titles = new ArrayList<>();
        titles.add("现货黄金");
        titles.add("现货白银");
        titles.add("现货铂金");
        titles.add("现货钯金");

        for(int i = 0; i < titles.size(); i++){
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(i)));
        }//初始化4个标签页

        List<Fragment>fragments = new ArrayList<>();//搞定fragments List用于传进FragmentAdapter的构造函数，此时仍未涉及布局

            fragments.add(new FragmentAu());
            fragments.add(new FragmentAg());
            fragments.add(new FragmentPt());
            fragments.add(new FragmentPd());


        FragmentAdapter mFragmentAdapteradapter = new FragmentAdapter(getSupportFragmentManager(),fragments,titles);

        mViewPager.setAdapter(mFragmentAdapteradapter);//关联ViewPager和它的adapter
        mTabLayout.setupWithViewPager(mViewPager);//把tab装入ViewPager
        mTabLayout.setTabsFromPagerAdapter(mFragmentAdapteradapter);//tab也要装入ViewPager的adapter
    }

    @Override
    public void showError() {
        Toast.makeText(this,"网络故障或尚未开市，无法获取新的报价信息",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccess() {
        Log.d("MainActivity","准备弹Toast");
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,"已成功获取报价信息并且存入数据库中",Toast.LENGTH_SHORT).show();
            }
        });


    }



    @Override
    public void setNews(News news) {

    }
    @Override
    public News getNews() {
        return null;
    }
}

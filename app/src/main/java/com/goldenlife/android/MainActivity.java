package com.goldenlife.android;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.goldenlife.android.gson.Result;
import com.goldenlife.android.presenter.MyPresenter;
import com.goldenlife.android.presenter.UpdateDBService;
import com.goldenlife.android.util.HttpUtil;
import com.goldenlife.android.util.Utility;
import com.goldenlife.android.view.ViewInt;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements ViewInt{
    MyPresenter myPresenter;
    private Button testButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, UpdateDBService.class);
        startService(intent);
        myPresenter = new MyPresenter(this);//把自己注入MyPresenter(通过MyPresenter的构造方法)
        testButton = (Button)findViewById(R.id.test);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPresenter.parseJson();
            }
        });
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
}

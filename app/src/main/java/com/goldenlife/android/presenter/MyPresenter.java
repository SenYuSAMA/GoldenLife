package com.goldenlife.android.presenter;

import android.util.Log;

import com.goldenlife.android.gson.Result;
import com.goldenlife.android.model.ModelImp;
import com.goldenlife.android.model.ModelInt;
import com.goldenlife.android.util.HttpUtil;
import com.goldenlife.android.util.Utility;
import com.goldenlife.android.view.ViewInt;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by 森宇 on 2018/5/8.
 */

public class MyPresenter {
    ModelInt mmodelInt;
    ViewInt mViewInt;


    public MyPresenter(ViewInt mViewInt){
        this.mViewInt = mViewInt;
        mmodelInt = new ModelImp();//*****曾因此句话丢失导致空指针错误！！！！
    }

    public void parseJson(){
        new Thread(new Runnable() {
            @Override
            public void run() {




        String path="http://web.juhe.cn:8080/finance/gold/bankgold?key=99b453c9cb68117ae21c0ef536ac1e68";
        HttpUtil.sendOkHttpRequest(path, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if(mViewInt != null){
                    mViewInt.showError();
                    Log.d("onfailure","onfailure被调用");
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseText = response.body().string();
                final Result result = Utility.handleResultResponse(responseText);
                Log.d("onResponse","刚好获取完result");
                        if(result != null){
                            //将解析回来的JSon对象转化成的Result对象对应一一赋值给各种Actual
                            Log.d("onResponse","准备调用tellmodlesave");
                            tellmodlesave(result);
                            /*mmodelInt.savetoDB(result);*/

                            Log.d("onResponse","准备调用showSuccess()");
                           tellviewshowsuccess();
                        }else if(result == null){
                            Log.d("onResponse","result是空");
                        }



            }
        });
            }
        }).start();
    }

    private void tellviewshowsuccess() {
        if(mViewInt !=null){
            mViewInt.showSuccess();
        }
    }

    private void tellmodlesave(Result result) {
        Log.d("tellmodlesave","准备开始调用savetodb");
        mmodelInt.savetoDB(result);
    }


}

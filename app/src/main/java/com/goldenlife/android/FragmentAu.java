package com.goldenlife.android;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.goldenlife.android.db.AuActual;
import com.goldenlife.android.presenter.FragmentPresenter;
import com.goldenlife.android.view.FragViewInt;

import org.litepal.crud.DataSupport;

/**
 * Created by 森宇 on 2018/5/15.
 */

public class FragmentAu extends Fragment implements FragViewInt {
    private FragmentPresenter fragmentPresenter;
    private TextView tvbuy;
    private TextView tvmid;
    private TextView tvsell;
    private TextView tvmin;
    private TextView tvmax;
    private TextView tvtoday;
    private TextView tvyes;
    private TextView tvtime;
    private TextView tvquan;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_au,container,false);
        Log.d("黄金", "onCreateView:调用 ");
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        fragmentPresenter = new FragmentPresenter(this);
        fragmentPresenter.updateAu();
        Log.d("黄金", "onStart:调用 ");
    }

 /*   @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {//在onCreateView之前就会执行
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            Log.d("黄金","对用户可见");

        }else {
            Log.d("黄金","不可见");
        }
    }*/

    @Override
    public void showData(DataSupport dataSupport) {
        AuActual au = (AuActual)dataSupport;
        Float buyprice = au.getBuypri();
        Float midpirce = au.getMidpri();
        Float sellprice = au.getSellpri();
        Float maxprice = au.getMaxpri();
        Float minprice = au.getMinpri();
        Float todayopen = au.getTodayopen();
        Float closeyes = au.getCloseyes();
        Float quan = au.getQuantpri();
        String time = au.getUpdatetime();

        tvbuy = super.getView().findViewById(R.id.au_buypri);
        tvsell = super.getView().findViewById(R.id.au_sellpri);
        tvmax = super.getView().findViewById(R.id.au_maxpri);
        tvmin = super.getView().findViewById(R.id.au_minpri);
        tvyes = super.getView().findViewById(R.id.au_closeyes);
        tvtoday = super.getView().findViewById(R.id.au_todayopen);
        tvmid = super.getView().findViewById(R.id.au_midpri);
        tvtime = super.getView().findViewById(R.id.au_time);
        tvquan = super.getView().findViewById(R.id.au_quantpri);

        if(quan <= 0){
            tvbuy.setText(buyprice.toString() + "↓");
            tvquan.setText(quan.toString());
            tvbuy.setTextColor(Color.rgb(27,148,23));
            tvquan.setTextColor(Color.rgb(27,148,23));
        }else if(quan > 0){
            tvbuy.setText(buyprice.toString()+ "↑");
            tvquan.setText(quan.toString());
            tvbuy.setTextColor(Color.RED);
            tvquan.setTextColor(Color.RED);
        }


        tvsell.setText(sellprice.toString());
        tvmax.setText(maxprice.toString());
        tvmin.setText(minprice.toString());
        tvyes.setText(closeyes.toString());
        tvtoday.setText(todayopen.toString());
        tvmid.setText(midpirce.toString());

        tvtime.setText(time);


    }
}

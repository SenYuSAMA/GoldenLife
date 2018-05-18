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

import com.goldenlife.android.db.AgActual;
import com.goldenlife.android.presenter.FragmentPresenter;
import com.goldenlife.android.view.FragViewInt;

import org.litepal.crud.DataSupport;

/**
 * Created by 森宇 on 2018/5/15.
 */

public class FragmentAg extends Fragment implements FragViewInt{
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
        View view = inflater.inflate(R.layout.fragment_ag,container,false);
        Log.d("白银", "onCreateView:调用 ");
        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("白银", "onStart:调用 ");
        fragmentPresenter = new FragmentPresenter(this);
        fragmentPresenter.updateAg();
    }

/*    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            Log.d("白银","对用户可见");

        }else{
            Log.d("白银","不可见");
        }
    }*/

    @Override
    public void showData(DataSupport dataSupport) {
        AgActual ag = (AgActual)dataSupport;
        Float buyprice = ag.getBuypri();
        Float midpirce = ag.getMidpri();
        Float sellprice = ag.getSellpri();
        Float maxprice = ag.getMaxpri();
        Float minprice = ag.getMinpri();
        Float todayopen = ag.getTodayopen();
        Float closeyes = ag.getCloseyes();
        Float quan = ag.getQuantpri();
        String time = ag.getUpdatetime();

        tvquan = super.getView().findViewById(R.id.ag_quantpri);
        tvbuy = super.getView().findViewById(R.id.ag_buypri);
        tvsell = super.getView().findViewById(R.id.ag_sellpri);
        tvmax = super.getView().findViewById(R.id.ag_maxpri);
        tvmin = super.getView().findViewById(R.id.ag_minpri);
        tvyes = super.getView().findViewById(R.id.ag_closeyes);
        tvtoday = super.getView().findViewById(R.id.ag_todayopen);
        tvmid = super.getView().findViewById(R.id.ag_midpri);
        tvtime = super.getView().findViewById(R.id.ag_time);

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

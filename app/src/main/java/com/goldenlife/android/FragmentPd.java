package com.goldenlife.android;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.goldenlife.android.db.AuActual;
import com.goldenlife.android.db.PdActual;
import com.goldenlife.android.presenter.FragmentPresenter;
import com.goldenlife.android.view.FragViewInt;

import org.litepal.crud.DataSupport;

/**
 * Created by 森宇 on 2018/5/15.
 */

public class FragmentPd extends Fragment implements FragViewInt{
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
        View view = inflater.inflate(R.layout.fragment_pd,container,false);
        Log.d("钯金", "onCreateView:调用 ");
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("钯金", "onStart:调用 ");
        fragmentPresenter = new FragmentPresenter(this);
        fragmentPresenter.updatePd();
    }

    @Override
    public void showData(DataSupport dataSupport) {
        PdActual pd = (PdActual)dataSupport;
        Float buyprice = pd.getBuypri();
        Float midpirce = pd.getMidpri();
        Float sellprice = pd.getSellpri();
        Float maxprice = pd.getMaxpri();
        Float minprice = pd.getMinpri();
        Float todayopen = pd.getTodayopen();
        Float closeyes = pd.getCloseyes();
        Float quan = pd.getQuantpri();
        String time = pd.getUpdatetime();

        tvbuy = super.getView().findViewById(R.id.pd_buypri);
        tvsell = super.getView().findViewById(R.id.pd_sellpri);
        tvmax = super.getView().findViewById(R.id.pd_maxpri);
        tvmin = super.getView().findViewById(R.id.pd_minpri);
        tvyes = super.getView().findViewById(R.id.pd_closeyes);
        tvtoday = super.getView().findViewById(R.id.pd_todayopen);
        tvmid = super.getView().findViewById(R.id.pd_midpri);
        tvtime = super.getView().findViewById(R.id.pd_time);
        tvquan = super.getView().findViewById(R.id.pd_quantpri);

        tvbuy.setText(buyprice.toString());
        tvsell.setText(sellprice.toString());
        tvmax.setText(maxprice.toString());
        tvmin.setText(minprice.toString());
        tvyes.setText(closeyes.toString());
        tvtoday.setText(todayopen.toString());
        tvmid.setText(midpirce.toString());
        tvquan.setText(quan.toString());
        tvtime.setText(time);
    }
}

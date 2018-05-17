package com.goldenlife.android;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.goldenlife.android.db.PdActual;
import com.goldenlife.android.db.PtActual;
import com.goldenlife.android.gson.Pt;
import com.goldenlife.android.presenter.FragmentPresenter;
import com.goldenlife.android.view.FragViewInt;

import org.litepal.crud.DataSupport;

/**
 * Created by 森宇 on 2018/5/15.
 */

public class FragmentPt extends Fragment implements FragViewInt {
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
        View view = inflater.inflate(R.layout.fragment_pt,container,false);
        Log.d("铂金", "onCreateView:调用 ");
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("铂金", "onStart:调用 ");
        fragmentPresenter = new FragmentPresenter(this);
        fragmentPresenter.updatePt();
    }

    @Override
    public void showData(DataSupport dataSupport) {
        PtActual pt = (PtActual)dataSupport;
        Float buyprice = pt.getBuypri();
        Float midpirce = pt.getMidpri();
        Float sellprice = pt.getSellpri();
        Float maxprice = pt.getMaxpri();
        Float minprice = pt.getMinpri();
        Float todayopen = pt.getTodayopen();
        Float closeyes = pt.getCloseyes();
        Float quan = pt.getQuantpri();
        String time = pt.getUpdatetime();

        tvbuy = super.getView().findViewById(R.id.pt_buypri);
        tvsell = super.getView().findViewById(R.id.pt_sellpri);
        tvmax = super.getView().findViewById(R.id.pt_maxpri);
        tvmin = super.getView().findViewById(R.id.pt_minpri);
        tvyes = super.getView().findViewById(R.id.pt_closeyes);
        tvtoday = super.getView().findViewById(R.id.pt_todayopen);
        tvmid = super.getView().findViewById(R.id.pt_midpri);
        tvtime = super.getView().findViewById(R.id.pt_time);
        tvquan = super.getView().findViewById(R.id.pt_quantpri);

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

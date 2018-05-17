package com.goldenlife.android.model;

import com.goldenlife.android.db.AgActual;
import com.goldenlife.android.db.AuActual;

import com.goldenlife.android.db.PdActual;
import com.goldenlife.android.db.PtActual;
import com.goldenlife.android.gson.Result;

import org.litepal.crud.DataSupport;

/**
 * Created by 森宇 on 2018/5/8.
 */

public interface ModelInt {
    public void savetoDB(Result result);//将报价数据并存储到数据库中

    public AgActual queryAg();

    public AuActual queryAu();

    public PdActual queryPd();

    public PtActual queryPt();


}

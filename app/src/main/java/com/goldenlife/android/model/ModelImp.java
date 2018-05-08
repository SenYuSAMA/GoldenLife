package com.goldenlife.android.model;

import android.util.Log;

import com.goldenlife.android.db.AgActual;
import com.goldenlife.android.db.AuActual;
import com.goldenlife.android.db.PdActual;
import com.goldenlife.android.db.PtActual;
import com.goldenlife.android.gson.Result;

/**
 * Created by 森宇 on 2018/5/8.
 */

public class ModelImp implements ModelInt {
    public void savetoDB(Result result){
        //Au一一赋值并保存至表
        AuActual auActual = new AuActual();
        auActual.setBuypri(result.au.aubuypri);
        auActual.setMaxpri(result.au.aumaxpri);
        auActual.setMidpri(result.au.aumidpri);
        auActual.setMinpri(result.au.auminpri);
        auActual.setCloseyes(result.au.aucloseyes);
        auActual.setQuantpri(result.au.auquantpri);
        auActual.setSellpri(result.au.ausellpri);
        auActual.setTodayopen(result.au.autodayopen);
        auActual.setUpdatetime(result.au.auupdatetime);
        auActual.save();

        //Ag一一赋值并保存至表
        AgActual agActual = new AgActual();
        agActual.setBuypri(result.ag.agbuypri);
        agActual.setMaxpri(result.ag.agmaxpri);
        agActual.setMidpri(result.ag.agmidpri);
        agActual.setMinpri(result.ag.agminpri);
        agActual.setCloseyes(result.ag.agcloseyes);
        agActual.setQuantpri(result.ag.agquantpri);
        agActual.setSellpri(result.ag.agsellpri);
        agActual.setTodayopen(result.ag.agtodayopen);
        agActual.setUpdatetime(result.ag.agupdatetime);
        agActual.save();

        //Pt一一赋值并保存至表
        PtActual ptActual = new PtActual();
        ptActual.setBuypri(result.pt.ptbuypri);
        ptActual.setMaxpri(result.pt.ptmaxpri);
        ptActual.setMidpri(result.pt.ptmidpri);
        ptActual.setMinpri(result.pt.ptminpri);
        ptActual.setCloseyes(result.pt.ptcloseyes);
        ptActual.setQuantpri(result.pt.ptquantpri);
        ptActual.setSellpri(result.pt.ptsellpri);
        ptActual.setTodayopen(result.pt.pttodayopen);
        ptActual.setUpdatetime(result.pt.ptupdatetime);
        ptActual.save();

        //Pd一一赋值并保存至表
        PdActual pdActual = new PdActual();
        pdActual.setBuypri(result.pd.pdbuypri);
        pdActual.setMaxpri(result.pd.pdmaxpri);
        pdActual.setMidpri(result.pd.pdmidpri);
        pdActual.setMinpri(result.pd.pdminpri);
        pdActual.setCloseyes(result.pd.pdcloseyes);
        pdActual.setQuantpri(result.pd.pdquantpri);
        pdActual.setSellpri(result.pd.pdsellpri);
        pdActual.setTodayopen(result.pd.pdtodayopen);
        pdActual.setUpdatetime(result.pd.pdupdatetime);
        pdActual.save();
    }
}

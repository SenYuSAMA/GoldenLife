package com.goldenlife.android.presenter;

import com.goldenlife.android.db.AgActual;
import com.goldenlife.android.db.AuActual;
import com.goldenlife.android.db.PdActual;
import com.goldenlife.android.db.PtActual;
import com.goldenlife.android.model.ModelImp;
import com.goldenlife.android.model.ModelInt;
import com.goldenlife.android.view.FragViewInt;




/**
 * Created by 森宇 on 2018/5/16.
 */

public class FragmentPresenter{
    ModelInt mmodelInt;
    FragViewInt mFragViewInt;
    public FragmentPresenter(FragViewInt mFragViewInt){
        this.mFragViewInt = mFragViewInt;
        mmodelInt = new ModelImp();
    }
    public void updateAg(){
        AgActual lastAg = mmodelInt.queryAg();
        mFragViewInt.showData(lastAg);
    }
    public void updateAu(){
        AuActual lastAu = mmodelInt.queryAu();
        mFragViewInt.showData(lastAu);
    }
    public void updatePd(){
        PdActual lastPd = mmodelInt.queryPd();
        mFragViewInt.showData(lastPd);
    }
    public void updatePt(){
        PtActual lastPt = mmodelInt.queryPt();
        mFragViewInt.showData(lastPt);
    }
}

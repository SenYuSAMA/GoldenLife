package com.goldenlife.android.presenter;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
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

public class UpdateDBService extends Service {
   //本service直接调用MyPresenter的各种逻辑，自己实现的逻辑仅仅是定时和不死
    MyPresenter myPresenter;
    public UpdateDBService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myPresenter =  new MyPresenter(null);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        myPresenter.parseJson();
        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        int timeflag = 30 * 60 * 1000;//三十分钟更新一次
        long triggerAtTime = SystemClock.elapsedRealtime() + timeflag;
        Intent i = new Intent(this,UpdateDBService.class);
        PendingIntent pi = PendingIntent.getService(this,0,i,0);
        manager.cancel(pi);
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggerAtTime,pi);
        return super.onStartCommand(intent,flags,startId);
    }
}

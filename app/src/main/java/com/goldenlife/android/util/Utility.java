package com.goldenlife.android.util;

import com.goldenlife.android.gson.Result;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by 森宇 on 2018/5/8.
 */

public class Utility {
    public static Result handleResultResponse(String response){
        try{
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("result");
            String resultContent = jsonArray.getJSONObject(0).toString();
            return  new Gson().fromJson(resultContent,Result.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

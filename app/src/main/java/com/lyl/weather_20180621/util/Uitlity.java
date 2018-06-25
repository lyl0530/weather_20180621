package com.lyl.weather_20180621.util;


import android.text.TextUtils;
import android.util.Log;

import com.lyl.weather_20180621.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by dengjifu on 18-6-23.
 */

public class Uitlity {
    private final static String TAG = "lyl123";
    public static boolean dealProvinceResonse(String response){
        Log.e(TAG, "jsonStr = " + response);
        if (!TextUtils.isEmpty(response)){
            JSONArray jsonArray = null;
            try {
                jsonArray = new JSONArray(response);
                for (int i = 0; i < jsonArray.length(); i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceId(jsonObject.getInt("id"));
                    province.setProvinceName(jsonObject.getString("name"/*"provinceName"*/));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}

package com.lyl.weather_20180621.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by dengjifu on 18-6-23.
 */

public class HttpUtil {
//    public static Response getResponse(URL url/*, Callback callback*/) throws IOException {
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder().url(url).build();
//        //client.newCall(request).enqueue(callback);
//        return client.newCall(request).execute();
//    }
    //方法名字要表示出该方法是干什么的
    //只是发送请求，此时还看不到返回值，返回值要在callback中处理
    //网址可使用字符串
    public static void sendOkHttpRequest(String url, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(callback);
    }
}

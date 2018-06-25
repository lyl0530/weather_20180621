package com.lyl.weather_20180621;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

public class MainActivity extends FragmentActivity {
    private final static String TAG = "lyl123";
/*
    "省市县"数据的各种操作
    来源：
        "http://guolin.tech/api/china"
        "http://guolin.tech/api/china/1"
        "http://guolin.tech/api/china/1/50"
    格式：
        Json格式数据　　　
         [{"id":1,"name":"北京"},{"id":2,"name":"上海"},　... ,{"id":34,"name":"新疆"}]
         [{"id":96,"name":"济南"},{"id":97,"name":"青岛"}, ... ,{"id":112,"name":"聊城"}]
         [{"id":862,"name":"泰安","weather_id":"CN101120801"}, ... ,{"id":866,"name":"宁阳","weather_id":"CN101120806"}]
    请求：
        okHttp --> 第三方库
        compile 'com.squareup.okhttp3:okhttp:3.4.1'
    处理：
        litepal操作数据库 --> 第三方库
        compile 'org.litepal.android:core:2.0.0'
    存取：
        DateSupport.findAll()/save()
    显示：
        listView + Adapter

*/

/*
    先显示界面　再请求处理数据　最后将数据显示
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(TAG, "动态添加fragment");
//        //动态添加fragment
//        //getSupportFragmentManager方法找不到，注意，对应的Activity要继承FragmentActivity
        FragmentManager fgMgr = getSupportFragmentManager();
        FragmentTransaction transaction = fgMgr.beginTransaction();//开启事务
        transaction.replace(R.id.fg_main, new ChooseAreaFragment());//添加
        transaction.commit();//提交
    }
}

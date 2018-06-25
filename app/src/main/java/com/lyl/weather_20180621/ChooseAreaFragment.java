package com.lyl.weather_20180621;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.litepal.crud.DataSupport;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.lyl.weather_20180621.db.Province;

import okhttp3.Call;
import okhttp3.Response;

import com.lyl.weather_20180621.util.HttpUtil;
import com.lyl.weather_20180621.util.Uitlity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChooseAreaFragment extends Fragment {
    private final static String TAG = "lyl123";

    private ListView lv_content;
    private List<String> dateList = new ArrayList<>();;
    private ArrayAdapter<String> myAdapter;

    private List<Province> provincesList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_choose_area, container, false);
        lv_content = (ListView) rootView.findViewById(R.id.lv_content);
        myAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, dateList);
        lv_content.setAdapter(this.myAdapter);

        return rootView;
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        queryProvince();
    }

    private void queryProvince() {
        //get data
        provincesList = DataSupport.findAll(Province.class);
        Log.e(TAG, "provincesList = " + provincesList);
        if (null != provincesList && provincesList.size() > 0){
            dateList.clear();
            for (Province p : provincesList){
                dateList.add(p.getProvinceName());
            }
            Log.e(TAG, "dateList = " + dateList);
            lv_content.setSelection(0);
            myAdapter.notifyDataSetChanged();

        } else {
            try {
                String url = "http://guolin.tech/api/china";
                queryFromServer(url);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private void queryFromServer(String url){
        HttpUtil.sendOkHttpRequest(url, new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String jsonStr = response.body().string();
                if(Uitlity.dealProvinceResonse(jsonStr)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            queryProvince();
                        }
                    });
                }

            }
        });


    }
}

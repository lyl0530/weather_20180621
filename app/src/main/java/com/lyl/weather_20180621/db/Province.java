package com.lyl.weather_20180621.db;

import org.litepal.crud.DataSupport;

/**
 * Created by dengjifu on 18-6-23.
 */

public class Province extends DataSupport {
    public int id;
    public String provinceName;
    public int provinceId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", provinceName='" + provinceName + '\'' +
                ", provinceId=" + provinceId +
                '}';
    }
}

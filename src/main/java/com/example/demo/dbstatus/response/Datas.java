package com.example.demo.dbstatus.response;

import java.util.ArrayList;
import java.util.List;

public class Datas {

    public Datas() {
        this.indicators = new ArrayList<>();
    }

    public Datas(String count, List<String> indicators, String subtypeEn) {
        this.count = count;
        this.indicators = indicators;
        this.subtypeEn = subtypeEn;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<String> getIndicators() {
        return indicators;
    }

    public void setIndicators(List<String> indicators) {
        this.indicators = indicators;
    }

    public String getSubtypeEn() {
        return subtypeEn;
    }

    public void setSubtypeEn(String subtypeEn) {
        this.subtypeEn = subtypeEn;
    }

    public String count;

    public List<String> indicators;

    public String subtypeEn;
}

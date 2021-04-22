package com.example.demo.district.response;

import java.util.ArrayList;
import java.util.List;

public class Datas {

    public Datas() {
        this.indicators = new ArrayList<>();
    }

    public Datas(Long count, List<String> indicators, String subtypeEn) {
        this.count = count;
        this.indicators = indicators;
        this.subtypeEn = subtypeEn;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
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

    public Long count;

    public List<String> indicators;

    public String subtypeEn;
}

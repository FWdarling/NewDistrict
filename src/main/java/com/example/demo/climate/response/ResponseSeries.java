package com.example.demo.climate.response;

import java.util.ArrayList;
import java.util.List;

/**
 * description: ResponseSeries
 * date: 4/24/21 4:52 PM
 * author: fourwood
 */
public class ResponseSeries {
    public ResponseSeries(ResponseIndicator indicator, List<ResponseData> datas) {
        this.indicator = indicator;
        this.datas = datas;
    }

    public ResponseSeries(ResponseIndicator indicator) {
        this.indicator = indicator;
        this.datas = new ArrayList<>();
    }

    public ResponseIndicator indicator;
    public List<ResponseData> datas;
}

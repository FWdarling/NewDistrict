package com.example.demo.pm25.response;

import java.util.ArrayList;
import java.util.List;

/**
 * description: ResponseSeries
 * date: 4/24/21 11:22 PM
 * author: fourwood
 */
public class ResponseSeries {

    public ResponseSeries(String type) {
        this.type = type;
        this.datas = new ArrayList<>();
    }

    public String type;
    public List<ResponseData> datas;
}

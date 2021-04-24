package com.example.demo.pm25.response;

import java.util.ArrayList;
import java.util.List;

/**
 * description: ResponsePm25
 * date: 4/24/21 11:21 PM
 * author: fourwood
 */
public class ResponsePm25 {

    public ResponsePm25(ResponsePosition station, int total, int count, int pageNum, int pageSize){
        this.station = station;
        this.count = count;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.series = new ArrayList<>();
    }

    public ResponsePosition station;
    public List<ResponseSeries> series;
    public int total;
    public int count;
    public int pageSize;
    public int pageNum;
}

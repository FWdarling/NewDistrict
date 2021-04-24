package com.example.demo.climate.response;

import java.util.ArrayList;
import java.util.List;

/**
 * description: ResponseSeries
 * date: 4/24/21 4:42 PM
 * author: fourwood
 */
public class ResponseClimate {



    public ResponseClimate(ResponseStation station, List<ResponseSeries> series) {
        this.station = station;
        this.series = series;
    }

    public ResponseClimate(ResponseStation station) {
        this.station = station;
        this.series = new ArrayList<>();
    }

    public ResponseStation station;
    public List<ResponseSeries> series;
    public int total;
    public int count;
    public int pageSize;
    public int pageNum;

}

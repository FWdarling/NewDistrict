package com.example.demo.climate.response;

/**
 * description: ResponseData
 * date: 4/24/21 4:27 PM
 * author: fourwood
 */
public class ResponseData {
    public ResponseData() {
    }

    public ResponseData(String date, String value) {
        this.date = date;
        this.value = value;
    }

    public String date;
    public String value;
}

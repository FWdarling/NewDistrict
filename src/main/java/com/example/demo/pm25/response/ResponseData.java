package com.example.demo.pm25.response;

import java.sql.Timestamp;

/**
 * description: ResponseData
 * date: 4/24/21 11:24 PM
 * author: fourwood
 */
public class ResponseData {
    public ResponseData(Timestamp time, String value) {
        this.time = time;
        this.value = value;
    }

    public Timestamp time;
    public String value;
}

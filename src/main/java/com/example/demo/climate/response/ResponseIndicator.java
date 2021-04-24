package com.example.demo.climate.response;

import com.example.demo.climate.entity.DataDic;
import com.example.demo.climate.entity.SurfChnMulMdayDic;

import javax.xml.crypto.Data;

/**
 * description: ResponseIndicator
 * date: 4/24/21 4:24 PM
 * author: fourwood
 */
public class ResponseIndicator {
    public ResponseIndicator() {
    }

    public ResponseIndicator(String subtypeCn, String indicatorNameCn, String indicatorNameEn) {
        this.subtypeCn = subtypeCn;
        this.indicatorNameCn = indicatorNameCn;
        this.indicatorNameEn = indicatorNameEn;
    }
    public ResponseIndicator(DataDic type){
        this.subtypeCn = type.getSubtypeCn();
        this.indicatorNameCn = type.getIndicatorNameCn();
        this.indicatorNameEn = type.getIndicatorNameEn();
        this.unit = type.getUnit();
    }
    public ResponseIndicator(SurfChnMulMdayDic type){
        this.subtypeCn = "地表天气";
        this.indicatorNameCn = type.getIndicatorName();
        this.indicatorNameEn = type.getIndicatorCode();
        this.unit = type.getUnit();
    }

    public String subtypeCn;
    public String indicatorNameCn;
    public String indicatorNameEn;
    public String unit;
}

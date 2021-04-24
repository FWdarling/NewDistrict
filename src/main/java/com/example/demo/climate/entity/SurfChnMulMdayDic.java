package com.example.demo.climate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * description: SurfChnMulMdayDic
 * date: 4/24/21 1:03 PM
 * author: fourwood
 */
@Entity
@Table(name = "SURF_CHN_MUL_MDAY_DIC")
public class SurfChnMulMdayDic {
    public SurfChnMulMdayDic() {
    }

    public SurfChnMulMdayDic(Long id, String indicatorCode, String indicatorName, String unit) {
        this.id = id;
        this.indicatorCode = indicatorCode;
        this.indicatorName = indicatorName;
        this.unit = unit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIndicatorCode() {
        return indicatorCode;
    }

    public void setIndicatorCode(String indicatorCode) {
        this.indicatorCode = indicatorCode;
    }

    public String getIndicatorName() {
        return indicatorName;
    }

    public void setIndicatorName(String indicatorName) {
        this.indicatorName = indicatorName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "indicator_code")
    private String indicatorCode;

    @Column(name = "indicator_name")
    private String indicatorName;

    @Column(name = "unit")
    private String unit;

}

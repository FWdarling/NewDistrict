package com.example.demo.climate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * description: SurfChnMulMday
 * date: 4/24/21 2:51 AM
 * author: fourwood
 */
@Entity
@Table(name = "SURF_CHN_MUL_MDAY")
public class SurfChnMulMday {
    public SurfChnMulMday() {
    }

    public SurfChnMulMday(Long id, String stationId, String vTimeAvaila, Long v04292, Double v12001_701, Double v12001_701_05, Double v12001_701_06, Double v13004_701, Double v13305_701, Double v13306_701, Double v11002_701) {
        this.id = id;
        this.stationId = stationId;
        this.vTimeAvaila = vTimeAvaila;
        this.v04292 = v04292;
        this.v12001_701 = v12001_701;
        this.v12001_701_05 = v12001_701_05;
        this.v12001_701_06 = v12001_701_06;
        this.v13004_701 = v13004_701;
        this.v13305_701 = v13305_701;
        this.v13306_701 = v13306_701;
        this.v11002_701 = v11002_701;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getvTimeAvaila() {
        return vTimeAvaila;
    }

    public void setvTimeAvaila(String vTimeAvaila) {
        this.vTimeAvaila = vTimeAvaila;
    }

    public Long getV04292() {
        return v04292;
    }

    public void setV04292(Long v04292) {
        this.v04292 = v04292;
    }

    public Double getV12001_701() {
        return v12001_701;
    }

    public void setV12001_701(Double v12001_701) {
        this.v12001_701 = v12001_701;
    }

    public Double getV12001_701_05() {
        return v12001_701_05;
    }

    public void setV12001_701_05(Double v12001_701_05) {
        this.v12001_701_05 = v12001_701_05;
    }

    public Double getV12001_701_06() {
        return v12001_701_06;
    }

    public void setV12001_701_06(Double v12001_701_06) {
        this.v12001_701_06 = v12001_701_06;
    }

    public Double getV13004_701() {
        return v13004_701;
    }

    public void setV13004_701(Double v13004_701) {
        this.v13004_701 = v13004_701;
    }

    public Double getV13305_701() {
        return v13305_701;
    }

    public void setV13305_701(Double v13305_701) {
        this.v13305_701 = v13305_701;
    }

    public Double getV13306_701() {
        return v13306_701;
    }

    public void setV13306_701(Double v13306_701) {
        this.v13306_701 = v13306_701;
    }

    public Double getV11002_701() {
        return v11002_701;
    }

    public void setV11002_701(Double v11002_701) {
        this.v11002_701 = v11002_701;
    }

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "station_id")
    private String stationId;
    @Column(name = "V_TIME_AVAILA")
    private String vTimeAvaila;
    @Column(name = "V04292")
    private Long v04292;
    @Column(name = "V12001_701")
    private Double v12001_701;
    @Column(name = "V12001_701_05")
    private Double v12001_701_05;
    @Column(name = "V12001_701_06")
    private Double v12001_701_06;
    @Column(name = "V13004_701")
    private Double v13004_701;
    @Column(name = "V13305_701")
    private Double v13305_701;
    @Column(name = "V13306_701")
    private Double v13306_701;
    @Column(name = "V11002_701")
    private Double v11002_701;

}

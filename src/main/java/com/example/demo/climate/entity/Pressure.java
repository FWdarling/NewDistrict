package com.example.demo.climate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * description: Pressure
 * date: 4/24/21 2:49 AM
 * author: fourwood
 */
@Entity
@Table(name = "pressure")
public class Pressure {
    public Pressure() {
    }

    public Pressure(Long id, String observatoryId, Float latitude, Float longitude, String observationHeight, String year, String month, String day, String timestamp, String avgPressure, String maxPressure, String minPressure, String avgPressureCode, String maxPressureCode, String minPressureCode, String cdate) {
        this.id = id;
        this.observatoryId = observatoryId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.observationHeight = observationHeight;
        this.year = year;
        this.month = month;
        this.day = day;
        this.timestamp = timestamp;
        this.avgPressure = avgPressure;
        this.maxPressure = maxPressure;
        this.minPressure = minPressure;
        this.avgPressureCode = avgPressureCode;
        this.maxPressureCode = maxPressureCode;
        this.minPressureCode = minPressureCode;
        this.cdate = cdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObservatoryId() {
        return observatoryId;
    }

    public void setObservatoryId(String observatoryId) {
        this.observatoryId = observatoryId;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getObservationHeight() {
        return observationHeight;
    }

    public void setObservationHeight(String observationHeight) {
        this.observationHeight = observationHeight;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getAvgPressure() {
        return avgPressure;
    }

    public void setAvgPressure(String avgPressure) {
        this.avgPressure = avgPressure;
    }

    public String getMaxPressure() {
        return maxPressure;
    }

    public void setMaxPressure(String maxPressure) {
        this.maxPressure = maxPressure;
    }

    public String getMinPressure() {
        return minPressure;
    }

    public void setMinPressure(String minPressure) {
        this.minPressure = minPressure;
    }

    public String getAvgPressureCode() {
        return avgPressureCode;
    }

    public void setAvgPressureCode(String avgPressureCode) {
        this.avgPressureCode = avgPressureCode;
    }

    public String getMaxPressureCode() {
        return maxPressureCode;
    }

    public void setMaxPressureCode(String maxPressureCode) {
        this.maxPressureCode = maxPressureCode;
    }

    public String getMinPressureCode() {
        return minPressureCode;
    }

    public void setMinPressureCode(String minPressureCode) {
        this.minPressureCode = minPressureCode;
    }

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "observatory_id")
    private String observatoryId;
    @Column(name = "latitude")
    private Float latitude;
    @Column(name = "longitude")
    private Float longitude;
    @Column(name = "observation_height")
    private String observationHeight;
    @Column(name = "year")
    private String year;
    @Column(name = "month")
    private String month;
    @Column(name = "day")
    private String day;
    @Column(name = "timestamp")
    private String timestamp;

    @Column(name = "avg_pressure")
    private String avgPressure;
    @Column(name = "max_pressure")
    private String maxPressure;
    @Column(name = "min_pressure")
    private String minPressure;
    @Column(name = "avg_pressure_code")
    private String avgPressureCode;
    @Column(name = "max_pressure_code")
    private String maxPressureCode;
    @Column(name = "min_pressure_code")
    private String minPressureCode;

    @Column(name = "cdate")
    private String cdate;

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }
}

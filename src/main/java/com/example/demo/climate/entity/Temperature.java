package com.example.demo.climate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * description: Temperature
 * date: 4/24/21 2:50 AM
 * author: fourwood
 */
@Entity
@Table(name = "temperature")
public class Temperature {
    public Temperature() {
    }

    public Temperature(Long id, String observatoryId, Float latitude, Float longitude, String observationHeight, String year, String month, String day, String timestamp, String avgTemperature, String maxTemperature, String minTemperature, String avgTemperatureCode, String maxTemperatureCode, String minTemperatureCode, String cdate) {
        this.id = id;
        this.observatoryId = observatoryId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.observationHeight = observationHeight;
        this.year = year;
        this.month = month;
        this.day = day;
        this.timestamp = timestamp;
        this.avgTemperature = avgTemperature;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.avgTemperatureCode = avgTemperatureCode;
        this.maxTemperatureCode = maxTemperatureCode;
        this.minTemperatureCode = minTemperatureCode;
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

    public String getAvgTemperature() {
        return avgTemperature;
    }

    public void setAvgTemperature(String avgTemperature) {
        this.avgTemperature = avgTemperature;
    }

    public String getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(String maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public String getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(String minTemperature) {
        this.minTemperature = minTemperature;
    }

    public String getAvgTemperatureCode() {
        return avgTemperatureCode;
    }

    public void setAvgTemperatureCode(String avgTemperatureCode) {
        this.avgTemperatureCode = avgTemperatureCode;
    }

    public String getMaxTemperatureCode() {
        return maxTemperatureCode;
    }

    public void setMaxTemperatureCode(String maxTemperatureCode) {
        this.maxTemperatureCode = maxTemperatureCode;
    }

    public String getMinTemperatureCode() {
        return minTemperatureCode;
    }

    public void setMinTemperatureCode(String minTemperatureCode) {
        this.minTemperatureCode = minTemperatureCode;
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

    @Column(name = "avg_temperature")
    private String avgTemperature;
    @Column(name = "max_temperature")
    private String maxTemperature;
    @Column(name = "min_temperature")
    private String minTemperature;
    @Column(name = "avg_temperature_code")
    private String avgTemperatureCode;
    @Column(name = "max_temperature_code")
    private String maxTemperatureCode;
    @Column(name = "min_temperature_code")
    private String minTemperatureCode;

    @Column(name = "cdate")
    private String cdate;

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }
}

package com.example.demo.climate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * description: Humidity
 * date: 4/24/21 2:48 AM
 * author: fourwood
 */
@Entity
@Table(name = "humidity")
public class Humidity {
    public Humidity(Long id, String observatoryId, Float latitude, Float longitude, String observationHeight, String year, String month, String day, String timestamp, String avgHumidity, String minHumidity, String avgHumidityCode, String minHumidityCode, String cdate) {
        this.id = id;
        this.observatoryId = observatoryId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.observationHeight = observationHeight;
        this.year = year;
        this.month = month;
        this.day = day;
        this.timestamp = timestamp;
        this.avgHumidity = avgHumidity;
        this.minHumidity = minHumidity;
        this.avgHumidityCode = avgHumidityCode;
        this.minHumidityCode = minHumidityCode;
        this.cdate = cdate;
    }

    public Humidity() {
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

    public String getAvgHumidity() {
        return avgHumidity;
    }

    public void setAvgHumidity(String avgHumidity) {
        this.avgHumidity = avgHumidity;
    }

    public String getMinHumidity() {
        return minHumidity;
    }

    public void setMinHumidity(String minHumidity) {
        this.minHumidity = minHumidity;
    }

    public String getAvgHumidityCode() {
        return avgHumidityCode;
    }

    public void setAvgHumidityCode(String avgHumidityCode) {
        this.avgHumidityCode = avgHumidityCode;
    }

    public String getMinHumidityCode() {
        return minHumidityCode;
    }

    public void setMinHumidityCode(String minHumidityCode) {
        this.minHumidityCode = minHumidityCode;
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

    @Column(name = "avg_humidity")
    private String avgHumidity;
    @Column(name = "min_humidity")
    private String minHumidity;
    @Column(name = "avg_humidity_code")
    private String avgHumidityCode;
    @Column(name = "min_humidity_code")
    private String minHumidityCode;

    @Column(name = "cdate")
    private String cdate;

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

}

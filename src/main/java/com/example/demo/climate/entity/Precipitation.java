package com.example.demo.climate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * description: Precipitation
 * date: 4/24/21 2:49 AM
 * author: fourwood
 */
@Entity
@Table(name = "precipitation")
public class Precipitation {
    public Precipitation() {
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

    public String getPrecipitation208() {
        return precipitation208;
    }

    public void setPrecipitation208(String precipitation208) {
        this.precipitation208 = precipitation208;
    }

    public String getPrecipitation820() {
        return precipitation820;
    }

    public void setPrecipitation820(String precipitation820) {
        this.precipitation820 = precipitation820;
    }

    public String getPrecipitation2020() {
        return precipitation2020;
    }

    public void setPrecipitation2020(String precipitation2020) {
        this.precipitation2020 = precipitation2020;
    }

    public String getPrecipitationCode208() {
        return precipitationCode208;
    }

    public void setPrecipitationCode208(String precipitationCode208) {
        this.precipitationCode208 = precipitationCode208;
    }

    public String getPrecipitationCode820() {
        return precipitationCode820;
    }

    public void setPrecipitationCode820(String precipitationCode820) {
        this.precipitationCode820 = precipitationCode820;
    }

    public String getPrecipitationCode2020() {
        return precipitationCode2020;
    }

    public void setPrecipitationCode2020(String precipitationCode2020) {
        this.precipitationCode2020 = precipitationCode2020;
    }

    public Precipitation(Long id, String observatoryId, Float latitude, Float longitude, String observationHeight, String year, String month, String day, String timestamp, String precipitation208, String precipitation820, String precipitation2020, String precipitationCode208, String precipitationCode820, String precipitationCode2020, String cdate) {
        this.id = id;
        this.observatoryId = observatoryId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.observationHeight = observationHeight;
        this.year = year;
        this.month = month;
        this.day = day;
        this.timestamp = timestamp;
        this.precipitation208 = precipitation208;
        this.precipitation820 = precipitation820;
        this.precipitation2020 = precipitation2020;
        this.precipitationCode208 = precipitationCode208;
        this.precipitationCode820 = precipitationCode820;
        this.precipitationCode2020 = precipitationCode2020;
        this.cdate = cdate;
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

    @Column(name = "20_8_precipitation")
    private String precipitation208;
    @Column(name = "8_20_precipitation")
    private String precipitation820;
    @Column(name = "20_20_precipitation")
    private String precipitation2020;
    @Column(name = "20_8_precipitation_code")
    private String precipitationCode208;
    @Column(name = "8_20_precipitation_code")
    private String precipitationCode820;
    @Column(name = "20_20_precipitation_code")
    private String precipitationCode2020;

    @Column(name = "cdate")
    private String cdate;

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }
}

package com.example.demo.climate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * description: Evaporation
 * date: 4/24/21 2:48 AM
 * author: fourwood
 */
@Entity
@Table(name = "evaporation")
public class Evaporation {
    public Evaporation(Long id, String observatoryId, Float latitude, Float longitude, String observationHeight, String year, String month, String day, String timestamp, String smallEvaporation, String largeEvaporation, String smallEvaporationCode, String largeEvaporationCode, String cdate) {
        this.id = id;
        this.observatoryId = observatoryId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.observationHeight = observationHeight;
        this.year = year;
        this.month = month;
        this.day = day;
        this.timestamp = timestamp;
        this.smallEvaporation = smallEvaporation;
        this.largeEvaporation = largeEvaporation;
        this.smallEvaporationCode = smallEvaporationCode;
        this.largeEvaporationCode = largeEvaporationCode;
        this.cdate = cdate;
    }

    public Evaporation() {
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

    public String getSmallEvaporation() {
        return smallEvaporation;
    }

    public void setSmallEvaporation(String smallEvaporation) {
        this.smallEvaporation = smallEvaporation;
    }

    public String getLargeEvaporation() {
        return largeEvaporation;
    }

    public void setLargeEvaporation(String largeEvaporation) {
        this.largeEvaporation = largeEvaporation;
    }

    public String getSmallEvaporationCode() {
        return smallEvaporationCode;
    }

    public void setSmallEvaporationCode(String smallEvaporationCode) {
        this.smallEvaporationCode = smallEvaporationCode;
    }

    public String getLargeEvaporationCode() {
        return largeEvaporationCode;
    }

    public void setLargeEvaporationCode(String largeEvaporationCode) {
        this.largeEvaporationCode = largeEvaporationCode;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
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
    @Column(name = "cdate")
    private String cdate;

    @Column(name = "small_evaporation")
    private String smallEvaporation;
    @Column(name = "large_evaporation")
    private String largeEvaporation;
    @Column(name = "small_evaporation_code")
    private String smallEvaporationCode;
    @Column(name = "large_evaporation_code")
    private String largeEvaporationCode;

}

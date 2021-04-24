package com.example.demo.climate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * description: Wind
 * date: 4/24/21 2:50 AM
 * author: fourwood
 */
@Entity
@Table(name = "wind")
public class Wind {
    public Wind() {
    }

    public Wind(Long id, String observatoryId, Float latitude, Float longitude, String observationHeight, String year, String month, String day, String timestamp, String avgSpeed, String maxSpeed, String maxSpeedDirection, String extreSpeed, String extreSpeedDirection, String avgSpeedCode, String maxSpeedCode, String maxSpeedDirectionCode, String extreSpeedCode, String extreSpeedDirectionCode, String cdate) {
        this.id = id;
        this.observatoryId = observatoryId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.observationHeight = observationHeight;
        this.year = year;
        this.month = month;
        this.day = day;
        this.timestamp = timestamp;
        this.avgSpeed = avgSpeed;
        this.maxSpeed = maxSpeed;
        this.maxSpeedDirection = maxSpeedDirection;
        this.extreSpeed = extreSpeed;
        this.extreSpeedDirection = extreSpeedDirection;
        this.avgSpeedCode = avgSpeedCode;
        this.maxSpeedCode = maxSpeedCode;
        this.maxSpeedDirectionCode = maxSpeedDirectionCode;
        this.extreSpeedCode = extreSpeedCode;
        this.extreSpeedDirectionCode = extreSpeedDirectionCode;
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

    public String getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(String avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    public String getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(String maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getMaxSpeedDirection() {
        return maxSpeedDirection;
    }

    public void setMaxSpeedDirection(String maxSpeedDirection) {
        this.maxSpeedDirection = maxSpeedDirection;
    }

    public String getExtreSpeed() {
        return extreSpeed;
    }

    public void setExtreSpeed(String extreSpeed) {
        this.extreSpeed = extreSpeed;
    }

    public String getExtreSpeedDirection() {
        return extreSpeedDirection;
    }

    public void setExtreSpeedDirection(String extreSpeedDirection) {
        this.extreSpeedDirection = extreSpeedDirection;
    }

    public String getAvgSpeedCode() {
        return avgSpeedCode;
    }

    public void setAvgSpeedCode(String avgSpeedCode) {
        this.avgSpeedCode = avgSpeedCode;
    }

    public String getMaxSpeedCode() {
        return maxSpeedCode;
    }

    public void setMaxSpeedCode(String maxSpeedCode) {
        this.maxSpeedCode = maxSpeedCode;
    }

    public String getMaxSpeedDirectionCode() {
        return maxSpeedDirectionCode;
    }

    public void setMaxSpeedDirectionCode(String maxSpeedDirectionCode) {
        this.maxSpeedDirectionCode = maxSpeedDirectionCode;
    }

    public String getExtreSpeedCode() {
        return extreSpeedCode;
    }

    public void setExtreSpeedCode(String extreSpeedCode) {
        this.extreSpeedCode = extreSpeedCode;
    }

    public String getExtreSpeedDirectionCode() {
        return extreSpeedDirectionCode;
    }

    public void setExtreSpeedDirectionCode(String extreSpeedDirectionCode) {
        this.extreSpeedDirectionCode = extreSpeedDirectionCode;
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

    @Column(name = "avg_speed")
    private String avgSpeed;
    @Column(name = "max_speed")
    private String maxSpeed;
    @Column(name = "max_speed_direction")
    private String maxSpeedDirection;
    @Column(name = "extre_speed")
    private String extreSpeed;
    @Column(name = "extre_speed_direction")
    private String extreSpeedDirection;
    @Column(name = "avg_speed_code")
    private String avgSpeedCode;
    @Column(name = "max_speed_code")
    private String maxSpeedCode;
    @Column(name = "max_speed_direction_code")
    private String maxSpeedDirectionCode;
    @Column(name = "extre_speed_code")
    private String extreSpeedCode;
    @Column(name = "extre_speed_direction_code")
    private String extreSpeedDirectionCode;

    @Column(name = "cdate")
    private String cdate;

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }
}

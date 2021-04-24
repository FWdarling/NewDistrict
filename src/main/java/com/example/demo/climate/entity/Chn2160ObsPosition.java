package com.example.demo.climate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * description: Chn2160ObsPosition
 * date: 4/24/21 1:02 PM
 * author: fourwood
 */
@Entity
@Table(name = "CHN_2160_OBS_POSITION")
public class Chn2160ObsPosition {
    public Chn2160ObsPosition() {
    }

    public Chn2160ObsPosition(Long id, String observatoryId, String province, String observatoryName, String longitude, String latitude, String observatoryHeight, String sensorHeight, String startYear, String endYear, String missingMeasurementInterval, String statisticInterval) {
        this.id = id;
        this.observatoryId = observatoryId;
        this.province = province;
        this.observatoryName = observatoryName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.observatoryHeight = observatoryHeight;
        this.sensorHeight = sensorHeight;
        this.startYear = startYear;
        this.endYear = endYear;
        MissingMeasurementInterval = missingMeasurementInterval;
        this.statisticInterval = statisticInterval;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getObservatoryName() {
        return observatoryName;
    }

    public void setObservatoryName(String observatoryName) {
        this.observatoryName = observatoryName;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getObservatoryHeight() {
        return observatoryHeight;
    }

    public void setObservatoryHeight(String observatoryHeight) {
        this.observatoryHeight = observatoryHeight;
    }

    public String getSensorHeight() {
        return sensorHeight;
    }

    public void setSensorHeight(String sensorHeight) {
        this.sensorHeight = sensorHeight;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public String getMissingMeasurementInterval() {
        return MissingMeasurementInterval;
    }

    public void setMissingMeasurementInterval(String missingMeasurementInterval) {
        MissingMeasurementInterval = missingMeasurementInterval;
    }

    public String getStatisticInterval() {
        return statisticInterval;
    }

    public void setStatisticInterval(String statisticInterval) {
        this.statisticInterval = statisticInterval;
    }

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "observatory_id")
    private String observatoryId;
    @Column(name = "province")
    private String province;
    @Column(name = "observatory_name")
    private String observatoryName;
    @Column(name = "longitude")
    private String longitude;
    @Column(name = "latitude")
    private String latitude;
    @Column(name = "observatory_height")
    private String observatoryHeight;
    @Column(name = "sensor_height")
    private String sensorHeight;
    @Column(name = "start_year")
    private String startYear;
    @Column(name = "end_year")
    private String endYear;
    @Column(name = "Missing_measurement_interval")
    private String MissingMeasurementInterval;
    @Column(name = "statistic_interval")
    private String statisticInterval;
}

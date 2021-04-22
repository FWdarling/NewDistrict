package com.example.demo.district.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "data_survey")
public class DataSurvey {

    public DataSurvey() {
    }

    public DataSurvey(Long id, String dataName, String dataCategory, String dataDesc, String statisFredaq, Long currentNumber, Date beginTime, Date endTime, String serverHost, String dbName, String tbName, String dataIndexName, String dataIndex, String coverRegion, Integer flag, String dbname, String tableName) {
        this.id = id;
        this.dataName = dataName;
        this.dataCategory = dataCategory;
        this.dataDesc = dataDesc;
        this.statisFredaq = statisFredaq;
        this.currentNumber = currentNumber;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.serverHost = serverHost;
        this.dbName = dbName;
        this.tbName = tbName;
        this.dataIndexName = dataIndexName;
        this.dataIndex = dataIndex;
        this.coverRegion = coverRegion;
        this.flag = flag;
        this.dbname = dbname;
        this.tableName = tableName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getDataCategory() {
        return dataCategory;
    }

    public void setDataCategory(String dataCategory) {
        this.dataCategory = dataCategory;
    }

    public String getDataDesc() {
        return dataDesc;
    }

    public void setDataDesc(String dataDesc) {
        this.dataDesc = dataDesc;
    }

    public String getStatisFredaq() {
        return statisFredaq;
    }

    public void setStatisFredaq(String statisFredaq) {
        this.statisFredaq = statisFredaq;
    }

    public Long getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(Long currentNumber) {
        this.currentNumber = currentNumber;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getServerHost() {
        return serverHost;
    }

    public void setServerHost(String serverHost) {
        this.serverHost = serverHost;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getTbName() {
        return tbName;
    }

    public void setTbName(String tbName) {
        this.tbName = tbName;
    }

    public String getDataIndexName() {
        return dataIndexName;
    }

    public void setDataIndexName(String dataIndexName) {
        this.dataIndexName = dataIndexName;
    }

    public String getDataIndex() {
        return dataIndex;
    }

    public void setDataIndex(String dataIndex) {
        this.dataIndex = dataIndex;
    }

    public String getCoverRegion() {
        return coverRegion;
    }

    public void setCoverRegion(String coverRegion) {
        this.coverRegion = coverRegion;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataSurvey that = (DataSurvey) o;
        return Objects.equals(id, that.id) && Objects.equals(dataName, that.dataName) && Objects.equals(dataCategory, that.dataCategory) && Objects.equals(dataDesc, that.dataDesc) && Objects.equals(statisFredaq, that.statisFredaq) && Objects.equals(currentNumber, that.currentNumber) && Objects.equals(beginTime, that.beginTime) && Objects.equals(endTime, that.endTime) && Objects.equals(serverHost, that.serverHost) && Objects.equals(dbName, that.dbName) && Objects.equals(tbName, that.tbName) && Objects.equals(dataIndexName, that.dataIndexName) && Objects.equals(dataIndex, that.dataIndex) && Objects.equals(coverRegion, that.coverRegion) && Objects.equals(flag, that.flag) && Objects.equals(dbname, that.dbname) && Objects.equals(tableName, that.tableName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataName, dataCategory, dataDesc, statisFredaq, currentNumber, beginTime, endTime, serverHost, dbName, tbName, dataIndexName, dataIndex, coverRegion, flag, dbname, tableName);
    }

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "data_name", length = 128)
    private String dataName;

    @Column(name = "data_category", length = 128)
    private String dataCategory;

    @Column(name = "data_desc", columnDefinition = "text")
    private String dataDesc;

    @Column(name = "statis_fredaq", length = 64)
    private String statisFredaq;

    @Column(name = "current_number", columnDefinition = "bigint(20)")
    private Long currentNumber;

    @Column(name = "begin_time", columnDefinition = "datetime")
    private Date beginTime;

    @Column(name = "end_time", columnDefinition = "datetime")
    private Date endTime;

    @Column(name = "server_host", length = 64)
    private String serverHost;

    @Column(name = "db_name", length = 128)
    private String dbName;

    @Column(name = "tb_name", length = 128)
    private String tbName;

    @Column(name = "data_index_name", length = 128)
    private String dataIndexName;

    @Column(name = "data_index", length = 128)
    private String dataIndex;

    @Column(name = "cover_region", columnDefinition = "text")
    private String coverRegion;

    @Column(name = "flag")
    private Integer flag;

    @Column(name = "dbname")
    private String dbname;

    @Column(name = "table_name")
    private String tableName;
}

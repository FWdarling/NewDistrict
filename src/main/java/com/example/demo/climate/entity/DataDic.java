package com.example.demo.climate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * description: DataDic
 * date: 4/24/21 12:51 PM
 * author: fourwood
 */
@Entity
@Table(name = "data_dic")
public class DataDic {
    public DataDic() {
    }

    public DataDic(Long id, String typeEn, String typeCn, String subtypeEn, String subtypeCn, String indicatorNameEn, String indicatorNameCn, String unit, String remarks) {
        this.id = id;
        this.typeEn = typeEn;
        this.typeCn = typeCn;
        this.subtypeEn = subtypeEn;
        this.subtypeCn = subtypeCn;
        this.indicatorNameEn = indicatorNameEn;
        this.indicatorNameCn = indicatorNameCn;
        this.unit = unit;
        this.remarks = remarks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeEn() {
        return typeEn;
    }

    public void setTypeEn(String typeEn) {
        this.typeEn = typeEn;
    }

    public String getTypeCn() {
        return typeCn;
    }

    public void setTypeCn(String typeCn) {
        this.typeCn = typeCn;
    }

    public String getSubtypeEn() {
        return subtypeEn;
    }

    public void setSubtypeEn(String subtypeEn) {
        this.subtypeEn = subtypeEn;
    }

    public String getSubtypeCn() {
        return subtypeCn;
    }

    public void setSubtypeCn(String subtypeCn) {
        this.subtypeCn = subtypeCn;
    }

    public String getIndicatorNameEn() {
        return indicatorNameEn;
    }

    public void setIndicatorNameEn(String indicatorNameEn) {
        this.indicatorNameEn = indicatorNameEn;
    }

    public String getIndicatorNameCn() {
        return indicatorNameCn;
    }

    public void setIndicatorNameCn(String indicatorNameCn) {
        this.indicatorNameCn = indicatorNameCn;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "type_en")
    private String typeEn;
    @Column(name = "type_cn")
    private String typeCn;
    @Column(name = "subtype_en")
    private String subtypeEn;
    @Column(name = "subtype_cn")
    private String subtypeCn;
    @Column(name = "indicator_name_en")
    private String indicatorNameEn;
    @Column(name = "indicator_name_cn")
    private String indicatorNameCn;
    @Column(name = "unit")
    private String unit;
    @Column(name = "remarks")
    private String remarks;
}

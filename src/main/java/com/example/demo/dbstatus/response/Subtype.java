package com.example.demo.dbstatus.response;

import java.util.Objects;

public class Subtype {

    public Subtype() {
    }

    public Subtype(String subtypeEn, String subtypeCn) {
        this.subtypeEn = subtypeEn;
        this.subtypeCn = subtypeCn;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subtype subtype = (Subtype) o;
        return Objects.equals(subtypeCn, subtype.subtypeCn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subtypeEn, subtypeCn);
    }

    public String subtypeEn;

    public String subtypeCn;
}

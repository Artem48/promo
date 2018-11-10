package com.scnetcracker.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "statistics", schema = "promo", catalog = "")
public class StatisticsEntity {
    private int id;
    private Timestamp date;
    private int type;
    private Integer value;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "type")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Basic
    @Column(name = "value")
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatisticsEntity that = (StatisticsEntity) o;

        if (id != that.id) return false;
        if (type != that.type) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + type;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}

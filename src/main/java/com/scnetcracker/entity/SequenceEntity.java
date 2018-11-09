package com.scnetcracker.entity;

import javax.persistence.*;

@Entity
@Table(name = "sequence", schema = "prom", catalog = "")
public class SequenceEntity {
    private int id;
    private byte stat;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "stat")
    public byte getStat() {
        return stat;
    }

    public void setStat(byte stat) {
        this.stat = stat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SequenceEntity that = (SequenceEntity) o;

        if (id != that.id) return false;
        if (stat != that.stat) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) stat;
        return result;
    }
}

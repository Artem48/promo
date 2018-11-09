package com.scnetcracker.entity;

import javax.persistence.*;

@Entity
@Table(name = "socialnetworks", schema = "prom", catalog = "")
public class SocialnetworksEntity {
    private int id;
    private String identificator;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "identificator")
    public String getIdentificator() {
        return identificator;
    }

    public void setIdentificator(String identificator) {
        this.identificator = identificator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SocialnetworksEntity that = (SocialnetworksEntity) o;

        if (id != that.id) return false;
        if (identificator != null ? !identificator.equals(that.identificator) : that.identificator != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (identificator != null ? identificator.hashCode() : 0);
        return result;
    }
}

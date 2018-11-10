package com.scnetcracker.entity;

import javax.persistence.*;

@Entity
@Table(name = "socialnetworks", schema = "promo", catalog = "")
public class SocialnetworksEntity {
    private int id;
    private int socialNetworkId;
    private String identificator;
    private int userId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "socialNetworkID")
    public int getSocialNetworkId() {
        return socialNetworkId;
    }

    public void setSocialNetworkId(int socialNetworkId) {
        this.socialNetworkId = socialNetworkId;
    }

    @Basic
    @Column(name = "identificator")
    public String getIdentificator() {
        return identificator;
    }

    public void setIdentificator(String identificator) {
        this.identificator = identificator;
    }

    @Basic
    @Column(name = "userID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SocialnetworksEntity that = (SocialnetworksEntity) o;

        if (id != that.id) return false;
        if (socialNetworkId != that.socialNetworkId) return false;
        if (userId != that.userId) return false;
        if (identificator != null ? !identificator.equals(that.identificator) : that.identificator != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + socialNetworkId;
        result = 31 * result + (identificator != null ? identificator.hashCode() : 0);
        result = 31 * result + userId;
        return result;
    }
}

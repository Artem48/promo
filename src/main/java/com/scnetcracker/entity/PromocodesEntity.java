package com.scnetcracker.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "promocodes", schema = "promo", catalog = "")
public class PromocodesEntity {
    private int promoId;
    private String promo;
    private Date issueDate;
    private Date expireDate;
    private String description;
    private int userId;
    private int shopId;
    private int parentId;

    @Id
    @Column(name = "PromoID")
    public int getPromoId() {
        return promoId;
    }

    public void setPromoId(int promoId) {
        this.promoId = promoId;
    }

    @Basic
    @Column(name = "promo")
    public String getPromo() {
        return promo;
    }

    public void setPromo(String promo) {
        this.promo = promo;
    }

    @Basic
    @Column(name = "issueDate")
    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    @Basic
    @Column(name = "expireDate")
    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "userID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "shopId")
    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    @Basic
    @Column(name = "parentID")
    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PromocodesEntity that = (PromocodesEntity) o;

        if (promoId != that.promoId) return false;
        if (userId != that.userId) return false;
        if (shopId != that.shopId) return false;
        if (parentId != that.parentId) return false;
        if (promo != null ? !promo.equals(that.promo) : that.promo != null) return false;
        if (issueDate != null ? !issueDate.equals(that.issueDate) : that.issueDate != null) return false;
        if (expireDate != null ? !expireDate.equals(that.expireDate) : that.expireDate != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = promoId;
        result = 31 * result + (promo != null ? promo.hashCode() : 0);
        result = 31 * result + (issueDate != null ? issueDate.hashCode() : 0);
        result = 31 * result + (expireDate != null ? expireDate.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + shopId;
        result = 31 * result + parentId;
        return result;
    }
}

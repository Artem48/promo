package com.scnetcracker.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "promcodes", schema = "prom", catalog = "")
public class PromcodesEntity {
    private int promoId;
    private String prom;
    private Date issueDate;
    private Date expireDate;
    private String description;
    private String userId;
    private String shopId;
    private String parentId;

    @Id
    @Column(name = "PromoID")
    public int getPromoId() {
        return promoId;
    }

    public void setPromoId(int promoId) {
        this.promoId = promoId;
    }

    @Basic
    @Column(name = "prom")
    public String getProm() {
        return prom;
    }

    public void setProm(String prom) {
        this.prom = prom;
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
    @Column(name = "userId")
    public String getUserId() {

        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "shopId")
    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    @Basic
    @Column(name = "parentId")
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PromcodesEntity that = (PromcodesEntity) o;

        if (promoId != that.promoId) return false;
        if (prom != null ? !prom.equals(that.prom) : that.prom != null) return false;
        if (issueDate != null ? !issueDate.equals(that.issueDate) : that.issueDate != null) return false;
        if (expireDate != null ? !expireDate.equals(that.expireDate) : that.expireDate != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = promoId;
        result = 31 * result + (prom != null ? prom.hashCode() : 0);
        result = 31 * result + (issueDate != null ? issueDate.hashCode() : 0);
        result = 31 * result + (expireDate != null ? expireDate.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}

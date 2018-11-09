package com.scnetcracker.entity;

import java.sql.Date;

@javax.persistence.Entity
@javax.persistence.Table(name="promocodes", schema="promo", catalog="")
public class PromocodesEntity {
  private int promoId;
  private String promo;
  private Date issueDate;
  private Date expireDate;
  private String description;
  private int userId;
  private int shopId;
  
  public PromocodesEntity() {}
  
  @javax.persistence.Id
  @javax.persistence.Column(name="PromoID")
  public int getPromoId() { return promoId; }
  
  public void setPromoId(int promoId)
  {
    this.promoId = promoId;
  }
  
  @javax.persistence.Basic
  @javax.persistence.Column(name="promo")
  public String getPromo() {
    return promo;
  }
  
  public void setPromo(String promo) {
    this.promo = promo;
  }
  
  @javax.persistence.Basic
  @javax.persistence.Column(name="issueDate")
  public Date getIssueDate() {
    return issueDate;
  }
  
  public void setIssueDate(Date issueDate) {
    this.issueDate = issueDate;
  }

  @javax.persistence.Basic
  @javax.persistence.Column(name="userId")
  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  @javax.persistence.Basic
  @javax.persistence.Column(name="shopId")
  public int getShopId() {
    return shopId;
  }

  public void setShopId(int shopId) {
    this.shopId = shopId;
  }

  @javax.persistence.Basic
  @javax.persistence.Column(name="expireDate")
  public Date getExpireDate() {
    return expireDate;
  }
  
  public void setExpireDate(Date expireDate) {
    this.expireDate = expireDate;
  }
  
  @javax.persistence.Basic
  @javax.persistence.Column(name="description")
  public String getDescription() {
    return description;
  }
  
  public void setDescription(String description) {
    this.description = description;
  }
  
  public boolean equals(Object o)
  {
    if (this == o) return true;
    if ((o == null) || (getClass() != o.getClass())) { return false;
    }
    PromocodesEntity that = (PromocodesEntity)o;
    
    if (promoId != promoId) return false;
    if (promo != null ? !promo.equals(promo) : promo != null) return false;
    if (issueDate != null ? !issueDate.equals(issueDate) : issueDate != null) return false;
    if (expireDate != null ? !expireDate.equals(expireDate) : expireDate != null) return false;
    if (description != null ? !description.equals(description) : description != null) { return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = promoId;
    result = 31 * result + (promo != null ? promo.hashCode() : 0);
    result = 31 * result + (issueDate != null ? issueDate.hashCode() : 0);
    result = 31 * result + (expireDate != null ? expireDate.hashCode() : 0);
    result = 31 * result + (description != null ? description.hashCode() : 0);
    return result;
  }
}

package com.scnetcracker.entity;

import javax.persistence.Column;

@javax.persistence.Entity
@javax.persistence.Table(name="promolikes", schema="promo", catalog="")
public class PromolikesEntity
{
  private int id;
  
  public PromolikesEntity() {}
  
  @javax.persistence.Id
  @Column(name="id")
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public boolean equals(Object o)
  {
    if (this == o) return true;
    if ((o == null) || (getClass() != o.getClass())) { return false;
    }
    PromolikesEntity that = (PromolikesEntity)o;
    
    if (id != id) { return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    return id;
  }
}

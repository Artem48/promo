package com.scnetcracker.entity;

import javax.persistence.Column;

@javax.persistence.Entity
@javax.persistence.Table(name="shoplikes", schema="promo", catalog="")
public class ShoplikesEntity
{
  private int id;
  
  public ShoplikesEntity() {}
  
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
    ShoplikesEntity that = (ShoplikesEntity)o;
    
    if (id != id) { return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    return id;
  }
}

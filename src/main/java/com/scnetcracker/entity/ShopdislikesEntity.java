package com.scnetcracker.entity;

import javax.persistence.Column;

@javax.persistence.Entity
@javax.persistence.Table(name="shopdislikes", schema="promo", catalog="")
public class ShopdislikesEntity
{
  private int id;
  
  public ShopdislikesEntity() {}
  
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
    ShopdislikesEntity that = (ShopdislikesEntity)o;
    
    if (id != id) { return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    return id;
  }
}

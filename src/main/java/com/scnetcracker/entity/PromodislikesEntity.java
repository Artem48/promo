package com.scnetcracker.entity;

import javax.persistence.Column;

@javax.persistence.Entity
@javax.persistence.Table(name="promodislikes", schema="promo", catalog="")
public class PromodislikesEntity
{
  private int id;
  
  public PromodislikesEntity() {}
  
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
    PromodislikesEntity that = (PromodislikesEntity)o;

    return id == id;
  }
  
  public int hashCode()
  {
    return id;
  }
}

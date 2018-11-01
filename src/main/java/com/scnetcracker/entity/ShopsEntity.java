package com.scnetcracker.entity;

import javax.persistence.Column;

@javax.persistence.Entity
@javax.persistence.Table(name="shops", schema="promo", catalog="")
public class ShopsEntity { private int id;
  private String name;
  private String url;
  private int count;
  
  public ShopsEntity() {}
  
  @javax.persistence.Id
  @Column(name="id")
  public int getId() { return id; }
  
  public void setId(int id)
  {
    this.id = id;
  }
  
  @javax.persistence.Basic
  @Column(name="name")
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  @javax.persistence.Basic
  @Column(name="URL")
  public String getUrl() {
    return url;
  }
  
  public void setUrl(String url) {
    this.url = url;
  }
  
  @javax.persistence.Basic
  @Column(name="count")
  public int getCount() {
    return count;
  }
  
  public void setCount(int count) {
    this.count = count;
  }
  
  public boolean equals(Object o)
  {
    if (this == o) return true;
    if ((o == null) || (getClass() != o.getClass())) { return false;
    }
    ShopsEntity that = (ShopsEntity)o;
    
    if (id != id) return false;
    if (count != count) return false;
    if (name != null ? !name.equals(name) : name != null) return false;
    if (url != null ? !url.equals(url) : url != null) { return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (url != null ? url.hashCode() : 0);
    result = 31 * result + count;
    return result;
  }
}

package com.scnetcracker.entity;

import javax.persistence.Column;

@javax.persistence.Entity
@javax.persistence.Table(name="groups", schema="promo", catalog="")
public class GroupsEntity { private int id;
  private String name;
  
  public GroupsEntity() {}
  
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
  
  public boolean equals(Object o)
  {
    if (this == o) return true;
    if ((o == null) || (getClass() != o.getClass())) { return false;
    }
    GroupsEntity that = (GroupsEntity)o;
    
    if (id != id) return false;
    if (name != null ? !name.equals(name) : name != null) { return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }
}

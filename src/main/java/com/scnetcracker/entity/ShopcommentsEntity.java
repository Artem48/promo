package com.scnetcracker.entity;

import java.sql.Timestamp;

@javax.persistence.Entity
@javax.persistence.Table(name="shopcomments", schema="promo", catalog="")
public class ShopcommentsEntity {
  private int id;
  private String comment;
  private Timestamp time;
  
  public ShopcommentsEntity() {}
  
  @javax.persistence.Id
  @javax.persistence.Column(name="id")
  public int getId() { return id; }
  
  public void setId(int id)
  {
    this.id = id;
  }
  
  @javax.persistence.Basic
  @javax.persistence.Column(name="comment")
  public String getComment() {
    return comment;
  }
  
  public void setComment(String comment) {
    this.comment = comment;
  }
  
  @javax.persistence.Basic
  @javax.persistence.Column(name="time")
  public Timestamp getTime() {
    return time;
  }
  
  public void setTime(Timestamp time) {
    this.time = time;
  }
  
  public boolean equals(Object o)
  {
    if (this == o) return true;
    if ((o == null) || (getClass() != o.getClass())) { return false;
    }
    ShopcommentsEntity that = (ShopcommentsEntity)o;
    
    if (id != id) return false;
    if (comment != null ? !comment.equals(comment) : comment != null) return false;
    if (time != null ? !time.equals(time) : time != null) { return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = id;
    result = 31 * result + (comment != null ? comment.hashCode() : 0);
    result = 31 * result + (time != null ? time.hashCode() : 0);
    return result;
  }
}

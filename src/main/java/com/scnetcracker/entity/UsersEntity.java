package com.scnetcracker.entity;

import javax.persistence.Column;

@javax.persistence.Entity
@javax.persistence.Table(name="users", schema="promo", catalog="")
public class UsersEntity {
  private int id;
  private String login;
  private String email;
  private String password;
  private Integer vkId;
  private int rating;
  private String session;
  private java.sql.Timestamp lastLogin;
  private int groupID;
  
  public UsersEntity() {}
  
  @javax.persistence.Id
  @Column(name="id")
  public int getId() { return id; }
  
  public void setId(int id)
  {
    this.id = id;
  }
  
  @javax.persistence.Basic
  @Column(name="login")
  public String getLogin() {
    return login;
  }
  
  public void setLogin(String login) {
    this.login = login;
  }
  
  @javax.persistence.Basic
  @Column(name="email")
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  @javax.persistence.Basic
  @Column(name="password")
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  @javax.persistence.Basic
  @Column(name="vkID")
  public Integer getVkId() {
    return vkId;
  }
  
  public void setVkId(Integer vkId) {
    this.vkId = vkId;
  }
  
  @javax.persistence.Basic
  @Column(name="rating")
  public int getRating() {
    return rating;
  }
  
  public void setRating(int rating) {
    this.rating = rating;
  }
  
  @javax.persistence.Basic
  @Column(name="session")
  public String getSession() {
    return session;
  }
  
  public void setSession(String session) {
    this.session = session;
  }
  
  @javax.persistence.Basic
  @Column(name="lastLogin")
  public java.sql.Timestamp getLastLogin() {
    return lastLogin;
  }
  
  public void setLastLogin(java.sql.Timestamp lastLogin) {
    this.lastLogin = lastLogin;
  }
  
  public int getGroupID() {
    return groupID;
  }
  
  public void setGroupID(int groupID) {
    this.groupID = groupID;
  }
  


  @javax.persistence.Basic
  @Column(name="groupID")
  public boolean equals(Object o)
  {
    if (this == o) return true;
    if ((o == null) || (getClass() != o.getClass())) { return false;
    }
    UsersEntity that = (UsersEntity)o;
    
    if (id != id) return false;
    if (rating != rating) return false;
    if (login != null ? !login.equals(login) : login != null) return false;
    if (email != null ? !email.equals(email) : email != null) return false;
    if (password != null ? !password.equals(password) : password != null) return false;
    if (vkId != null ? !vkId.equals(vkId) : vkId != null) return false;
    if (session != null ? !session.equals(session) : session != null) return false;
    if (lastLogin != null ? !lastLogin.equals(lastLogin) : lastLogin != null) { return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = id;
    result = 31 * result + (login != null ? login.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (password != null ? password.hashCode() : 0);
    result = 31 * result + (vkId != null ? vkId.hashCode() : 0);
    result = 31 * result + rating;
    result = 31 * result + (session != null ? session.hashCode() : 0);
    result = 31 * result + (lastLogin != null ? lastLogin.hashCode() : 0);
    return result;
  }
}

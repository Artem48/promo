package com.scnetcracker.service;

import java.util.List;

public abstract interface UserService
{
  public abstract void createUser(String paramString1, String paramString2, String paramString3, int paramInt);
  List getUser(String Email);
  List getUserPromo(int userId);
  List getShop(int id);
}

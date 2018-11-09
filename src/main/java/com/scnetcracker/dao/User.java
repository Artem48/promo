package com.scnetcracker.dao;

import java.util.List;

public abstract interface User
{
  void createUser(String paramString1, String paramString2, String paramString3, int paramInt);
  List getUser(String email);
  List getUserPromo(int userId);
  List getShop(int id);
}

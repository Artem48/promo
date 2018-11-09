package com.scnetcracker.dao;

import java.util.List;

public interface User
{
  void createUser(String paramString1, String paramString2, String paramString3);
  List getUser(String email);
}

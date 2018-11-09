package com.scnetcracker.service;

import java.util.List;

public interface UserService {
    void createUser(String paramString1, String paramString2, String paramString3);

    List getUser(String Email);

}

package com.scnetcracker.controller;

import com.scnetcracker.service.UserServiceImp;
import org.json.JSONObject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class HelloController
{
  public HelloController() {}
  
  @RequestMapping(value={"/"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String index(Model model)
  {
    return "index";
  }
  
  @RequestMapping(value={"/auth"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String auth(@org.springframework.web.bind.annotation.RequestParam("code") String code, Model model) throws java.io.IOException {
    int id = 6733997;
    String secret = "S0SRXD3p1d4ckfsXoRyI";
    String redirect = "http://localhost:8080/auth";
    
    String url = String.format("https://oauth.vk.com/access_token?client_id=%s&client_secret=%s&redirect_uri=%s&code=%s", new Object[] {
    
      Integer.valueOf(id), secret, redirect, code });
    

    try
    {
      JSONObject jsonObj = com.scnetcracker.utils.Tmp.reques(url);
      
      String token = jsonObj.get("access_token").toString();
      int userID = Integer.valueOf(jsonObj.get("user_id").toString()).intValue();
      

      url = String.format("https://api.vk.com/method/users.get?user_ids=261010067&fields=&access_token=%s&v=5.84", new Object[] { token });
      
      jsonObj = com.scnetcracker.utils.Tmp.reques(url);
      
      jsonObj = (JSONObject)jsonObj.getJSONArray("response").get(0);
      String fName = jsonObj.get("first_name").toString();
      String lName = jsonObj.get("last_name").toString();
      
      UserServiceImp user = new UserServiceImp();
      user.createUser(lName, "", "vkontakte", userID);
      
      return "redirect:/";
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    

    return "redirect:/enter";
  }
  
  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST}, produces={"application/json"})
  @org.springframework.web.bind.annotation.ResponseBody
  public String add() {
    UserServiceImp user = new UserServiceImp();
    user.createUser("stas", "password", "mail", 260);
    return "{stas:'123'}";
  }
  
  @RequestMapping(value={"/registration"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String registration(Model model) {
    return "registration";
  }
  
  @RequestMapping(value={"/enter"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String enter(Model model) { return "enter"; }
}

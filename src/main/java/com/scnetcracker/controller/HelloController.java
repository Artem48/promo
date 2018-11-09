package com.scnetcracker.controller;

import com.scnetcracker.entity.PromocodesEntity;
import com.scnetcracker.entity.UsersEntity;
import com.scnetcracker.service.UserServiceImp;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HelloController {
    public HelloController() {
    }

    @RequestMapping(value = {"/"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = {"/auth"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public String auth(@org.springframework.web.bind.annotation.RequestParam("code") String code, Model model) throws java.io.IOException {
        int id = 6733997;
        String secret = "S0SRXD3p1d4ckfsXoRyI";
        String redirect = "http://localhost:8080/auth";

        String url = String.format("https://oauth.vk.com/access_token?client_id=%s&client_secret=%s&redirect_uri=%s&code=%s", Integer.valueOf(id), secret, redirect, code);


        try {
            JSONObject jsonObj = com.scnetcracker.utils.Tmp.reques(url);

            String token = jsonObj.get("access_token").toString();
            int userID = Integer.valueOf(jsonObj.get("user_id").toString());


            url = String.format("https://api.vk.com/method/users.get?user_ids=261010067&fields=&access_token=%s&v=5.84", new Object[]{token});

            jsonObj = com.scnetcracker.utils.Tmp.reques(url);

            jsonObj = (JSONObject) jsonObj.getJSONArray("response").get(0);
            String fName = jsonObj.get("first_name").toString();
            String lName = jsonObj.get("last_name").toString();

            UserServiceImp user = new UserServiceImp();
            user.createUser(lName, "", "vkontakte", userID);

            return "redirect:/";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return "redirect:/enter";
    }

    @RequestMapping(value = {"/add"}, method = {RequestMethod.POST}, produces = {"application/json"})
    @ResponseBody
    public String add() {
        UserServiceImp user = new UserServiceImp();
        user.createUser("stas", "password", "mail", 260);
        return "{stas:'123'}";
    }

    @RequestMapping(value = {"/registration"}, method = {RequestMethod.GET})
    public String registration(Model model) {
        return "registration";
    }

    @RequestMapping(value = {"/enter"}, method = {RequestMethod.GET})
    public String enter(Model model) {

        return "enter";
    }

    @RequestMapping(value = {"/enter"}, method = {RequestMethod.POST})
    @ResponseBody
    public ResponseEntity login(Model model, HttpServletRequest request) {

        UserServiceImp user = new UserServiceImp();
        List<UsersEntity> list = user.getUser("1");

        String Email = request.getParameter("Email");
        String Password = request.getParameter("Password");

        if(list.size() > 1) {
            for (UsersEntity u : list) {
                if (u.getEmail().equals(Email) && u.getPassword().equals(Password)) {
                    request.getSession().setAttribute("user", Email);
                    return new ResponseEntity<>("KULL", HttpStatus.OK);
                }
            }

        }


        return new ResponseEntity<>("NE_KULL_LAST", HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @RequestMapping(value = {"/login"}, method = {RequestMethod.POST})
    @ResponseBody
    public String test(Model model, HttpServletRequest request) {
        UserServiceImp user = new UserServiceImp();
        List<UsersEntity> userD = user.getUser("1");
        for (UsersEntity u : userD) {
            List<PromocodesEntity> list = user.getUserPromo(u.getId());
            for (PromocodesEntity w : list) {
                System.out.println(w.getUserId() + ' ' + w.getPromo());
            }
        }


        return "test";
    }

    @RequestMapping(value = {"/reguser"}, method = {RequestMethod.POST})
    @ResponseBody
    public ResponseEntity<String> reguser(Model model, HttpServletRequest request) {
        UserServiceImp user = new UserServiceImp();

        String Login = request.getParameter("Login");
        String Email = request.getParameter("Email");
        String Password = request.getParameter("Password");


        user.createUser(Login, Password, Email, 0);

        request.getSession().setAttribute("user", Email);

        return new ResponseEntity<>("KULL", HttpStatus.OK);


    }

    @RequestMapping(value = {"/logout"}, method = {RequestMethod.GET})
    public String logout(Model model, HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "redirect:/";
    }

    @RequestMapping(value = {"/profile"}, method = {RequestMethod.GET})
    public String profile(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("user") != null) {
            return "profile";
        } else {
            return "redirect:/enter";
        }

    }

}

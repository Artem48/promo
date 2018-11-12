package com.scnetcracker.controller;

import com.scnetcracker.service.UserServiceImp;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/*
 * Контроллер для обработки GET запросов отправленных на сервер
 *
 * @RequestMapping содержит переменные:
 * value - показывает ккой путь обрабатывает функция находящаяся ниже
 * method - метод которые обработки
 *
 * @ResponseBody - говорит, что с Сервера будет будет получен ответ и тело ответа (наприммер JSON)
 *
 * В методы обработки контроллеров может передавать Модел (Model model) в которой можно прикреблять
 * дополнительные параметры для отображения в .jsp файле (Что-то вроде переменных)
 *
 */

@Controller
public class GetController {
    @RequestMapping(value = {"/"}, method = {RequestMethod.GET})
    public String index() {
        return "index";
    }

    @RequestMapping(value = {"/auth"}, method = {RequestMethod.GET})
    public String auth(@RequestParam("code") String code) {
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
            user.createUser(lName, "", "vkontakte");

            return "redirect:/";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/enter";
    }

    @RequestMapping(value = {"/registration"}, method = {RequestMethod.GET})
    public String registration() {
        return "registration";
    }

    @RequestMapping(value = {"/enter"}, method = {RequestMethod.GET})
    public String enter() {
        return "enter";
    }

    @RequestMapping(value = {"/logout"}, method = {RequestMethod.GET})
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "redirect:/";
    }
    @RequestMapping(value = {"/profile"}, method = {RequestMethod.GET})
    public String profile(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") != null) {
            return "profile";
        } else {
            return "redirect:/enter";
        }
    }
    @RequestMapping(value = {"/addpromo"}, method = {RequestMethod.GET})
    public String addpromo(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") != null) {
            return "addpromo";
        } else {
            return "redirect:/enter";
        }
    }
    @RequestMapping(value = {"/categories"}, method = {RequestMethod.GET})
    public String categories() {
        return "categories";
    }
    @RequestMapping(value = {"/shops"}, method = {RequestMethod.GET})
    public String shops() {
        return "shops";
    }
}

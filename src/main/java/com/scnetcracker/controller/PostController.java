package com.scnetcracker.controller;

import com.scnetcracker.entity.UsersEntity;
import com.scnetcracker.service.UserServiceImp;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.scnetcracker.service.PromoServiceImp;


import javax.servlet.http.HttpServletRequest;
import java.util.List;
/*
* Контроллер для обработки GET запросов отправленных на сервер
*
* @RequestMapping содержит переменные:
* value - показывает ккой путь обрабатывает функция находящаяся ниже
* method - метод которые обработки
*
* @ResponseBody - говорит, что с Сервера будет будет получен ответ и тело ответа (наприммер JSON)
 */
@Controller
public class PostController {
    @RequestMapping(value = {"/enter"}, method = {RequestMethod.POST})
    @ResponseBody
    public ResponseEntity login(HttpServletRequest request) {

        UserServiceImp user = new UserServiceImp();

        String Email = request.getParameter("Email");
        String Password = DigestUtils.md5Hex(request.getParameter("Password"));

        List<UsersEntity> list = user.getUser(Email);
        System.out.println(Password);
        if (list.size() >= 1) {
            for (UsersEntity u : list) {
                System.out.println(u.getPassword() + "    " + Password);
                if (u.getEmail().equals(Email) && u.getPassword().equals(Password)) {
                    request.getSession().setAttribute("user", Email);
                    return new ResponseEntity<>("KULL", HttpStatus.OK);
                }
            }
        }
        // Возвращаем статус
        return new ResponseEntity<>("NE_KULL", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = {"/reguser"}, method = {RequestMethod.POST})
    @ResponseBody
    public ResponseEntity<String> reguser(HttpServletRequest request) {
        UserServiceImp user = new UserServiceImp();

        String Login = request.getParameter("Login");
        String Email = request.getParameter("Email");
        String Password = DigestUtils.md5Hex(request.getParameter("Password"));

        user.createUser(Login, Password, Email);

        request.getSession().setAttribute("user", Email);

        return new ResponseEntity<>("KULL", HttpStatus.OK);

    }

    @RequestMapping(value = {"/promoadd"}, method = {RequestMethod.POST})
    @ResponseBody
    public ResponseEntity<String> promoadd(HttpServletRequest request) {
        PromoServiceImp PromoService = new PromoServiceImp();

        String Promo = request.getParameter("Promo");
        String Description = request.getParameter("Description");
        String Shop = request.getParameter("Shop");
        String Category = request.getParameter("Category");
        String ExpireDate = request.getParameter("ExpireDate");
        String User = (String) request.getSession().getAttribute("user");
        System.out.println(Promo);
        System.out.println(Description);
        System.out.println(Shop);
        System.out.println(Category);
        System.out.println(ExpireDate);
        System.out.println(User);

        PromoService.createPromo(Promo, Description, Shop, Category, ExpireDate, User);

        return new ResponseEntity<>("KULL", HttpStatus.OK);

    }
}

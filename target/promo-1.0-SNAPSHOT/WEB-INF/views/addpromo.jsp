<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="com.scnetcracker.entity.ShopsEntity" %>
<%@ page import="com.scnetcracker.service.ShopServiceImp" %>
<%@ page import="com.scnetcracker.entity.CategoriesEntity" %>
<%@ page import="com.scnetcracker.service.CategoryServiceImp" %>
<%@ page import="java.util.List" %>

<c:set var="baseURL" value="http://localhost:8080"/>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Регистрация</title>
    <link rel="stylesheet" href="resources/css/auth.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="reg-block">
        <h3>Добавление промокода</h3>
        <br>
        <br>
        <form>
            <div class="inputVal">
                <label for="Promo">Промокод</label><br>
                <input required="required"  type="text" id="Promo">
            </div>

            <div class="inputVal">
                <label for="Description">Описание</label><br>
                <input required="required" type="text" id="Description">
            </div>

            <div class="inputVal">
                <label>Магазин</label><br>
                <select id="Shop">
                    <%
                        ShopServiceImp shopService = new ShopServiceImp();
                        List<ShopsEntity> shops = shopService.getShops();
                        for(ShopsEntity shop : shops){

                    %>
                    <option id=<%=shop.getId()%>>
                        <%=shop.getName()%>
                    </option>

                    <%
                        }
                    %>
                </select><br>
            </div>

            <div class="inputVal">
                <label>Категория</label><br>
                <select id="Category">
                    <%
                        CategoryServiceImp categoryService = new CategoryServiceImp();
                        List<CategoriesEntity> categories = categoryService.getCategories();
                        for(CategoriesEntity category : categories){

                    %>
                        <option id=<%=category.getId()%>>
                                    <%=category.getName()%>
                        </option>
                    <%
                        }
                    %>
                </select><br>
            </div>

            <div class="inputVal">
                <label for="ExpireDate">Дата окончания действия</label><br>
                <input required="required" type="date" id="ExpireDate">
            </div>

            <div class="inputVal">
                <p class="error"></p>
            </div>

            <div class="inputVal">
                <button type="submit" value="Добавить" id="subAddButton">Добавить</button>
            </div>
        </form>


    </div>
</div>



<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="resources/js/addPromo.js"></script>


</body>
</html>
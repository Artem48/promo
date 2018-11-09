<%@ page import="com.scnetcracker.service.UserServiceImp" %>
<%@ page import="com.scnetcracker.entity.UsersEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="com.scnetcracker.entity.PromocodesEntity" %>
<%@ page import="com.scnetcracker.entity.ShopsEntity" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Промокоды</title>
    <link rel="stylesheet" href="resources/css/main.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>

<body>
<div id="header">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">
            Название
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Категории</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Еще что то
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">Пример</a>
                    </div>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Поиск" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Поиск</button>
            </form>

            <a href="profile"><p><%=session.getAttribute("user")%></p></a>

        </div>
    </nav>
</div>
<!-- Body -->
<div id="container">

    <div class="card-group" id="promos">
        <%
            UserServiceImp user = new UserServiceImp();
            List<UsersEntity> userD = user.getUser((String) session.getAttribute("user"));
            for(UsersEntity u : userD){
                List<PromocodesEntity> list = user.getUserPromo(u.getId());
                for(PromocodesEntity w : list){

        %>
                        <div class="col-md-3">
                            <div class="card card-box">
                                <img class="card-img-top card-middle card-image" src="resources/img/1.png" alt="Card image cap">
                                <div class="card-block">
                                    <h4 class="card-title card-middle-text">
                                        <%
                                            List<ShopsEntity> shops = user.getShop(w.getShopId());
                                            for(ShopsEntity shop : shops){
                                        %>
                                        <a href="<%=shop.getUrl()%>"><%=shop.getName()%></a>
                                        <%
                                            }
                                        %>
                                    </h4>
                                    <p class="card-text"><%=w.getDescription()%></p>
                                    <p class="card-text"><small class="text-muted">был добавлен <%=w.getIssueDate()%></small></p>
                                    <a href="#" class="btn btn-primary card-middle-button"><%=w.getPromo()%></a>
                                </div>
                            </div>
                        </div>

        <%
                }
            }

        %>
    </div>
</div>
<!-- Footer -->
<div id="footer"></div>
</body>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="resources/js/profile.js"></script>
</body>
</html>
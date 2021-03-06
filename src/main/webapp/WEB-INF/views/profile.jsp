<%@ page import="com.scnetcracker.service.UserServiceImp" %>
<%@ page import="com.scnetcracker.entity.UsersEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="com.scnetcracker.entity.ShopsEntity" %>
<%@ page import="com.scnetcracker.service.PromoServiceImp" %>
<%@ page import="com.scnetcracker.service.ShopServiceImp" %>
<%@ page import="com.scnetcracker.entity.PromocodesEntity" %>
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
<jsp:include page="templates/topNavBar.jsp" />
<!-- Body -->
<div id="container">

    <div class="card-group" id="promos">
        <%
            UserServiceImp user = new UserServiceImp();
            PromoServiceImp promo = new PromoServiceImp();
            ShopServiceImp shopService = new ShopServiceImp();

            List<UsersEntity> userD = user.getUser((String) session.getAttribute("user"));
            for(UsersEntity u : userD){
                List<PromocodesEntity> list = promo.getUserPromo(u.getId());
                for(PromocodesEntity w : list){

        %>
                        <div class="col-md-3">
                            <div class="card card-box">
                                <img class="card-img-top card-middle card-image" src="resources/img/1.png" alt="Card image cap">
                                <a href="/delete/<%=w.getPromoId()%>">X</a>
                                <div class="card-block">
                                    <h4 class="card-title card-middle-text">
                                        <%
                                            List<ShopsEntity> shops = shopService.getShop(w.getShopId());
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
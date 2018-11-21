<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="java.util.List" %>
<%@ page import="com.scnetcracker.entity.ShopsEntity" %>
<%@ page import="com.scnetcracker.service.PromoServiceImp" %>
<%@ page import="com.scnetcracker.service.ShopServiceImp" %>
<%@ page import="com.scnetcracker.entity.PromocodesEntity" %>

<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Промокоды</title>
    <jsp:include page="templates/header.jsp" />
    <style>
        <%@include file='/resources/css/main.css' %>
    </style>

</head>
<body>

<body>
<jsp:include page="templates/topNavBar.jsp" />
<!-- Body -->
<div id="container">
        <div class="card-group" id="promos">
            <%
                PromoServiceImp promo = new PromoServiceImp();
                ShopServiceImp shopService = new ShopServiceImp();
                List<PromocodesEntity> list = promo.getCategoryPromo(Integer.parseInt(request.getAttribute("id").toString()));
                for(PromocodesEntity w : list){

            %>
            <div class="col-md-3">
                <div class="card card-box">
                    <img class="card-img-top card-middle card-image" src="/resources/img/1.png" alt="Card image cap">
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

            %>
        </div>

</div>
<!-- Footer -->
<div id="footer"></div>
</body>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="/resources/js/main.js"></script>
</body>
</html>
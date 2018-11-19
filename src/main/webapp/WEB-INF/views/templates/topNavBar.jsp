<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.scnetcracker.service.CategoryServiceImp" %>
<%@ page import="com.scnetcracker.entity.CategoriesEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="com.scnetcracker.service.ShopServiceImp" %>
<%@ page import="com.scnetcracker.entity.ShopsEntity" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    CategoryServiceImp categoryService = new CategoryServiceImp();
    ShopServiceImp shopService = new ShopServiceImp();
    List<CategoriesEntity> categories = categoryService.getCategories();
    List<ShopsEntity> shops = shopService.getShops();

%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
        <a class="navbar-brand" href="#">Проект</a>
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="categoriesDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Категории
                </a>
                <ul class="dropdown-menu" aria-labelledby="categoriesDropdown">
                    <%

                        for(CategoriesEntity category : categories){
                            List<CategoriesEntity> categoriesChildren = categoryService.getChildrenCategory(category.getId());
                            boolean state = false;
                            String liClass = "";
                            StringBuffer aClass = new StringBuffer("dropdown-item");
                            if (categoriesChildren.size() > 0) {
                               state = true;
                               liClass = "dropdown-submenu";
                               aClass.append(" dropdown-toggle");

                            }


                            %>
                            <li class="<%=liClass%>"><a class="<%=aClass%>"  href="#"><%=category.getName()%></a>
                            <%


                                if (state){
                                    %>
                                <ul class="dropdown-menu">
                                    <%
                                    for(CategoriesEntity child : categoriesChildren ){
                                    %>
                                        <li><a class="dropdown-item"  href="#"><%=child.getName()%></a></li>
                                    <%
                                    }
                                    %>
                                </ul>
                                <%
                                }

                            %>
                            </li>



                            <%
                                }
                            %>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">

                        <a class="nav-link dropdown-toggle" href="http://example.com" id="shopsDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Магазины
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="categoriesDropdown">
                            <%
                                for(ShopsEntity shop : shops){

                            %>
                            <li><a class="dropdown-item"  href="<%=shop.getName()%>"><%=shop.getName()%></a>
                            <%
                                }
                            %>
                        </ul>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="addpromo">Добавить промокод</a>
                    </li>
                </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Поиск</button>
        </form>

        <c:choose>
            <c:when test="${sessionScope.user == null}">
                <p><a href="enter">Вход</a>/<a href="registration">Регистрация</a></p>

            </c:when>
            <c:otherwise>
                <p>Пользователь: <a href="profile"><%=session.getAttribute("user")%></a></p>
                <a href="logout" class="btn btn-outline-success my-2 my-sm-0">Выйти</a>
            </c:otherwise>
        </c:choose>
    </div>
</nav>
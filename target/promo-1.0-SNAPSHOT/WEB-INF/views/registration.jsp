
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


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
        <h3>Регистрация</h3>
        <br>
        <br>
        <form>
            <div class="inputVal">
                <label for="Login">Имя пользователя:</label><br>
                <input required="required"  type="text" id="Login">
            </div>

            <div class="inputVal">
                <label for="Email">Email:</label><br>
                <input required="required"  type="text" id="Email">
            </div>

            <div class="inputVal">
                <label for="Password">Пароль:</label><br>
                <input required="required" type="text" id="Password">
            </div>
            <div class="inputVal">
                <label for="chkPass">Подтверждение пароля:</label><br>
                <input required="required" type="text" id="chkPass">
            </div>
            <div class="inputVal">
                <input type="submit" value="Регистрация" id="subRegButton">
            </div>
        </form>


    </div>
</div>



<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="resources/js/auth.js"></script>


</body>
</html>
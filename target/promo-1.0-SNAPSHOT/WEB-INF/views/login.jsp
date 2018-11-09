<%--
  Created by IntelliJ IDEA.
  User: Workstation
  Date: 07.11.2018
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <h1>This is secured!</h1>
    <p>
        Hello <b><c:out value="${pageContext.request.remoteUser}"/></b>
    </p>
</div>
</body>
</html>

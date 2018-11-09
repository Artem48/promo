<%--
  Created by IntelliJ IDEA.
  User: Workstation
  Date: 06.11.2018
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<div class="container">
    <h1>This is secured!</h1>
    <p>
        Hello <b><%=session.getAttribute("user")%></b>
    </p>
</div>
</body>

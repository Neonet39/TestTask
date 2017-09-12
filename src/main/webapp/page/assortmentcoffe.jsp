<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form accept-charset="UTF-8" action="${pageContext.servletContext.contextPath}/preordercoffe " method="post">
<div class="tabl">
    <table name="test">
        <tr>
            <th>Сорт кофе</th>
            <th>Цена</th>
            <th>Количество</th>c
        </tr>

        <c:forEach items="${assortementCoffeList}" var="assortementCoffe">

        <tr>
            <td>${assortementCoffe.getType_name()}</td>
            <td>${assortementCoffe.getPrice()}</td>
            <td> "><input name="${assortementCoffe.getId()}" type="text">/td>
        </tr>

        </c:forEach>
        <tr>
            <td></td>
            <td></td>
            <td><button>Заказать</button></td>
        </tr>

    </table>
</div>
</form>


</body>
</html>

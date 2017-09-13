<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="accept/css/about.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Inconsolata">
    <link rel="stylesheet" type="text/css" href="accept/css/order.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/accept/js/script.js"></script>

</head>

<body>

<div id="top">
    <c:import url="header/header.jsp" />
</div>


<form accept-charset="UTF-8" action="${pageContext.servletContext.contextPath}/preordercoffe " method="post" onsubmit="return validate();">
<div class="tabl">
    <table id="age-table">
        <tr>
            <th>Сорт кофе</th>
            <th>Цена</th>
            <th>Количество</th>
        </tr>

        <c:forEach items="${assortementCoffeList}" var="assortementCoffe">

        <tr>
            <td>${assortementCoffe.getType_name()}</td>
            <td>${assortementCoffe.getPrice()} TGR</td>
            <td><input name="${assortementCoffe.getId()}" type="text"></td>
        </tr>

        </c:forEach>
        <tr>
            <td></td>
            <td></td>
            <td><button>to Order</button></td>
        </tr>

    </table>
</div>
</form>


</body>
</html>

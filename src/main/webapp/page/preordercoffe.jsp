<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<form method="post" action="${pageContext.servletContext.contextPath}/order" onsubmit="return validateAdrres();">
<div >
    <table id="age-table">
        <tr>
            <th>Delivery</th>
        </tr>

        <tr>
            <td>Full name</td>
            <td><input name="fio" type="text"></td>

        </tr>
        <tr>
            <td>Address</td>
            <td><input name="adres" type="text"> </td>
        </tr>
        <tr>
            <td></td>
            <td><button>to order</button> </td>
        </tr>

    </table>
</div>
</form>
    <div class="tabl">
        <table  >
            <tr>
                <th>Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Total</th>
            </tr>

            <c:forEach items="${preOrderCoffeList}" var="preOrderCoffe">

                <tr>
                    <td>${preOrderCoffe.getType_name()}</td>
                    <td>${preOrderCoffe.getPrice()} TGR</td>
                    <td> ${preOrderCoffe.getQuantity()}</td>
                    <td> ${preOrderCoffe.getFull_price()} TGR</td>
                </tr>

            </c:forEach>
            <tr>
                <td></td>
                <td></td>
                <td>Total:</td>
                <td>${totalPrice.getTotal()} TGR</td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td>Delivery:</td>
                <td>${totalPrice.getDelivery()} TGR</td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td>Total:</td>
                <td>${totalPrice.getFullTotal()} TGR</td>
            </tr>

        </table>
    </div>
</body>
</html>

<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="${pageContext.servletContext.contextPath}/order">
<div class="tabl">
    <table name="test">
        <tr>
            <th>Доствка</th>
        </tr>

        <tr>
            <td>ФИО<input name="fio" type="text"></td>
            <td>Адрес<input name="adres" type="text"> </td>
            <td><input value="Заказать" name="" type="submit"> </td>

        </tr>

    </table>
</div>
</form>
    <div class="tabl">
        <table name="test">
            <tr>
                <th>Название</th>
                <th>Цена</th>
                <th>Количество</th>
                <th>Всего</th>
            </tr>

            <c:forEach items="${preOrderCoffeList}" var="preOrderCoffe">

                <tr>
                    <td>${preOrderCoffe.getType_name()}</td>
                    <td>${preOrderCoffe.getPrice()}</td>
                    <td> ${preOrderCoffe.getQuantity()}</td>
                    <td> ${preOrderCoffe.getFull_price()}</td>
                </tr>

            </c:forEach>
            <tr>
                <td></td>
                <td></td>
                <td>сумма:</td>
                <td>${totalPrice.getTotal()}</td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td>Доставка:</td>
                <td>${totalPrice.getDelivery()}</td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td>Всего:</td>
                <td>${totalPrice.getFullTotal()}</td>
            </tr>

        </table>
    </div>



</body>
</html>

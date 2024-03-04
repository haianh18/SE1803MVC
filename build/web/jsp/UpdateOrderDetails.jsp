<%-- 
    Document   : UpdateOrderDetail
    Created on : Feb 29, 2024, 11:10:48 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,entity.OrderDetails,java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Orders</title>
    </head>
    <body>
        <%Vector<OrderDetails> vector
                    =(Vector<OrderDetails>)request.getAttribute("vector");
        OrderDetails ode = vector.get(0);
        %><!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="OrderDetailsControllerURL" method="post">
            <table>
                <caption>Update Order Details</caption>
                <tr>
                    <td>OrderID</td>
                    <td><input type = "text" name = "OrderID" id ="" value ="<%=ode.getOrderID()%>" readonly></td>
                </tr>
                <tr>
                    <td>ProductID</td>
                    <td><input type="text" name="ProductID" id="" value ="<%=ode.getProductID()%>"></td>
                </tr>
                <tr>
                    <td>UnitPrice</td>
                    <td><input type="text" name="UnitPrice" id=""value ="<%=ode.getUnitPrice()%>"></td>
                </tr>
                <tr>
                    <td>Quantity</td>
                    <td><input type="text" name="Quantity" id=""value ="<%=ode.getQuantity()%>"></td>
                </tr>
                <tr>
                    <td>Discount</td>
                    <td><input type="text" name="Discount" id="" value ="<%=ode.getDiscount()%>"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="update Order Details" name="submit"></td>
                    <td><input type="reset" value="Clear"></td>
                </tr>
                <input type="hidden" name="service" value="update">
            </table>
        </form>
    </body>
</html>

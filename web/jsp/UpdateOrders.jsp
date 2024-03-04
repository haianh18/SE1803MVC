<%-- 
    Document   : updateOrders
    Created on : Feb 29, 2024, 9:55:20 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,entity.Orders,java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Orders</title>
    </head>
    <body>
        <%Vector<Orders> vector
                    =(Vector<Orders>)request.getAttribute("vector");
        Orders od =vector.get(0);
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
        <form action="OrdersControllerURL" method="post">
            <table>
                <caption>Update Orders</caption>
                <tr>
                    <td>OrderID</td>
                    <td><input type = "text" name = "OrderID" id ="" value ="<%=od.getOrderID()%>" readonly></td>
                </tr>
                <tr>
                    <td>CustomerID</td>
                    <td><input type="text" name="CustomerID" id="" value ="<%=od.getCustomerID()%>"></td>
                </tr>
                <tr>
                    <td>EmployeeID</td>
                    <td><input type="text" name="EmployeeID" id=""value ="<%=od.getEmployeeID()%>"></td>
                </tr>
                <tr>
                    <td>ShipVia</td>
                    <td><input type="text" name="ShipVia" id=""value ="<%=od.getShipVia()%>"></td>
                </tr>
                <tr>
                    <td>OrderDate</td>
                    <td><input type="text" name="OrderDate" id="" value ="<%=od.getOrderDate()%>"></td>
                </tr>
                <tr>
                    <td>RequiredDate</td>
                    <td><input type="text" name="RequiredDate" id="" value ="<%=od.getRequiredDate()%>"></td>
                </tr>
                <tr>
                    <td>ShippedDate</td>
                    <td><input type="text" name="ShippedDate" id="" value ="<%=od.getShippedDate()%>"></td>
                </tr>
                <tr>
                    <td>ShipName</td>
                    <td><input type="text" name="ShipName" id="" value ="<%=od.getShipName()%>"></td>
                </tr>
                <tr>
                    <td>ShipAddress</td>
                    <td><input type="text" name="ShipAddress" id="" value ="<%=od.getShipAddress()%>"></td>
                </tr>
                <tr>
                    <td>ShipCity</td>
                    <td><input type="text" name="ShipCity" id="" value ="<%=od.getShipCity()%>"></td>
                </tr>
                <tr>
                    <td>ShipRegion</td>
                    <td><input type="text" name="ShipRegion" id=""value ="<%=od.getShipRegion()%>"></td>
                </tr>
                <tr>
                    <td>ShipPostalCode</td>
                    <td><input type="text" name="ShipPostalCode" id="" value ="<%=od.getShipPostalCode()%>"></td>
                </tr>
                <tr>
                    <td>ShipCountry</td>
                    <td><input type="text" name="ShipCountry" id=""value ="<%=od.getShipCountry()%>"></td>
                </tr>
                <tr>
                    <td>Freight</td>
                    <td><input type="text" name="Freight" id=""value ="<%=od.getFreight()%>"></td>
                </tr>

                <tr>
                    <td><input type="submit" value="update Orders" name="submit"></td>
                    <td><input type="reset" value="Clear"></td>
                </tr>
                <input type="hidden" name="service" value="update">
            </table>
        </form>
    </body>
</html>

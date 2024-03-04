<%-- 
    Document   : OrderDetailsManage
    Created on : Feb 29, 2024, 11:10:29 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,entity.OrderDetails"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <% String titlePage=(String)request.getAttribute("titlePage");%>
        <title><%=titlePage%></title>
    </head>
    <body>
        <table border="1">
            <% String titleTable=(String)request.getAttribute("titleTable");%>
            <caption><%=titleTable%></caption>
            <tr>
                <th>OrderID</th>
                <th>ProductID</th>
                <th>UnitPrice</th>
                <th>Quantity</th>
                <th>Discount</th>
            </tr>
            <% Vector<OrderDetails> vector
                  =(Vector<OrderDetails>)request.getAttribute("data");
          for(OrderDetails ode:vector){
            %>
            <tr>
                <td><%=ode.getOrderID()%></td>
                <td><%=ode.getProductID()%></td>
                <td><%=ode.getUnitPrice()%></td>
                <td><%=ode.getQuantity()%></td>
                <td><%=ode.getDiscount()%></td>
                <td><a href="OrderDetailsControllerURL?service=update&id=<%=ode.getOrderID()%>">Update</a></td>
                <td><a href="OrderDetailsControllerURL?service=delete&id=<%=ode.getOrderID()%>">Delete</a></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>

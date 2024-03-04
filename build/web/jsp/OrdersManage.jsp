<%-- 
    Document   : OrdersManage
    Created on : Feb 29, 2024, 8:58:53 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,entity.Orders"%>
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
                <th>CustomerID</th>
                <th>EmployeeID</th>
                <th>OrderDate</th>
                <th>RequiredDate</th>
                <th>ShippedDate</th>
                <th>ShipVia</th>
                <th>Freight</th>
                <th>ShipName</th>
                <th>ShipAddress</th>
                <th>ShipCity</th>
                <th>ShipRegion</th>
                <th>ShipPostalCode</th>
                <th>ShipCountry</th>

            </tr>
            <% Vector<Orders> vector
                  =(Vector<Orders>)request.getAttribute("data");
          for(Orders od:vector){
            %>
            <tr>
                <td><%=od.getOrderID()%></td>
                <td><%=od.getCustomerID()%></td>
                <td><%=od.getEmployeeID()%></td>
                <td><%=od.getOrderDate()%></td>
                <td><%=od.getRequiredDate()%></td>
                <td><%=od.getShippedDate()%></td>
                <td><%=od.getShipVia()%></td>
                <td><%=od.getFreight()%></td>
                <td><%=od.getShipName()%></td>
                <td><%=od.getShipAddress()%></td>
                <td><%=od.getShipCity()%></td>
                <td><%=od.getShipRegion()%></td>
                <td><%=od.getShipPostalCode()%></td>
                <td><%=od.getShipCountry()%></td>
                <td><a href="OrdersControllerURL?service=update&id=<%=od.getOrderID()%>">update</a></td>
                <td><a href="OrdersControllerURL?service=delete&id=<%=od.getOrderID()%>">delete</a></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>

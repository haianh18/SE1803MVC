<%-- 
    Document   : CustomersManage
    Created on : Feb 22, 2024, 9:40:47 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,entity.Customers"%>
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
            <th>CustomerID</th>
            <th>CompanyName</th>
            <th>ContactName</th>
            <th>ContactTitle</th>
            <th>Address</th>
            <th>City</th>
            <th>Region</th>
            <th>PostalCode</th>
            <th>Country</th>
            <th>Phone</th>
            <th>Fax</th>
            </tr>
            <% Vector<Customers> vector
                    =(Vector<Customers>)request.getAttribute("data");
            for(Customers cus:vector){
            %>
            <tr>
                <td><%=cus.getCustomerID()%></td>
                <td><%=cus.getCompanyName()%></td>
                <td><%=cus.getContactName()%></td>
                <td><%=cus.getContactTitle()%></td>
                <td><%=cus.getAddress()%></td>
                <td><%=cus.getCity()%></td>
                <td><%=cus.getRegion()%></td>
                <td><%=cus.getPostalCode()%></td>
                <td><%=cus.getCountry()%></td>
                <td><%=cus.getPhone()%></td>
                <td><%=cus.getFax()%></td>
                <td><a href="CustomersControllerURL?service=update&id=<%=cus.getCustomerID()%>">update</a></td>
                <td><a href="CustomersControllerURL?service=delete&id=<%=cus.getCustomerID()%>">delete</a></td>
            </tr>
            <%}%>
    </body>
</html>

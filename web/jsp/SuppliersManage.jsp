<%-- 
    Document   : SuppliersManage
    Created on : Mar 4, 2024, 9:29:13 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,entity.Suppliers"%>
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
                <th>SupplierID</th>
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
                <th>HomePage</th>
            </tr>
            <% Vector<Suppliers> vector
                    =(Vector<Suppliers>)request.getAttribute("data");
            for(Suppliers sup:vector){
            %>
            <tr>
                <td><%=sup.getSupplierID()%></td>
                <td><%=sup.getCompanyName()%></td>
                <td><%=sup.getContactName()%></td>
                <td><%=sup.getContactTitle()%></td>
                <td><%=sup.getAddress()%></td>
                <td><%=sup.getCity()%></td>
                <td><%=sup.getRegion()%></td>
                <td><%=sup.getPostalCode()%></td>
                <td><%=sup.getCountry()%></td>
                <td><%=sup.getPhone()%></td>
                <td><%=sup.getFax()%></td>
                <td><%=sup.getHomePage()%></td>
                <td><a href="SuppliersControllerURL?service=update&id=<%=sup.getSupplierID()%>">update</a></td>
                <td><a href="SuppliersControllerURL?service=delete&id=<%=sup.getSupplierID()%>">delete</a></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>

<%-- 
    Document   : UpdateCustomers
    Created on : Feb 22, 2024, 9:48:51 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,entity.Customers,java.sql.ResultSet"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>update customers</title>
    </head>
    <body>
         <%Vector<Customers> vector
                    =(Vector<Customers>)request.getAttribute("vector");
        Customers cus=vector.get(0);
        %>
        <form action="CustomersControllerURL" method="post">
             <table>
                <caption>update customers</caption>
                <tr>
                <td>CustomerID</td>
                <td><input type="text" name="CustomerID" id="" value="<%=cus.getCustomerID()%>" readonly></td>
            </tr>
            <tr>
                <td>CompanyName</td>
                <td><input type="text" name="CompanyName" id="" value="<%=cus.getCompanyName()%>"></td>
            </tr>
            <tr>
                <td>ContactName</td>
                <td><input type="text" name="ContactName" id="" value="<%=cus.getContactName()%>"></td>
            </tr>
            <tr>
                <td>ContactTitle</td>
                <td><input type="text" name="ContactTitle" id="" value="<%=cus.getContactTitle()%>"></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input type="text" name="Address" id="" value="<%=cus.getAddress()%>"></td>
            </tr>
            <tr>
                <td>City</td>
                <td><input type="text" name="City" id="" value="<%=cus.getCity()%>"></td>
            </tr>
            <tr>
                <td>Region</td>
                <td><input type="text" name="Region" id="" value="<%=cus.getRegion()%>"></td>
            </tr>
            <tr>
                <td>PostalCode</td>
                <td><input type="text" name="PostalCode" id="" value="<%=cus.getPostalCode()%>"></td>
            </tr>
            <tr>
                <td>Country</td>
                <td><input type="text" name="Country" id="" value="<%=cus.getCountry()%>"></td>
            </tr>
            <tr>
                <td>Phone</td>
                <td><input type="text" name="Phone" id="" value="<%=cus.getPhone()%>"></td>
            </tr>
            <tr>
                <td>Fax</td>
                <td><input type="text" name="Fax" id="" value="<%=cus.getFax()%>"></td>
            </tr>
            <tr>
                <td><input type="submit" value="update Customers" name="submit"></td>
                <td><input type="reset" value="Reset"></td>
            </tr>
            <input type="hidden" name="service" value="update">
             </table>
        </form>
    </body>
</html>

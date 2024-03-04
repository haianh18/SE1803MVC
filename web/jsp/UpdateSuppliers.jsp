<%-- 
    Document   : UpdateSuppliers
    Created on : Mar 4, 2024, 9:37:33 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,entity.Suppliers,java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Suppliers</title>
    </head>
    <body>
        <%Vector<Suppliers> vector
                    =(Vector<Suppliers>)request.getAttribute("vector");
        Suppliers sup=vector.get(0);
        %>
        <form action="SuppliersControllerURL" method="post">
            <table>
                <caption>update suppliers</caption>
                <tr>
                <td>SupplierID</td>
                <td><input type="text" name="SupplierID" id="" value="<%=sup.getSupplierID()%>" readonly></td>
            </tr>
            <tr>
                <td>CompanyName</td>
                <td><input type="text" name="CompanyName" id="" value="<%=sup.getCompanyName()%>" ></td>
            </tr>
            <tr>
                <td>ContactName</td>
                <td><input type="text" name="ContactName" id="" value="<%=sup.getContactName()%>" ></td>
            </tr>
            <tr>
                <td>ContactTitle</td>
                <td><input type="text" name="ContactTitle" id="" value="<%=sup.getContactTitle()%>" ></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input type="text" name="Address" id="" value="<%=sup.getAddress()%>" ></td>
            </tr>
            <tr>
                <td>City</td>
                <td><input type="text" name="City" id="" value="<%=sup.getCity()%>" ></td>
            </tr>
            <tr>
                <td>Region</td>
                <td><input type="text" name="Region" id="" value="<%=sup.getRegion()%>" ></td>
            </tr>
            <tr>
                <td>PostalCode</td>
                <td><input type="text" name="PostalCode" id="" value="<%=sup.getPostalCode()%>" ></td>
            </tr>
            <tr>
                <td>Country</td>
                <td><input type="text" name="Country" id="" value="<%=sup.getCountry()%>" ></td>
            </tr>
            <tr>
                <td>Phone</td>
                <td><input type="text" name="Phone" id="" value="<%=sup.getPhone()%>" ></td>
            </tr>
            <tr>
                <td>Fax</td>
                <td><input type="text" name="Fax" id="" value="<%=sup.getFax()%>" ></td>
            </tr>
            <tr>
                <td>HomePage</td>
                <td><input type="text" name="HomePage" id="" value="<%=sup.getHomePage()%>" ></td>
            </tr>
             <tr>
                <td><input type="submit" value="update Suppliers" name="submit"></td>
                <td><input type="reset" value="Reset"></td>
            </tr>
            <input type="hidden" name="service" value="update">
            
            </table>
        </form>
    </body>
</html>

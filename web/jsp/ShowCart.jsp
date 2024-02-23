<%-- 
    Document   : ShowCart
    Created on : 23 Feb 2024, 8:37:14 am
    Author     : laivu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Products"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
    </head>
    <body>
        <h1>Continue shopping</h1><!-- Tu lam -->
        <table border="1">
		<caption>List of Products</caption>
		<tr>
			<th>ProductID</th>
			<th>ProductName</th>
			<th>Quantity</th>
			<th>UnitPrice</th>
			<th>subTotal</th>
			<th>remove</th>
                </tr>
                <% java.util.Enumeration em = session.getAttributeNames();
                //get keys
                while(em.hasMoreElements()){
                    String key = em.nextElement().toString();//get key id
                    Products pro = (Products)session.getAttribute(key);//get value
                %>
                <tr>
                    <td><%=pro.getProductID()%></td>
                    <td><%=pro.getProductName()%></td>
                    <td><%=pro.getUnitsInStock()%></td>
                    <td><%=pro.getUnitPrice()%></td>
                    <td>code subTotal</td>
                    <td>code Remove</td>
                </tr>
                <%}%>
        </table>
        <p>code grandTotal = sum of subTotal</p>
        <p>code remove all products in cart</p>
        <p>code check out: write cart into DB</p>
    </body>
</html>

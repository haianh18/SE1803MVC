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
                double grandTotal = 0;
                while(em.hasMoreElements()){
                    String key = em.nextElement().toString();//get key id
                    //if != username
                    Products pro = (Products)session.getAttribute(key);//get value
                    double subTotal = pro.getUnitsInStock()*pro.getUnitPrice();
                    grandTotal+=subTotal;
                %>
                <tr>
                    <td><%=pro.getProductID()%></td>
                    <td><%=pro.getProductName()%></td>
                    <td><input ><--<!-- dung javascript viet --></td>
                    <td><%=pro.getUnitsInStock()%></td>
                    <td><%=pro.getUnitPrice()%></td>
                    <td><%=subTotal%></td>
                    <td>code Remove</td>
                </tr>
                <%}%>
        </table>
                <p>Grand Total: <%=grandTotal%></p><!--<!-- them code js -->
        <p>code remove all products in cart</p> <!<!-- duyet qua tung phan tu de tranh delete username-->
        <p>code check out: write cart into DB</p> <!<!--write vao orderdetail, update them vao order-->
        <!<!-- them update -->
        <!<!-- quantity sua duoc chu ko chi xoa -->
    </body>
</html>

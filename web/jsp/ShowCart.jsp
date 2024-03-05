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
        <form action="CartURL" method="post">
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
                    <td><input type="text" value="<%=pro.getUnitsInStock()%>" name="UnitsInStock"></td>
                    <td><%=pro.getUnitPrice()%></td>
                    <td><%=subTotal%></td>
                <input type="hidden" value="<%=pro.getProductID()%>" name="ProductID">
                <input type="hidden" value="<%=pro.getProductName()%>" name="ProductName">
                <input type="hidden" value="<%=pro.getUnitPrice()%>" name="UnitPrice">
                <!-- dung javascript viet them phan subtotal -->
                <td><input type="submit" name="service" value="remove"></td>
                </tr>

                <%}%>
                <tr>
                    <td><input name="service" type="submit" value="Update"></td>
                    <td><input type="reset" value="Reset"></td>
                    <td></td>
                    <td>Grand Total: </td><!--<!-- them code js -->
                    <td><%=grandTotal%></td>
                    <td><input name="service" type="submit" value="Remove All"></td>
                </tr>
            </table>
            <p></p>
            <input type="submit" name="service" value="Check Out">
        </form>

        <!-- duyet qua tung phan tu de tranh delete username-->
        <p>code check out: write cart into DB</p> <!<!--write vao orderdetail, update them vao order-->
        <!-- them update -->
        <!-- quantity sua duoc chu ko chi xoa -->
    </body>
</html>

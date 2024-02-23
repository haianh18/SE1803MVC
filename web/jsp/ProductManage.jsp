<%-- 
    Document   : ProductManage
    Created on : 30 Jan 2024, 10:58:22 am
    Author     : laivu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,entity.Products"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <% String titlePage=(String) request.getAttribute("titlePage"); %>
        <title><%=titlePage%></title>
    </head>
    <body>
        <p>add Product</p><p>Search</p><!-- tu viet -->
        <p><a href="CartURL?service=showcart">show cart</a></p>
        <table border="1">
                <% String titleTable=(String) request.getAttribute("titleTable"); %>
		<caption><%=titleTable%></caption>
		<tr>
			<th>ProductID</th>
			<th>ProductName</th>
			<th>SupplierID</th>
			<th>CategoryID</th>
			<th>QuantityPerUnit</th>
			<th>UnitPrice</th>
			<th>UnitsInStock</th>
			<th>UnitsOnOrder</th>
			<th>ReorderLevel</th>
			<th>Discontinued</th>
			<th>update</th>
			<th>delete</th>
                        <th>Cart</th>
		</tr>
                <% Vector<Products> vector
                    =(Vector<Products>) request.getAttribute("data");
                    for(Products pro:vector){
                 %>
		<tr>
			<td><%=pro.getProductID()%></td>
			<td><%=pro.getProductName()%></td>
			<td><%=pro.getSupplierID()%></td>
			<td><%=pro.getCategoryID()%></td>
			<td><%=pro.getQuantityPerUnit()%></td>
			<td><%=pro.getUnitPrice()%></td>
			<td><%=pro.getUnitsInStock()%></td>
			<td><%=pro.getUnitsOnOrder()%></td>
			<td><%=pro.getReorderLevel()%></td>
                        <td><%=pro.isDiscontinued()%></td>
			<td><a href="ProductControllerURL?service=update&id=<%=pro.getProductID()%>">update</a></td>
			<td><a href="ProductControllerURL?service=delete&id=<%=pro.getProductID()%>">delete</a></td>
                        <td><a href="CartURL?service=add2cart&id=<%=pro.getProductID()%>">add2cart</a></td>
                </tr>
                <%}%>
	</table>
    </body>
</html>

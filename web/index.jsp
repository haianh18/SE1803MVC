<%-- 
    Document   : index
    Created on : 4 Mar 2024, 9:49:48 pm
    Author     : HaiAnh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@page import="entity.Categories, model.DAOCategories, java.util.Vector"%>

        <title>Home Page</title>
    </head>
    <body>

        <ul>
            <%
                DAOCategories dao = new DAOCategories();
                Vector<Categories> vector = dao.getAll("select * from Categories");
                for (Categories cate : vector) {
                   
            %>
            <li><%=cate.getCategoryName()%></li>
            <%}%>
        </ul>
        <p><a href="ProductControllerURL?service=listAll">list all Products</a></p>
        <p><a href="EmployeeControllerURL?service=listAll">list all Employees</a></p>
        <p><a href="CategoriesControllerURL?service=listAll">list all Categories</a></p>
        <p><a href="CustomersControllerURL?service=listAll">list all Customers</a></p>
        <p><a href="OrdersControllerURL?service=listAll">list all Orders</a></p>
        <p><a href="OrderDetailsControllerURL?service=listAll">list all Order Details</a></p>
        <p><a href="SuppliersControllerURL?service=listAll">list all Suppliers</a></p>
    </body>
</html>

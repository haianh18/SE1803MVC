<%-- 
    Document   : UpdateCategories
    Created on : Feb 22, 2024, 4:47:59 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,entity.Categories,java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>update category</title>
    </head>
    <body>
        <%Vector<Categories> vector
                    =(Vector<Categories>)request.getAttribute("vector");
        Categories cate=vector.get(0);
        %>
        <form action="CategoriesControllerURL" method="post">
            <table>
                <caption>update categories</caption>
            <tr>
                <td>CategoryID</td>
                <td><input type="text" name="CategoryID" id="" value="<%=cate.getCategoryID()%>" readonly></td>
            </tr>
            <tr>
                <td>CategoryName</td>
                <td><input type="text" name="CategoryName" id="" value="<%=cate.getCategoryName()%>"></td>
            </tr>
                <tr>
                <td>Description</td>
                <td><input type="text" name="Description" id="" value="<%=cate.getDescription()%>"></td>
            </tr>
            <tr>
                <td>Picture</td>
                <td><input type="text" name="Picture" id="" value="<%=cate.getPicture()%>"></td>
            </tr>
            <tr>
                <td><input type="submit" value="update Categories" name="submit"></td>
                <td><input type="reset" value="Reset"></td>
            </tr>
            <input type="hidden" name="service" value="update">
            
            </table>
        </form>
    </body>
</html>

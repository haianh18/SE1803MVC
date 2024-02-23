<%-- 
    Document   : CategoriesManage
    Created on : Feb 22, 2024, 8:46:30 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,entity.Categories"%>
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
                <th>CategoryID</th>
                <th>CategoryName</th>
                <th>Description</th>
                <th>Picture</th>
            </tr>
              <% Vector<Categories> vector
                    =(Vector<Categories>)request.getAttribute("data");
            for(Categories cate:vector){
            %>
            <tr>
                <td><%=cate.getCategoryID()%></td>
                <td><%=cate.getCategoryName()%></td>
                <td><%=cate.getDescription()%></td>
                <td><%=cate.getPicture()%></td>
                <td><a href="CategoriesControllerURL?service=update&id=<%=cate.getCategoryID()%>">update</a></td>
                <td><a href="CategoriesControllerURL?service=delete&id=<%=cate.getCategoryID()%>">delete</a></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>

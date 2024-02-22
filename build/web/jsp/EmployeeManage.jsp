<%-- 
    Document   : EmployeeManage
    Created on : 22 Feb 2024, 8:15:26 pm
    Author     : HaiAnh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,entity.Employees"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%String titlePage=(String)request.getAttribute("titlePage");%>
        <title><%=titlePage%></title>
    </head>
    <body>
        <table border="1">
            <%String titleTable=(String)request.getAttribute("titleTable");%>
            <caption><%=titleTable%></caption>	
            <tr>
                <th>EmployeeID</th>
                <th>LastName</th>
                <th>FirstName</th>
                <th>Title</th>
                <th>TitleOfCourtesy</th>
                <th>BirthDate</th>
                <th>HireDate</th>
                <th>Address</th>
                <th>City</th>
                <th>Region</th>
                <th>PostalCode</th>
                <th>Country</th>
                <th>HomePhone</th>
                <th>Extension</th>
                <th>Photo</th>
                <th>Notes</th>
                <th>ReportsTo</th>
                <th>PhotoPath</th>
            </tr>
            <% Vector<Employees> vector
               =(Vector<Employees>) request.getAttribute("data");
               for(Employees emp:vector){
            %>
            <tr>
                <td><%=emp.getEmployeeID()%></td>
                <td><%=emp.getLastName()%></td>
                <td><%=emp.getFirstName()%></td>
                <td><%=emp.getTitle()%></td>
                <td><%=emp.getTitleOfCourtesy()%></td>
                <td><%=emp.getBirthDate()%></td>
                <td><%=emp.getHireDate()%></td>
                <td><%=emp.getAddress()%></td>
                <td><%=emp.getCity()%></td>
                <td><%=emp.getRegion()%></td>
                <td><%=emp.getPostalCode()%></td>
                <td><%=emp.getCountry()%></td>
                <td><%=emp.getHomePhone()%></td>
                <td><%=emp.getExtension()%></td>
                <td><%=emp.getPhoto()%></td>
                <td><%=emp.getNotes()%></td>
                <td><%=emp.getReportsTo()%></td>
                <td><%=emp.getPhotoPath()%></td>
                <td><a href="EmployeeControllerURL?service=update&id=<%=emp.getEmployeeID()%>">update</a></td>
                <td><a href="EmployeeControllerURL?service=delete&id=<%=emp.getEmployeeID()%>">delete</a></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>

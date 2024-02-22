<%-- 
    Document   : UpdateEmployee
    Created on : 22 Feb 2024, 9:16:58 pm
    Author     : HaiAnh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,entity.Employees,java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Employee</title>
    </head>
    <body>
        <%Vector<Employees> vector
                    =(Vector<Employees>)request.getAttribute("vector");
        Employees emp=vector.get(0);
        ResultSet rsTitle=(ResultSet)request.getAttribute("rsTitle");
        ResultSet rsTitleOfCourtesy=(ResultSet)request.getAttribute("rsTitleOfCourtesy");
        %>
        <form action="EmployeeControllerURL" method="post">
            <table>
                <caption>update Employee</caption>
                <tr>
                    <td>EmployeeID</td>
                    <td><input type="text" name="EmployeeID" id="" value="<%=emp.getEmployeeID()%>"></td>
                </tr>
                <tr>
                    <td>LastName</td>
                    <td><input type="text" name="LastName" id="" value="<%=emp.getLastName()%>"></td>
                </tr>
                <tr>
                    <td>FirstName</td>
                    <td><input type="text" name="FirstName" id="" value="<%=emp.getFirstName()%>"></td>
                </tr>
                <tr>
                    <td>Title</td>
                    <td><select name="Title" id="" >
                            <%while (rsTitle.next()){%>
                            <option value="<%=rsTitle.getString(1)%>"><%=rsTitle.getString(1)%></option>
                            <%}%>
                        </select></td>
                </tr>
                <tr>
                    <td>TitleOfCourtesy</td>
                    <td><select name="TitleOfCourtesy" id="">
                            <%while (rsTitleOfCourtesy.next()){%>
                            <option value="<%=rsTitleOfCourtesy.getString(1)%>"><%=rsTitleOfCourtesy.getString(1)%></option>
                            <%}%>
                        </select></td>
                </tr>
                <tr>
                    <td>BirthDate</td>
                    <td><input type="text" name="BirthDate" id="" value="<%=emp.getBirthDate()%>"></td>
                </tr>
                <tr>
                    <td>HireDate</td>
                    <td><input type="text" name="HireDate" id="" value="<%=emp.getHireDate()%>"></td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><input type="text" name="Address" id="" value="<%=emp.getAddress()%>"></td>
                </tr>
                <tr>
                    <td>City</td>
                    <td><input type="text" name="City" id="" value="<%=emp.getCity()%>"></td>
                </tr>
                <tr>
                    <td>Region</td>
                    <td><input type="text" name="Region" id="" value="<%=emp.getRegion()%>"></td>
                </tr>
                <tr>
                    <td>PostalCode</td>
                    <td><input type="text" name="PostalCode" id="" value="<%=emp.getPostalCode()%>"></td>
                </tr>
                <tr>
                    <td>Country</td>
                    <td><input type="text" name="Country" id="" value="<%=emp.getCountry()%>"></td>
                </tr>
                <tr>
                    <td>HomePhone</td>
                    <td><input type="text" name="HomePhone" id="" value="<%=emp.getHomePhone()%>"></td>
                </tr>
                <tr>
                    <td>Extension</td>
                    <td><input type="text" name="Extension" id="" value="<%=emp.getExtension()%>"></td>
                </tr>
                <tr>
                    <td>Photo</td>
                    <td><input type="text" name="Photo" id="" value="<%=emp.getPhoto()%>"></td>
                </tr>
                <tr>
                    <td>Notes</td>
                    <td><input type="text" name="Notes" id="" value="<%=emp.getNotes()%>"></td>
                </tr>
                <tr>
                    <td>ReportsTo</td>
                    <td><input type="text" name="ReportsTo" id="" value="<%=emp.getReportsTo()%>"></td>
                </tr>
                <tr>
                    <td>PhotoPath</td>
                    <td><input type="text" name="PhotoPath" id="" value="<%=emp.getPhotoPath()%>"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="update Employee" name="submit"></td>
                    <td><input type="reset" value="Reset"></td>

                </tr>
                <input type="hidden" name="service" value="update">
            </table>
    </body>
</html>

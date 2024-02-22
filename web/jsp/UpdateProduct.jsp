<%-- 
    Document   : UpdateProduct
    Created on : 20 Feb 2024, 10:23:47 am
    Author     : laivu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,entity.Products,java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Product</title>
    </head>
    <body>
         <%Vector<Products> vector
                    =(Vector<Products>)request.getAttribute("vector");
        Products pro=vector.get(0);
        ResultSet rsCate=(ResultSet)request.getAttribute("rsCate");
        ResultSet rsSup=(ResultSet)request.getAttribute("rsSup");
        %>
        <form action="ProductControllerURL" method="post">
            <table>
                <caption>update Product</caption>
                <tr>
                    <td>ProductID</td>
                    <td><input type="text" name="ProductID" id="" value="<%=pro.getProductID()%>" readonly></td>
                </tr>
                <tr>
                    <td>ProductName</td>
                    <td><input type="text" name="ProductName" id="" value="<%=pro.getProductName()%>"></td>
                </tr>
                <tr>
                    <td>SupplierID</td>
                    <td><select name="SupplierID" id="" >
                            <%while(rsSup.next()){%>
                          <option value="<%=rsSup.getInt(1)%>"><%=rsSup.getString(2)%></option>
                        <%}%>

                        </select></td>
                </tr>
                <tr>
                    <td>CategoryID</td>
                    <td><select name="CategoryID" id=""">
                            <%while(rsCate.next()){%>
                          <option value="<%=rsCate.getInt(1)%>"><%=rsCate.getString(2)%></option>
                        <%}%>
                        </select></td>
                </tr>
                <tr>
                    <td>QuantityPerUnit</td>
                    <td><input type="text" name="QuantityPerUnit" id="" value="<%=pro.getQuantityPerUnit()%>" ></td>
                </tr>
                <tr>
                    <td>UnitPrice</td>
                    <td><input type="text" name="UnitPrice" id="" value="<%=pro.getUnitPrice()%>"></td>
                </tr>
                <tr>
                    <td>UnitsInStock</td>
                    <td><input type="text" name="UnitsInStock" id="" value="<%=pro.getUnitsInStock()%>"></td>
                </tr>
                <tr>
                    <td>UnitsOnOrder</td>
                    <td><input type="text" name="UnitsOnOrder" id="" value="<%=pro.getUnitsOnOrder()%>"></td>
                </tr>
                <tr>
                    <td>ReorderLevel</td>
                    <td><input type="text" name="ReorderLevel" id="" value="<%=pro.getReorderLevel()%>"></td>
                </tr>
                <tr>
                    <td>Discontinued</td>
                    <td><input type="radio" value="1" name="Discontinued" id=""
                               <%=(pro.isDiscontinued()==true?"checked":"")%>>Continue
                        <input type="radio" value="0" name="Discontinued" id=""
                               <%=(pro.isDiscontinued()==false?"checked":"")%>>Discontinue
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="update Product" name="submit"></td>
                    <td><input type="reset" value="Reset"></td>

                </tr>
                <input type="hidden" name="service" value="update">
            </table>
        </form>
    </body>
</html>

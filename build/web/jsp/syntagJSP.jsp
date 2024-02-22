<%-- 
    Document   : syntagJSP
    Created on : 30 Jan 2024, 10:33:53 am
    Author     : laivu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--script-->
         <% //code java here
            int Max=300;//local
            out.print("<h3>Max= "+Max+"</h3>");
         %>
         
        <!--expression-->
         <p> max*3= <%=Max*3%>
         <% for(int i=10;i<=Max;i+=10) {%>
            <hr width="<%=i%>"/>
         <% }%>    
         
        <!--declare-->
        <%! int Min=100; //global%>
        <%! public int getValue() {return Min;}%>
        <p>Value: <%=getValue()%>
        <h1>Hello World!</h1>
    </body>
</html>

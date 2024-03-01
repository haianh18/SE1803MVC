/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAOOrders;
import entity.Orders;
import java.util.Vector;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
@WebServlet(name="OrdersController", urlPatterns={"/OrdersControllerURL"})
public class OrdersController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            DAOOrders dao = new DAOOrders();
            HttpSession session = request.getSession(true);
            String service = request.getParameter("service");
            if(service == null){
                service = "listAll";
            }
            if(service.equals("listAll")){
                Vector<Orders> vector = dao.getAll("select * from Orders");
                request.setAttribute("data", vector);
                request.setAttribute("titlePage", "OrdersManage");
                request.setAttribute("titleTable", "List of Orders");
                RequestDispatcher dispath = request.getRequestDispatcher("/jsp/OrdersManage.jsp");
                dispath.forward(request, response);
            }
            if(service.equals("update")){
                String submit = request.getParameter("submit");
                if(submit == null){
                    int id = Integer.parseInt(request.getParameter("id"));
                    Vector<Orders> vector = dao.getAll("select * from Orders where OrderID="+id);
                    request.setAttribute("vector", vector);
                    RequestDispatcher dispath = request.getRequestDispatcher("/jsp/UpdateOrders.jsp");
                    dispath.forward(request, response);
                }else{
                int OrderID = Integer.parseInt(request.getParameter("OrderID"));
                int EmployeeID = Integer.parseInt(request.getParameter("EmployeeID"));
                int ShipVia = Integer.parseInt(request.getParameter("ShipVia"));
                String CustomerID = request.getParameter("CustomerID");
                String OrderDate = request.getParameter("OrderDate");
                String RequiredDate = request.getParameter("RequiredDate");
                String ShippedDate = request.getParameter("ShippedDate");
                String ShipName = request.getParameter("ShipName");
                String ShipAddress = request.getParameter("ShipAddress");
                String ShipCity = request.getParameter("ShipCity");
                String ShipRegion = request.getParameter("ShipRegion");
                String ShipPostalCode = request.getParameter("ShipPostalCode");
                String ShipCountry = request.getParameter("ShipCountry");
                Double Freight = Double.parseDouble(request.getParameter("Freight"));
                Orders od = new Orders(OrderID, CustomerID, EmployeeID, OrderDate, RequiredDate, ShippedDate, ShipVia, Freight, ShipName, ShipAddress, ShipCity, ShipRegion, ShipPostalCode, ShipCountry);
                dao.updateOrders(od);
                response.sendRedirect("OrdersControllerURL?service=listAll");
                }
            }
            if(service.equals("delete")){
                int id = Integer.parseInt(request.getParameter("id"));
                dao.removeOrders(id);
                response.sendRedirect("OrdersControllerURL?service=listAll");
            }
//            try (PrintWriter out = response.getWriter()) {
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet OrdersController</title>");  
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet OrdersController at " + request.getContextPath () + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Vector;
import entity.OrderDetails;
import model.DAOOrderDetails;
import model.DAOOrders;
/**
 *
 * @author Administrator
 */
@WebServlet(name="OrderDetailsController", urlPatterns={"/OrderDetailsControllerURL"})
public class OrderDetailsController extends HttpServlet {
   
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
        DAOOrderDetails dao = new DAOOrderDetails();
            HttpSession session = request.getSession(true);
            String service = request.getParameter("service");
            if(service == null){
                service = "listAll";
            }
            if(service.equals("listAll")){
                Vector<OrderDetails> vector = dao.getAll("select * from [Order Details]");
                request.setAttribute("data", vector);
                request.setAttribute("titlePage", "OrderDetailsManage");
                request.setAttribute("titleTable", "Order Details");
                RequestDispatcher dispath = request.getRequestDispatcher("/jsp/OrderDetailsManage.jsp");
                dispath.forward(request, response);
            }
            if(service.equals("update")){
                String submit = request.getParameter("submit");
                if(submit == null){
                    int id = Integer.parseInt(request.getParameter("id"));
                    Vector<OrderDetails> vector = dao.getAll("select * from [Order Details] where OrderID="+id);
                    request.setAttribute("vector", vector);
                    RequestDispatcher dispath = request.getRequestDispatcher("/jsp/UpdateOrderDetails.jsp");
                    dispath.forward(request, response);
                }else{
                int OrderID = Integer.parseInt(request.getParameter("OrderID"));
                int ProductID = Integer.parseInt(request.getParameter("ProductID"));
                int Quantity = Integer.parseInt(request.getParameter("Quantity"));
                int Discount = Integer.parseInt(request.getParameter("Discount"));
                Double UnitPrice = Double.parseDouble(request.getParameter("UnitPrice"));
                OrderDetails ode = new OrderDetails(OrderID, ProductID, UnitPrice, Quantity, Discount);
                dao.updateOrderDetail(ode);
                response.sendRedirect("OrderDetailsControllerURL?service=listAll");
                }
            }
            if(service.equals("delete")){
                int id = Integer.parseInt(request.getParameter("id"));
                dao.removeOrderDetails(id);
                response.sendRedirect("OrderDetailsControllerURL?service=listAll");
            }
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet OrderDetailsController</title>");  
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet OrderDetailsController at " + request.getContextPath () + "</h1>");
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

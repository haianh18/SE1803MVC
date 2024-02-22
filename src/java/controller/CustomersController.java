/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Customers;
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
import model.DAOCustomers;

/**
 *
 * @author admin
 */
@WebServlet(name = "CustomersController", urlPatterns = {"/CustomersControllerURL"})
public class CustomersController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAOCustomers dao = new DAOCustomers();
        HttpSession session = request.getSession(true);
        String service = request.getParameter("service");
        if (service == null){
            service = "listAll";
        }
        if (service.equals("listAll")){
            Vector<Customers> vector = dao.getAll("select * from Customers");
            request.setAttribute("data", vector);
            request.setAttribute("titlePage", "CustomersManage");
            request.setAttribute("titleTable", "List of Customers");
            //select view (jsp)
            RequestDispatcher dispath
                    = request.getRequestDispatcher("/jsp/CustomersManage.jsp");
            //run
            dispath.forward(request, response);
        }
        if (service.equals("update")) {
            //check submit
            String submit = request.getParameter("submit");
            if (submit == null) { // show data
                //get id
                String id =(request.getParameter("id"));
                //get product with id
                Vector<Customers> vector
                        = dao.getAll("select * from Customers where CustomerID like '%" + id+"%'");
                request.setAttribute("vector", vector);
               
                RequestDispatcher dispath
                        = request.getRequestDispatcher("/jsp/UpdateCustomers.jsp");
                //run
                dispath.forward(request, response);
            }else{
                String CustomerID = request.getParameter("CustomerID");
                String CompanyName = request.getParameter("CompanyName");
                String ContactName = request.getParameter("ContactName");
                String ContactTitle = request.getParameter("ContactTitle");
                String Address = request.getParameter("Address");
                String City = request.getParameter("City");
                String Region = request.getParameter("Region");
                String PostalCode = request.getParameter("PostalCode");
                String Country = request.getParameter("Country");
                String Phone = request.getParameter("Phone");
                String Fax = request.getParameter("Fax");
                Customers cus = new Customers(CustomerID, CompanyName, 
                        ContactName, ContactTitle, Address, City, Region, 
                        PostalCode, Country, Phone, Fax);
                dao.updateCustomers(cus);
                response.sendRedirect("CustomersControllerURL?service=listAll");
            }
        }
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet CustomersController</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet CustomersController at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

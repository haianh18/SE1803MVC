/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Products;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Vector;
import model.DAOProducts;
import java.sql.ResultSet;

/**
 *
 * @author laivu
 */
@WebServlet(name = "ProductController", urlPatterns = {"/ProductControllerURL"})
public class ProductController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAOProducts dao = new DAOProducts();
        //DAOCategory
        HttpSession session = request.getSession(true);
        String service = request.getParameter("service");
        if (service == null) {
            service = "listAll";
        }
        if (service.equals("listAll")) {
            //call model
            Vector<Products> vector = dao.getAll("select * from Products");
           
//set data to view
            request.setAttribute("data", vector);
            request.setAttribute("titlePage", "ProductManage");
            request.setAttribute("titleTable", "List of Products");
            //select view (jsp)
            RequestDispatcher dispath
                    = request.getRequestDispatcher("/jsp/ProductManage.jsp");
            //run
            dispath.forward(request, response);

        }
        if (service.equals("update")) {
            //check update
            String submit = request.getParameter("submit");
            if (submit == null) {
                //show data
                  int id = Integer.parseInt(request.getParameter("id"));

                Vector<Products> vector
                        = dao.getAll("select * from Products where ProductID=" + id);
                request.setAttribute("vector", vector);
                ResultSet rsCate = dao.getData("select * from categories");
                ResultSet rsSup = dao.getData("select * from Suppliers");
                request.setAttribute("rsCate", rsCate);
                request.setAttribute("rsSup", rsSup);
                
                RequestDispatcher dispath
                        = request.getRequestDispatcher("/jsp/UpdateProduct.jsp");
                //run
                dispath.forward(request, response);

            }else{
                //update data
                int ProductID = Integer.parseInt(request.getParameter("ProductID"));
                String ProductName = request.getParameter("ProductName");
                int SupplierID = Integer.parseInt(request.getParameter("SupplierID"));
                int CategoryID = Integer.parseInt(request.getParameter("CategoryID"));
                String QuantityPerUnit = request.getParameter("QuantityPerUnit");
                double UnitPrice = Double.parseDouble(request.getParameter("UnitPrice"));
                int UnitsInStock = Integer.parseInt(request.getParameter("UnitsInStock"));
                int UnitsOnOrder = Integer.parseInt(request.getParameter("UnitsOnOrder"));
                int ReorderLevel = Integer.parseInt(request.getParameter("ReorderLevel"));
                boolean Discontinued
                        = (Integer.parseInt(request.getParameter("Discontinued")) == 1) ? true : false;

                Products pro = new Products(ProductID, ProductName, SupplierID,
                        CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock,
                        UnitsOnOrder, ReorderLevel, Discontinued);

                dao.updateProduct(pro);
                response.sendRedirect("ProductControllerURL");
                
            }
            //get id
            }
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ProductController</title>");  
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ProductController at " + request.getContextPath () + "</h1>");
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Products;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DAOProducts;

/**
 *
 * @author laivu
 */
@WebServlet(name = "Cart", urlPatterns = {"/CartURL"})
public class Cart extends HttpServlet {

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
        HttpSession session = request.getSession(true);
        String service = request.getParameter("service");
        DAOProducts dao = new DAOProducts();

        if (service.equals("add2cart")) {
            String id = request.getParameter("id"); //id: key
            Products pro = (Products) session.getAttribute(id);
            if (pro == null) {
                //first time
                //pro = new Products();
                pro = dao.getCart(Integer.parseInt(id));
                pro.setUnitsInStock(1); //UnitInStock = quantity in cart
                session.setAttribute(id, pro);
            } else {
                pro.setUnitsInStock(pro.getUnitsInStock() + 1);
                session.setAttribute(id, pro);
            }
            response.sendRedirect("ProductControllerURL");
        }

        if (service.equals("showcart")) {
            RequestDispatcher dispath
                    = request.getRequestDispatcher("/jsp/ShowCart.jsp");
            //run
            dispath.forward(request, response);
        }

        if (service.equals("Update")) {
            String[] id = request.getParameterValues("ProductID");
            for (int i = 0; i < id.length; i++) {
                Products pro = dao.getCart(Integer.parseInt(id[i]));
                pro.setUnitsInStock(Integer.parseInt(request.getParameterValues("UnitsInStock")[i]));
                session.setAttribute(id[i], pro);
            }
            RequestDispatcher dispath
                    = request.getRequestDispatcher("/jsp/ShowCart.jsp");
            //run
            dispath.forward(request, response);
        }
        if(service.equals("remove")){
            String id = request.getParameter("ProductID");
            session.removeAttribute(id);
            RequestDispatcher dispath
                    = request.getRequestDispatcher("/jsp/ShowCart.jsp");
            //run
            dispath.forward(request, response);
        }
        if(service.equals("Remove All")){
            String[] id = request.getParameterValues("ProductID");
            for (int i = 0; i < id.length; i++) {
                session.removeAttribute(id[i]);
            }
            RequestDispatcher dispath
                    = request.getRequestDispatcher("/jsp/ShowCart.jsp");
            //run
            dispath.forward(request, response);
        }
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

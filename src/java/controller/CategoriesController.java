/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Categories;
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
import model.DAOCategories;

/**
 *
 * @author admin
 */
@WebServlet(name = "CategoriesController", urlPatterns = {"/CategoriesControllerURL"})
public class CategoriesController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAOCategories dao = new DAOCategories();
        HttpSession session = request.getSession(true);
        String service = request.getParameter("service");
        if (service == null){
            service = "listAll";
        }
        if (service.equals("listAll")){
            Vector<Categories> vector = dao.getAll("select * from Categories");
            request.setAttribute("data", vector);
            request.setAttribute("titlePage", "CategoriesManage");
            request.setAttribute("titleTable", "List of Categories");
            //select view (jsp)
            RequestDispatcher dispath
                    = request.getRequestDispatcher("/jsp/CategoriesManage.jsp");
            //run
            dispath.forward(request, response);
        }
        if (service.equals("update")) {
            //check submit
            String submit = request.getParameter("submit");
            if (submit == null) { // show data
                //get id
                int id = Integer.parseInt(request.getParameter("id"));
                //get product with id
                Vector<Categories> vector
                        = dao.getAll("select * from Categories where CategoryID=" + id);
                request.setAttribute("vector", vector);
               
                RequestDispatcher dispath
                        = request.getRequestDispatcher("/jsp/UpdateCategories.jsp");
                //run
                dispath.forward(request, response);
            }else{
                int CategoryID = Integer.parseInt(request.getParameter("CategoryID"));
                String CategoryName = request.getParameter("CategoryName");
                String Description = request.getParameter("Description");
                String Picture = request.getParameter("Picture");
                Categories cat = new Categories(CategoryID, CategoryName, Description, Picture);
                dao.updateCategories(cat);
                response.sendRedirect("CategoriesControllerURL?service=listAll");
            }
        }
        
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet CategoriesController</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet CategoriesController at " + request.getContextPath() + "</h1>");
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


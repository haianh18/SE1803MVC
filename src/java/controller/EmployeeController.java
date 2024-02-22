/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Employees;
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
import model.DAOEmployees;
import java.sql.ResultSet;

/**
 *
 * @author HaiAnh
 */
@WebServlet(name = "EmployeeController", urlPatterns = {"/EmployeeControllerURL"})
public class EmployeeController extends HttpServlet {

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
        DAOEmployees dao = new DAOEmployees();
        HttpSession session = request.getSession(true);
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");
            if (service == null) {
                service = "listAll";
            }
            if (service.equals("update")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    Vector<Employees> vector
                            = dao.getAll("select * from Employees where EmployeeID =" + id);
                    request.setAttribute("vector", vector);
                    ResultSet rsTitle = dao.getData("select distinct Title from Employees");
                    ResultSet rsTitleOfCourtesy = dao.getData("select distinct TitleOfCourtesy from Employees");
                    request.setAttribute("rsTitle", rsTitle);
                    request.setAttribute("rsTitleOfCourtesy", rsTitleOfCourtesy);
                    RequestDispatcher dispatch
                            = request.getRequestDispatcher("/jsp/UpdateEmployee.jsp");
                    dispatch.forward(request, response);
                } else {
                    int EmployeeID = Integer.parseInt(request.getParameter("EmployeeID"));
                    String LastName = request.getParameter("LastName");
                    String FirstName = request.getParameter("FirstName");
                    String Title = request.getParameter("Title");
                    String TitleOfCourtesy = request.getParameter("TitleOfCourtesy");
                    String BirthDate = request.getParameter("BirthDate");
                    String HireDate = request.getParameter("HireDate");
                    String Address = request.getParameter("Address");
                    String City = request.getParameter("City");
                    String Region = request.getParameter("Region");
                    String PostalCode = request.getParameter("PostalCode");
                    String Country = request.getParameter("Country");
                    String HomePhone = request.getParameter("HomePhone");
                    String Extension = request.getParameter("Extension");
                    String Photo = request.getParameter("Photo");
                    String Notes = request.getParameter("Notes");
                    int ReportsTo = Integer.parseInt(request.getParameter("ReportsTo"));
                    String PhotoPath = request.getParameter("PhotoPath");
                    Employees emp = new Employees(EmployeeID, LastName, FirstName,
                            Title, TitleOfCourtesy, BirthDate,
                            HireDate, Address, City, Region,
                            PostalCode, Country, HomePhone,
                            Extension, Photo, Notes,
                            ReportsTo, PhotoPath);
                    dao.updateEmployees(emp);
                    response.sendRedirect("EmployeeControllerURL");
                }
            }
            if (service.equals("listAll")) {
                Vector<Employees> vector = dao.getAll("select * from Employees");
                request.setAttribute("data", vector);
                request.setAttribute("titlePage", "EmployeeManage");
                request.setAttribute("titleTable", "List of Employee");
                //select view (jsp)
                RequestDispatcher dispath
                        = request.getRequestDispatcher("/jsp/EmployeeManage.jsp");
                //run
                dispath.forward(request, response);
            }
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

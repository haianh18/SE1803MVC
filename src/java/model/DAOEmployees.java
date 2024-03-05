/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Employees;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author HaiAnh
 */
public class DAOEmployees extends DBConnect {
    
    public int insertEmployees(Employees emp) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Employees]\n"
                + "           ([LastName]\n"
                + "           ,[FirstName]\n"
                + "           ,[Title]\n"
                + "           ,[TitleOfCourtesy]\n"
                + "           ,[BirthDate]\n"
                + "           ,[HireDate]\n"
                + "           ,[Address]\n"
                + "           ,[City]\n"
                + "           ,[Region]\n"
                + "           ,[PostalCode]\n"
                + "           ,[Country]\n"
                + "           ,[HomePhone]\n"
                + "           ,[Extension]\n"
                + "           ,[Photo]\n"
                + "           ,[Notes]\n"
                + "           ,[ReportsTo]\n"
                + "           ,[PhotoPath])\n"
                + "     VALUES\n"
                + "           ('" + emp.getLastName() + "'\n"
                + "           ,'" + emp.getFirstName() + "'\n"
                + "           ,'" + emp.getTitle() + "'\n"
                + "           ,'" + emp.getTitleOfCourtesy() + "'\n"
                + "           ,'" + emp.getBirthDate() + "'\n"
                + "           ,'" + emp.getHireDate() + "'\n"
                + "           ,'" + emp.getAddress() + "'\n"
                + "           ,'" + emp.getCity() + "'\n"
                + "           ,'" + emp.getRegion() + "'\n"
                + "           ,'" + emp.getPostalCode() + "'\n"
                + "           ,'" + emp.getCountry() + "'\n"
                + "           ,'" + emp.getHomePhone() + "'\n"
                + "           ,'" + emp.getExtension() + "'\n"
                + "           ,'" + emp.getPhoto() + "'\n"
                + "           ,'" + emp.getNotes() + "'\n"
                + "           ,'" + emp.getReportsTo() + "'\n"
                + "           ,'" + emp.getPhotoPath() + "')";
        
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return n;
    }
    
    public int addEmployees(Employees emp) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Employees]\n"
                + "           ([LastName]\n"
                + "           ,[FirstName]\n"
                + "           ,[Title]\n"
                + "           ,[TitleOfCourtesy]\n"
                + "           ,[BirthDate]\n"
                + "           ,[HireDate]\n"
                + "           ,[Address]\n"
                + "           ,[City]\n"
                + "           ,[Region]\n"
                + "           ,[PostalCode]\n"
                + "           ,[Country]\n"
                + "           ,[HomePhone]\n"
                + "           ,[Extension]\n"
                + "           ,[Photo]\n"
                + "           ,[Notes]\n"
                + "           ,[ReportsTo]\n"
                + "           ,[PhotoPath])\n"
                + "     VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, emp.getLastName());
            pre.setString(2, emp.getFirstName());
            pre.setString(3, emp.getTitle());
            pre.setString(4, emp.getTitleOfCourtesy());
            pre.setString(5, emp.getBirthDate());
            pre.setString(6, emp.getHireDate());
            pre.setString(7, emp.getAddress());
            pre.setString(8, emp.getCity());
            pre.setString(9, emp.getRegion());
            pre.setString(10, emp.getPostalCode());
            pre.setString(11, emp.getCountry());
            pre.setString(12, emp.getHomePhone());
            pre.setString(13, emp.getExtension());
            pre.setNull(14, 1, emp.getPhoto());
            pre.setString(15, emp.getNotes());
            //pre.setObject(16, null, 1);
            pre.setInt(16, emp.getReportsTo());
            pre.setString(17, emp.getPhotoPath());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    
    public int updateEmployees(Employees emp) {
        int n = 0;
        String sql = "UPDATE [dbo].[Employees]\n"
                + "   SET [LastName] = ?\n"
                + "      ,[FirstName] = ?\n"
                + "      ,[Title] = ?\n"
                + "      ,[TitleOfCourtesy] = ?\n"
                + "      ,[BirthDate] = ?\n"
                + "      ,[HireDate] = ?\n"
                + "      ,[Address] = ?\n"
                + "      ,[City] = ?\n"
                + "      ,[Region] = ?\n"
                + "      ,[PostalCode] = ?\n"
                + "      ,[Country] = ?\n"
                + "      ,[HomePhone] = ?\n"
                + "      ,[Extension] = ?\n"
                + "      ,[Photo] = ?\n"
                + "      ,[Notes] = ?\n"
                + "      ,[ReportsTo] = ?\n"
                + "      ,[PhotoPath] = ?\n"
                + " WHERE EmployeeID=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, emp.getLastName());
            pre.setString(2, emp.getFirstName());
            pre.setString(3, emp.getTitle());
            pre.setString(4, emp.getTitleOfCourtesy());
            pre.setString(5, emp.getBirthDate());
            pre.setString(6, emp.getHireDate());
            pre.setString(7, emp.getAddress());
            pre.setString(8, emp.getCity());
            pre.setString(9, emp.getRegion());
            pre.setString(10, emp.getPostalCode());
            pre.setString(11, emp.getCountry());
            pre.setString(12, emp.getHomePhone());
            pre.setString(13, emp.getExtension());
            pre.setNull(14, 1, emp.getPhoto());
            pre.setString(15, emp.getNotes());
            //pre.setObject(16, null, 1);
            pre.setInt(16, emp.getReportsTo());
            pre.setString(17, emp.getPhotoPath());
            pre.setInt(18, emp.getEmployeeID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return n;
    }
    
    public int removeEmployee(int id) {
        int n = 0;
        String sql = "Delete from Employees where EmployeeID = " + id
                + " AND (" + id + " not in (select distinct EmployeeID from "
                + "[EmployeeTerritories])) AND (" + id + " not in (select distinct"
                + " EmployeeID from [Orders]))";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    
    public Vector<Employees> getAll(String sql) {
        Vector<Employees> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int eid = rs.getInt(1);
                String lname = rs.getString(2);
                String fname = rs.getString(3);
                String title = rs.getString(4);
                String courtesy = rs.getString(5);
                String bdate = rs.getString(6);
                String hdate = rs.getString(7);
                String address = rs.getString(8);
                String city = rs.getString(9);
                String region = rs.getString(10);
                String postal = rs.getString(11);
                String country = rs.getString(12);
                String phone = rs.getString(13);
                String extension = rs.getString(14);
                String photo = rs.getString(15);
                String note = rs.getString(16);
                String photopath = rs.getString(18);
                int reportto = rs.getInt(17);
                Employees emp = new Employees(eid, lname,
                        fname, title, courtesy,
                        bdate, hdate, address, city,
                        region, postal, country,
                        phone, extension, photo, note,
                        reportto, photopath);
                vector.add(emp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }
    
    public Vector<Employees> searchEmployee(String name) {
        Vector<Employees> vector = new Vector<>();
        String sql = "select * from Employees "
                + "where FirstName like '" + name + "%'";
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int eid = rs.getInt(1);
                String lname = rs.getString(2);
                String fname = rs.getString(3);
                String title = rs.getString(4);
                String courtesy = rs.getString(5);
                String bdate = rs.getString(6);
                String hdate = rs.getString(7);
                String address = rs.getString(8);
                String city = rs.getString(9);
                String region = rs.getString(10);
                String postal = rs.getString(11);
                String country = rs.getString(12);
                String phone = rs.getString(13);
                String extension = rs.getString(14);
                String photo = rs.getString(15);
                String note = rs.getString(16);
                String photopath = rs.getString(18);
                int reportto = rs.getInt(17);
                Employees emp = new Employees(eid, lname,
                        fname, title, courtesy,
                        bdate, hdate, address, city,
                        region, postal, country,
                        phone, extension, photo, note,
                        reportto, photopath);
                vector.add(emp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }
    
    public boolean checkLogin(String username, String pass){
        String sql = "select * from Employees where "
                + "FirstName = ? And HomePhone = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2,pass);
            ResultSet re = pre.executeQuery();
            if(re.next()){
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public static void main(String[] args) {
        DAOEmployees dao = new DAOEmployees();

//        int n = dao.addEmployees(
//                new Employees(11, "LDemo-1", "FDemo-1",
//                        "TDem", "CDemo-2",
//                        "1948-12-08 00:00:00.000",
//                        "1992-05-01 00:00:00.000",
//                        "ADemo", "CityDemo",
//                        "ReDemo", "PDemo", "CouDemo",
//                        "HP-Demo", "Demo", null,
//                        "NDemo",10, "Pa-Demo")
//        );
//        if (n > 0) {
//            System.out.println("INSERTED!!!");
//        }
//          int n=dao.removeEmployee(15);
//          if(n>0)System.out.println("DELETED!!!");
//        Vector<Employees> vector = dao.getAll("select * from Employees "
//                + "where LastName like 'S%'");
//        for(Employees emp : vector){
//            System.out.println(emp);
//        }
        Vector<Employees> vector = dao.searchEmployee("L");
        for (Employees emp : vector) {
            System.out.println(emp);
        }
        
    }
}

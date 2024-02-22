/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.EmployeeTerritories;
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
public class DAOEmployeeTerritories extends DBConnect {

    public int insertEmployeeTerritories(EmployeeTerritories empTer) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[EmployeeTerritories]\n"
                + "           ([EmployeeID]\n"
                + "           ,[TerritoryID])\n"
                + "     VALUES\n"
                + "           ('" + empTer.getEmployeeID() + "'\n"
                + "           ,'" + empTer.getTerritoryID() + "')";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;
    }

    public int addEmployeeTerritories(EmployeeTerritories emp) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[EmployeeTerritories]\n"
                + "           ([EmployeeID]\n"
                + "           ,[TerritoryID])\n"
                + "     VALUES(?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, emp.getEmployeeID());
            pre.setString(2, emp.getTerritoryID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;
    }

    public int updateEmployeeTerritories(EmployeeTerritories emp) {
        int n = 0;
        String sql = "UPDATE [dbo].[EmployeeTerritories]\n"
                + "   SET [EmployeeID] = ?\n"
                + "      ,[TerritoryID] = ?\n"
                + " WHERE EmployeeID=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, emp.getEmployeeID());
            pre.setString(2, emp.getTerritoryID());
            pre.setInt(3, emp.getEmployeeID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    
    public int removeEmployeeTerritory(int id){
        int n=0;
        String sql = "Delete from EmployeeTerritories where EmployeeID = " + id;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    
    public Vector<EmployeeTerritories> getAll(String sql){
        Vector<EmployeeTerritories> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()){
                int eid = rs.getInt(1);
                String tid = rs.getString(2);
                EmployeeTerritories emp = new EmployeeTerritories(eid, 
                        tid);
                vector.add(emp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }
    
    public Vector<EmployeeTerritories> searchEmployeeTerritory(int id){
        Vector<EmployeeTerritories> vector = new Vector<>();
        String sql="select * from "
                  + "EmployeeTerritories where EmployeeID = "+id;
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()){
                int eid = rs.getInt(1);
                String tid = rs.getString(2);
                EmployeeTerritories emp = new EmployeeTerritories(eid, 
                        tid);
                vector.add(emp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }
    
    public static void main(String[] args) {
        DAOEmployeeTerritories dao = new DAOEmployeeTerritories();
//        int n = dao.updateEmployeeTerritories(
//                new EmployeeTerritories(15, "1")
//        );
//        if (n > 0) {
//            System.out.println("UPDATED!!!");
//        }
        
//        int n = dao.removeEmployeeTerritory(15);
//        if (n > 0) {
//            System.out.println("Deleted!!!");
//        }

//          Vector<EmployeeTerritories> vector = dao.getAll("select * from "
//                  + "EmployeeTerritories where EmployeeID = 8");
//          for(EmployeeTerritories emp : vector){
//              System.out.println(emp);
//          }
          
            Vector<EmployeeTerritories> vector = dao.searchEmployeeTerritory(16);
            for(EmployeeTerritories emp: vector){
                System.out.println(emp);
            }
          
    }
}

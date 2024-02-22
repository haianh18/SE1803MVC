/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.CustomerDemographics;
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
public class DAOCustomerDemographics extends DBConnect {

    public int insertCustomerDemographics(CustomerDemographics cusdemographics) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[CustomerDemographics]\n"
                + "           ([CustomerTypeID]\n"
                + "           ,[CustomerDesc])\n"
                + "     VALUES\n"
                + "           ('" + cusdemographics.getCustomerTypeID() + "'\n"
                + "           ,'" + cusdemographics.getCustomerDesc() + "')";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int addCustomerDemographics(CustomerDemographics cusdemoDemographics) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[CustomerDemographics]\n"
                + "           ([CustomerTypeID]\n"
                + "           ,[CustomerDesc])\n"
                + "     VALUES(?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, cusdemoDemographics.getCustomerTypeID());
            pre.setString(2, cusdemoDemographics.getCustomerDesc());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int updateCustomerDemographics(CustomerDemographics cus) {
        int n = 0;
        String sql = "UPDATE [dbo].[CustomerDemographics]\n"
                + "   SET [CustomerTypeID] = ?\n"
                + "      ,[CustomerDesc] = ?\n"
                + " WHERE CustomerTypeID=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, cus.getCustomerTypeID());
            pre.setString(2, cus.getCustomerDesc());
            pre.setString(3, cus.getCustomerTypeID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return n;
    }
    
    public int removeCustomerCustomerDemo(int id) {
        int n = 0;
        String sql = "Delete from CustomerDemographics where CustomerTypeid = " + id
                + " AND (" + id + " not in (select  distinct CustomerTypeid from [CustomerCustomerDemo]))";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    public Vector<CustomerDemographics > searchName(String name) {
        Vector<CustomerDemographics> vector = new Vector<CustomerDemographics>();
        String sql = "select * from CustomerDemographics where Description like '%" + name + "%'";
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                String ctid = rs.getString(1);
                String des = rs.getString(2);
                CustomerDemographics cusdemographics = new CustomerDemographics(ctid, des);
                vector.add(cusdemographics);
            }
        }catch (SQLException ex) {
                ex.printStackTrace();
                }
        return vector;
    }
    
    public Vector<CustomerDemographics > getAll(String sql) {
        Vector<CustomerDemographics> vector = new Vector<CustomerDemographics>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                String ctid = rs.getString(1);
                String des = rs.getString(2);
                CustomerDemographics cusdemographics = new CustomerDemographics(ctid, des);
                vector.add(cusdemographics);
            }
        }catch (SQLException ex) {
                ex.printStackTrace();
                }
        return vector;
    }
    


    public static void main(String[] args) {
        DAOCustomerDemographics dao = new DAOCustomerDemographics();
        int n = dao.updateCustomerDemographics(
                new CustomerDemographics("DEMO-2", "DEMO-3")
        );
        if (n > 0) {
            System.out.println("UPDATED!");
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.CustomerCustomerDemo;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
/**
 *
 * @author HaiAnh
 */
public class DAOCustomerCustomerDemo extends DBConnect {

    public int insertCustomerCustomerDemo(CustomerCustomerDemo cusdemo) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[CustomerCustomerDemo]\n"
                + "           ([CustomerID]\n"
                + "           ,[CustomerTypeID])\n"
                + "     VALUES\n"
                + "           ('" + cusdemo.getCustomerID() + "'\n"
                + "           ,'" + cusdemo.getCustomerTypeID() + "')";

        Statement state;
        try {
            state = conn.createStatement();
            n = state.executeUpdate(sql);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;
    }

    public int addCustomerCustomerDemo(CustomerCustomerDemo cus) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[CustomerCustomerDemo]\n"
                + "           ([CustomerID]\n"
                + "           ,[CustomerTypeID])\n"
                + "     VALUES(?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, cus.getCustomerID());
            pre.setString(2, cus.getCustomerTypeID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;
    }

    public int updateCustomerCustomerDemo(CustomerCustomerDemo cus) {
        int n = 0;
        String sql = "UPDATE [dbo].[CustomerCustomerDemo]\n"
                + "   SET [CustomerID] = ?\n"
                + "      ,[CustomerTypeID] = ?\n"
                + " WHERE CustomerID=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, cus.getCustomerID());
            pre.setString(2, cus.getCustomerTypeID());
            pre.setString(3,cus.getCustomerID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    
    public int removeCustomerCustomerDemo(int id) {
        int n = 0;
        String sql = "Delete from CustomerCustomerDemo where CustomerID = " + id;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public Vector<CustomerCustomerDemo> searchName(String id) {
        Vector<CustomerCustomerDemo> vector = new Vector<CustomerCustomerDemo>();
        String sql = "select * from CustomerCustomerDemo where CustomerID like '%" + id + "%'";
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                String cid = rs.getString(1);
                String ctID = rs.getString(2);
                CustomerCustomerDemo cusDemo = new CustomerCustomerDemo(ctID, ctID);
                vector.add(cusDemo);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public Vector<CustomerCustomerDemo> getAll(String sql) {
        Vector<CustomerCustomerDemo> vector = new Vector<CustomerCustomerDemo>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                String cid = rs.getString(1);
                String ctID = rs.getString(2);
                CustomerCustomerDemo cusDemo = new CustomerCustomerDemo(ctID, ctID);
                vector.add(cusDemo);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public static void main(String[] args) {
        DAOCustomerCustomerDemo dao = new DAOCustomerCustomerDemo();
        int n = dao.updateCustomerCustomerDemo(
                new CustomerCustomerDemo("2", "DEMO-1")
        );
        if (n > 0) {
            System.out.println("UPDATED!!!");
        }
    }
}

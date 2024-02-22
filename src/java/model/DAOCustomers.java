/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Customers;
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
public class DAOCustomers extends DBConnect {

    public int insertCustomers(Customers cus) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Customers]\n"
                + "           ([CustomerID]\n"
                + "           ,[CompanyName]\n"
                + "           ,[ContactName]\n"
                + "           ,[ContactTitle]\n"
                + "           ,[Address]\n"
                + "           ,[City]\n"
                + "           ,[Region]\n"
                + "           ,[PostalCode]\n"
                + "           ,[Country]\n"
                + "           ,[Phone]\n"
                + "           ,[Fax])\n"
                + "     VALUES\n"
                + "           (" + cus.getCustomerID() + "\n"
                + "           ,'" + cus.getCompanyName() + "'\n"
                + "           ,'" + cus.getContactName() + "'\n"
                + "           ,'" + cus.getContactTitle() + "'\n"
                + "           ,'" + cus.getAddress() + "'\n"
                + "           ,'" + cus.getCity() + "'\n"
                + "           ,'" + cus.getRegion() + "'\n"
                + "           ,'" + cus.getPostalCode() + "'\n"
                + "           ,'" + cus.getCountry() + "'\n"
                + "           ,'" + cus.getPhone() + "'\n"
                + "           ," + cus.getFax() + ")";

        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {

            ex.printStackTrace();
        }

        return n;
    }

    public int addCustomers(Customers cus) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Customers]\n"
                + "           ([CustomerID]\n"
                + "           ,[CompanyName]\n"
                + "           ,[ContactName]\n"
                + "           ,[ContactTitle]\n"
                + "           ,[Address]\n"
                + "           ,[City]\n"
                + "           ,[Region]\n"
                + "           ,[PostalCode]\n"
                + "           ,[Country]\n"
                + "           ,[Phone]\n"
                + "           ,[Fax])\n"
                + "     VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, cus.getCustomerID());
            pre.setString(2, cus.getCompanyName());
            pre.setString(3, cus.getContactName());
            pre.setString(4, cus.getContactTitle());
            pre.setString(5, cus.getAddress());
            pre.setString(6, cus.getCity());
            pre.setString(7, cus.getRegion());
            pre.setString(8, cus.getPostalCode());
            pre.setString(9, cus.getCountry());
            pre.setString(10, cus.getPhone());
            pre.setString(11, cus.getFax());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;
    }

    public int updateCustomers(Customers cus) {
        int n = 0;
        String sql = "UPDATE [dbo].[Customers]\n"
                + "   SET [CustomerID] = ?\n"
                + "      ,[CompanyName] = ?\n"
                + "      ,[ContactName] = ?\n"
                + "      ,[ContactTitle] = ?\n"
                + "      ,[Address] = ?\n"
                + "      ,[City] = ?\n"
                + "      ,[Region] = ?\n"
                + "      ,[PostalCode] = ?\n"
                + "      ,[Country] = ?\n"
                + "      ,[Phone] = ?\n"
                + "      ,[Fax] = ?\n"
                + " WHERE CustomerID=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, cus.getCustomerID());
            pre.setString(2, cus.getCompanyName());
            pre.setString(3, cus.getContactName());
            pre.setString(4, cus.getContactTitle());
            pre.setString(5, cus.getAddress());
            pre.setString(6, cus.getCity());
            pre.setString(7, cus.getRegion());
            pre.setString(8, cus.getPostalCode());
            pre.setString(9, cus.getCountry());
            pre.setString(10, cus.getPhone());
            pre.setString(11, cus.getFax());
            pre.setString(12, cus.getCustomerID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    
   public int removeCustomers(String id) {
        int n = 0;
        String sql = "Delete from Customers where CustomerID = '"+ id +"' AND ('"+ id +"' not in (select distinct CustomerID from [Orders]))";

        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public Vector<Customers> searchCity(String cityName) {
        Vector<Customers> vector = new Vector<Customers>();
        String sql = "select * from Customers where City like '%" + cityName + "%'";
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()){
                String cid = rs.getString(1);
                String cname = rs.getString(2);
                String contact = rs.getString(3);
                String contacttitle = rs.getString(4);
                String add = rs.getString(5);
                String city = rs.getString(6);
                String reg = rs.getString(7);
                String pstcode = rs.getString(8);
                String ctry = rs.getString(9);
                String phone = rs.getString(10);
                String fax = rs.getString(11);
                Customers cus = new Customers(cid, cname,
                        contact, contacttitle,
                        add, city, reg,
                        pstcode, ctry,
                        phone, fax);
                vector.add(cus);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }
    public Vector<Customers> getAll(String sql){
        Vector<Customers> vector = new Vector<Customers>();
        
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()){
                String cid = rs.getString(1);
                String cname = rs.getString(2);
                String contact = rs.getString(3);
                String contacttitle = rs.getString(4);
                String add = rs.getString(5);
                String city = rs.getString(6);
                String reg = rs.getString(7);
                String pstcode = rs.getString(8);
                String ctry = rs.getString(9);
                String phone = rs.getString(10);
                String fax = rs.getString(11);
                Customers cus = new Customers(cid, cname,
                        contact, contacttitle,
                        add, city, reg,
                        pstcode, ctry,
                        phone, fax);
                vector.add(cus);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }


    public static void main(String[] args) {
        DAOCustomers dao = new DAOCustomers();
        int n = dao.updateCustomers(
                new Customers("2", "CusDEMO-5", "CusName",
                        "1", "1", "1", "1", "1",
                        "1", "1", "1")
        );
        if (n > 0) {
            System.out.println("Updated!!!");
        }
    }

}

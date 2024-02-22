/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Suppliers;
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
public class DAOSuppliers extends DBConnect {

    public int insertSuppliers(Suppliers supplier) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Suppliers]\n"
                + "           ([CompanyName]\n"
                + "           ,[ContactName]\n"
                + "           ,[ContactTitle]\n"
                + "           ,[Address]\n"
                + "           ,[City]\n"
                + "           ,[Region]\n"
                + "           ,[PostalCode]\n"
                + "           ,[Country]\n"
                + "           ,[Phone]\n"
                + "           ,[Fax]\n"
                + "           ,[HomePage])\n"
                + "     VALUES\n"
                + "           ('" + supplier.getCompanyName() + "'\n"
                + "           ,'" + supplier.getContactName() + "'\n"
                + "           ,'" + supplier.getContactTitle() + "'\n"
                + "           ,'" + supplier.getAddress() + "'\n"
                + "           ,'" + supplier.getCity() + "'\n"
                + "           ,'" + supplier.getRegion() + "'\n"
                + "           ,'" + supplier.getPostalCode() + "'\n"
                + "           ,'" + supplier.getCountry() + "'\n"
                + "           ,'" + supplier.getPhone() + "'\n"
                + "           ,'" + supplier.getFax() + "'\n"
                + "           ,'" + supplier.getHomePage() + "')";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;
    }

    public int addSuppliers(Suppliers sup) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Suppliers]\n"
                + "           ([CompanyName]\n"
                + "           ,[ContactName]\n"
                + "           ,[ContactTitle]\n"
                + "           ,[Address]\n"
                + "           ,[City]\n"
                + "           ,[Region]\n"
                + "           ,[PostalCode]\n"
                + "           ,[Country]\n"
                + "           ,[Phone]\n"
                + "           ,[Fax]\n"
                + "           ,[HomePage])\n"
                + "     VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, sup.getCompanyName());
            pre.setString(2, sup.getContactName());
            pre.setString(3, sup.getContactTitle());
            pre.setString(4, sup.getAddress());
            pre.setString(5, sup.getCity());
            pre.setString(6, sup.getRegion());
            pre.setString(7, sup.getPostalCode());
            pre.setString(8, sup.getCountry());
            pre.setString(9, sup.getPhone());
            pre.setString(10, sup.getFax());
            pre.setString(11, sup.getHomePage());
            n = pre.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;
    }

    public int updateSuppliers(Suppliers sup) {
        int n = 0;
        String sql = "UPDATE [dbo].[Suppliers]\n"
                + "   SET [CompanyName] = ?\n"
                + "      ,[ContactName] = ?\n"
                + "      ,[ContactTitle] = ?\n"
                + "      ,[Address] = ?\n"
                + "      ,[City] = ?\n"
                + "      ,[Region] = ?\n"
                + "      ,[PostalCode] = ?\n"
                + "      ,[Country] = ?\n"
                + "      ,[Phone] = ?\n"
                + "      ,[Fax] = ?\n"
                + "      ,[HomePage] = ?\n"
                + " WHERE SupplierID=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, sup.getCompanyName());
            pre.setString(2, sup.getContactName());
            pre.setString(3, sup.getContactTitle());
            pre.setString(4, sup.getAddress());
            pre.setString(5, sup.getCity());
            pre.setString(6, sup.getRegion());
            pre.setString(7, sup.getPostalCode());
            pre.setString(8, sup.getCountry());
            pre.setString(9, sup.getPhone());
            pre.setString(10, sup.getFax());
            pre.setString(11, sup.getHomePage());
            pre.setInt(12, sup.getSupplierID());
            n = pre.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int removeSupplier(int id) {
        int n = 0;
        String sql = "Delete from Suppliers where SupplierID = " + id;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public Vector<Suppliers> getAll(String sql) {
        Vector<Suppliers> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int sid = rs.getInt(1);
                String companyname = rs.getString(2);
                String contactname = rs.getString(3);
                String contacttitle = rs.getString(4);
                String address = rs.getString(5);
                String city = rs.getString(6);
                String region = rs.getString(7);
                String postal = rs.getString(8);
                String country = rs.getString(9);
                String phone = rs.getString(10);
                String fax = rs.getString(11);
                String home = rs.getString(12);
                Suppliers sup = new Suppliers(sid,
                        companyname, contactname,
                        contacttitle, address, city,
                        region, postal, country,
                        phone, fax, home);
                vector.add(sup);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }
    
    public Vector<Suppliers> searchSupplier(String name){
        Vector<Suppliers> vector = new Vector<Suppliers>();
        String sql="select * from Suppliers"
                + " where companyName like '%"+name+"%'";
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int sid = rs.getInt(1);
                String companyname = rs.getString(2);
                String contactname = rs.getString(3);
                String contacttitle = rs.getString(4);
                String address = rs.getString(5);
                String city = rs.getString(6);
                String region = rs.getString(7);
                String postal = rs.getString(8);
                String country = rs.getString(9);
                String phone = rs.getString(10);
                String fax = rs.getString(11);
                String home = rs.getString(12);
                Suppliers sup = new Suppliers(sid,
                        companyname, contactname,
                        contacttitle, address, city,
                        region, postal, country,
                        phone, fax, home);
                vector.add(sup);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }
    
    public static void main(String[] args) {
        DAOSuppliers dao = new DAOSuppliers();
//        int n = dao.updateSuppliers(
//                new Suppliers(31, "DEMO-2", "DEMO-3",
//                        "DEMO-2", "DEMO-2", "DEMO-2",
//                        "DEMO-2", "DEMO-2", "DEMO-2",
//                        "DEMO-2", "DEMO-2", "DEMO-2")
//        );
//        int n = dao.removeSupplier(32);
//        if (n > 0) {
//            System.out.println("DELETED!!!");
//        }

//        Vector<Suppliers> vector = dao.getAll("select * from Suppliers"
//                + " where SupplierID = 33");
//        for (Suppliers sup : vector) {
//            System.out.println(sup);
//        }

          Vector<Suppliers> vector = dao.searchSupplier("Ex");
          for(Suppliers sup : vector){
              System.out.println(sup);
          }

    }
}

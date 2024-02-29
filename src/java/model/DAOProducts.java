/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Products;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author laivu
 */
public class DAOProducts extends DBConnect {

    public int insertProduct(Products pro) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Products]\n"
                + "           ([ProductName]\n"
                + "           ,[SupplierID]\n"
                + "           ,[CategoryID]\n"
                + "           ,[QuantityPerUnit]\n"
                + "           ,[UnitPrice]\n"
                + "           ,[UnitsInStock]\n"
                + "           ,[UnitsOnOrder]\n"
                + "           ,[ReorderLevel]\n"
                + "           ,[Discontinued])\n"
                + "     VALUES('" + pro.getProductName() + "'\n"
                + "           ," + pro.getSupplierID() + "\n"
                + "           ," + pro.getCategoryID() + "\n"
                + "           ,'" + pro.getQuantityPerUnit() + "'\n"
                + "           ," + pro.getUnitPrice() + "\n"
                + "           ," + pro.getUnitsInStock() + "\n"
                + "           ," + pro.getUnitsOnOrder() + "\n"
                + "           ," + pro.getReorderLevel() + "\n"
                + "           ," + (pro.isDiscontinued() == true ? 1 : 0) + ")";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int addProduct(Products pro) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Products]\n"
                + "           ([ProductName]\n"
                + "           ,[SupplierID]\n"
                + "           ,[CategoryID]\n"
                + "           ,[QuantityPerUnit]\n"
                + "           ,[UnitPrice]\n"
                + "           ,[UnitsInStock]\n"
                + "           ,[UnitsOnOrder]\n"
                + "           ,[ReorderLevel]\n"
                + "           ,[Discontinued])\n"
                + "     VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            //pre.setDataType(indexOf ?,value);
            pre.setString(1, pro.getProductName());
            pre.setInt(2, pro.getSupplierID());
            pre.setInt(3, pro.getCategoryID());
            pre.setString(4, pro.getQuantityPerUnit());
            pre.setDouble(5, pro.getUnitPrice());
            pre.setInt(6, pro.getUnitsInStock());
            pre.setInt(7, pro.getUnitsOnOrder());
            pre.setInt(8, pro.getReorderLevel());
            pre.setBoolean(9, pro.isDiscontinued());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;
    }

    public int updateProduct(Products pro) {
        int n = 0;
        String sql = "UPDATE [dbo].[Products]\n"
                + "   SET [ProductName] = ?\n"
                + "      ,[SupplierID] = ?\n"
                + "      ,[CategoryID] = ?\n"
                + "      ,[QuantityPerUnit] = ?\n"
                + "      ,[UnitPrice] = ?\n"
                + "      ,[UnitsInStock] = ?\n"
                + "      ,[UnitsOnOrder] = ?\n"
                + "      ,[ReorderLevel] = ?\n"
                + "      ,[Discontinued] = ?\n"
                + " WHERE Productid=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            //pre.setDataType(indexOf ?, value);
            pre.setString(1, pro.getProductName());
            pre.setInt(2, pro.getSupplierID());
            pre.setInt(3, pro.getCategoryID());
            pre.setString(4, pro.getQuantityPerUnit());
            pre.setDouble(5, pro.getUnitPrice());
            pre.setInt(6, pro.getUnitsInStock());
            pre.setInt(7, pro.getUnitsOnOrder());
            pre.setInt(8, pro.getReorderLevel());
            pre.setBoolean(9, pro.isDiscontinued());
            pre.setInt(10, pro.getProductID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;
    }

    public int removeProduct(int id) {
        int n = 0;
        String sql = "Delete from Products where Productid = " + id
                + " AND (" + id + " not in (select distinct Productid from "
                + "[order details]))";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public Vector<Products> getAll(String sql) {
        Vector<Products> vector = new Vector<Products>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int pid = rs.getInt(1);
                //int pid = rs.getInt("Productid");
                //String pname = rs.getString("ProductName");
                String pname = rs.getString(2);
                int supID = rs.getInt(3);
                int cate = rs.getInt(4);
                String quantity = rs.getString(5);
                Double price = rs.getDouble(6);
                int unitIn = rs.getInt(7);
                int unitOn = rs.getInt(8);
                int reorder = rs.getInt(9);
                boolean dis = rs.getBoolean(10);
                Products pro = new Products(pid, pname,
                        supID, cate,
                        quantity, price, unitIn,
                        unitOn, reorder, dis);
                vector.add(pro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return vector;
    }

    public Products getCart(int id) {
        String sql = "select * from Products where ProductID=" + id;
        Products pro = null;
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int pid = rs.getInt(1);
                //int pid = rs.getInt("Productid");
                //String pname = rs.getString("ProductName");
                String pname = rs.getString(2);
                int supID = rs.getInt(3);
                int cate = rs.getInt(4);
                String quantity = rs.getString(5);
                Double price = rs.getDouble(6);
                int unitIn = rs.getInt(7);
                int unitOn = rs.getInt(8);
                int reorder = rs.getInt(9);
                boolean dis = rs.getBoolean(10);
                pro = new Products(pid, pname,
                        unitIn, price);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pro;
    }

    public Vector<Products> searchName(String name) {
        Vector<Products> vector = new Vector<>();
        String sql = "select * from Products where productName like "
                + "'%" + name + "%'";
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int pid = rs.getInt(1);
                //int pid = rs.getInt("Productid");
                String pname = rs.getString("ProductName");
                //String pname = rs.getInt(2);
                int supID = rs.getInt(3);
                int cate = rs.getInt(4);
                String quantity = rs.getString(5);
                Double price = rs.getDouble(6);
                int unitIn = rs.getInt(7);
                int unitOn = rs.getInt(8);
                int reorder = rs.getInt(9);
                boolean dis = rs.getBoolean(10);
                Products pro = new Products(pid, pname,
                        supID, cate,
                        quantity, price, unitIn,
                        unitOn, reorder, dis);
                vector.add(pro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public static void main(String[] args) {
        DAOProducts dao = new DAOProducts();
        int n = dao.insertProduct(
                new Products(79, "PDEMO-19", 1, 1,
                        "box", 0.5, 1, 0,
                        0, true)
        );

        if (n > 0) {
            System.out.println("inserted!");
        }
//        int n = dao.removeProduct(78);
//        if (n > 0) {
//            System.out.println("DELETED!!!");
//        }
//        Vector<Products> vector = dao.getAll("select * from Products"
//                + " where ProductName like 'M%'");
//        for(Products pro: vector){
//            System.out.println(pro);
//        }
//        Vector<Products> vector = dao.searchName("PDEMO-1");
//        for (Products pro : vector) {
//            System.out.println(pro);
//        }
    }
}

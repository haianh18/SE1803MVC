/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Categories;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HaiAnh
 */
public class DAOCategories extends DBConnect {

    public int insertCategories(Categories cate) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Categories]\n"
                + "           ([CategoryName]\n"
                + "           ,[Description]\n"
                + "           ,[Picture])\n"
                + "     VALUES\n"
                + "           ('" + cate.getCategoryName() + "'\n"
                + "           ,'" + cate.getDescription() + "'\n"
                + "           ,'" + cate.getPicture() + "')";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int addCategories(Categories cate) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Categories]\n"
                + "           ([CategoryName]\n"
                + "           ,[Description]\n"
                + "           ,[Picture])\n"
                + "     VALUES(?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, cate.getCategoryName());
            pre.setString(2, cate.getDescription());
            pre.setNull(3, n, cate.getPicture());
            pre.setNull(3, java.sql.Types.NULL);
            n = pre.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;

    }

    public int updateCategories(Categories cate) {
        int n = 0;
        String sql = "UPDATE [dbo].[Categories]\n"
                + "   SET [CategoryName] = ?\n"
                + "      ,[Description] = ?\n"
                + "      ,[Picture] = ?\n"
                + " WHERE CategoryID=?";

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, cate.getCategoryName());
            pre.setString(2, cate.getDescription());
            pre.setNull(3, n, cate.getPicture());
            pre.setInt(4, cate.getCategoryID());
            n = pre.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;
    }

    public int removeCategories(int id) {
        int n = 0;
        String sql = "Delete from Categories where CategoryID = " + id
                + " AND (" + id + "not in (select distinct CategoryID from "
                + "[Products]))";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public Vector<Categories> getAll(String sql) {
        Vector<Categories> vector = new Vector<Categories>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int cid = rs.getInt(1);
                //int pid = rs.getInt("Productid");
                //String pname = rs.getString("ProductName");
                String catename = rs.getString(2);

                String des = rs.getString(3);
                String pic = rs.getString(4);
                Categories cate = new Categories(cid,
                        catename, des, pic);
                vector.add(cate);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return vector;
    }

    public Vector<Categories> searchName(String name) {
        Vector<Categories> vector = new Vector<>();
        String sql = "select * from Categories where CategoryName like "
                + "'%" + name + "%'";
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int cid = rs.getInt(1);
                //int pid = rs.getInt("Productid");
                //String pname = rs.getString("ProductName");
                String catename = rs.getString(2);

                String des = rs.getString(3);
                String pic = rs.getString(4);
                Categories cate = new Categories(cid,
                        catename, des, pic);
                vector.add(cate);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public static void main(String[] args) {
        DAOCategories dao = new DAOCategories();
//        int n = dao.updateCategories(
//                new Categories(9, "CATDEMO-2", 
//                        "DDEMO-3", "null")
//        );
//        if (n > 0) {
//            System.out.println("Updated!");
//        }

//        Vector<Categories> vector = dao.getAll("select * from Categories"
//                + " where CategoryName like 'M%'");
//        for (Categories cate : vector) {
//            System.out.println(cate);
//        }
//        Vector<Categories> vector = dao.searchName("CATDEMO-2");
//        for (Categories cate : vector) {
//            System.out.println(cate);
//        }
        int n = dao.removeCategories(9);
        if (n > 0) {
            System.out.println("DELETED!!!");
        }

    }

}

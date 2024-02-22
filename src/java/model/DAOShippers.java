/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Shippers;
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
public class DAOShippers extends DBConnect {

    public int insertShippers(Shippers shipper) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Shippers]\n"
                + "           ([CompanyName]\n"
                + "           ,[Phone])\n"
                + "     VALUES\n"
                + "           ('" + shipper.getCompanyName() + "'\n"
                + "           ,'" + shipper.getPhone() + "')";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;
    }

    public int addShippers(Shippers shipper) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Shippers]\n"
                + "           ([CompanyName]\n"
                + "           ,[Phone])\n"
                + "     VALUES(?,?)";

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, shipper.getCompanyName());
            pre.setString(2, shipper.getPhone());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int updateShippers(Shippers ship) {
        int n = 0;
        String sql = "UPDATE [dbo].[Shippers]\n"
                + "   SET [CompanyName] = ?\n"
                + "      ,[Phone] = ?\n"
                + " WHERE ShipperID=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,ship.getCompanyName());
            pre.setString(2, ship.getPhone());
            pre.setInt(3, ship.getIDENTITY());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    
    public int removeShippers(int id) {
        int n = 0;
        String sql = "Delete from Shippers where ShipperID = " + id
                + " AND (" + id + " not in (select  distinct ShipVia from [Orders]))";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    public Vector<Shippers> searchName(String name) {
        Vector<Shippers> vector = new Vector<Shippers>();
        String sql = "select * from Shippers where CompanyName like '%" + name + "%'";
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int sid = rs.getInt(1);
                String cname = rs.getString(2);
                String phone = rs.getString(3);
                Shippers sp = new Shippers(sid, cname, phone);
                vector.add(sp);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }
     public Vector<Shippers> getAll(String sql) {
        Vector<Shippers> vector = new Vector<Shippers>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int sid = rs.getInt(1);
                String cname = rs.getString(2);
                String phone = rs.getString(3);
                Shippers sp = new Shippers(sid, cname, phone);
                vector.add(sp);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }
    
    public static void main(String[] args) {
        DAOShippers dao = new DAOShippers();
        int n = dao.updateShippers(
                new Shippers(1, "DEMO-2", "DEMO-1")
        );
        if (n > 0) {
            System.out.println("UPDATED!!!");
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Region;
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
public class DAORegion extends DBConnect {

    public int insertRegion(Region region) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Region]\n"
                + "           ([RegionID]\n"
                + "           ,[RegionDescription])\n"
                + "     VALUES\n"
                + "           ('" + region.getRegionID() + "'\n"
                + "           ,'" + region.getRegionDescription() + "')";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;
    }

    public int addRegion(Region region) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Region]\n"
                + "           ([RegionID]\n"
                + "           ,[RegionDescription])\n"
                + "     VALUES(?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, region.getRegionID());
            pre.setString(2, region.getRegionDescription());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;
    }

    public int updateRegion(Region region) {
        int n = 0;
        String sql = "UPDATE [dbo].[Region]\n"
                + "   SET [RegionID] = ?\n"
                + "      ,[RegionDescription] = ?\n"
                + " WHERE RegionID=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, region.getRegionID());
            pre.setString(2, region.getRegionDescription());
            pre.setInt(3, region.getRegionID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int removeRegion(int id) {
        int n = 0;
        String sql = "Delete from Region where RegionID = " + id
                + " AND (" + id + "not in (select distinct RegionID from "
                + "[Territories]))";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    
    public Vector<Region> getAll(String sql){
        Vector<Region> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()){
                int rid = rs.getInt(1);
                String des = rs.getString(2);
                Region region = new Region(rid, des);
                vector.add(region);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }
    
    public Vector<Region> searchRegion(int id){
        Vector<Region> vector = new Vector<>();
        String sql="select * from Region where "
                  + "RegionID = "+id;
         try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()){
                int rid = rs.getInt(1);
                String des = rs.getString(2);
                Region region = new Region(rid, des);
                vector.add(region);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public static void main(String[] args) {
        DAORegion dao = new DAORegion();
//        int n = dao.updateRegion(
//                new Region(7, "DEMO-3")
//        );
//        if (n > 0) {
//            System.out.println("INSERTED!!!");
//        }

//        int n = dao.removeRegion(1);
//        if (n > 0) {
//            System.out.println("DELETED!!!");
//        }

//          Vector<Region> vector = dao.getAll("select * from Region where "
//                  + "RegionID = 2");
//          for(Region region : vector){
//              System.out.println(region);
//          }
          
           Vector<Region> vector = dao.searchRegion(5);
          for(Region region : vector){
              System.out.println(region);
          }
          
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Territories;
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
public class DAOTerritories extends DBConnect {

    public int insertTerritories(Territories territory) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Territories]\n"
                + "           ([TerritoryID]\n"
                + "           ,[TerritoryDescription]\n"
                + "           ,[RegionID])\n"
                + "     VALUES\n"
                + "           ('" + territory.getTerritoryID() + "'\n"
                + "           ,'" + territory.getTerritoryDescription() + "'\n"
                + "           ,'" + territory.getRegionID() + "')";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int addTerritories(Territories territory) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Territories]\n"
                + "           ([TerritoryID]\n"
                + "           ,[TerritoryDescription]\n"
                + "           ,[RegionID])\n"
                + "     VALUES(?,?,?)";

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, territory.getTerritoryID());
            pre.setString(2, territory.getTerritoryDescription());
            pre.setInt(3, territory.getRegionID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;
    }

    public int updateTerritories(Territories territory) {
        int n = 0;
        String sql = "UPDATE [dbo].[Territories]\n"
                + "   SET [TerritoryID] = ?\n"
                + "      ,[TerritoryDescription] = ?\n"
                + "      ,[RegionID] = ?\n"
                + " WHERE TerritoryID=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, territory.getTerritoryID());
            pre.setString(2, territory.getTerritoryDescription());
            pre.setInt(3, territory.getRegionID());
            pre.setString(4, territory.getTerritoryID());

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int removeTerritory(int id) {
        int n = 0;
        String sql = "Delete from Territories where TerritoryID = '" + id
                + "' AND ('" + id + "'not in (select distinct TerritoryID "
                + "from [EmployeeTerritories]))";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public Vector<Territories> getAll(String sql) {
        Vector<Territories> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                String tid = rs.getString(1);
                String des = rs.getString(2);
                int rid = rs.getInt(3);
                Territories ter = new Territories(tid,
                        des, rid);
                vector.add(ter);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }
    
    public Vector<Territories> searchTerritory(String name){
        Vector<Territories> vector = new Vector<>();
        String sql="select * from Territories"
                + " where TerritoryDescription like '"+name+"%'";
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                String tid = rs.getString(1);
                String des = rs.getString(2);
                int rid = rs.getInt(3);
                Territories ter = new Territories(tid,
                        des, rid);
                vector.add(ter);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public static void main(String[] args) {
        DAOTerritories dao = new DAOTerritories();
//        int n = dao.addTerritories(
//                new Territories("0", "DEMO-1", 5)
//        );
//        if (n > 0) {
//            System.out.println("UPDATED!!!");
//        }

//        int n = dao.removeTerritory(0);
//        if (n > 0) {
//            System.out.println("DELETED!!!");
//        }
//        Vector<Territories> vector = dao.getAll("select * from Territories"
//                + " where TerritoryDescription like 'W%'");
//        for (Territories ter : vector) {
//            System.out.println(ter);
//        }
   Vector<Territories> vector = dao.searchTerritory("H");
        for (Territories ter : vector) {
            System.out.println(ter);
        }
    }
}

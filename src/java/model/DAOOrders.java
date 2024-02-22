/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Orders;
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
public class DAOOrders extends DBConnect {

    public int insertOrders(Orders order) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Orders]\n"
                + "           ([CustomerID]\n"
                + "           ,[EmployeeID]\n"
                + "           ,[OrderDate]\n"
                + "           ,[RequiredDate]\n"
                + "           ,[ShippedDate]\n"
                + "           ,[ShipVia]\n"
                + "           ,[Freight]\n"
                + "           ,[ShipName]\n"
                + "           ,[ShipAddress]\n"
                + "           ,[ShipCity]\n"
                + "           ,[ShipRegion]\n"
                + "           ,[ShipPostalCode]\n"
                + "           ,[ShipCountry])\n"
                + "     VALUES\n"
                + "           ('" + order.getCustomerID() + "'\n"
                + "           ,'" + order.getEmployeeID() + "'\n"
                + "           ,'" + order.getOrderDate() + "'\n"
                + "           ,'" + order.getRequiredDate() + "'\n"
                + "           ,'" + order.getShippedDate() + "'\n"
                + "           ,'" + order.getShipVia() + "'\n"
                + "           ,'" + order.getFreight() + "'\n"
                + "           ,'" + order.getShipName() + "'\n"
                + "           ,'" + order.getShipAddress() + "'\n"
                + "           ,'" + order.getShipCity() + "'\n"
                + "           ,'" + order.getShipRegion() + "'\n"
                + "           ,'" + order.getShipPostalCode() + "'\n"
                + "           ,'" + order.getShipCountry() + "')";

        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;
    }

    public int addOrders(Orders order) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Orders]\n"
                + "           ([CustomerID]\n"
                + "           ,[EmployeeID]\n"
                + "           ,[OrderDate]\n"
                + "           ,[RequiredDate]\n"
                + "           ,[ShippedDate]\n"
                + "           ,[ShipVia]\n"
                + "           ,[Freight]\n"
                + "           ,[ShipName]\n"
                + "           ,[ShipAddress]\n"
                + "           ,[ShipCity]\n"
                + "           ,[ShipRegion]\n"
                + "           ,[ShipPostalCode]\n"
                + "           ,[ShipCountry])\n"
                + "     VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, order.getCustomerID());
            pre.setInt(2, order.getEmployeeID());
            pre.setString(3, order.getOrderDate());
            pre.setString(4, order.getRequiredDate());
            pre.setString(5, order.getShippedDate());
            pre.setInt(6, order.getShipVia());
            pre.setDouble(7, order.getFreight());
            pre.setString(8, order.getShipName());
            pre.setString(9, order.getShipAddress());
            pre.setString(10, order.getShipCity());
            pre.setString(11, order.getShipRegion());
            pre.setString(12, order.getShipPostalCode());
            pre.setString(13, order.getShipCountry());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int updateOrders(Orders order) {
        int n = 0;
        String sql = "UPDATE [dbo].[Orders]\n"
                + "   SET [CustomerID] = ?\n"
                + "      ,[EmployeeID] = ?\n"
                + "      ,[OrderDate] = ?\n"
                + "      ,[RequiredDate] = ?\n"
                + "      ,[ShippedDate] = ?\n"
                + "      ,[ShipVia] = ?\n"
                + "      ,[Freight] = ?\n"
                + "      ,[ShipName] = ?\n"
                + "      ,[ShipAddress] = ?\n"
                + "      ,[ShipCity] = ?\n"
                + "      ,[ShipRegion] = ?\n"
                + "      ,[ShipPostalCode] = ?\n"
                + "      ,[ShipCountry] = ?\n"
                + " WHERE OrderID=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, order.getCustomerID());
            pre.setInt(2, order.getEmployeeID());
            pre.setString(3, order.getOrderDate());
            pre.setString(4, order.getRequiredDate());
            pre.setString(5, order.getShippedDate());
            pre.setInt(6, order.getShipVia());
            pre.setDouble(7, order.getFreight());
            pre.setString(8, order.getShipName());
            pre.setString(9, order.getShipAddress());
            pre.setString(10, order.getShipCity());
            pre.setString(11, order.getShipRegion());
            pre.setString(12, order.getShipPostalCode());
            pre.setString(13, order.getShipCountry());
            pre.setInt(14, order.getOrderID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public Vector<Orders> getAll(String sql) {
        Vector<Orders> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int oid = rs.getInt(1);
                String cid = rs.getString(2);
                int eid = rs.getInt(3);
                String orderdate = rs.getString(4);
                String requiredate = rs.getString(5);
                String shipdate = rs.getString(6);
                int shipvia = rs.getInt(7);
                int freight = rs.getInt(8);
                String shipname = rs.getString(9);
                String shipaddress = rs.getString(10);
                String shipcity = rs.getString(11);
                String shipregion = rs.getString(12);
                String shippostalcode = rs.getString(13);
                String shipcountry = rs.getString(14);
                Orders order = new Orders(oid, cid,
                        eid, orderdate, requiredate,
                        shipdate, shipvia, freight,
                        shipname, shipaddress, shipcity,
                        shipregion, shippostalcode,
                        shipcountry);
                vector.add(order);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }
    
    public int removeOrders(int id) {
        int n = 0;
        String sql = "Delete from Orders where Orderid = " + id
                + " AND (" + id + " not in (select  distinct Orderid from [order details]))";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public Vector<Orders> searchName(String name) {
        Vector<Orders> vector = new Vector<Orders>();
        String sql = "select * from Orders where ShipCountry like '%" + name + "%'";
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int oid = rs.getInt(1);
                String cid = rs.getString(2);
                int eid = rs.getInt(3);
                String orderdate = rs.getString(4);
                String requiredate = rs.getString(5);
                String shipdate = rs.getString(6);
                int shipvia = rs.getInt(7);
                int freight = rs.getInt(8);
                String shipname = rs.getString(9);
                String shipaddress = rs.getString(10);
                String shipcity = rs.getString(11);
                String shipregion = rs.getString(12);
                String shippostalcode = rs.getString(13);
                String shipcountry = rs.getString(14);
                Orders order = new Orders(oid, cid,
                        eid, orderdate, requiredate,
                        shipdate, shipvia, freight,
                        shipname, shipaddress, shipcity,
                        shipregion, shippostalcode,
                        shipcountry);
                vector.add(order);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }


    public static void main(String[] args) {
        DAOOrders dao = new DAOOrders();
//        int n = dao.updateOrders(
//                new Orders(11079, "2", 12,
//                        "1997-04-01 00:00:00.000",
//                        "1997-04-29 00:00:00.000",
//                        "1997-04-11 00:00:00.000",
//                        3, 2, "Demo-3", "Demo-2",
//                        "Demo-2", "Demo-2",
//                        "Demo", "Demo")
//        );
//        if (n > 0) {
//            System.out.println("UPDATED!!!");
//        }
        Vector<Orders> vector = dao.getAll("select * from Orders"
                + " where OrderID = 11075");
        for (Orders order : vector) {
            System.out.println(order);
        }

    }
}

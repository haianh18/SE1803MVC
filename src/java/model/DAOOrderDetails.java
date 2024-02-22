/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.OrderDetails;
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
public class DAOOrderDetails extends DBConnect {

    public int insertOrderDetails(OrderDetails orderDetail) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Order Details]\n"
                + "           ([OrderID]\n"
                + "           ,[ProductID]\n"
                + "           ,[UnitPrice]\n"
                + "           ,[Quantity]\n"
                + "           ,[Discount])\n"
                + "     VALUES\n"
                + "           (" + orderDetail.getOrderID() + "\n"
                + "           ," + orderDetail.getProductID() + "\n"
                + "           ," + orderDetail.getUnitPrice() + "\n"
                + "           ," + orderDetail.getQuantity() + "\n"
                + "           ," + orderDetail.getDiscount() + ")";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int addOrderDetails(OrderDetails order) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Order Details]\n"
                + "           ([OrderID]\n"
                + "           ,[ProductID]\n"
                + "           ,[UnitPrice]\n"
                + "           ,[Quantity]\n"
                + "           ,[Discount])\n"
                + "     VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, order.getOrderID());
            pre.setInt(2, order.getProductID());
            pre.setDouble(3, order.getUnitPrice());
            pre.setInt(4, order.getQuantity());
            pre.setInt(5, order.getDiscount());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;
    }

    public int updateOrderDetail(OrderDetails order) {
        int n = 0;
        String sql = "UPDATE [dbo].[Order Details]\n"
                + "   SET [OrderID] = ?\n"
                + "      ,[ProductID] = ?\n"
                + "      ,[UnitPrice] = ?\n"
                + "      ,[Quantity] = ?\n"
                + "      ,[Discount] = ?\n"
                + " WHERE OrderID=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, order.getOrderID());
            pre.setInt(2, order.getProductID());
            pre.setDouble(3, order.getUnitPrice());
            pre.setInt(4, order.getQuantity());
            pre.setInt(5, order.getDiscount());
            pre.setInt(6, order.getOrderID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    
    public int removeOrderDetails(int id) {
        int n = 0;
        String sql = "Delete from [Order Details] where Orderid = "+id;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
        public Vector<OrderDetails> searchName(int id) {
        Vector<OrderDetails> vector = new Vector<OrderDetails>();
        String sql = "select * from [Order Details] where OrderID like '%" + id + "%'";
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int oid = rs.getInt(1);
                int pid = rs.getInt(2);
                Double price = rs.getDouble(3);
                int quantity = rs.getInt(4);
                int dis = rs.getInt(5);
                OrderDetails od = new OrderDetails(oid, pid, price, quantity, dis);
                vector.add(od);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }
        public Vector<OrderDetails> getAll(String sql) {
        Vector<OrderDetails> vector = new Vector<OrderDetails>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int oid = rs.getInt(1);
                int pid = rs.getInt(2);
                Double price = rs.getDouble(3);
                int quantity = rs.getInt(4);
                int dis = rs.getInt(5);
                OrderDetails od = new OrderDetails(oid, pid, price, quantity, dis);
                vector.add(od);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }


    public static void main(String[] args) {
        DAOOrderDetails dao = new DAOOrderDetails();
        int n = dao.updateOrderDetail(
                new OrderDetails(11078, 78, 2.5, 3, 1)
        );

        if (n > 0) {
            System.out.println("UPDATED!");
        }
    }
}

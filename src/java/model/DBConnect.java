package model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author laivu
 */
public class DBConnect {

    Connection conn = null;

    // Connection
    public DBConnect(String URL, String userName, String password) {
        try {
            //driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Connect
            conn = DriverManager.getConnection(URL, userName, password);
            System.out.println("Connected!!!");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public DBConnect() {
        this("jdbc:sqlserver://localhost:1433;databaseName=SE1803;trustServerCertificate=true", "sa", "123456");
    }

    public ResultSet getData(String sql) {
        ResultSet rs = null;
        Statement state;
        try {
            
             state = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
            rs = state.executeQuery(sql);
        }catch(SQLException x){
            x.printStackTrace();
        }

        return rs;
    }

    public static void main(String[] args) {
        new DBConnect();
    }
}

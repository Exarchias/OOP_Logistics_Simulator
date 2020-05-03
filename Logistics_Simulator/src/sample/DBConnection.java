package sample;


import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {

    Connection conn = null;

    public static Connection ConnectDb() {
        String connectionUrl = "jdbc:mysql://localhost:3306/logisticapp?serverTimezone=UTC";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectionUrl, "root", "root");
            //JOptionPane.showMessageDialog(null, "Connection Established");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }


}

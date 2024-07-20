
package com.example.projects;



import java.sql.*;

public class DBconnection {


    public static Connection connector() {
        Connection connect = null;
        try {
           //new AddEmployeeForm();

            Class.forName("org.sqlite.JDBC");
            String url =  "jdbc:sqlite:emp.db";
            connect = DriverManager.getConnection(url);
            connect.setAutoCommit(false);

            System.out.println("Connected");

            System.out.println("Data base conceted successfully");
        } catch (ClassNotFoundException | SQLException ex) {

            System.err.println(STR."Error class not found\{ex.getClass().getName()}");
        }
        return connect;
    }
}
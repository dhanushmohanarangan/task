package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
             private static final String url  = "jdbc:mysql://localhost:3306/employee_db";
             private static final String user = "root";
             private static final String password = "Dhanush*03";

              public static Connection getConnection() throws SQLException , ClassNotFoundException{
                  Class.forName("com.mysql.cj.jdbc.Driver");
                  Connection con = DriverManager.getConnection(url, user, password);
                  return con;
              }
}

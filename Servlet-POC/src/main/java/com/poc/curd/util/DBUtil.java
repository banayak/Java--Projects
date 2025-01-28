package com.poc.curd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
  private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE"; // Update with your DB URL
  private static final String USER = "hr";
  private static final String PASSWORD = "admin";
  private static Connection connection = null;

  static {
    try {
      Class.forName("oracle.jdbc.OracleDriver");
      connection = DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  public static Connection getConnection() {
    return connection;
  }

  public static void closeResources(ResultSet rs, PreparedStatement ps) {
    try {
      if (rs != null) rs.close();
      if (ps != null) ps.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}


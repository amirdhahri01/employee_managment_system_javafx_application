package com.mycompany.javafx.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDB {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Xdgxcx@200#3";
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/ems";
    static Connection con = null;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(CONNECTION_URL , USERNAME , PASSWORD);
            System.out.println("Connection To Database Has Established");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
        }
        return con;
    }

    public static List<Admins> getAdmins() {
        List<Admins> list = new ArrayList<>();
        try {
            String sql_query = "SELECT * FROM users";
            con = getConnection();
            ResultSet resultSet = con.prepareStatement(sql_query).executeQuery();
            while (resultSet.next()) {
                Admins adm = new Admins();
                adm.setId(resultSet.getInt(1));
                adm.setUsername(resultSet.getString(2));
                adm.setPassword(resultSet.getString(3));
                list.add(adm);
            }
            con.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } 
        return list;
    }

}

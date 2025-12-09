package com.ipsausentismos.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL =
        "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=IPS_AUSENTISMOS;encrypt=false;trustServerCertificate=true;";

    private static final String USER = "sa";
    private static final String PASSWORD = "MiClave123";

    public static Connection getConnection() throws SQLException {
        Connection conexion = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✔ Conexión exitosa a SQL Server");
        } catch (ClassNotFoundException e) {
            System.out.println("✖ No se encontró el driver JDBC de SQL Server.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("✖ Error al conectar con la base de datos: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return conexion;
    }
}

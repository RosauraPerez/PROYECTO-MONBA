package org.monba.bd;

import java.sql.Connection;
//import java.io.IOException;
import java.sql.DriverManager;
//import java.sql.SQLException;

public class ConexionMySQL {
    Connection conn;
    public Connection open() {
        String user = "root";
        String password = "root";
        String url = "jdbc:mysql://127.0.0.1:3306/monba";
        String parametros = "?useSSL=false&useUnicode=true&characterEncoding=utf-8";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url + parametros, user, password);
            return conn;
        } catch (Exception e) {
            System.out.println("Error al conectar con el servidor, Inicie el servidor de la base de datos");
            return null;
        }
    }

    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Excepción controlada.");
            }
        }
    }
    
//    String url = "jdbc:mysql://localhost:3306/monba";
//    String user = "root";
//    String password = "root";
//    
//    public Connection abrirConexion() throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        Connection conexion = DriverManager.getConnection(url, user, password);
//
//        return conexion;
//    }
//
//    public void cerrarConexion(Connection conexion) throws IOException, SQLException {
//        if(conexion!=null){
//            conexion.close();
//        }
//        
//    }
    
}

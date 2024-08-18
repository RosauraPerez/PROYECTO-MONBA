package org.monba.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.codec.digest.DigestUtils;
import org.monba.bd.ConexionMySQL;
import org.monba.model.Usuario;

public class ControllerAcceso {

    public String login(String nombreUsuario, String contrasenia) throws ClassNotFoundException, SQLException, IOException {
        //1. Definir la consulta
        String querySELECT = "SELECT * FROM v_usuario WHERE nombre_usuario = ? AND contrasenia = ?";

        String queryUPDATE = "UPDATE usuario SET token = ? WHERE nombre_usuario = ? AND contrasenia = ?;";
        //2. Establecemos la conexion
        ConexionMySQL objConMySQL = new ConexionMySQL();
        try {
            Connection conn = objConMySQL.open();
            PreparedStatement pstmt = conn.prepareStatement(querySELECT);

            pstmt.setString(1, nombreUsuario);
            pstmt.setString(2, contrasenia);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String tokenizer = generarToken(nombreUsuario);
                PreparedStatement updateStatement = conn.prepareStatement(queryUPDATE);
                int id_empleado = rs.getInt("id_empleado");
                String nombre = rs.getString("nombre");
                String a_paterno = rs.getString("a_paterno");
                String a_materno = rs.getString("a_materno");
                int idUsuario = rs.getInt("id_usuario");
                String nombre_usuario = rs.getString("nombre_usuario");
                String clave = rs.getString("contrasenia");
                String rol = rs.getString("rol");

                updateStatement.setString(1, tokenizer);
                updateStatement.setString(2, nombreUsuario);
                updateStatement.setString(3, contrasenia);
                updateStatement.executeUpdate();

                Usuario usu = new Usuario(idUsuario, nombre_usuario, clave, rol, tokenizer);
                return "{"
                        + "\"id_empleado\":\"" + id_empleado + "\","
                        + "\"nombre\":\"" + nombre + "\","
                        + "\"a_paterno\":\"" + a_paterno + "\","
                        + "\"a_materno\":\"" + a_materno + "\","
                        + "\"id_usuario\":\"" + usu.getId_usuario() + "\","
                        + "\"nombre_usuario\":\"" + usu.getNombre_usuario() + "\","
                        + "\"contrasenia\":\"" + usu.getContrasenia() + "\","
                        + "\"rol\":\"" + usu.getRol() + "\","
                        + "\"token\":\"" + usu.getToken() + "\""
                        + "}";

            } else {
                return "{\"rol\":\"ERROR\"}";
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return "{\"rol\":\"ERROR\"}";
    }

    // Método para generar el token
    public String generarToken(String nombreUsuario) {
        String token = "";
        try {
            Date miFecha = new Date();
            String fecha = new SimpleDateFormat("dd-MM-yyyy").format(miFecha);
            String cadena = nombreUsuario + "." + "MONBA" + "." + fecha;
            token = DigestUtils.md5Hex(cadena);
            System.out.println("Token generado: " + token);
        } catch (Exception e) {
            System.out.println("Error al generar el token: " + e.getMessage());
        }
        return token;
    }

    public static void main(String[] args) {
        try {
            ControllerAcceso cl = new ControllerAcceso();
            System.out.println(cl.login("admin", "admin"));
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }
}

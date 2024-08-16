package org.monba.controller;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import org.monba.bd.ConexionMySQL;
import org.monba.model.Empresa;

public class ControllerEmpresa {
    public List<Empresa> getAllActivas(String rol) throws SQLException, ClassNotFoundException, IOException {
        List<Empresa> listaEmpresas = new ArrayList<>();
        ConexionMySQL connMySQL = new ConexionMySQL();

        // 1. Crear la sentencia SQL
        String query = "SELECT * FROM empresa WHERE estatus = 1 AND rol = ?";
        // 2. Se establece la conexión con la BD
        Connection conn = connMySQL.open();
        // 3. Se genera el statement para enviar la consulta
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, rol);
        // 4. Se prepara un ResultSet para obtener la respuesta de la BD
        ResultSet rs = pstmt.executeQuery();
        // 5. Recorrer el rs y extraer los datos
        while (rs.next()) {
            Empresa e = new Empresa();
            e.setId_empresa(rs.getInt("id_empresa"));
            e.setNombre(rs.getString("nombre"));
            e.setDomicilio(rs.getString("domicilio"));
            e.setColonia(rs.getString("colonia"));
            e.setCodigo_postal(rs.getString("codigo_postal"));
            e.setCiudad(rs.getString("ciudad"));
            e.setEstado(rs.getString("estado"));
            e.setNum_autorizacion(rs.getString("numero_autorizacion"));
            e.setTelefono(rs.getString("telefono"));
            e.setCorreo(rs.getString("correo"));
            e.setRfc(rs.getString("rfc"));
            e.setDirector(rs.getString("director"));
            e.setRol(rs.getString("rol"));
            e.setEstatus(rs.getInt("estatus"));

            listaEmpresas.add(e);
        }

        // 6. Cerrar todos los objetos
        rs.close();
        pstmt.close();
        conn.close();
        connMySQL.close();

        // 7. Devolver la información
        return listaEmpresas;
    }
    
    public List<Empresa> getAllInactivas(String rol) throws SQLException, ClassNotFoundException, IOException {
        List<Empresa> listaEmpresas = new ArrayList<>();
        ConexionMySQL connMySQL = new ConexionMySQL();

        // 1. Crear la sentencia SQL
        String query = "SELECT * FROM empresa WHERE estatus = 0 AND rol = ?";
        // 2. Se establece la conexión con la BD
        Connection conn = connMySQL.open();
        // 3. Se genera el statement para enviar la consulta
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, rol);
        // 4. Se prepara un ResultSet para obtener la respuesta de la BD
        ResultSet rs = pstmt.executeQuery();
        // 5. Recorrer el rs y extraer los datos
        while (rs.next()) {
            Empresa e = new Empresa();
            e.setId_empresa(rs.getInt("id_empresa"));
            e.setNombre(rs.getString("nombre"));
            e.setDomicilio(rs.getString("domicilio"));
            e.setColonia(rs.getString("colonia"));
            e.setCodigo_postal(rs.getString("codigo_postal"));
            e.setCiudad(rs.getString("ciudad"));
            e.setEstado(rs.getString("estado"));
            e.setNum_autorizacion(rs.getString("numero_autorizacion"));
            e.setTelefono(rs.getString("telefono"));
            e.setCorreo(rs.getString("correo"));
            e.setRfc(rs.getString("rfc"));
            e.setDirector(rs.getString("director"));
            e.setRol(rs.getString("rol"));
            e.setEstatus(rs.getInt("estatus"));

            listaEmpresas.add(e);
        }

        // 6. Cerrar todos los objetos
        rs.close();
        pstmt.close();
        conn.close();
        connMySQL.close();

        // 7. Devolver la información
        return listaEmpresas;
    }
    public void activarEmpresa(Empresa e) throws ClassNotFoundException {
        try {
            //1. generar la consulta
            String query = "UPDATE empresa SET estatus = 1 WHERE id_empresa=" + e.getId_empresa()+ ";";
            //2.Generar la conexion con la BD
            ConexionMySQL connMysql = new ConexionMySQL();
            //abrir la conexion
            Connection conn = connMysql.open();
            //crear objeto que lleva la sentencia - Statement
            Statement stmt = conn.createStatement();
            //5.Ejecutar la query
            stmt.execute(query);
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }
    public void eliminarEmpresa(Empresa e) throws ClassNotFoundException {
        try {
            //1. generar la consulta
            String query = "UPDATE empresa SET estatus = 0 WHERE id_empresa=" + e.getId_empresa()+ ";";
            //2.Generar la conexion con la BD
            ConexionMySQL connMysql = new ConexionMySQL();
            //abrir la conexion
            Connection conn = connMysql.open();
            //crear objeto que lleva la sentencia - Statement
            Statement stmt = conn.createStatement();
            //5.Ejecutar la query
            stmt.execute(query);
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }

    }
    public int insertarEmpresa(Empresa e) throws SQLException, IOException, ClassNotFoundException {
        String query = "{call InsertarEmpresa(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        ConexionMySQL connMysql = new ConexionMySQL();
        // se abre la conexion
        Connection conn = connMysql.open();
        // crear el steatment  que llevara la consulta
        CallableStatement cstm = (CallableStatement) conn.prepareCall(query);
        //llenar todos los parametros de la llamada al procedure
        cstm.setString(1, e.getNombre());
        cstm.setString(2, e.getDomicilio());
        cstm.setString(3, e.getColonia());
        cstm.setString(4, e.getCodigo_postal());
        cstm.setString(5, e.getCiudad());
        cstm.setString(6, e.getEstado());
        cstm.setString(7, e.getNum_autorizacion());
        cstm.setString(8, e.getTelefono());
        cstm.setString(9, e.getCorreo());
        cstm.setString(10, e.getRfc());
        cstm.setString(11, e.getDirector());
        cstm.setString(12, e.getRol());

        cstm.registerOutParameter(13, Types.INTEGER);  // p_id_empresa

        cstm.execute();
        
        e.setId_empresa(cstm.getInt(13));
        cstm.close();
        conn.close();
        connMysql.close();
        return e.getId_empresa();
    }
    public int modificarEmpresa(Empresa e) throws SQLException, IOException, ClassNotFoundException{
        String query = "{call ModificarEmpresa(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        ConexionMySQL connMysql = new ConexionMySQL();
        // se abre la conexion
        Connection conn = connMysql.open();
        // crear el steatment  que llevara la consulta
        CallableStatement cstm =  (CallableStatement) conn.prepareCall(query);
        //llenar todos los parametros de la llamada al procedure
        cstm.setInt(1, e.getId_empresa());
        cstm.setString(2, e.getNombre());
        cstm.setString(3, e.getDomicilio());
        cstm.setString(4, e.getColonia());
        cstm.setString(5, e.getCodigo_postal());
        cstm.setString(6, e.getCiudad());
        cstm.setString(7, e.getEstado());
        cstm.setString(8, e.getNum_autorizacion());
        cstm.setString(9, e.getTelefono());
        cstm.setString(10, e.getCorreo());
        cstm.setString(11, e.getRfc());
        cstm.setString(12, e.getDirector());
        cstm.setString(13, e.getRol());
        
        cstm.execute();
        
        cstm.close();
        conn.close();
        connMysql.close();
        
        return e.getId_empresa();
    }
    public static void main(String[] args) {
        try {
            ControllerEmpresa ce = new ControllerEmpresa();
            Empresa e = new Empresa(1, "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", 1);
            System.out.println(ce.modificarEmpresa(e));
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }
}

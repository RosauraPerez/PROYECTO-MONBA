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
import org.monba.model.Empleado;
import org.monba.model.Empresa;
import org.monba.model.Manifiesto;
import org.monba.model.Persona;
import org.monba.model.Remision;
import org.monba.model.Usuario;

public class ControllerRemision {
    public List<Remision> getAllActivas(int id_empleado) throws SQLException, ClassNotFoundException, IOException {
        List<Remision> listaRemisiones = new ArrayList<>();
        ConexionMySQL connMySQL = new ConexionMySQL();

        // 1. Crear la sentencia SQL
        String query = "SELECT * FROM v_remisiones WHERE estatus_remision = 1 AND id_empleado = ?";
        // 2. Se establece la conexión con la BD
        Connection conn = connMySQL.open();
        // 3. Se genera el statement para enviar la consulta
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, id_empleado);
        // 4. Se prepara un ResultSet para obtener la respuesta de la BD
        ResultSet rs = pstmt.executeQuery();
        // 5. Recorrer el rs y extraer los datos
        while (rs.next()) {
            Persona p = new Persona();
            p.setId_persona(rs.getInt("id_persona"));
            p.setNombre(rs.getString("nombre_persona"));
            p.setApellido_paterno(rs.getString("a_paterno"));
            p.setApellido_materno(rs.getString("a_materno"));
            p.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
            p.setGenero(rs.getString("genero"));
            p.setCurp(rs.getString("curp"));
            p.setRfc(rs.getString("rfc_persona"));
            p.setDomicilio(rs.getString("domicilio_persona"));
            p.setCodigo_postal(rs.getString("codigo_postal_persona"));
            p.setCiudad(rs.getString("codigo_postal_persona"));
            p.setEstado(rs.getString("estado_persona"));
            p.setTelefono(rs.getString("telefono_persona"));
            p.setFoto(rs.getString("foto"));
            p.setNumero_licencia(rs.getString("numero_licencia"));
            p.setTipo_licencia(rs.getString("tipo_licencia"));
            
            Usuario u = new Usuario();
            u.setId_usuario(rs.getInt("id_usuario"));
            u.setNombre_usuario(rs.getString("nombre_usuario"));
            u.setContrasenia(rs.getString("contrasenia"));
            u.setRol(rs.getString("rol_usuario"));
            u.setToken(rs.getString("token"));

            Empleado e = new Empleado();
            e.setId_empleado(rs.getInt("id_empleado"));
            e.setCodigo(rs.getString("codigo_empleado"));
            e.setFecha_ingreso(rs.getString("fecha_ingreso"));
            e.setPuesto(rs.getString("puesto"));
            e.setCorreo_electronico(rs.getString("correo_empleado"));
            e.setEstatus(rs.getInt("estatus_empleado"));
            e.setComentario(rs.getString("comentario_empleado"));
            e.setNombre_expediente(rs.getString("nombre_expediente"));
            e.setExpediente(rs.getBytes("expediente"));
            e.setNombre_nomina(rs.getString("nombre_nomina"));
            e.setPdf_nomina(rs.getBytes("pdf_nomina"));
            e.setNombre_alta(rs.getString("nombre_alta"));
            e.setPdf_alta(rs.getBytes("pdf_alta"));
            e.setNombre_vacaciones(rs.getString("nombre_formato"));
            e.setPdf_vacaciones(rs.getBytes("pdf_formato"));
            e.setTipo_vehiculo(rs.getString("tipo_vehiculo"));
            e.setNum_placa(rs.getString("num_placa"));
            e.setPersona(p);
            e.setUsuario(u);
            
            Empresa emp_gen = new Empresa();
            emp_gen.setId_empresa(rs.getInt("id_empresa_generador"));
            emp_gen.setNombre(rs.getString("nombre_empresa_generador"));
            emp_gen.setDomicilio(rs.getString("domicilio_empresa_generador"));
            emp_gen.setColonia(rs.getString("colonia_generador"));
            emp_gen.setCodigo_postal(rs.getString("codigo_postal_generador"));
            emp_gen.setCiudad(rs.getString("ciudad_generador"));
            emp_gen.setEstado(rs.getString("estado_generador"));
            emp_gen.setNum_autorizacion(rs.getString("numero_autorizacion"));
            emp_gen.setTelefono(rs.getString("telefono_empresa_generador"));
            emp_gen.setCorreo(rs.getString("correo_empresa_generador"));
            emp_gen.setRfc(rs.getString("rfc_empresa_generador"));
            emp_gen.setDirector(rs.getString("director"));
            emp_gen.setRol(rs.getString("rol_empresa_generador"));
            emp_gen.setEstatus(rs.getInt("estatus_empresa_generador"));
            
            Empresa emp_dest = new Empresa();
            emp_dest.setId_empresa(rs.getInt("id_empresa_destino"));
            emp_dest.setNombre(rs.getString("nombre_empresa_destino"));
            emp_dest.setDomicilio(rs.getString("domicilio_empresa_destino"));
            emp_dest.setColonia(rs.getString("colonia_destino"));
            emp_dest.setCodigo_postal(rs.getString("codigo_postal_destino"));
            emp_dest.setCiudad(rs.getString("ciudad_destino"));
            emp_dest.setEstado(rs.getString("estado_destino"));
            emp_dest.setNum_autorizacion(rs.getString("numero_autorizacion_destino"));
            emp_dest.setTelefono(rs.getString("telefono_empresa_destino"));
            emp_dest.setCorreo(rs.getString("telefono_empresa_destino"));
            emp_dest.setRfc(rs.getString("rfc_empresa_destino"));
            emp_dest.setDirector(rs.getString("director_destino"));
            emp_dest.setRol(rs.getString("rol_empresa_destino"));
            emp_dest.setEstatus(rs.getInt("estatus_empresa_destino"));
            
            Manifiesto m = new Manifiesto();
            m.setId_manifiesto(rs.getInt("id_manifiesto"));
            m.setNum_manifiesto(rs.getString("num_manifiesto"));
            m.setNombre_manifiesto(rs.getString("nombre_manifiesto"));
            m.setPdf_manifiesto(rs.getBytes("pdf_manifiesto"));
            m.setFecha_embarque(rs.getString("fecha_embarque"));
            m.setFecha_recepcion(rs.getString("fecha_recepcion"));
            
            Remision r = new Remision();
            r.setId_remision(rs.getInt("id_remision"));
            r.setResiduo(rs.getString("residuo"));
            r.setCantidad(rs.getFloat("cantidad"));
            r.setUnidad(rs.getString("unidad"));
            r.setTipo_contenedor(rs.getString("tipo_contenedor"));
            r.setVolumen(rs.getString("volumen"));
            r.setEmpresa_cliente(rs.getString("empresa_cliente"));
            r.setEmpresa_destino(rs.getString("empresa_destino"));
            r.setFecha(rs.getString("fecha"));
            r.setEstatus(rs.getInt("estatus_remision"));
            r.setEmpleado(e);
            r.setEmpresa_des(emp_dest);
            r.setEmpresa_gen(emp_gen);
            r.setManifiesto(m);

            listaRemisiones.add(r);
        }

        // 6. Cerrar todos los objetos
        rs.close();
        pstmt.close();
        conn.close();
        connMySQL.close();

        // 7. Devolver la información
        return listaRemisiones;
    }
    
    public List<Remision> getAllInactivas(int id_empleado) throws SQLException, ClassNotFoundException, IOException {
        List<Remision> listaRemisiones = new ArrayList<>();
        ConexionMySQL connMySQL = new ConexionMySQL();

        // 1. Crear la sentencia SQL
        String query = "SELECT * FROM v_remisiones WHERE estatus_remision = 0 AND id_empleado = ?";
        // 2. Se establece la conexión con la BD
        Connection conn = connMySQL.open();
        // 3. Se genera el statement para enviar la consulta
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, id_empleado);
        // 4. Se prepara un ResultSet para obtener la respuesta de la BD
        ResultSet rs = pstmt.executeQuery();
        // 5. Recorrer el rs y extraer los datos
        while (rs.next()) {
            Persona p = new Persona();
            p.setId_persona(rs.getInt("id_persona"));
            p.setNombre(rs.getString("nombre_persona"));
            p.setApellido_paterno(rs.getString("a_paterno"));
            p.setApellido_materno(rs.getString("a_materno"));
            p.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
            p.setGenero(rs.getString("genero"));
            p.setCurp(rs.getString("curp"));
            p.setRfc(rs.getString("rfc_persona"));
            p.setDomicilio(rs.getString("domicilio_persona"));
            p.setCodigo_postal(rs.getString("codigo_postal_persona"));
            p.setCiudad(rs.getString("codigo_postal_persona"));
            p.setEstado(rs.getString("estado_persona"));
            p.setTelefono(rs.getString("telefono_persona"));
            p.setFoto(rs.getString("foto"));
            p.setNumero_licencia(rs.getString("numero_licencia"));
            p.setTipo_licencia(rs.getString("tipo_licencia"));
            
            Usuario u = new Usuario();
            u.setId_usuario(rs.getInt("id_usuario"));
            u.setNombre_usuario(rs.getString("nombre_usuario"));
            u.setContrasenia(rs.getString("contrasenia"));
            u.setRol(rs.getString("rol_usuario"));
            u.setToken(rs.getString("token"));

            Empleado e = new Empleado();
            e.setId_empleado(rs.getInt("id_empleado"));
            e.setCodigo(rs.getString("codigo_empleado"));
            e.setFecha_ingreso(rs.getString("fecha_ingreso"));
            e.setPuesto(rs.getString("puesto"));
            e.setCorreo_electronico(rs.getString("correo_empleado"));
            e.setEstatus(rs.getInt("estatus_empleado"));
            e.setComentario(rs.getString("comentario_empleado"));
            e.setNombre_expediente(rs.getString("nombre_expediente"));
            e.setExpediente(rs.getBytes("expediente"));
            e.setNombre_nomina(rs.getString("nombre_nomina"));
            e.setPdf_nomina(rs.getBytes("pdf_nomina"));
            e.setNombre_alta(rs.getString("nombre_alta"));
            e.setPdf_alta(rs.getBytes("pdf_alta"));
            e.setNombre_vacaciones(rs.getString("nombre_formato"));
            e.setPdf_vacaciones(rs.getBytes("pdf_formato"));
            e.setTipo_vehiculo(rs.getString("tipo_vehiculo"));
            e.setNum_placa(rs.getString("num_placa"));
            e.setPersona(p);
            e.setUsuario(u);
            
            Empresa emp_gen = new Empresa();
            emp_gen.setId_empresa(rs.getInt("id_empresa_generador"));
            emp_gen.setNombre(rs.getString("nombre_empresa_generador"));
            emp_gen.setDomicilio(rs.getString("domicilio_empresa_generador"));
            emp_gen.setColonia(rs.getString("colonia_generador"));
            emp_gen.setCodigo_postal(rs.getString("codigo_postal_generador"));
            emp_gen.setCiudad(rs.getString("ciudad_generador"));
            emp_gen.setEstado(rs.getString("estado_generador"));
            emp_gen.setNum_autorizacion(rs.getString("numero_autorizacion"));
            emp_gen.setTelefono(rs.getString("telefono_empresa_generador"));
            emp_gen.setCorreo(rs.getString("correo_empresa_generador"));
            emp_gen.setRfc(rs.getString("rfc_empresa_generador"));
            emp_gen.setDirector(rs.getString("director"));
            emp_gen.setRol(rs.getString("rol_empresa_generador"));
            emp_gen.setEstatus(rs.getInt("estatus_empresa_generador"));
            
            Empresa emp_dest = new Empresa();
            emp_dest.setId_empresa(rs.getInt("id_empresa_destino"));
            emp_dest.setNombre(rs.getString("nombre_empresa_destino"));
            emp_dest.setDomicilio(rs.getString("domicilio_empresa_destino"));
            emp_dest.setColonia(rs.getString("colonia_destino"));
            emp_dest.setCodigo_postal(rs.getString("codigo_postal_destino"));
            emp_dest.setCiudad(rs.getString("ciudad_destino"));
            emp_dest.setEstado(rs.getString("estado_destino"));
            emp_dest.setNum_autorizacion(rs.getString("numero_autorizacion_destino"));
            emp_dest.setTelefono(rs.getString("telefono_empresa_destino"));
            emp_dest.setCorreo(rs.getString("telefono_empresa_destino"));
            emp_dest.setRfc(rs.getString("rfc_empresa_destino"));
            emp_dest.setDirector(rs.getString("director_destino"));
            emp_dest.setRol(rs.getString("rol_empresa_destino"));
            emp_dest.setEstatus(rs.getInt("estatus_empresa_destino"));
            
            Manifiesto m = new Manifiesto();
            m.setId_manifiesto(rs.getInt("id_manifiesto"));
            m.setNum_manifiesto(rs.getString("num_manifiesto"));
            m.setNombre_manifiesto(rs.getString("nombre_manifiesto"));
            m.setPdf_manifiesto(rs.getBytes("pdf_manifiesto"));
            m.setFecha_embarque(rs.getString("fecha_embarque"));
            m.setFecha_recepcion(rs.getString("fecha_recepcion"));
            
            Remision r = new Remision();
            r.setId_remision(rs.getInt("id_remision"));
            r.setResiduo(rs.getString("residuo"));
            r.setCantidad(rs.getFloat("cantidad"));
            r.setUnidad(rs.getString("unidad"));
            r.setTipo_contenedor(rs.getString("tipo_contenedor"));
            r.setVolumen(rs.getString("volumen"));
            r.setEmpresa_cliente(rs.getString("empresa_cliente"));
            r.setEmpresa_destino(rs.getString("empresa_destino"));
            r.setFecha(rs.getString("fecha"));
            r.setEstatus(rs.getInt("estatus_remision"));
            r.setEmpleado(e);
            r.setEmpresa_des(emp_dest);
            r.setEmpresa_gen(emp_gen);
            r.setManifiesto(m);

            listaRemisiones.add(r);
        }

        // 6. Cerrar todos los objetos
        rs.close();
        pstmt.close();
        conn.close();
        connMySQL.close();

        // 7. Devolver la información
        return listaRemisiones;
    }
    
    public void cancelarRemision(Remision r) throws ClassNotFoundException {
        try {
            //1. generar la consulta
            String query = "UPDATE remision SET estatus = 0 WHERE id_remision=" + r.getId_remision()+ ";";
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
    
    public int registrarRemision(Remision r) throws SQLException, IOException, ClassNotFoundException {
        String query = "{call InsertarRemision(?,?,?,?,?,?,?,?,?,?,?,?)}";
        ConexionMySQL connMysql = new ConexionMySQL();
        // se abre la conexion
        Connection conn = connMysql.open();
        // crear el steatment  que llevara la consulta
        CallableStatement cstm = (CallableStatement) conn.prepareCall(query);
        //llenar todos los parametros de la llamada al procedure
        cstm.setString(1, r.getResiduo());
        cstm.setFloat(2, r.getCantidad());
        cstm.setString(3, r.getUnidad());
        cstm.setString(4, r.getTipo_contenedor());
        cstm.setString(5, r.getVolumen());
        cstm.setString(6, r.getEmpresa_cliente());
        cstm.setString(7, r.getEmpresa_destino());
        cstm.setString(8, r.getFecha());
        cstm.setInt(9, r.getEmpleado().getId_empleado());
        cstm.setInt(10, r.getEmpresa_gen().getId_empresa());
        cstm.setInt(11, r.getEmpresa_des().getId_empresa());

        cstm.registerOutParameter(12, Types.INTEGER);  // p_id_remision

        cstm.execute();
        
        r.setId_remision(cstm.getInt(12));
        cstm.close();
        conn.close();
        connMysql.close();
        return r.getId_remision();
    }
    
    public int modificarRemision(Remision r) throws SQLException, IOException, ClassNotFoundException {
        String query = "{call ModificarRemision(?,?,?,?,?,?,?,?,?,?,?,?)}";
        ConexionMySQL connMysql = new ConexionMySQL();
        // se abre la conexion
        Connection conn = connMysql.open();
        // crear el steatment  que llevara la consulta
        CallableStatement cstm = (CallableStatement) conn.prepareCall(query);
        //llenar todos los parametros de la llamada al procedure
        cstm.setInt(1, r.getId_remision());
        cstm.setString(2, r.getResiduo());
        cstm.setFloat(3, r.getCantidad());
        cstm.setString(4, r.getUnidad());
        cstm.setString(5, r.getTipo_contenedor());
        cstm.setString(6, r.getVolumen());
        cstm.setString(7, r.getEmpresa_cliente());
        cstm.setString(8, r.getEmpresa_destino());
        cstm.setString(9, r.getFecha());
        cstm.setInt(10, r.getEmpleado().getId_empleado());
        cstm.setInt(11, r.getEmpresa_gen().getId_empresa());
        cstm.setInt(12, r.getEmpresa_des().getId_empresa());

        cstm.execute();

        cstm.close();
        conn.close();
        connMysql.close();
        return r.getId_remision();
    }
    
    public static void main(String[] args) {
        try {
            ControllerRemision cr = new ControllerRemision();
            Empleado e = new Empleado();
            e.setId_empleado(1);
            Empresa emp_gen = new Empresa();
            emp_gen.setId_empresa(1);
            Empresa emp_dest = new Empresa();
            emp_dest.setId_empresa(4);
            
            Remision r = new Remision(1, "1", 20, "jD", "C", "30", "k", "m", "2024/07/23", 1, e, emp_gen, emp_dest);
            
            System.out.println(cr.getAllActivas(1));
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }
}

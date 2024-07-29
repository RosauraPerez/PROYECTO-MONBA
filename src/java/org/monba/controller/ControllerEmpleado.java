
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
import org.monba.model.Persona;
import org.monba.model.Usuario;

/**
 *
 * @author perez
 */
public class ControllerEmpleado {

    public List<Empleado> getAllActivos() throws ClassNotFoundException, SQLException, IOException {
        // Generar la consulta
        String query = "SELECT * FROM vista_empleados WHERE estatus = 1";

        // Conectarse a la BD
        ConexionMySQL connMySQL = new ConexionMySQL();

        // Abrir la conexion
        Connection conn = connMySQL.open();
        // Crear el objeto que lleva la sentencia a la BD
        PreparedStatement pstmt = conn.prepareStatement(query);
        // Se ejecuta la sentencia y se recibe el resultado
        ResultSet rs = pstmt.executeQuery();

        List<Empleado> empleados = new ArrayList<>();
        // Se recorre el resultado de la consulta - rs
        while (rs.next()) {

            Usuario u = new Usuario();
            u.setId_usuario(rs.getInt("id_usuario"));
            u.setNombre_usuario(rs.getString("nombre_usuario"));
            u.setContrasenia(rs.getString("contrasenia"));
            u.setRol(rs.getString("rol_usuario"));
            // u.setToken(rs.getString("token")); // No se usa token en la vista

            // Imprimir nombre de usuario para depuración
            System.out.println(rs.getString("nombre_usuario"));

            Persona p = new Persona();
            p.setId_persona(rs.getInt("id_persona"));
            p.setNombre(rs.getString("nombre_persona"));
            p.setApellido_paterno(rs.getString("a_paterno"));
            p.setApellido_materno(rs.getString("a_materno"));
            p.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
            p.setGenero(rs.getString("genero"));
            p.setCurp(rs.getString("curp"));
            p.setRfc(rs.getString("rfc_persona"));
            p.setDomicilio(rs.getString("domicilio"));
            p.setCodigo_postal(rs.getString("codigo_postal_persona"));
            p.setCiudad(rs.getString("ciudad_persona"));
            p.setEstado(rs.getString("estado_persona"));
            p.setTelefono(rs.getString("telefono_persona"));
            p.setFoto(rs.getString("foto"));
            p.setNumero_licencia(rs.getString("numero_licencia")); // Agregar si se usa este campo
            p.setTipo_licencia(rs.getString("tipo_licencia"));     // Agregar si se usa este campo

            Empleado e = new Empleado();
            e.setId_empleado(rs.getInt("id_empleado"));
            e.setCodigo(rs.getString("codigo_empleado"));
            e.setFecha_ingreso(rs.getString("fecha_ingreso"));
            e.setPuesto(rs.getString("puesto"));
            e.setCorreo_electronico(rs.getString("correo_electronico"));
            e.setEstatus(rs.getInt("estatus"));
            e.setComentario(rs.getString("comentario"));
            e.setNombre_expediente(rs.getString("nombre_expediente"));
            e.setExpediente(rs.getString("expediente"));
            e.setNombre_nomina(rs.getString("nombre_nomina"));     // Nuevo campo
            e.setPdf_nomina(rs.getString("pdf_nomina"));            // Nuevo campo
            e.setNombre_alta(rs.getString("nombre_alta"));         // Nuevo campo
            e.setPdf_alta(rs.getString("pdf_alta"));                // Nuevo campo
            e.setNombre_vacaciones(rs.getString("nombre_formato"));   // Nuevo campo
            e.setPdf_vacaciones(rs.getString("pdf_formato"));          // Nuevo campo
            e.setTipo_vehiculo(rs.getString("tipo_vehiculo"));
            e.setNum_placa(rs.getString("num_placa"));
            e.setPersona(p);
            e.setUsuario(u);

            empleados.add(e);
        }
        rs.close();
        pstmt.close();
        conn.close();
        connMySQL.close();

        return empleados;
    }

    public List<Empleado> getAllInctivos() throws ClassNotFoundException, SQLException, IOException {
        // Generar la consulta
        String query = "SELECT * FROM vista_empleados WHERE estatus = 0";

        // Conectarse a la BD
        ConexionMySQL connMySQL = new ConexionMySQL();

        // Abrir la conexion
        Connection conn = connMySQL.open();
        // Crear el objeto que lleva la sentencia a la BD
        PreparedStatement pstmt = conn.prepareStatement(query);
        // Se ejecuta la sentencia y se recibe el resultado
        ResultSet rs = pstmt.executeQuery();

        List<Empleado> empleados = new ArrayList<>();
        // Se recorre el resultado de la consulta - rs
        while (rs.next()) {

            Usuario u = new Usuario();
            u.setId_usuario(rs.getInt("id_usuario"));
            u.setNombre_usuario(rs.getString("nombre_usuario"));
            u.setContrasenia(rs.getString("contrasenia"));
            u.setRol(rs.getString("rol_usuario"));
            // u.setToken(rs.getString("token")); // No se usa token en la vista

            // Imprimir nombre de usuario para depuración
            System.out.println(rs.getString("nombre_usuario"));

            Persona p = new Persona();
            p.setId_persona(rs.getInt("id_persona"));
            p.setNombre(rs.getString("nombre_persona"));
            p.setApellido_paterno(rs.getString("a_paterno"));
            p.setApellido_materno(rs.getString("a_materno"));
            p.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
            p.setGenero(rs.getString("genero"));
            p.setCurp(rs.getString("curp"));
            p.setRfc(rs.getString("rfc_persona"));
            p.setDomicilio(rs.getString("domicilio"));
            p.setCodigo_postal(rs.getString("codigo_postal_persona"));
            p.setCiudad(rs.getString("ciudad_persona"));
            p.setEstado(rs.getString("estado_persona"));
            p.setTelefono(rs.getString("telefono_persona"));
            p.setFoto(rs.getString("foto"));
            p.setNumero_licencia(rs.getString("numero_licencia")); // Agregar si se usa este campo
            p.setTipo_licencia(rs.getString("tipo_licencia"));     // Agregar si se usa este campo

            Empleado e = new Empleado();
            e.setId_empleado(rs.getInt("id_empleado"));
            e.setCodigo(rs.getString("codigo_empleado"));
            e.setFecha_ingreso(rs.getString("fecha_ingreso"));
            e.setPuesto(rs.getString("puesto"));
            e.setCorreo_electronico(rs.getString("correo_electronico"));
            e.setEstatus(rs.getInt("estatus"));
            e.setComentario(rs.getString("comentario"));
            e.setNombre_expediente(rs.getString("nombre_expediente"));
            e.setExpediente(rs.getString("expediente"));
            e.setNombre_nomina(rs.getString("nombre_nomina"));     // Nuevo campo
            e.setPdf_nomina(rs.getString("pdf_nomina"));            // Nuevo campo
            e.setNombre_alta(rs.getString("nombre_alta"));         // Nuevo campo
            e.setPdf_alta(rs.getString("pdf_alta"));                // Nuevo campo
            e.setNombre_vacaciones(rs.getString("nombre_formato"));   // Nuevo campo
            e.setPdf_vacaciones(rs.getString("pdf_formato"));          // Nuevo campo
            e.setTipo_vehiculo(rs.getString("tipo_vehiculo"));
            e.setNum_placa(rs.getString("num_placa"));
            e.setPersona(p);
            e.setUsuario(u);

            empleados.add(e);
        }
        rs.close();
        pstmt.close();
        conn.close();
        connMySQL.close();

        return empleados;
    }

    public int insert(Empleado e) throws ClassNotFoundException, SQLException, IOException {
        // 1. Generar la sentencia SQL
        String query = "call insertarEmpleado(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        // 2. Crear la conexión a la BD
        ConexionMySQL conMySQL = new ConexionMySQL();

        // 3. Se abre la conexión
        Connection conn = conMySQL.open();

        // 4. Crear el statement que llevará la consulta
        CallableStatement cstm = conn.prepareCall(query);

        // 5. Llenar todos los parámetros de la llamada al Procedure
        cstm.setString(1, e.getPersona().getNombre());
        cstm.setString(2, e.getPersona().getApellido_paterno());
        cstm.setString(3, e.getPersona().getApellido_materno());
        cstm.setString(4, e.getPersona().getFecha_nacimiento());
        cstm.setString(5, e.getPersona().getGenero());
        cstm.setString(6, e.getPersona().getCurp());
        cstm.setString(7, e.getPersona().getRfc());
        cstm.setString(8, e.getPersona().getDomicilio());
        cstm.setString(9, e.getPersona().getCodigo_postal());
        cstm.setString(10, e.getPersona().getCiudad());
        cstm.setString(11, e.getPersona().getEstado());
        cstm.setString(12, e.getPersona().getTelefono());
        cstm.setString(13, e.getPersona().getFoto());
        cstm.setString(14, e.getPersona().getNumero_licencia());
        cstm.setString(15, e.getPersona().getTipo_licencia());

        cstm.setString(16, e.getUsuario().getNombre_usuario());
        cstm.setString(17, e.getUsuario().getContrasenia());
        cstm.setString(18, e.getUsuario().getRol());

        cstm.setString(19, e.getPuesto());
        cstm.setString(20, e.getCorreo_electronico());
        cstm.setInt(21, e.getEstatus());
        cstm.setString(22, e.getComentario());
        cstm.setString(23, e.getNombre_expediente());
        cstm.setString(24, e.getExpediente());

        // Agregar los nuevos parámetros
        cstm.setString(25, e.getNombre_nomina());
        cstm.setString(26, e.getPdf_nomina());
        cstm.setString(27, e.getNombre_alta());
        cstm.setString(28, e.getPdf_alta());
        cstm.setString(29, e.getNombre_vacaciones());
        cstm.setString(30, e.getPdf_vacaciones());

        cstm.setString(31, e.getTipo_vehiculo());
        cstm.setString(32, e.getNum_placa());

        // Registrar los parámetros de salida
        cstm.registerOutParameter(33, Types.INTEGER); // idPersona
        cstm.registerOutParameter(34, Types.INTEGER); // idUsuario
        cstm.registerOutParameter(35, Types.INTEGER); // idEmpleado
        cstm.registerOutParameter(36, Types.VARCHAR); // codigoEmpleado

        // 6. Ejecutar la sentencia
        cstm.execute();

        // 7. Obtener todos los parámetros de retorno
        e.getPersona().setId_persona(cstm.getInt(33));
        e.getUsuario().setId_usuario(cstm.getInt(34));
        e.setId_empleado(cstm.getInt(35));
        e.setCodigo(cstm.getString(36));

        // 8. Cerrar los objetos
        cstm.close();
        conn.close();
        conMySQL.close();

        return e.getId_empleado();
    }

    public void delete(Empleado e) throws ClassNotFoundException {
        try {
            //1. Generar la consulta
            String query = "UPDATE empleado SET estatus=0 WHERE id_empleado=" + e.getId_empleado() + ";";
            //2.Generar la conexion con el gestor
            ConexionMySQL objConnMySQL = new ConexionMySQL();
            //3.Abrir la conexion
            Connection conn = objConnMySQL.open();
            //4.Crear objeto que lleva la sentencia - Stament
            Statement stmt = conn.createStatement();
            //5.Ejecutar la query
            stmt.execute(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void activar(Empleado e) throws ClassNotFoundException {
        try {
            //1. Generar la consulta
            String query = "UPDATE empleado SET estatus=1 WHERE id_empleado=" + e.getId_empleado() + ";";
            //2.Generar la conexion con el gestor
            ConexionMySQL objConnMySQL = new ConexionMySQL();
            //3.Abrir la conexion
            Connection conn = objConnMySQL.open();
            //4.Crear objeto que lleva la sentencia - Stament
            Statement stmt = conn.createStatement();
            //5.Ejecutar la query
            stmt.execute(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int modificar(Empleado e) throws ClassNotFoundException, SQLException, IOException {
        // 1. Generar la sentencia SQL
        String query = "{call modificarEmpleado(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

        // 2. Crear la conexión a la BD
        ConexionMySQL conMySQL = new ConexionMySQL();

        // 3. Se abre la conexión
        Connection conn = conMySQL.open();

        // 4. Crear el statement que llevará la consulta
        CallableStatement cstm = conn.prepareCall(query);

        // 5. Llenar todos los parámetros de la llamada al Procedure
        cstm.setInt(1, e.getId_empleado());
        cstm.setString(2, e.getPersona().getNombre());
        cstm.setString(3, e.getPersona().getApellido_paterno());
        cstm.setString(4, e.getPersona().getApellido_materno());
        cstm.setString(5, e.getPersona().getFecha_nacimiento());
        cstm.setString(6, e.getPersona().getGenero());
        cstm.setString(7, e.getPersona().getCurp());
        cstm.setString(8, e.getPersona().getRfc());
        cstm.setString(9, e.getPersona().getDomicilio());
        cstm.setString(10, e.getPersona().getCodigo_postal());
        cstm.setString(11, e.getPersona().getCiudad());
        cstm.setString(12, e.getPersona().getEstado());
        cstm.setString(13, e.getPersona().getTelefono());
        cstm.setString(14, e.getPersona().getFoto());
        cstm.setString(15, e.getPersona().getNumero_licencia());
        cstm.setString(16, e.getPersona().getTipo_licencia());

        cstm.setString(17, e.getUsuario().getNombre_usuario());
        cstm.setString(18, e.getUsuario().getContrasenia());
        cstm.setString(19, e.getUsuario().getRol());

        cstm.setString(20, e.getPuesto());
        cstm.setString(21, e.getCorreo_electronico());
        cstm.setInt(22, e.getEstatus());
        cstm.setString(23, e.getComentario());
        cstm.setString(24, e.getNombre_expediente());
        cstm.setString(25, e.getExpediente());

        // Agregar los nuevos parámetros para los archivos PDF adicionales
        cstm.setString(26, e.getNombre_nomina());
        cstm.setString(27, e.getPdf_nomina());
        cstm.setString(28, e.getNombre_alta());
        cstm.setString(29, e.getPdf_alta());
        cstm.setString(30, e.getNombre_vacaciones());
        cstm.setString(31, e.getPdf_vacaciones());

        cstm.setString(32, e.getTipo_vehiculo());
        cstm.setString(33, e.getNum_placa());

        // 6. Ejecutar la sentencia
        cstm.execute();

        // 7. Cerrar los objetos
        cstm.close();
        conn.close();
        conMySQL.close();

        return e.getId_empleado();
    }

    public static void main(String[] args) {
        try {

            Persona persona = new Persona();
            persona.setNombre("Juan");
            persona.setApellido_paterno("Pérez");
            persona.setApellido_materno("Gómez");
            persona.setFecha_nacimiento("1990-01-01");
            persona.setGenero("M");
            persona.setCurp("JPGM900101HDFRRN00");
            persona.setRfc("PAGJ900101HDF");
            persona.setDomicilio("Calle Falsa 123");
            persona.setCodigo_postal("12345");
            persona.setCiudad("Ciudad Ejemplo");
            persona.setEstado("Estado Ejemplo");
            persona.setTelefono("1234567890");
            persona.setFoto("ruta/de/la/foto.jpg");
            persona.setNumero_licencia("L1234567890");
            persona.setTipo_licencia("A");

            Usuario usuario = new Usuario();
            usuario.setNombre_usuario("juanp");
            usuario.setContrasenia("password123");
            usuario.setRol("empleado");

            Empleado empleado = new Empleado();
            empleado.setCodigo("EMP001");
            empleado.setFecha_ingreso("2024-07-23");
            empleado.setPuesto("Operador");
            empleado.setCorreo_electronico("juan.perez@example.com");
            empleado.setEstatus(1);
            empleado.setComentario("Empleado de prueba");
            empleado.setNombre_expediente("expediente.pdf");
            empleado.setExpediente("Expediente"); 
            empleado.setTipo_vehiculo("Camión");
            empleado.setNum_placa("ABC123");
            empleado.setPersona(persona);
            empleado.setUsuario(usuario);

            ControllerEmpleado emp = new ControllerEmpleado();
            int idEmpleado = emp.insert(empleado);

            System.out.println("Empleado insertado con ID: " + idEmpleado);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

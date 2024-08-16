package org.monba.rest;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.monba.bd.ConexionMySQL;
import org.monba.controller.ControllerAcceso;

@Path("acceso")
public class RESTAcceso {
    @Path("login")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@FormParam("u") @DefaultValue("") String usuario,
                          @FormParam("c") @DefaultValue("") String contrasenia) {
        String out = "";
        try {
            ControllerAcceso ca = new ControllerAcceso();
            out = ca.login(usuario, contrasenia);
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            out = ex.getLocalizedMessage();
        }
        return Response.ok(out).build();
    }
    @Path("logout")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response cerrarSesion(@FormParam("u") String usuario) throws ClassNotFoundException, SQLException {
        
            ConexionMySQL objConn = new ConexionMySQL();
            Connection conn = objConn.abrirConexion();

            String queryUpdate = "UPDATE usuario SET token = NULL WHERE nombre_usuario = ?";
            PreparedStatement pstmt = conn.prepareStatement(queryUpdate);
            pstmt.setString(1, usuario);
            String out;
            int fila = pstmt.executeUpdate();

            if (fila > 0) {
                out = "{\"exito\":\"EXITO\"}";
            } else {
                out ="{\"error\":\"ERROR\"}";
            }
        return Response.ok(out).build();
    }
}

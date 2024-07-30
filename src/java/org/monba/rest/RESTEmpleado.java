package org.monba.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.monba.controller.ControllerEmpleado;
import org.monba.model.Empleado;

/**
 *
 * @author perez
 */
@Path("empleado")
public class RESTEmpleado {

    @Path("getAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@QueryParam("estatus") @DefaultValue("true") boolean estatus) {
        String out = "";
        try {
            ControllerEmpleado objCE = new ControllerEmpleado();
            List<Empleado> listaEmpleados = objCE.getAllActivos();
            Gson objGson = new Gson();
            out = objGson.toJson(listaEmpleados);
        } catch (Exception e) {
            e.printStackTrace();
            out = "{\"error\":\"Se produjo un error en la ejecución\"}";
        }
        return Response.ok(out).build();
    }

    @Path("delete")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@FormParam("id") @DefaultValue("") Integer empleado) {
        String out = "";
        
        try {
            Empleado e = new Empleado();
            e.setId_empleado(empleado);
            
            ControllerEmpleado ce = new ControllerEmpleado();
            
            ce.delete(e);
            
            out = """
                  {"response" : "OK"}
                  """;
        } catch (Exception e) {
            e.printStackTrace();
            out = """
                  {"response" : "ERROR"}
                  """;
        }
        
        return Response.ok(out).build();
    }

    @Path("activar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response activar(@QueryParam("id_empleado") @DefaultValue("0") String id_empleado) throws ClassNotFoundException {
        Empleado e = new Empleado();
        e.setId_empleado(Integer.parseInt(id_empleado));
        ControllerEmpleado objCE = new ControllerEmpleado();
        objCE.activar(e);
        String out = "{\"response\":\"OK\"}";
        return Response.ok(out).build();
    }

    @Path("insert")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert(@FormParam("e") @DefaultValue("") String empleado) throws ClassNotFoundException, IOException {
        Gson objGson = new Gson();

        Empleado e = objGson.fromJson(empleado, Empleado.class);

        String out = "";

        ControllerEmpleado objCE = new ControllerEmpleado();
        try {
            int idEmpleadoGenerado = objCE.insert(e);
            out = """
                  {"response" : "OK"}
                  """;
            out = String.format(out, idEmpleadoGenerado);
        } catch (SQLException ex) {
            ex.printStackTrace();
            out = """
                  {"response" : "ERROR"}
                  """;
        }
        return Response.ok(out).build();
    }

    @Path("update")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@FormParam("e") String empleado) {
        Gson objGson = new Gson();
        Empleado e = objGson.fromJson(empleado, Empleado.class);

        String out;
        ControllerEmpleado objCE = new ControllerEmpleado();

        try {
            int resultado = objCE.modificar(e);

            if (resultado > 0) {
                out = "{\"result\":\"Empleado actualizado exitosamente\"}";
            } else {
                out = "{\"result\":\"No se encontró el empleado a actualizar\"}";
            }

        } catch (SQLException | ClassNotFoundException | IOException ex) {
            out = "{\"result\":\"Error al actualizar el empleado: " + ex.getMessage() + "\"}";
        }

        return Response.ok(out).build();
    }

}

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
import org.monba.controller.ControllerRemision;
import org.monba.model.Remision;

@Path("remision")
public class RESTRemision {

    @Path("getAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@QueryParam("estatus") @DefaultValue("true") boolean estatus, @QueryParam("id_empleado") int id_empleado) throws IOException {
        String out = "";
        try {
            ControllerRemision cr = new ControllerRemision();
            List<Remision> listaRemisiones = estatus ? cr.getAllActivas(id_empleado) : cr.getAllInactivas(id_empleado);
            Gson objGson = new Gson();
            out = objGson.toJson(listaRemisiones);
        } catch (SQLException | ClassNotFoundException ex) {
            out = "{\"error\":\"" + ex.getLocalizedMessage() + "\"}";
        }
        return Response.ok(out).build();
    }

    @Path("cancelar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@QueryParam("id_remision") @DefaultValue("") String id_remision) throws ClassNotFoundException {
        Remision r = new Remision();
        r.setId_remision(Integer.parseInt(id_remision));
        ControllerRemision cr = new ControllerRemision();
        cr.cancelarRemision(r);
        String out = "{\"response\":\"ok\"}";
        return Response.ok(out).build();
    }

    @Path("registrar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrarRemision(@FormParam("r") @DefaultValue("") String remision) throws IOException, ClassNotFoundException {
        Gson gson = new Gson();
        Remision r = gson.fromJson(remision, Remision.class);
        String out = "";
        ControllerRemision cr = new ControllerRemision();

        try {
            int resultado = cr.registrarRemision(r);

            if (resultado > 0) {
                out = "{\"result\":\"EXITO\"}";
            } else {
                out = "{\"result\":\"ERROR\"}";
            }

        } catch (SQLException ex) {
            out = "{\"error\":\"Error al insertar la remision: " + ex.getMessage() + "\"}";
        }

        return Response.ok(out).build();
    }

    @Path("modificar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response modificarRemision(@FormParam("r") @DefaultValue("") String remision) throws IOException, ClassNotFoundException {
        Gson objGson = new Gson();
        Remision r = objGson.fromJson(remision, Remision.class);
        String out = "";
        ControllerRemision cr = new ControllerRemision();

        try {
            int resultado = cr.modificarRemision(r);

            if (resultado > 0) {
                out = "{\"result\":\"EXITO\"}";
            } else {
                out = "{\"result\":\"ERROR\"}";
            }

        } catch (SQLException ex) {
            out = "{\"error\":\"Error al modificar la remision: " + ex.getMessage() + "\"}";
        }

        return Response.ok(out).build();
    }
}

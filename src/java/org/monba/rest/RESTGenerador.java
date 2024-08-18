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
import org.monba.controller.ControllerEmpresa;
import org.monba.model.Empresa;

@Path("generador")
public class RESTGenerador {
    @Path("getAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@QueryParam("estatus") @DefaultValue("true") boolean estatus) throws IOException {
        String out = "";
        try {

            ControllerEmpresa ce = new ControllerEmpresa();
            List<Empresa> listaGenerador = estatus ? ce.getAllActivas("GENERADOR"): ce.getAllInactivas("GENERADOR");
            Gson objGson = new Gson();
            out = objGson.toJson(listaGenerador);
        } catch (SQLException | ClassNotFoundException ex) {
            out = "{\"error\":\"" + ex.getLocalizedMessage()+ "\"}";
        }
        return Response.ok(out).build();
    }
    
    @Path("activar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response activar(@QueryParam("id_generador") @DefaultValue("") String id_empresa) throws ClassNotFoundException {
        Empresa e = new Empresa();
        e.setId_empresa(Integer.parseInt(id_empresa));
        ControllerEmpresa ce = new ControllerEmpresa();
        ce.activarEmpresa(e);
        String out = "{\"response\":\"ok\"}";
        return Response.ok(out).build();
    }
    
    @Path("eliminar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@QueryParam("id_generador") @DefaultValue("") String id_empresa) throws ClassNotFoundException {
        Empresa e = new Empresa();
        e.setId_empresa(Integer.parseInt(id_empresa));
        ControllerEmpresa ce = new ControllerEmpresa();
        ce.eliminarEmpresa(e);
        String out = "{\"response\":\"ok\"}";
        return Response.ok(out).build();
    }
    
    @Path("insertar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertarGenerador(@FormParam("g") @DefaultValue("") String generador) throws IOException, ClassNotFoundException{
        Gson gson = new Gson();
        Empresa e = gson.fromJson(generador, Empresa.class);
        String out = "";
        ControllerEmpresa ce = new ControllerEmpresa();
        
        try {
            int resultado = ce.insertarEmpresa(e);

            if (resultado > 0) {
                out = "{\"result\":\"EXITO\"}";
            } else {
                out = "{\"result\":\"ERROR\"}";
            }

        } catch (SQLException  ex) {
            out = "{\"error\":\"Error al insertar el generador: " + ex.getMessage() + "\"}";
        }

        return Response.ok(out).build();
    }
    @Path("modificar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response modificarGenerador(@FormParam("g") @DefaultValue("") String generador) throws IOException, ClassNotFoundException{
        Gson objGson = new Gson();
        Empresa e = objGson.fromJson(generador, Empresa.class);
        String out = "";
        ControllerEmpresa ce = new ControllerEmpresa();
        
        try {
            int resultado = ce.modificarEmpresa(e);

            if (resultado > 0) {
                out = "{\"result\":\"EXITO\"}";
            } else {
                out = "{\"result\":\"ERROR\"}";
            }

        } catch (SQLException  ex) {
            out = "{\"error\":\"Error al modificar el generador: " + ex.getMessage() + "\"}";
        }

        return Response.ok(out).build();
    }
}

package com.krakedev.servicios;

import com.krakedev.entidades.Equipo;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Path("equipos")
public class EquipoServicio {

    @POST
    @Path("ingresar")
    @Consumes(MediaType.APPLICATION_JSON) 
    public Response ingresarEquipo(Equipo equipo) {
       
        try (Connection conn =conexionBDD.obtenerConexion()) {
            String sql = "INSERT INTO equipos (codigo_internacional, nombre) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, equipo.getCodigoInternacional());
            stmt.setString(2, equipo.getNombre());
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                return Response.status(Response.Status.CREATED)
                        .entity("Equipo ingresado exitosamente.")
                        .build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error:" + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al ingresar equipo: " + e.getMessage())
                    .build();
        }
        return Response.status(Response.Status.BAD_REQUEST)
                .entity("No se pudo ingresar el equipo.")
                .build();
    }
}

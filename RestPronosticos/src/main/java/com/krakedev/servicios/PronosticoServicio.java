package com.krakedev.servicios;

import com.krakedev.entidades.Pronostico;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Path("pronosticos")
public class PronosticoServicio {

    @GET
    @Path("/usuario/{codigoUsuario}")
    @Produces("application/json")
    public Response obtenerPronosticos(@PathParam("codigoUsuario") String codigoUsuario) {
       
        List<Pronostico> pronosticos = new ArrayList<>();
        try (Connection conn = conexionBDD.obtenerConexion()){
            String sql = "SELECT * FROM pronosticos WHERE codigo_usuario = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, codigoUsuario);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Pronostico p = new Pronostico(
                    rs.getInt("id"),
                    rs.getString("codigo_usuario"),
                    rs.getInt("id_partido"),
                    rs.getString("equipo1_codigo"),
                    rs.getInt("marcador_equipo1"),
                    rs.getString("equipo2_codigo"),
                    rs.getInt("marcador_equipo2")
                );
                pronosticos.add(p);
            }
            return Response.ok(pronosticos).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al obtener pronósticos: " + e.getMessage())
                    .build();
        }
    }



    @POST
    @Path("ingresar")
    @Consumes("application/json")
    @Produces("application/json")
    public Response ingresarPronostico(Pronostico pronostico) {

        try (Connection conn = conexionBDD.obtenerConexion()) {
            String sql = "INSERT INTO pronosticos (codigo_usuario, id_partido, equipo1_codigo, marcador_equipo1, equipo2_codigo, marcador_equipo2) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, pronostico.getCodigoUsuario());
            stmt.setInt(2, pronostico.getIdPartido());
            stmt.setString(3, pronostico.getEquipo1Codigo());
            stmt.setInt(4, pronostico.getMarcadorEquipo1());
            stmt.setString(5, pronostico.getEquipo2Codigo());
            stmt.setInt(6, pronostico.getMarcadorEquipo2());
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                return Response.status(Response.Status.CREATED)
                        .entity("Pronóstico ingresado exitosamente.")
                        .build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al ingresar pronóstico: " + e.getMessage())
                    .build();
        }
        return Response.status(Response.Status.BAD_REQUEST)
                .entity("No se pudo ingresar el pronóstico.")
                .build();
    }





}

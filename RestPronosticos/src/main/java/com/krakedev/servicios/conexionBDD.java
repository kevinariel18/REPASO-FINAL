package com.krakedev.servicios;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class conexionBDD {
	public static Connection obtenerConexion() throws Exception {
		Context ctx = null;
		DataSource ds = null;
		Connection con = null;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/copaAmerica");
			con = ds.getConnection();

		} catch (NamingException | SQLException e) {
			throw new Exception("se ha producido un error en la conexion: " + e.getMessage());
		} 
		
		return con;
	}
}

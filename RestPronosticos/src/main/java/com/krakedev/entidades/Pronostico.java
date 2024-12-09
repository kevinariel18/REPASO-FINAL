package com.krakedev.entidades;

public class Pronostico {
    private int id;
    private String codigoUsuario;
    private int idPartido;
    private String equipo1Codigo;
    private int marcadorEquipo1;
    private String equipo2Codigo;
    private int marcadorEquipo2;
	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public Pronostico() {
		super();
	}
	public Pronostico(int id, String codigoUsuario, int idPartido, String equipo1Codigo, int marcadorEquipo1,
			String equipo2Codigo, int marcadorEquipo2) {
		super();
		this.id = id;
		this.codigoUsuario = codigoUsuario;
		this.idPartido = idPartido;
		this.equipo1Codigo = equipo1Codigo;
		this.marcadorEquipo1 = marcadorEquipo1;
		this.equipo2Codigo = equipo2Codigo;
		this.marcadorEquipo2 = marcadorEquipo2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigoUsuario() {
		return codigoUsuario;
	}
	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	public int getIdPartido() {
		return idPartido;
	}
	public void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
	}
	public String getEquipo1Codigo() {
		return equipo1Codigo;
	}
	public void setEquipo1Codigo(String equipo1Codigo) {
		this.equipo1Codigo = equipo1Codigo;
	}
	public int getMarcadorEquipo1() {
		return marcadorEquipo1;
	}
	public void setMarcadorEquipo1(int marcadorEquipo1) {
		this.marcadorEquipo1 = marcadorEquipo1;
	}
	public String getEquipo2Codigo() {
		return equipo2Codigo;
	}
	public void setEquipo2Codigo(String equipo2Codigo) {
		this.equipo2Codigo = equipo2Codigo;
	}
	public int getMarcadorEquipo2() {
		return marcadorEquipo2;
	}
	public void setMarcadorEquipo2(int marcadorEquipo2) {
		this.marcadorEquipo2 = marcadorEquipo2;
	}

    // Constructor, Getters y Setters
    
    
}

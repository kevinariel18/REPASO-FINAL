package com.krakedev.entidades;

public class Equipo {
    private String codigoInternacional; 
    private String nombre;

    // Constructor
    public Equipo(String codigoInternacional, String nombre) {
        this.codigoInternacional = codigoInternacional;
        this.nombre = nombre;
    }

    
    
    
    public Equipo() {
		super();
	}




	// Getters y Setters
    public String getCodigoInternacional() { return codigoInternacional; }
    public void setCodigoInternacional(String codigoInternacional) { this.codigoInternacional = codigoInternacional; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}

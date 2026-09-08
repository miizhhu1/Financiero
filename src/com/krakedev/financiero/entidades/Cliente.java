package com.krakedev.financiero.entidades;

public class Cliente {
	private String cedula;
	private String nombre;
	private String apellido;
	// crear como atributo de la clase private Direccion
	private Direccion direccion;

	// constructores
	//constructor vacio
	public Cliente(){ 
		
	}
	//constructor con parametros
	public Cliente(String cedula, String nombre, String apellido, Direccion direccion) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion=direccion;
	}

	// metodos
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direcion) {
		this.direccion=direccion;
	}
	
	//metodo imprimir
	public void imprimir() {
		String mensaje;
		mensaje ="Cedula: "+cedula+", Nombre: "+nombre+", Apellido: "+ apellido + ", Direccion: "+direccion;
		System.out.println(mensaje);
	}

}

package com.krakedev.financiero.entidades;

public class Direccion {
	// crear una clase direccion en entidades con atributos calle, numero ambos
	// string
	// clase

	private String calle;
	private String numero;

	public Direccion(String calle, String numero) {
		super();
		this.calle = calle;
		this.numero = numero;

	}

	@Override
	public String toString() {
		return "Calle: " + calle + ", Numero: " + numero;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void imprimir() {
		String mensaje;
		mensaje = "Calle : " + calle + ", Numero de calle: " + numero;
		System.out.println(mensaje);
	}

}

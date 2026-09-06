package com.krakedev.financiero.entidades;

public class Cuenta {
	// atributos
	private String id;
	private double saldoActual;
	private String tipo;

	// construcor
	public Cuenta(String id) {
		this.id = id;
		this.saldoActual = 0;
		this.tipo = "A";
	}
	
	// metodos getters y setters para todos los atributos

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getSaldoActual() {
		return saldoActual;
	}

	public void setSaldoActual(double saldoActual) {
		this.saldoActual = saldoActual;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	//metodo imprimir
	
	public void imprimir() {
		String mensaje;
		mensaje ="Id: "+id+", Saldo actual: "+saldoActual+", Tipo de cuenta: "+ tipo;
		System.out.println(mensaje);
	}

}

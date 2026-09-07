package com.krakedev.financiero.servicios;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;

public class Banco {
	private int ultimoCodigo = 1000;

	// constructor vacio
	public Banco() {

	}

	// Getters y setters
	public int getUltimoCodigo() {
		return ultimoCodigo;
	}

	public void setUltimoCodigo(int ultimoCodigo) {
		this.ultimoCodigo = ultimoCodigo;
	}
	
	//crear cuenta
	public Cuenta crearCuenta(Cliente cliente) {
		String codigoStr = ultimoCodigo + "";
		ultimoCodigo++;
		Cuenta cuenta = new Cuenta(codigoStr);

        cuenta.setPropietario(cliente);

        return cuenta;
	}
	
	//metodo depositar
	public boolean depositar(double monto, Cuenta cuenta) {
		if (monto>0) {
			cuenta.setSaldoActual(cuenta.getSaldoActual()+monto);
			return true;
		}else {
			return false;
		}
	}

}

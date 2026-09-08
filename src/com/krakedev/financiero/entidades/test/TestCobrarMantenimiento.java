package com.krakedev.financiero.entidades.test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;
import com.krakedev.financiero.entidades.Direccion;
import com.krakedev.financiero.servicios.Banco;

public class TestCobrarMantenimiento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Banco banco = new Banco();

		Direccion direccion = new Direccion("Calle Amazonas","20");
		Cliente cliente = new Cliente("1752","Mishell","Yanez",direccion);
		
		
		Cuenta cuenta1 = banco.crearCuenta(cliente);
		
		cuenta1.setSaldoActual(120);
		cuenta1.imprimir();
		
        boolean resultado = banco.cobrarMantenimiento(0.5, cuenta1);
        System.out.println("¿Se realizó el cobro de mantenimiento?: " + resultado);

		cuenta1.imprimir();


	}

}

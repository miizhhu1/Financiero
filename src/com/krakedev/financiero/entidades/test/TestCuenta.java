package com.krakedev.financiero.entidades.test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;
import com.krakedev.financiero.servicios.Banco;

public class TestCuenta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Banco banco = new Banco();

		Cliente cliente = new Cliente("1753506128", "Mishell", "Yanez");
		
		Cuenta cuenta1 = new Cuenta("10");
		
		cuenta1.setPropietario(cliente);
        boolean resultado = banco.depositar(50, cuenta1);
        System.out.println("¿Se realizó el depósito?: " + resultado);

		cuenta1.imprimir();

	}

}

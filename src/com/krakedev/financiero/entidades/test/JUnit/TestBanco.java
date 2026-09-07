package com.krakedev.financiero.entidades.test.JUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;
import com.krakedev.financiero.servicios.Banco;

public class TestBanco {

	// validar que se crean las cuentas con códigos consecutivos
	@Test

	public void crearCuentaCodigosConsecutivos() {

		// Preparar
		Banco banco = new Banco();

		Cliente cliente = new Cliente("1234567890", "Ana", "Perez");

		// Ejecutar
		Cuenta cuenta1 = banco.crearCuenta(cliente);
		Cuenta cuenta2 = banco.crearCuenta(cliente);

		// Verificar
		assertEquals("1000", cuenta1.getId());
		assertEquals("1001", cuenta2.getId());
	}

	// probar que recibe correctamente el cliente
	@Test
	public void crearCuentaAsignaCliente() {

		// Preparar
		Banco banco = new Banco();

		Cliente cliente = new Cliente("1234567890", "Ana", "Perez");

		// Ejecutar
		Cuenta cuenta = banco.crearCuenta(cliente);

		// Verificar
		assertEquals(cliente, cuenta.getPropietario());
	}

	// verificar que sea una cuenta de ahorros
	@Test
	public void crearCuentaEsTipoAhorros() {

		Banco banco = new Banco();

		Cliente cliente = new Cliente("1234567890", "Ana", "Perez");

		Cuenta cuenta = banco.crearCuenta(cliente);

		assertEquals("A", cuenta.getTipo());
	}

	// probar deposito valido
	@Test
	public void probarDepositoValido() {

		// Preparar
		Banco banco = new Banco();
		Cuenta cuenta = new Cuenta("1000");

		// Ejecutar
		boolean resultado = banco.depositar(100, cuenta);

		// Verificar
		assertEquals(true, resultado);
		assertEquals(100, cuenta.getSaldoActual());
	}

	// probar depostio con valor de 0
	@Test
	public void probarDepositoMontoInvalido() {

		// Preparar
		Banco banco = new Banco();
		Cuenta cuenta = new Cuenta("1000");

		// Ejecutar
		boolean resultado = banco.depositar(0, cuenta);

		// Verificar
		assertEquals(false, resultado);
		assertEquals(0, cuenta.getSaldoActual());
	}
	//deposito con valor negativo
	@Test
	public void probarDepositoMontoNegativo() {

	    Banco banco = new Banco();
	    Cuenta cuenta = new Cuenta("1000");

	    boolean resultado = banco.depositar(-50, cuenta);

	    assertEquals(false, resultado);
	    assertEquals(0, cuenta.getSaldoActual());
	}
}

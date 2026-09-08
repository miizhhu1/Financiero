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

		Cliente cliente = new Cliente();

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

		Cliente cliente = new Cliente();

		// Ejecutar
		Cuenta cuenta = banco.crearCuenta(cliente);

		// Verificar
		assertEquals(cliente, cuenta.getPropietario());
	}

	// verificar que sea una cuenta de ahorros
	@Test
	public void crearCuentaEsTipoAhorros() {

		Banco banco = new Banco();

		Cliente cliente = new Cliente();

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

	// deposito con valor negativo
	@Test
	public void probarDepositoMontoNegativo() {

		Banco banco = new Banco();
		Cuenta cuenta = new Cuenta("1000");

		boolean resultado = banco.depositar(-50, cuenta);

		assertEquals(false, resultado);
		assertEquals(0, cuenta.getSaldoActual());
	}

	// probar retiro valido
	@Test
	public void probarRetiroValido() {

		Banco banco = new Banco();
		Cuenta cuenta = new Cuenta("1000");

		cuenta.setSaldoActual(100);

		boolean resultado = banco.retirar(40, cuenta);

		assertEquals(true, resultado);
		assertEquals(60, cuenta.getSaldoActual());
	}

	// probar retiro monto 0
	@Test
	public void probarReritoCero() {
		Banco banco = new Banco();
		Cuenta cuenta = new Cuenta("25");
		cuenta.setSaldoActual(500);
		boolean resultado = banco.retirar(0, cuenta);
		assertEquals(false, resultado);
		assertEquals(500, cuenta.getSaldoActual());
	}

	// retiro es mayor al saldo de la cuenta
	@Test
	public void probarRetiroMayorAlSaldo() {

		Banco banco = new Banco();
		Cuenta cuenta = new Cuenta("1000");

		cuenta.setSaldoActual(50);

		boolean resultado = banco.retirar(150, cuenta);

		assertEquals(false, resultado);
		assertEquals(50, cuenta.getSaldoActual());
	}
	
	// probar transferencia
	@Test
	public void probarTransferencia() {

	    Banco banco = new Banco();

	    Cuenta origen = new Cuenta("1000");
	    Cuenta destino = new Cuenta("1001");

	    origen.setSaldoActual(500);
	    destino.setSaldoActual(100);

	    boolean resultado = banco.transferir(origen, destino);

	    assertEquals(true, resultado);
	    assertEquals(0, origen.getSaldoActual(),0.001);
	    assertEquals(600, destino.getSaldoActual(),0.001);
	}
	
}

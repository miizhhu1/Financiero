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
}

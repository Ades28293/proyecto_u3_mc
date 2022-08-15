package com.uce.edu.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.uce.edu.demo.repository.modelo.CuentaBancaria;

@SpringBootTest
@Transactional
@Rollback(true)
class ICuentaBancariaServiceTest {
	@Autowired
	private ICuentaBancariaService iCuentaBancariaService;

	@Test
	void testCrearCuenta() {
		assertThat(iCuentaBancariaService.crearCuenta("Ahorros", "852966", new BigDecimal(50))).isTrue();
	}

	@Test
	void testBuscarCuenta() {
		String numero = "123456";
		assertEquals(numero, this.iCuentaBancariaService.buscar(numero).getNumero());
	}

	@Test
	void testActualizarCuenta() {
		CuentaBancaria cuenta = this.iCuentaBancariaService.buscar("123456");
		cuenta.setTipo("Corriente");
		assertTrue(iCuentaBancariaService.actualizar(cuenta));
	}
}

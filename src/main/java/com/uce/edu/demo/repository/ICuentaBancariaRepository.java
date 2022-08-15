package com.uce.edu.demo.repository;

import java.math.BigDecimal;

import com.uce.edu.demo.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaRepository {
	
	//public void actualizar(CuentaBancaria cuentaBancaria);
	
	public CuentaBancaria buscarPorNumero(String numeroCta);
	
	//Trabajo
	public void actualizar(CuentaBancaria cuenta);

	//public CuentaBancaria buscarPorNumero(String numero);

	public void insertar(CuentaBancaria c);

}

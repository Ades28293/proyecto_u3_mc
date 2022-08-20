package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.management.RuntimeErrorException;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.repository.ITransferenciaRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {

	@Autowired
	private ICuentaBancariaRepository bancariaRepository;

	@Autowired
	private ITransferenciaRepository iTransferenciaRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarTransferencia(String numeroOrigen, String numeroDestino, BigDecimal monto) {

		// TODO Auto-generated method stub
		// 0.buscar cuenta origen (obtener el saldo)
		CuentaBancaria ctaOrigen = this.bancariaRepository.buscarPorNumero(numeroOrigen);
		// 1.Restar el monto a la cta Origen
		BigDecimal saldoOrigen = ctaOrigen.getSaldo();
		BigDecimal saldoFinal = saldoOrigen.subtract(monto);
		ctaOrigen.setSaldo(saldoFinal);
		this.bancariaRepository.actualizar(ctaOrigen);

		// 0.buscar cuenta destino (obtener el saldo)
		CuentaBancaria ctaDestino = this.bancariaRepository.buscarPorNumero(numeroDestino);
		// 2. Sumar el monto a la cta Destino
		ctaDestino.setSaldo(ctaDestino.getSaldo().add(monto));
		this.bancariaRepository.actualizar(ctaDestino);

		// 3. insertar la transferencia
		Transferencia trans = new Transferencia();
		trans.setFecha(LocalDateTime.now());
		trans.setMonto(monto);
		trans.setCuentaOrigen(ctaOrigen);
		trans.setCuentaDestino(ctaDestino);
		this.iTransferenciaRepository.insertar(trans);
		
		if(monto.compareTo(saldoOrigen)>0) {
			throw new RuntimeException();
		}
		
		
	/*	if(ctaOrigen.getTipo().equals("Ahorros")) {
			throw new RuntimeException();
		}
		*/

	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarTransferenciaFachada(String numeroOrigen, String numeroDestino, BigDecimal monto) {
		// TODO Auto-generated method stub

		this.realizarTransferencia(numeroOrigen, numeroDestino, monto);

	}

}

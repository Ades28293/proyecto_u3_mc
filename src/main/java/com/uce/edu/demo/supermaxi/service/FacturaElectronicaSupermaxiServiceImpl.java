package com.uce.edu.demo.supermaxi.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.supermaxi.repository.IFacturaElectronicaSupermaxiRepository;
import com.uce.edu.demo.supermaxi.repository.modelo.FacturaElectronica;

@Service
public class FacturaElectronicaSupermaxiServiceImpl implements IFacturaElectronicaSupermaxiService{
	
	@Autowired
	private IFacturaElectronicaSupermaxiRepository electronicaSupermaxiRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void procesarElectronica(String numeroFactura, Integer cantidadItems, BigDecimal monto) {
		// TODO Auto-generated method stub
		FacturaElectronica fael= new FacturaElectronica();
		
		fael.setNumero(numeroFactura);
		fael.setFechaActual(LocalDateTime.now());
		fael.setNumeroItems(cantidadItems);
		fael.setMontoFactura(monto);
		
		
		this.electronicaSupermaxiRepository.insertar(fael);
		throw new RuntimeException();
		
	}
	

}

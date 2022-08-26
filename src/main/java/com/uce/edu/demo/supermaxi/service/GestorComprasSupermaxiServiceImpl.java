package com.uce.edu.demo.supermaxi.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestorComprasSupermaxiServiceImpl implements IGestorComprasSupermaxiService {

	@Autowired
	private IFacturaSupermaxiService facturaSupermaxiService;

	@Autowired
	private IFacturaElectronicaSupermaxiService electronicaSupermaxiService;

	@Override
	public void generarFacturaElectronicaSRI(String cedula, String numeroFactura, List<String> codigos) {
		// TODO Auto-generated method stub
		BigDecimal totalPagar = this.facturaSupermaxiService.insertar(cedula, numeroFactura, codigos);

		this.electronicaSupermaxiService.procesarElectronica(numeroFactura, codigos.size(), totalPagar);
	}

}

package com.uce.edu.demo.supermaxi.service;

import java.util.List;

public interface IGestorComprasSupermaxiService {
	public void generarFacturaElectronicaSRI(String cedula, String numeroFactura, List<String>codigos);
}

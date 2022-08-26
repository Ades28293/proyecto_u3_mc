package com.uce.edu.demo.supermaxi.service;

import java.math.BigDecimal;
import java.util.List;

public interface IFacturaSupermaxiService {
	
	public BigDecimal insertar(String cedulaCliente,String numeroFactura,List<String> codigos);
	


}

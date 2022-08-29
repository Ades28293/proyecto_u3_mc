package com.uce.edu.demo.service.funcional.tarea;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

public class MatriculaConsumerImpl implements IMatriculaConsumer<BigDecimal>{
	private static final Logger LOGGER = Logger.getLogger(MatriculaConsumerImpl.class);
	@Override
	public void calculoPrecio(BigDecimal arg1) {
		// TODO Auto-generated method stub
		
		BigDecimal precio=arg1.add(new BigDecimal(150));
		
		LOGGER.info("Precio total matricula: "+precio);
		
		
	}

}

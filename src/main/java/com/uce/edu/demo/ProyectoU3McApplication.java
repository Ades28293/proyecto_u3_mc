package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.service.IHotelService;
import com.uce.edu.demo.service.ITransferenciaService;
import com.uce.edu.demo.tarea.repository.modelo.DetalleFactura;
import com.uce.edu.demo.tarea.repository.modelo.Factura;
import com.uce.edu.demo.tarea.service.IFacturaService;

@SpringBootApplication
public class ProyectoU3McApplication implements CommandLineRunner {
	private static final Logger LOGGER = Logger.getLogger(ProyectoU3McApplication.class);

	@Autowired
	private IHotelService hotelService;

	@Autowired
	private IFacturaService facturaService;

	@Autowired
	private ITransferenciaService iTransferenciaService;
	
	
	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
		
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3McApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		this.iTransferenciaService.realizarTransferencia("2421742", " 78945212", new BigDecimal(1));
		
	}

}

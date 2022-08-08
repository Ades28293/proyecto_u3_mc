package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.IHotelService;
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

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3McApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

/*
		LOGGER.info("Join Where");

		List<Hotel> listaHotelesWhere = this.hotelService.buscarHotelJoinWhere("Matrimonial");

		for (Hotel h2 : listaHotelesWhere) {
			LOGGER.info("Hotel: " + h2.getNombre() + " " + h2.getDireccion());
		}
		
		
		LOGGER.info("Inner Join Eager/Lazy");
		List<Hotel> listaHoteles = this.hotelService.buscarHotelInnerJoin2("Matrimonial");

		for (Hotel h : listaHoteles) {
			LOGGER.info("Hotel2: " + h.getNombre() + " " + h.getDireccion());
			for(Habitacion ha:h.getHabitaciones()) {
				LOGGER.info("Habitacion2:"+ha);
			}
		}
	
		
		LOGGER.info("Join Fetch");
		List<Hotel> listaHoteles3 = this.hotelService.buscarHotelOuterFetchJoin("Matrimonial");

		for (Hotel h : listaHoteles3) {
			LOGGER.info("Hotel2: " + h.getNombre() + " " + h.getDireccion());
			for(Habitacion ha:h.getHabitaciones()) {
				LOGGER.info("Habitacion2:"+ha);
			}
		}
		
		*/
		
		LOGGER.info("Join Where");

		List<Factura> listaFacturaWhere = this.facturaService.buscarFacturaJoinWhere(10);

		for (Factura h2 : listaFacturaWhere) {
			LOGGER.info("Factura: " + h2.getId() + " " + h2.getNumero());
		}
		
				
		LOGGER.info("Join Fetch");
		List<Factura> listaFactura3 = this.facturaService.buscarFacturaOuterFetchJoin(10);

		for (Factura h : listaFactura3) {
			LOGGER.info("Factura2: " + h.getId() + " " + h.getNumero());
			for(DetalleFactura ha:h.getDetalles()){
				LOGGER.info("DetalleFactura:"+ha);
			}
		}
		
		
		
	}

}

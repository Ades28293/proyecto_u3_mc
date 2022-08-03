package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3McApplication implements CommandLineRunner {
	private static final Logger LOGGER = Logger.getLogger(ProyectoU3McApplication.class);

	@Autowired
	private IHotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3McApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// InnerJoin
		LOGGER.info("InnerJoin");
		List<Hotel> listaHoteles = this.hotelService.buscarHotelInnerJoin("Matrimonial");

		for (Hotel h : listaHoteles) {
			LOGGER.info("Hotel: " + h.getNombre() + " " + h.getDireccion());
		}
		
		List<Hotel> listaHotelesJoin = this.hotelService.buscarHotelInnerJoin();
		for (Hotel h : listaHotelesJoin) {
			LOGGER.info("Hotel sin parametros: " + h.getNombre() + " " + h.getDireccion());
		}
		
		
		

		// LEFT
		LOGGER.info("LEFT Join");
		List<Hotel> listaHotelesLeft = this.hotelService.buscarHotelOuterJoinLeft("Matrimonial");

		for (Hotel h1 : listaHotelesLeft) {
			LOGGER.info("Hotel: " + h1.getNombre() + " " + h1.getDireccion());
		}
		
		List<Hotel> listaHotelesLeft2 = this.hotelService.buscarHotelOuterJoinLeft();
		
		for (Hotel h1 : listaHotelesLeft2) {
			LOGGER.info("Hotel sin parametros: " + h1.getNombre() + " " + h1.getDireccion());
		}
		
		
		
		// RIGHT
		LOGGER.info("RIGHT Join");
		
		List<Hotel> listaHotelesRight = this.hotelService.buscarHotelOuterJoinRight("Matrimonial");

		for (Hotel h2 : listaHotelesRight) {
			LOGGER.info("Hotel: " + h2.getNombre() + " " + h2.getDireccion());
		}
		
		List<Hotel> listaHotelesRight2 = this.hotelService.buscarHotelOuterJoinRight();

		for (Hotel h2 : listaHotelesRight2) {
			LOGGER.info("Hotel sin parametros: " + h2.getNombre() + " " + h2.getDireccion());
		}

	}

}

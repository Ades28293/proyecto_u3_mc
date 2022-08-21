package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.service.IHotelService;
import com.uce.edu.demo.service.ITransferenciaService;
import com.uce.edu.demo.supermaxi.repository.modelo.Cliente;
import com.uce.edu.demo.supermaxi.repository.modelo.Producto;
import com.uce.edu.demo.supermaxi.service.IClienteSupermaxiService;
import com.uce.edu.demo.supermaxi.service.IFacturaSupermaxiService;
import com.uce.edu.demo.supermaxi.service.IProductoSupermaxiService;

@SpringBootApplication
public class ProyectoU3McApplication implements CommandLineRunner {
	private static final Logger LOGGER = Logger.getLogger(ProyectoU3McApplication.class);

	@Autowired
	private IHotelService hotelService;

//	@Autowired
//	private IFacturaService facturaService;

	@Autowired
	private ITransferenciaService iTransferenciaService;
	
	
	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
	
	@Autowired
	private IClienteSupermaxiService clienteService;
	
	@Autowired
	private IProductoSupermaxiService iProductoService;
	
	@Autowired
	private IFacturaSupermaxiService facturaSupermaxiService;
		
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3McApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		//this.iTransferenciaService.realizarTransferencia("2421742", " 78945212", new BigDecimal(1));
		
		Cliente clie1=new Cliente();
		clie1.setApellido("Cen");
		clie1.setCedula("1720757105");
		clie1.setNombre("Zhong");
		clie1.setNumeroTarjeta("4654654654");
		
		Cliente clie2=new Cliente();
		clie2.setApellido("Yunga");
		clie2.setCedula("17207574668");
		clie2.setNombre("Juan");
		clie2.setNumeroTarjeta("6486454");
		
	//	this.clienteService.insertar(clie1);
	//	this.clienteService.insertar(clie2);
		
		Producto prod1=new Producto();
		prod1.setCodigoBarras("15646767");
		prod1.setNombre("Doritos");
		prod1.setPrecio(new BigDecimal(2.50));
		prod1.setStock(15);
		
		
		Producto prod2=new Producto();
		prod2.setCodigoBarras("64566542");
		prod2.setNombre("Galletas Amor");
		prod2.setPrecio(new BigDecimal(1.50));
		prod2.setStock(20);
		
	//	this.iProductoService.insertar(prod1);
	//	this.iProductoService.insertar(prod2);
		
		List<String> carrito =new ArrayList<String>();
		carrito.add(prod1.getCodigoBarras());
		carrito.add(prod2.getCodigoBarras());
	
		this.facturaSupermaxiService.insertar("17207574668", "465465", carrito);
	
	}

}

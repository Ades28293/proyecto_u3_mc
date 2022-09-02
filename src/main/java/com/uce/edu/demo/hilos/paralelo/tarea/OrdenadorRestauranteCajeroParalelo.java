package com.uce.edu.demo.hilos.paralelo.tarea;

import java.util.concurrent.TimeUnit;
public class OrdenadorRestauranteCajeroParalelo extends Thread{
	
	

	private RestauranteCajeroParalelo restauranteParalelo;

	public OrdenadorRestauranteCajeroParalelo(RestauranteCajeroParalelo restauranteParalelo) {
		this.restauranteParalelo = restauranteParalelo;
	}
	
	//Disparar el metodo a paralelizar
	@Override
	public void run () {
		
		this.procesar(this.restauranteParalelo);
	}
	
	public void procesar(RestauranteCajeroParalelo restauranteParalelo) {
		long tiempoInicial=System.currentTimeMillis();
		System.out.println("Nombre Hilo: "+Thread.currentThread().getName());
		System.out.println("Procesando cajero: "+restauranteParalelo.getNombre()+" "+restauranteParalelo.getApellido()+" "+restauranteParalelo.getCedula());
		for(String cliente: restauranteParalelo.getClientes()) {
			this.atenderCliente(cliente);
		}
		long tiempoFinal=System.currentTimeMillis();
		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
		System.out.println(tiempoTranscurrido + "seg");
		System.out.println("Termino: "+restauranteParalelo.getNombre()+" "+restauranteParalelo.getApellido()+" "+restauranteParalelo.getCedula());
	}
	
	private void atenderCliente(String cliente) {
		System.out.println("Atendiendo a: "+cliente);
		//demora 5 sg
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}

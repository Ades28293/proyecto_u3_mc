package com.uce.edu.demo.hilos.paralelo.tarea;

import java.util.Arrays;

import com.uce.edu.demo.hilos.paralelo.CajeroParalelo;
import com.uce.edu.demo.hilos.paralelo.PCCajeroParalelo;

public class MainParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

long tiempoInicial=System.currentTimeMillis();
		
		System.out.println("Nombre Hilo: "+Thread.currentThread().getName());
		
		//RestauranteCajeroParalelo 
		
		RestauranteCajeroParalelo cajero1=new RestauranteCajeroParalelo("Michael","Cen","1720757101", Arrays.asList("Juan"));
		RestauranteCajeroParalelo cajero2=new RestauranteCajeroParalelo("Maria","Hidalgo","26546546", Arrays.asList("Manuel"));
		RestauranteCajeroParalelo cajero3=new RestauranteCajeroParalelo("Hugo","Peralta","25949848", Arrays.asList("Andrea"));
		
		RestauranteCajeroParalelo cajero4=new RestauranteCajeroParalelo("Leo","Andrade","59195194", Arrays.asList("Alisson"));
		RestauranteCajeroParalelo cajero5=new RestauranteCajeroParalelo("Daniel","Castro","921919", Arrays.asList("Mario"));
		RestauranteCajeroParalelo cajero6=new RestauranteCajeroParalelo("Lucas","Diaz","2984987998", Arrays.asList("Martin"));
		
		OrdenadorRestauranteCajeroParalelo gestorAtencion=new OrdenadorRestauranteCajeroParalelo(cajero1);
		gestorAtencion.start();//ejecuta el procesar
		
		OrdenadorRestauranteCajeroParalelo gestorAtencion1=new OrdenadorRestauranteCajeroParalelo(cajero2);
		gestorAtencion1.start();;//ejecuta el procesar
		
		OrdenadorRestauranteCajeroParalelo gestorAtencion2=new OrdenadorRestauranteCajeroParalelo(cajero3);
		gestorAtencion2.start();;//ejecuta el procesar
		
		
		OrdenadorRestauranteCajeroParalelo gestorAtencion3=new OrdenadorRestauranteCajeroParalelo(cajero1);
		gestorAtencion3.start();//ejecuta el procesar
		
		OrdenadorRestauranteCajeroParalelo gestorAtencion4=new OrdenadorRestauranteCajeroParalelo(cajero2);
		gestorAtencion4.start();;//ejecuta el procesar
		
		OrdenadorRestauranteCajeroParalelo gestorAtencion5=new OrdenadorRestauranteCajeroParalelo(cajero3);
		gestorAtencion5.start();;//ejecuta el procesar
		
		
		
		long tiempoFinal=System.currentTimeMillis();
		
		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
		
		System.out.println(tiempoTranscurrido + "seg");
		
		
		
	}

}

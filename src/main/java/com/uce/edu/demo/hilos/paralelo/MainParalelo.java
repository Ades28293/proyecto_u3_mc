package com.uce.edu.demo.hilos.paralelo;

import java.util.Arrays;

public class MainParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
long tiempoInicial=System.currentTimeMillis();
		
		System.out.println("Nombre Hilo: "+Thread.currentThread().getName());
		
		
		CajeroParalelo cajero1=new CajeroParalelo("Michael", Arrays.asList("Pepito"));
		CajeroParalelo cajero2=new CajeroParalelo("Luis", Arrays.asList("Pepito2"));
		CajeroParalelo cajero3=new CajeroParalelo("Paul", Arrays.asList("Pepito3"));
		
		CajeroParalelo cajero4=new CajeroParalelo("Michael", Arrays.asList("Juan"));
		CajeroParalelo cajero5=new CajeroParalelo("Luis", Arrays.asList("Juan2"));
		CajeroParalelo cajero6=new CajeroParalelo("Paul", Arrays.asList("Juan3"));
		
		
		PCCajeroParalelo gestorAtencion=new PCCajeroParalelo(cajero1);
		gestorAtencion.start();//ejecuta el procesar
		
		PCCajeroParalelo gestorAtencion1=new PCCajeroParalelo(cajero2);
		gestorAtencion1.start();;//ejecuta el procesar
		
		PCCajeroParalelo gestorAtencion2=new PCCajeroParalelo(cajero3);
		gestorAtencion2.start();;//ejecuta el procesar
		
		
		PCCajeroParalelo gestorAtencion3=new PCCajeroParalelo(cajero1);
		gestorAtencion3.start();//ejecuta el procesar
		
		PCCajeroParalelo gestorAtencion4=new PCCajeroParalelo(cajero2);
		gestorAtencion4.start();;//ejecuta el procesar
		
		PCCajeroParalelo gestorAtencion5=new PCCajeroParalelo(cajero3);
		gestorAtencion5.start();;//ejecuta el procesar
		
		
		
		long tiempoFinal=System.currentTimeMillis();
		
		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
		
		System.out.println(tiempoTranscurrido + "seg");
		
		
		
		
	}

}

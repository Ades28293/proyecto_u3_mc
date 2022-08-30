package com.uce.edu.demo.hilos.tradicional;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long tiempoInicial=System.currentTimeMillis();
		
		Cajero cajero1=new Cajero("Michael", Arrays.asList("Pepito","Juan","Daniel","Maria"));
		Cajero cajero2=new Cajero("Luis", Arrays.asList("Pepito2","Juan","Daniel2"));
		Cajero cajero3=new Cajero("Paul", Arrays.asList("Pepito3","Juan"));
		
		PCCajero gestorAtencion=new PCCajero();
		gestorAtencion.procesar(cajero1);
		gestorAtencion.procesar(cajero2);
		gestorAtencion.procesar(cajero3);
		
		long tiempoFinal=System.currentTimeMillis();
		
		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
		
		System.out.println(tiempoTranscurrido + "seg");
		
		
		
		
		
	}

}

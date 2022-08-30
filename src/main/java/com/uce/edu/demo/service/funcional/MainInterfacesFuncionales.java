package com.uce.edu.demo.service.funcional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import com.uce.edu.demo.ProyectoU3McApplication;

public class MainInterfacesFuncionales {
	private static final Logger LOGGER = Logger.getLogger(MainInterfacesFuncionales.class);

	public static boolean prueba(Integer numero) {
		return numero>=3;
	}
	
	public static void imprimir(String cadena) {
		LOGGER.info("Impresion:"+ cadena);
	}
	
	public static void guardar(String elementoAInsertar) {
	//consumo del repository para guardar
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConsumoMetodosHighOrder metodosHG=new ConsumoMetodosHighOrder();
		
		//SUPPLER
//		Clases
		
		IPersonaSupplier<String> supplier=new PersonaSupplierImpl();
		LOGGER.info("Supplier Clase: "+supplier.getNombre());
		
		IPersonaSupplier<String> supplierTE=new PersonaSupplierTEImpl();
		LOGGER.info("Supplier Clase: "+supplier.getNombre());
		
		//		Lambdas
		IPersonaSupplier<String> supplierLambda= () ->"Michael2";
		LOGGER.info("Supplier Lambda: "+supplierLambda.getNombre());
		
		IPersonaSupplier<String> supplierLambdaTE= () ->"Daniel TE2";
		LOGGER.info("Supplier Lambda: "+supplierLambdaTE.getNombre());
		
		//Metodos Hight Order
		String valorHO=metodosHG.consumirSupplier( () ->"Hola Mundo");
		LOGGER.info("HO Supplier: "+valorHO);
		
		String valorHO1=metodosHG.consumirSupplier( () ->{
			String valorConsultado="15646768";
			return valorConsultado;
		});
		LOGGER.info("HO Supplier: "+valorHO1);
		
		//JAVA
		LOGGER.info("JAVA Supplier");
		Stream<String> test=Stream.generate(() ->"Michael").limit(7);
		test.forEach(cadena -> System.out.println(cadena));
		
		
		
//		CONSUMER
//		Clases
		
		IPersonaConsumer<String> consumerClase=new PersonaConsumerImpl();
		consumerClase.accept("Prueba Consumer");
//		Lambdas
		IPersonaConsumer<String> consumerLambda= cadena -> System.out.println("Prueba Consumer Lambda");
		consumerLambda.accept("Prueba Consumer");
		
		//Metodos Hight Order
		metodosHG.consumirConsumer(valor -> System.out.println(valor), 2);
		
		//JAVA
		LOGGER.info("JAVA Consumer");
		List<Integer> listaNumeros= Arrays.asList(1,2,3,4,5);
		listaNumeros.forEach(numero->System.out.println(numero));
		
//		PREDICATE
//		Clases
//		Lambdas
		IPersonaPredicate<String> predicateLambda= cadena -> cadena.contains("Z");
		LOGGER.info("Predicate Lambda: "+predicateLambda.evaluar("Zhong"));
		
		//Metodos Hight Order
		boolean respuesta=metodosHG.consumirPredicate(cadena -> cadena.contains("A"), "Zhong");
		LOGGER.info("HO Predicate : "+respuesta);
		
		//JAVA
		LOGGER.info("JAVA Predicate");
		Stream<Integer>nuevaLista=listaNumeros.stream().filter(numero-> prueba(numero));
		nuevaLista.forEach(numero-> System.out.println(numero));
		
		
//		FUNCTION
//		Clases
//		Lambdas
		IPersonaFunction<Integer, String> functionLambda= cadena ->{
			Integer valor=Integer.parseInt(cadena);
			Integer valorFinal=valor-2;
			return valorFinal;
		};
		
		LOGGER.info("Function Lambda: "+functionLambda.aplicar("7"));
		
		//Metodos Hight Order
		String valorFinalF=metodosHG.consumirFunction(valor ->{
			String retorn=valor.toString()+"A";
			return retorn;
		}, 1);
		
		LOGGER.info("HO Function : "+valorFinalF);
		
		//JAVA
		LOGGER.info("JAVA Function");
		//Conversiones/cast Empleado -> EmpleadoDTO(Ligero)
		Stream<String>listaCambiada=listaNumeros.stream().map(numeroLista-> {
			Integer valor=numeroLista+1;
			String cadena="Num:"+valor.toString();
			return cadena;
		});
		//listaCambiada.forEach(valor->System.out.println(valor));
		//listaCambiada.forEach(valor->imprimir(valor));
		
		//Declarativa:ideas/intencion
		listaCambiada.forEach(valor->imprimir(valor));
		
		//Imperativa
//		for(String valor:listaCambiada) {
//			imprimir(valor);
//		}
		
//		List<String> lista1=new ArrayList<>();
//		Map<String, String> mpa1=new HashMap<String, String> ();
		
		
		
		
//		UNARY OPERATOR(FUNCTION)
//		Clases
//		Lambdas
		
		IPersonaUnaryOperator<String> unaryLambda= cadena->{
			String valorFinal=cadena.concat("sufijo");
			return valorFinal;
		};
		
		LOGGER.info("UnaryOperator Lambda: "+unaryLambda.apply("Juan"));
	}

}

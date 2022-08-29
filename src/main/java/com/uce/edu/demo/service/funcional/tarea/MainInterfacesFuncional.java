package com.uce.edu.demo.service.funcional.tarea;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.apache.log4j.Logger;

import com.uce.edu.demo.service.funcional.MainInterfacesFuncionales;

public class MainInterfacesFuncional {
	private static final Logger LOGGER = Logger.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConsumoMHighOrder metodosHG = new ConsumoMHighOrder();

		// SUPPLER
//		Clases

		IPersonaSupplier<LocalDateTime> supplier = new PersonaSupplierImpl();
		LOGGER.info("Supplier Clase: " + supplier.getFecha());

		// Lambdas
		IPersonaSupplier<LocalDateTime> supplierLambda = () -> LocalDateTime.of(2022, 8, 28, 5, 6);
		LOGGER.info("Supplier Lambda: " + supplierLambda.getFecha());;

		// Metodos Hight Order
		LocalDateTime valorHO = metodosHG.consumirSupplier(()->LocalDateTime.now());
		LOGGER.info("HO Supplier: " + valorHO);

		//Consumer
//		Clases
		
		IMatriculaConsumer<BigDecimal> consumerClase=new MatriculaConsumerImpl();
		consumerClase.calculoPrecio(new BigDecimal(150));

		
		//		Lambdas
		IMatriculaConsumer<BigDecimal> consumerLambda=precioTotal->System.out.println("Prueba Consumer Lambda Precio"+precioTotal);
		consumerLambda.calculoPrecio(new BigDecimal(300));
		
		
		//Metodos Hight Order
		metodosHG.consumirConsumer(precioTotal -> System.out.println("Prueba Consumer Lambda Precio"+precioTotal), new BigDecimal(300));   

		
//		PREDICATE
//		Clases
//		Lambdas
		IPersonaPredicate<Integer> predicateLambda= new PersonaPredicateImpl();
		LOGGER.info("Predicate Clase: "+predicateLambda.comprobracion(5));
		
		IPersonaPredicate<Integer>predicateLambda2= numero -> numero.equals(5);
		LOGGER.info("Predicate Clase: "+predicateLambda2.comprobracion(5));
		
		
		//Metodos Hight Order
		boolean respuesta=metodosHG.consumirPredicate(numero -> numero.equals(5), 6);
		LOGGER.info("HO Predicate : "+respuesta);
		
		
		//Function

		INumeroFunction<Integer,Boolean>function=new NumeroFunctionImpl();
		LOGGER.info("Function Clase: "+function.apply(false));

		INumeroFunction<Integer,Boolean>functionLambda=verdad->verdad.compareTo(true);
		LOGGER.info("Function Lambda "+ functionLambda.apply(false));;

		Integer valorIntegerHo=metodosHG.consumirFunction(verdad->verdad.compareTo(false), false);
		LOGGER.info("Function HO "+valorIntegerHo);
		
		
		//Unary Operator

		IPersonaUnaryOperator<String>funcionUnaryOperator=new PersonaUnaryOperatorImpl();
		LOGGER.info("Unary Clase: "+funcionUnaryOperator.convertirLetra("MICHAEL", "ZHONG"));

		IPersonaUnaryOperator<String>funcionUnaryOperatorLambda=(String palabra1,String palabra2)->palabra1.toLowerCase()+palabra2.toLowerCase();
		LOGGER.info("Unary Lambda: "+funcionUnaryOperatorLambda.convertirLetra("CEN", "YUNGA"));

		String salida=metodosHG.consumirUnary((String palabra1,String palabra2)->palabra1.toLowerCase()+palabra2.toLowerCase(), "Michael", "CEN");
		LOGGER.info("HO Unary "+salida );

	}

}

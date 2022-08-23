package com.uce.edu.demo.service.funcional;

import org.apache.log4j.Logger;

import com.uce.edu.demo.ProyectoU3McApplication;

public class MainInterfacesFuncionales {
	private static final Logger LOGGER = Logger.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		
//		CONSUMER
//		Clases
		
		IPersonaConsumer<String> consumerClase=new PersonaConsumerImpl();
		consumerClase.accept("Prueba Consumer");
//		Lambdas
		IPersonaConsumer<String> consumerLambda= cadena -> System.out.println("Prueba Consumer Lambda");
		consumerLambda.accept("Prueba Consumer");
		
//		PREDICATE
//		Clases
//		Lambdas
		
//		FUNCTION
//		Clases
//		Lambdas
		
		
//		UNARY OPERATOR(FUNCTION)
//		Clases
//		Lambdas
	}

}

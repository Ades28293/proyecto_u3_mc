package com.uce.edu.demo.service.funcional.tarea;

public class PersonaUnaryOperatorImpl implements IPersonaUnaryOperator<String>{

	@Override
	public String convertirLetra(String arg1, String arg2) {
		// TODO Auto-generated method stub
		String palabra1=arg1.toLowerCase();
		String palabra2=arg2.toLowerCase();
		
		return palabra1+palabra2;
	}

}

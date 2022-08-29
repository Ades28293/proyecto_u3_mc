package com.uce.edu.demo.service.funcional.tarea;

public class PersonaPredicateImpl implements IPersonaPredicate<Integer>{

	@Override
	public boolean comprobracion(Integer arg1) {
		// TODO Auto-generated method stub
		Integer lesserthan = 5; 
		boolean	respuesta;
		boolean verdad = true;
		boolean falso=false;
		if(arg1==lesserthan) {
			respuesta=verdad;
		}else {
			respuesta=falso;
		}
		
		return  respuesta;
	}

}

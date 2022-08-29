package com.uce.edu.demo.service.funcional.tarea;
@FunctionalInterface
public interface IPersonaUnaryOperator<T>{
	
	public String convertirLetra(T arg1, T arg2);
}

package com.uce.edu.demo.service.funcional.tarea;
@FunctionalInterface
public interface INumeroFunction <R,T> {
	
	public R apply(T arg1);

}

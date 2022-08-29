package com.uce.edu.demo.service.funcional.tarea;
@FunctionalInterface
public interface IPersonaPredicate<T> {
	
	public boolean comprobracion(T arg1);

}

package com.uce.edu.demo.service.funcional.tarea;

import java.time.LocalDateTime;

public class PersonaSupplierImpl<T> implements IPersonaSupplier<LocalDateTime>{

	@Override
	public LocalDateTime getFecha() {
		// TODO Auto-generated method stub
		return LocalDateTime.now();
	}

}

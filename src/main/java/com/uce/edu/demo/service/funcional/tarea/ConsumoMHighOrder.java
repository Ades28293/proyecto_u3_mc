package com.uce.edu.demo.service.funcional.tarea;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ConsumoMHighOrder {

	public LocalDateTime consumirSupplier(IPersonaSupplier<LocalDateTime> funcion) {

		return funcion.getFecha();
	}

	public void consumirConsumer(IMatriculaConsumer<BigDecimal> funcion, BigDecimal precioTotal) {
		funcion.calculoPrecio(precioTotal);
	}

	public boolean consumirPredicate(IPersonaPredicate<Integer> funcion, Integer numero) {
		return funcion.comprobracion(numero);

	}

	public Integer consumirFunction(INumeroFunction<Integer, Boolean> funcion, Boolean respuesta) {
		return funcion.apply(respuesta);
	}

	public String consumirUnary(IPersonaUnaryOperator<String> funcion, String palabra1, String palabra2) {

		return funcion.convertirLetra(palabra1, palabra2);

	}
}

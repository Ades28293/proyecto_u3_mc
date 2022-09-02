package com.uce.edu.demo.hilos.paralelo.tarea;

import java.util.List;

public class RestauranteCajeroParalelo {

		private String nombre;
		private String apellido;
		private String cedula;
	
		private List<String > clientes;

		public RestauranteCajeroParalelo(String nombre, String apellido, String cedula, List<String> clientes) {
			super();
			this.nombre = nombre;
			this.apellido = apellido;
			this.cedula = cedula;
			this.clientes = clientes;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public String getCedula() {
			return cedula;
		}

		public void setCedula(String cedula) {
			this.cedula = cedula;
		}

		public List<String> getClientes() {
			return clientes;
		}

		public void setClientes(List<String> clientes) {
			this.clientes = clientes;
		}
		
		
	
}

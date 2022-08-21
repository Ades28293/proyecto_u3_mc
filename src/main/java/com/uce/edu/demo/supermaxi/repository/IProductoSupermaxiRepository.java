package com.uce.edu.demo.supermaxi.repository;

import com.uce.edu.demo.supermaxi.repository.modelo.Producto;

public interface IProductoSupermaxiRepository {
	
	public void insertar(Producto producto);
	
	public void actualizar(Producto producto);
	
	public Producto buscarCodigoBarras(String codigo);

	

}

package com.uce.edu.demo.tarea.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.tarea.repository.modelo.Factura;

public interface IFacturaService {

	public Factura consultar(Integer id);

	public List<Factura> buscarFacturaInnerJoin(Integer cantidad);

	public List<Factura> buscarFacturaInnerJoin();

	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidad);

	public List<Factura> buscarFacturaOuterJoinRight();

	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidad);

	public List<Factura> buscarFacturaOuterJoinLeft();

	public List<Factura> buscarFacturaOuterFetchJoin(Integer cantidad);

	public List<Factura> buscarFacturaJoinWhere(Integer cantidad);
	
	//Trabajo
	public void insertar(Factura factura);

	public void actualizar(Factura factura);

	public void eliminar(Integer id);

	public int actualizarFecha(LocalDateTime fecha);

	public Factura buscar(Integer id);

	public Factura buscarPorNumero(String numero);

}

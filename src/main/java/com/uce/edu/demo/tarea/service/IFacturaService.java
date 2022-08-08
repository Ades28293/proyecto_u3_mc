package com.uce.edu.demo.tarea.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Hotel;
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

}

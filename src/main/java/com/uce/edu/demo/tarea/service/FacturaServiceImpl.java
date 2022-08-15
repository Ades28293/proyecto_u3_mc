package com.uce.edu.demo.tarea.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea.repository.IFacturaRepository;
import com.uce.edu.demo.tarea.repository.modelo.Factura;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository facturaRepository;

	@Override
	public Factura consultar(Integer id) {
		// TODO Auto-generated method stub
		return this.facturaRepository.consultar(id);
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaInnerJoin(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaInnerJoin();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaOuterJoinRight(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinRight() {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaOuterJoinRight();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaOuterJoinLeft(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLeft() {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaOuterJoinLeft();
	}

	@Override
	public List<Factura> buscarFacturaOuterFetchJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaOuterFetchJoin(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaJoinWhere(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaJoinWhere(cantidad);
	}
	
	//
	@Override
	public void insertar(Factura factura) {
		this.facturaRepository.insertar(factura);
	}

	@Override
	public void actualizar(Factura factura) {
		this.facturaRepository.actualizar(factura);
	}

	@Override
	public void eliminar(Integer id) {
		this.facturaRepository.eliminar(id);
	}

	@Override
	public int actualizarFecha(LocalDateTime fecha) {
		return this.facturaRepository.actualizarFecha(fecha);
	}

	@Override
	public Factura buscar(Integer id) {
		return this.facturaRepository.buscar(id);
	}

	@Override
	public Factura buscarPorNumero(String numero) {
		return this.facturaRepository.buscarPorNumero(numero);
	}
	
	

}

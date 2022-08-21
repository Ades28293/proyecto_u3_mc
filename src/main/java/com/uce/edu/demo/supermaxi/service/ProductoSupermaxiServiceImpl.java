package com.uce.edu.demo.supermaxi.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.supermaxi.repository.IProductoSupermaxiRepository;
import com.uce.edu.demo.supermaxi.repository.modelo.Producto;

@Service
public class ProductoSupermaxiServiceImpl implements IProductoSupermaxiService {

	@Autowired
	private IProductoSupermaxiRepository iProductoRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.iProductoRepository.insertar(producto);
	}

	@Override
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.iProductoRepository.actualizar(producto);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public Producto buscarCodigoBarras(String codigo) {
		// TODO Auto-generated method stub
		return this.iProductoRepository.buscarCodigoBarras(codigo);
	}

}

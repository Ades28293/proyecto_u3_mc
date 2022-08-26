package com.uce.edu.demo.supermaxi.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.supermaxi.repository.IClienteSupermaxiRepository;
import com.uce.edu.demo.supermaxi.repository.IFacturaSupermaxiRepository;
import com.uce.edu.demo.supermaxi.repository.IProductoSupermaxiRepository;
import com.uce.edu.demo.supermaxi.repository.modelo.DetalleFactura;
import com.uce.edu.demo.supermaxi.repository.modelo.Factura;
import com.uce.edu.demo.supermaxi.repository.modelo.Producto;

@Service
public class FacturaSupermaxiServiceImpl implements IFacturaSupermaxiService {

	@Autowired
	private IFacturaSupermaxiRepository iFacturaRepository;

	@Autowired
	private IClienteSupermaxiRepository clienteRepository;

	@Autowired
	private IProductoSupermaxiRepository iProductoRepository;

	

	@Override
	@Transactional(value = TxType.REQUIRED)
	public BigDecimal insertar(String cedulaCliente, String numeroFactura, List<String> codigos) {
		// TODO Auto-generated method stub

		List<DetalleFactura> detalles = new ArrayList<>();
		BigDecimal totalPagar = new BigDecimal(0);
		Factura fact = new Factura();
		fact.setNumero(numeroFactura);
		fact.setCliente(this.clienteRepository.buscarPorCedula(cedulaCliente));
		fact.setFecha(LocalDateTime.now());
		
		for (String codigoProd : codigos) {
			DetalleFactura deta = new DetalleFactura();
			deta.setCantidad(1);
			deta.setFactura(fact);
			Producto producto = this.iProductoRepository.buscarCodigoBarras(codigoProd);
			deta.setProducto(producto);
			deta.setSubtotal(deta.getProducto().getPrecio());
			totalPagar = totalPagar.add(deta.getSubtotal());
			producto.setStock(producto.getStock() - deta.getCantidad());
			this.iProductoRepository.actualizar(producto);
			detalles.add(deta);
			//this.detalleRepository.insertar(deta);

		}
		fact.setDetalles(detalles);
		this.iFacturaRepository.insertar(fact);
		return totalPagar;

	}

}

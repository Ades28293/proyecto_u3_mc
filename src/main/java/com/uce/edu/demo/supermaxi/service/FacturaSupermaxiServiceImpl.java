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
import com.uce.edu.demo.supermaxi.repository.IDetalleFacturaSupermaxiRepository;
import com.uce.edu.demo.supermaxi.repository.IFacturaElectronicaSupermaxiRepository;
import com.uce.edu.demo.supermaxi.repository.IFacturaSupermaxiRepository;
import com.uce.edu.demo.supermaxi.repository.IProductoSupermaxiRepository;
import com.uce.edu.demo.supermaxi.repository.modelo.Cliente;
import com.uce.edu.demo.supermaxi.repository.modelo.DetalleFactura;
import com.uce.edu.demo.supermaxi.repository.modelo.Factura;
import com.uce.edu.demo.supermaxi.repository.modelo.FacturaElectronica;
import com.uce.edu.demo.supermaxi.repository.modelo.Producto;

@Service
public class FacturaSupermaxiServiceImpl implements IFacturaSupermaxiService {

	@Autowired
	private IFacturaSupermaxiRepository iFacturaRepository;

	@Autowired
	private IClienteSupermaxiRepository clienteRepository;

	@Autowired
	private IProductoSupermaxiRepository iProductoRepository;

	@Autowired
	private IDetalleFacturaSupermaxiRepository detalleFacturaRepository;

	@Autowired
	private IFacturaElectronicaSupermaxiRepository electronicaRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(String cedulaCliente, String numeroFactura, List<String> codigos) {
		// TODO Auto-generated method stub

		Factura fact = new Factura();
		fact.setFecha(LocalDateTime.now());

		Cliente clie = this.clienteRepository.buscarPorCedula(cedulaCliente);
		fact.setCliente(clie);

		fact.setNumero(numeroFactura);

		this.iFacturaRepository.insertar(fact);

		List<DetalleFactura> detallesList = new ArrayList<DetalleFactura>();

		BigDecimal total = new BigDecimal(0);

		for (String produc : codigos) {

			DetalleFactura deta = new DetalleFactura();
			deta.setCantidad(1);
			deta.setFactura(fact);
			deta.setProducto(this.iProductoRepository.buscarCodigoBarras(produc));
			deta.setSubtotal(deta.getProducto().getPrecio());

			Producto prod = this.iProductoRepository.buscarCodigoBarras(produc);
			prod.setStock(prod.getStock() - 1);

			this.iProductoRepository.actualizar(prod);

			detallesList.add(deta);
			this.detalleFacturaRepository.insertar(deta);

			total = total.add(deta.getSubtotal());

		}
		fact.setDetalles(detallesList);

		FacturaElectronica fael = new FacturaElectronica();
		fael.setFechaActual(LocalDateTime.now());
		fael.setMontoFactura(total);
		fael.setNumero(numeroFactura);
		fael.setNumeroItems(detallesList.size());

		this.electronicaRepository.insertar(fael);

	}

}

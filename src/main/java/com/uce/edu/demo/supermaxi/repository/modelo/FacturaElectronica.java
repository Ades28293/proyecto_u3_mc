package com.uce.edu.demo.supermaxi.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "factura_electronica")
public class FacturaElectronica {

	@Id
	@Column(name = "fael_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fael_id_seq") // anotacion de secuencia
	@SequenceGenerator(name = "fael_id_seq", sequenceName = "fael_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "fael_numero")
	private String numero;

	@Column(name = "fael_fecha")
	private LocalDateTime fechaActual;

	@Column(name = "fael_monto")
	private BigDecimal montoFactura;

	@Column(name = "fael_items")
	private Integer numeroItems;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(LocalDateTime fechaActual) {
		this.fechaActual = fechaActual;
	}

	public BigDecimal getMontoFactura() {
		return montoFactura;
	}

	public void setMontoFactura(BigDecimal montoFactura) {
		this.montoFactura = montoFactura;
	}

	public Integer getNumeroItems() {
		return numeroItems;
	}

	public void setNumeroItems(Integer numeroItems) {
		this.numeroItems = numeroItems;
	}

}
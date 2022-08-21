package com.uce.edu.demo.supermaxi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.supermaxi.repository.modelo.DetalleFactura;

@Repository
@Transactional
public class DetalleFacturaSupermaxiRepositoryImpl implements IDetalleFacturaSupermaxiRepository{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(DetalleFactura detalleFactura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(detalleFactura);
	}

}

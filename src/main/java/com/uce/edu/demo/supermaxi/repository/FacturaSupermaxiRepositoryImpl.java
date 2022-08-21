package com.uce.edu.demo.supermaxi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.supermaxi.repository.modelo.Factura;

@Repository
@Transactional
public class FacturaSupermaxiRepositoryImpl implements IFacturaSupermaxiRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Factura factura) {
		this.entityManager.persist(factura);
	}

}

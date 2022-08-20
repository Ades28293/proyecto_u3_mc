package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Transferencia;
@Repository
@Transactional
public class TransferenciaRepositoryImpl implements ITransferenciaRepository{
	private static final Logger LOGGER = Logger.getLogger(TransferenciaRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(transferencia);
		
		throw new RuntimeException();
	}

}

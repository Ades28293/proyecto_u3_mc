package com.uce.edu.demo.supermaxi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.supermaxi.repository.modelo.FacturaElectronica;

@Repository
@Transactional
public class FacturaElectronicaSupermaxiRepositoryImpl implements IFacturaElectronicaSupermaxiRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void insertar(FacturaElectronica facturaElectronica) {
		// TODO Auto-generated method stub
		try {
			this.entityManager.persist(facturaElectronica);
		}catch (Exception e) {
			// TODO: handle exception
			
		}
		
		
		
		
	}

}

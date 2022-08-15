package com.uce.edu.demo.tarea.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea.repository.modelo.Factura;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Factura consultar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Factura.class, id);
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f JOIN f.detalles de WHERE de.cantidad>=:cantidad", Factura.class);
		myQuery.setParameter("cantidad", cantidad);

		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f JOIN f.detalles de",
				Factura.class);

		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f RIGHT JOIN f.detalles de WHERE de.cantidad>=:cantidad", Factura.class);
		myQuery.setParameter("cantidad", cantidad);

		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinRight() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f RIGHT JOIN f.detalles de",
				Factura.class);

		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f LEFT JOIN f.detalles de WHERE de.cantidad>=:cantidad", Factura.class);
		myQuery.setParameter("cantidad", cantidad);

		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLeft() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalles de",
				Factura.class);

		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterFetchJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f JOIN FETCH f.detalles de WHERE de.cantidad>=:cantidad", Factura.class);
		myQuery.setParameter("cantidad", cantidad);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaJoinWhere(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f,DetalleFactura de WHERE f = de.factura AND de.cantidad >=:cantidad",
				Factura.class);
		myQuery.setParameter("cantidad", cantidad);
		return myQuery.getResultList();
	}

	@Override
	public void insertar(Factura factura) {
		this.entityManager.persist(factura);
	}

	@Override
	public void actualizar(Factura factura) {
		this.entityManager.merge(factura);
	}

	@Override
	public int actualizarFecha(LocalDateTime fecha) {
		Query query = this.entityManager.createQuery("UPDATE Factura f SET f.fecha = :dato_fecha");
		query.setParameter("dato_fecha", fecha);
		return query.executeUpdate();
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.entityManager.find(Factura.class, id));
	}

	@Override
	public Factura buscar(Integer id) {
		return this.entityManager.find(Factura.class, id);
	}

	@Override
	public Factura buscarPorNumero(String numero) {
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f WHERE f.numero > :numero",
				Factura.class);
		myQuery.setParameter("numero", numero);
		return myQuery.getSingleResult();
	}

}

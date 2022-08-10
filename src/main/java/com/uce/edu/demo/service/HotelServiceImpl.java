package com.uce.edu.demo.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.repository.IHotelRepository;
import com.uce.edu.demo.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {
	private static final Logger LOGGER = Logger.getLogger(HotelServiceImpl.class);
	@Autowired
	private IHotelRepository hotelRepository;

	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotelInnerJoin(tipoHabitacion);
	}
	@Override
	public List<Hotel> buscarHotelInnerJoin2(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotelInnerJoin2(tipoHabitacion);
	}
	
	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotelInnerJoin();
	}

	@Override
	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotelJoinWhere(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinRight(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return  this.hotelRepository.buscarHotelOuterJoinRight(tipoHabitacion);
	}
	
	@Override
	public List<Hotel> buscarHotelOuterJoinRight() {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotelOuterJoinRight();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return  this.hotelRepository.buscarHotelOuterJoinLeft(tipoHabitacion);
	}
	
	
	@Override
	public List<Hotel> buscarHotelOuterJoinLeft() {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotelOuterJoinLeft();
	}

	@Override
	public List<Hotel> buscarHotelOuterFetchJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		LOGGER.info("Transaccion activa repository: "+TransactionSynchronizationManager.isActualTransactionActive());
		
		return  this.hotelRepository.buscarHotelOuterFetchJoin(tipoHabitacion);
	}

	

	

	

	

}

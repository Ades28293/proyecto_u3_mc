package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Hotel;

public interface IHotelRepository {

	
	//public void insertar(Hotel hotel);
	
	//public List<Hotel> buscarPorNombre(String nombre);
	
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion);

	public List<Hotel> buscarHotelInnerJoin();

	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion);

	public List<Hotel> buscarHotelOuterJoinRight(String tipoHabitacion);

	public List<Hotel> buscarHotelOuterJoinRight();

	public List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion);

	public List<Hotel> buscarHotelOuterJoinLeft();

	public List<Hotel> buscarHotelOuterFetchJoin(String tipoHabitacion);

	public List<Hotel> buscarHotelInnerJoin2(String tipoHabitacion);
}

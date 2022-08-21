package com.uce.edu.demo.supermaxi.repository;

import com.uce.edu.demo.supermaxi.repository.modelo.Cliente;

public interface IClienteSupermaxiRepository {
	
	public void insertar(Cliente cliente);
	public Cliente buscarPorCedula(String cedula);

}

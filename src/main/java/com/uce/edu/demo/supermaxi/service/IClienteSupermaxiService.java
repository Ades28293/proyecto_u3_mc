package com.uce.edu.demo.supermaxi.service;

import com.uce.edu.demo.supermaxi.repository.modelo.Cliente;

public interface IClienteSupermaxiService {
	
	public void insertar(Cliente cliente);
	
	public Cliente buscarPorCedula (String cedula);

}

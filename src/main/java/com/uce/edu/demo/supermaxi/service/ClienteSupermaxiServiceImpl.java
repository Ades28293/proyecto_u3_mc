package com.uce.edu.demo.supermaxi.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.supermaxi.repository.IClienteSupermaxiRepository;
import com.uce.edu.demo.supermaxi.repository.modelo.Cliente;

@Service
public class ClienteSupermaxiServiceImpl implements IClienteSupermaxiService{

	@Autowired
	private IClienteSupermaxiRepository clienteRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.clienteRepository.insertar(cliente);
	}

	@Override
	public Cliente buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.clienteRepository.buscarPorCedula(cedula);
	}



}

package com.cuevasdeayllon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuevasdeayllon.entity.Estados;
import com.cuevasdeayllon.repository.EstadosRepository;

@Service
public class EstadosServiceImpl implements EstadosService{
	
	@Autowired
	EstadosRepository service;

	@Override
	public void guardarEstado(Estados estado) {
		service.guardarEstado(estado);
		
	}

	@Override
	public void actualizarEstado(Estados estado) {
		
		
		
		service.actualizarEstado(estado);
		
	}

	@Override
	public Estados findByIdPropuesta(int idPropuesta) {
		// TODO Auto-generated method stub
		return service.findByIdPropuesta(idPropuesta);
	}

}

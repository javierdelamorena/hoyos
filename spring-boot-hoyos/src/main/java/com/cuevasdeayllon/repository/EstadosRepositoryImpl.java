package com.cuevasdeayllon.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cuevasdeayllon.entity.Estados;

@Repository
public class EstadosRepositoryImpl implements EstadosRepository{
	
	@Autowired
	EstadosJpaRepository repository;

	@Override
	public void guardarEstado(Estados estado) {
		repository.save(estado);
		
	}

	@Override
	public void actualizarEstado(Estados estado) {
		
		
		
		repository.save(estado);
		
	}

	@Override
	public Estados findById(int idEstado) {
		// TODO Auto-generated method stub
		return repository.findById(idEstado).orElse(null);
	}

	@Override
	public Estados findByIdPropuesta(int idPropuesta) {
		// TODO Auto-generated method stub
		return repository.findByIdPropuesta(idPropuesta);
	}

}

package com.cuevasdeayllon.repository;

import com.cuevasdeayllon.entity.Estados;

public interface EstadosRepository {
	
	
	void guardarEstado(Estados estado);
	
	
	void actualizarEstado(Estados estado);
	
	Estados findById(int idEstado);
	
	Estados findByIdPropuesta(int idPropuesta);
	
	
	
	
	

}

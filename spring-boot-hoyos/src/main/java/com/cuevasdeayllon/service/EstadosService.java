package com.cuevasdeayllon.service;

import com.cuevasdeayllon.entity.Estados;

public interface EstadosService {
	
	void guardarEstado(Estados estado);
	
	void actualizarEstado(Estados estado);
	
	Estados findByIdPropuesta(int idPropuesta);

}

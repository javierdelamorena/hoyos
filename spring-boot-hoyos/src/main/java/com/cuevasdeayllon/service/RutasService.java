package com.cuevasdeayllon.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cuevasdeayllon.entity.Enlaces;
import com.cuevasdeayllon.entity.Rutas;

public interface RutasService {
	void salvarRutas(Rutas ruta, MultipartFile file1, MultipartFile file2, MultipartFile file3, MultipartFile file4,
			MultipartFile file5);
	
	
	
	void editarRutas(Rutas ruta, MultipartFile file1, MultipartFile file2, MultipartFile file3, MultipartFile file4,
			MultipartFile file5);

	void borrarRutas(int idRuta);

	List<Rutas> todasLasRutas();

	Rutas unRutas(int idRutas);
}

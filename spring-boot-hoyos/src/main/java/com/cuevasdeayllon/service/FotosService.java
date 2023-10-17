package com.cuevasdeayllon.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

import com.cuevasdeayllon.entity.Fotos;
import com.cuevasdeayllon.entity.Usuario;

public interface FotosService {
	
	public List<Fotos> todasLasFotos();
	
	void salvarFoto(Fotos foto);
	
	void deleteFoto( String foto, String email,Usuario usuario,int idFotos);
	
	Page<Fotos> fotosPaginas(Pageable page);
	
	public List<Fotos> todasByIdUsuario(int idUsuario);
	
	Fotos fotoByIdUsuario(int idUsuario);
	
	Fotos fotoById(int idFotos);

}

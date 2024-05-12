package com.cuevasdeayllon.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cuevasdeayllon.entity.Fotos;
import com.cuevasdeayllon.entity.Usuario;
import com.cuevasdeayllon.repository.FotosJpaRepository;

@Service
public class FotosServiceImpl implements FotosService {

	@Autowired
	FotosJpaRepository fotosJpaRepository;
	//static final String ROOT_PATH = "D://TEMP//uploadsGaleria";
	static final String ROOT_PATH = "/uploadsGaleria";

	public List<Fotos> todasLasFotos() {

		return fotosJpaRepository.findAll();

	}

	@Override
	public void salvarFoto(Fotos foto) {

		fotosJpaRepository.save(foto);

	}

	@Override
	public void deleteFoto(String foto, String email, Usuario usuario, int idFotos) {
		Fotos fotos = new Fotos();
		

		if (foto != null) {

			fotos.setFotos(foto);
			fotos.setUsuario(usuario);
			fotos.setIdFotos(idFotos);
			try {
				Path rutaCompletaImagen = Paths.get(ROOT_PATH+ "//" + fotos.getFotos());

				Files.deleteIfExists(rutaCompletaImagen);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			fotosJpaRepository.delete(fotos);

		}

	}

	@Override
	public Page<Fotos> fotosPaginas(Pageable page) {

		return fotosJpaRepository.findAllPage(page);
	}

	@Override
	public List<Fotos> todasByIdUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return fotosJpaRepository.findAllByIdUsuario(idUsuario);
	}

	@Override
	public Fotos fotoByIdUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return fotosJpaRepository.findByIdUsuario(idUsuario);
	}

	@Override
	public Fotos fotoById(int idFotos) {
		// TODO Auto-generated method stub
		return fotosJpaRepository.getById(idFotos);
	};

}

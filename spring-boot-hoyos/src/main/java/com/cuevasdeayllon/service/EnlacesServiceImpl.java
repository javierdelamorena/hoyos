package com.cuevasdeayllon.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cuevasdeayllon.entity.Enlaces;
import com.cuevasdeayllon.repository.EnlacesJpaRepository;

@Service
public class EnlacesServiceImpl implements EnlacesService {

	static final String ROOT_PATH = "D://TEMP//uploadsEnlaces";
	// static final String ROOT_PATH = "/uploadsEnlaces";

	@Autowired
	EnlacesJpaRepository enlacesJpaRepository;

	@Override
	public void salvarEnlace(Enlaces enlaces, MultipartFile file1, MultipartFile file2) {

		Enlaces enlace = new Enlaces();

		enlace.setNombre(enlaces.getNombre());
		enlace.setApellidos(enlaces.getApellidos());
		enlace.setDireccion(enlaces.getDireccion());
		enlace.setTelefono(enlaces.getTelefono());
		enlace.setEnlaceweb(enlaces.getEnlaceweb());
		enlace.setTexto1(enlaces.getTexto1());
		enlace.setTexto2(enlaces.getTexto2());
		enlace.setTexto3(enlaces.getTexto3());

		if (!file1.isEmpty()) {

			try {
				byte[] bytes = file1.getBytes();
				Path rutaCompleta = Paths.get(ROOT_PATH + "//" + file1.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				String extension1 = FilenameUtils.getExtension(file1.getOriginalFilename());

				//if (extension1.equals("jpg") || extension1.equals("png")) {
					enlace.setFoto1(file1.getOriginalFilename());
				//}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (!file2.isEmpty()) {

			try {
				byte[] bytes = file2.getBytes();
				Path rutaCompleta = Paths.get(ROOT_PATH + "//" + file2.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				String extension2 = FilenameUtils.getExtension(file2.getOriginalFilename());

				//if (extension2.equals("jpg") || extension2.equals("png")) {
					enlace.setFoto2(file1.getOriginalFilename());
				//}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		enlacesJpaRepository.save(enlace);
	}

	@Override
	public void borrarEnlace(int idEnlaces) {
		enlacesJpaRepository.deleteById(idEnlaces);
	}

	@Override
	public List<Enlaces> todosLosElaces() {

		return enlacesJpaRepository.findAll();
	}

	@Override
	public Enlaces unEnlace(int idEnlaces) {

		return enlacesJpaRepository.getById(idEnlaces);
	}

}

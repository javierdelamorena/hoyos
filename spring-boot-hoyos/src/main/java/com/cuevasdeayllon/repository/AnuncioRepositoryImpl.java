package com.cuevasdeayllon.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.mail.Multipart;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.cuevasdeayllon.entity.Anuncios;

@Repository
public class AnuncioRepositoryImpl implements AnunciosRepository {

	@Autowired
	private AnuncioJpaRepository anuncioJpaRepository;

	@Override
	public void insertarAnucio(String anuncio, String titulo, MultipartFile file) {
		String rootPath = "C://TEMP//uploadsAnuncios";

		int oraLen = file.getOriginalFilename().length();

		Anuncios anuncioeditable = new Anuncios();
		anuncioeditable.setIdAnuncios(0);
		anuncioeditable.setAnuncio(anuncio);
		anuncioeditable.setFecha(new Date());
		anuncioeditable.setTitulo_anuncio(titulo);
		if (!file.isEmpty()) {

			try {
				byte[] bytes = file.getBytes();
				Path rutaCompleta = Paths.get(rootPath + "//" + file.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				String extension = FilenameUtils.getExtension(file.getOriginalFilename());
				if (extension.equals("mp4")) {
					anuncioeditable.setVideo_anuncio(file.getOriginalFilename());

				} else if (extension.equals("jpg") || extension.equals("png")) {
					anuncioeditable.setFoto_anuncio(file.getOriginalFilename());
				} else {
					anuncioeditable.setAudio_anuncio(file.getOriginalFilename());

				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}
		anuncioJpaRepository.save(anuncioeditable);

	}

	@Override
	public Anuncios recuperarAnuncio(int idAnuncio) {

		return anuncioJpaRepository.findById(idAnuncio).orElse(null);
	}

	@Override
	public void deleteAnuncio(int idAnuncio) {

		anuncioJpaRepository.deleteById(idAnuncio);

	}

	@Override
	public void editarAnuncio(Anuncios anuncioeditable, String anuncio, String titulo, String fecha,
			MultipartFile file) {
		// String rootPath="/uploadsAnuncios/";
		String rootPath = "C://TEMP//uploadsAnuncios";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date fechaConvertida = null;
		try {
			Date parsed = dateFormat.parse(fecha);
			fechaConvertida = new java.sql.Date(parsed.getTime());
		} catch (Exception e) {
			System.out.println("Error occurred" + e.getMessage());
		}

		anuncioeditable.setIdAnuncios(anuncioeditable.getIdAnuncios());
		anuncioeditable.setAnuncio(anuncio);
		anuncioeditable.setFecha(fechaConvertida);
		anuncioeditable.setTitulo_anuncio(titulo);
		if (!file.isEmpty()) {

			try {
				byte[] bytes = file.getBytes();
				Path rutaCompleta = Paths.get(rootPath + "//" + file.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				String extension = FilenameUtils.getExtension(file.getOriginalFilename());
				if (extension.equals("mp4")) {
					anuncioeditable.setVideo_anuncio(file.getOriginalFilename());

				} else if (extension.equals("jpg") || extension.equals("png")) {
					anuncioeditable.setFoto_anuncio(file.getOriginalFilename());
				} else {
					anuncioeditable.setAudio_anuncio(file.getOriginalFilename());

				}

			} catch (IOException e) {

				e.printStackTrace();
			}

		}

		anuncioJpaRepository.save(anuncioeditable);

	}

	@Override
	public List<Anuncios> listAnuncio() {

		return anuncioJpaRepository.findAll();
	}

}

package com.cuevasdeayllon.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
	public void insertarAnucio(Anuncios anuncio,MultipartFile file)  {
		String rootPath="C://TEMP//uploadsAnuncios";
		//String rootPath="/uploadsAnuncios/";
		Anuncios anuncioeditable=new Anuncios();
		anuncioeditable.setIdAnuncios(0);
		anuncioeditable.setAnuncio(anuncio.getAnuncio());
		anuncioeditable.setFecha(new Date());		
		anuncioeditable.setTitulo_anuncio(anuncio.getTitulo_anuncio());

		if(!file.isEmpty()) {


			try {
				byte[]bytes=file.getBytes();
				Path rutaCompleta=Paths.get(rootPath+"//"+file.getOriginalFilename().toString().trim());
				Files.write(rutaCompleta,bytes);
				String extension = FilenameUtils.getExtension(file.getOriginalFilename());
				if(extension.equals("mp4")) {
					anuncioeditable.setVideo_anuncio(file.getOriginalFilename());
					
				}else {
					anuncioeditable.setFoto_anuncio(file.getOriginalFilename());
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			anuncioJpaRepository.save(anuncioeditable);

		}
		else {

			anuncioeditable.setFoto_anuncio(null);
			anuncioJpaRepository.save(anuncioeditable);



		}


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
	public void editarAnuncio(int idAnuncio ,Anuncios anuncio) {
		
		Anuncios anuncioeditable=new Anuncios();
		anuncioeditable.setAnuncio(anuncio.getAnuncio());
		anuncioeditable.setFecha(anuncio.getFecha());
		anuncioeditable.setIdAnuncios(anuncio.getIdAnuncios());
		anuncioeditable.setTitulo_anuncio(anuncio.getTitulo_anuncio());
		anuncioeditable.setFoto_anuncio(anuncio.getFoto_anuncio());

		anuncioJpaRepository.save(anuncioeditable);

	}

	@Override
	public List<Anuncios> listAnuncio() {

		return anuncioJpaRepository.findAll();
	}




}

package com.cuevasdeayllon.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cuevasdeayllon.entity.Rutas;
import com.cuevasdeayllon.repository.RutasJpaRepository;

@Service
public class RutasServiceImpl implements RutasService {

	static final String ROOT_PATH = "D://TEMP//imagenesRutas/hoyos";
	// static final String ROOT_PATH = "/imagenesRutas/hoyos";

	@Autowired
	private RutasJpaRepository rutasJpaRepository;

	@Override
	public void salvarRutas(Rutas rutas, MultipartFile file1, MultipartFile file2, MultipartFile file3,
			MultipartFile file4, MultipartFile file5) {
		Rutas ruta = new Rutas();
		if (rutas.getNombre() != null) {
			ruta.setNombre(rutas.getNombre());
		}
		if (rutas.getTexto1() != null) {
			ruta.setTexto1(rutas.getTexto1());
		}
		if (rutas.getTexto2() != null) {
			ruta.setTexto2(rutas.getTexto2());
		}
		if (rutas.getTexto3() != null) {
			ruta.setTexto3(rutas.getTexto3());
		}
		if (rutas.getTexto4() != null) {
			ruta.setTexto4(rutas.getTexto4());
		}
		if (rutas.getTexto5() != null) {
			ruta.setTexto5(rutas.getTexto5());
		}
		if (!file1.isEmpty()) {
			try {
				byte[] bytes = file1.getBytes();
				Path rutaCompleta = Paths.get(ROOT_PATH + "//" + file1.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				ruta.setFoto1(file1.getOriginalFilename());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (!file2.isEmpty())

		{
			try {
				byte[] bytes = file2.getBytes();
				Path rutaCompleta = Paths.get(ROOT_PATH + "//" + file2.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				ruta.setFoto2(file2.getOriginalFilename());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (!file3.isEmpty()) {

			try {
				byte[] bytes = file3.getBytes();
				Path rutaCompleta = Paths.get(ROOT_PATH + "//" + file3.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				ruta.setFoto3(file3.getOriginalFilename());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (!file4.isEmpty()) {
			try {
				byte[] bytes = file4.getBytes();
				Path rutaCompleta = Paths.get(ROOT_PATH + "//" + file4.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				ruta.setFoto4(file4.getOriginalFilename());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (!file5.isEmpty()) {

			try {
				byte[] bytes = file5.getBytes();
				Path rutaCompleta = Paths.get(ROOT_PATH + "//" + file5.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				ruta.setFoto5(file5.getOriginalFilename());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		rutasJpaRepository.save(ruta);

	}

	@Override
	public void editarRutas(Rutas rutas, MultipartFile file1, MultipartFile file2, MultipartFile file3,
			MultipartFile file4, MultipartFile file5) {
		Rutas ruta = new Rutas();

		if (rutas.getId() > 0) {

			ruta.setId(rutas.getId());

		

		if (rutas.getNombre() != null) {
			ruta.setNombre(rutas.getNombre());
		}
		if (rutas.getTexto1() != null) {
			ruta.setTexto1(rutas.getTexto1());
		}
		if (rutas.getTexto2() != null) {
			ruta.setTexto2(rutas.getTexto2());
		}
		if (rutas.getTexto3() != null) {
			ruta.setTexto3(rutas.getTexto3());
		}
		if (rutas.getTexto4() != null) {
			ruta.setTexto4(rutas.getTexto4());
		}
		if (rutas.getTexto5() != null) {
			ruta.setTexto5(rutas.getTexto5());
		}
		if (!file1.isEmpty()) {
			try {
				byte[] bytes = file1.getBytes();
				Path rutaCompleta = Paths.get(ROOT_PATH + "//" + file1.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				ruta.setFoto1(file1.getOriginalFilename());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (!file2.isEmpty())

		{
			try {
				byte[] bytes = file2.getBytes();
				Path rutaCompleta = Paths.get(ROOT_PATH + "//" + file2.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				ruta.setFoto2(file2.getOriginalFilename());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (!file3.isEmpty()) {

			try {
				byte[] bytes = file3.getBytes();
				Path rutaCompleta = Paths.get(ROOT_PATH + "//" + file3.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				ruta.setFoto3(file3.getOriginalFilename());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (!file4.isEmpty()) {
			try {
				byte[] bytes = file4.getBytes();
				Path rutaCompleta = Paths.get(ROOT_PATH + "//" + file4.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				ruta.setFoto4(file4.getOriginalFilename());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (!file5.isEmpty()) {

			try {
				byte[] bytes = file5.getBytes();
				Path rutaCompleta = Paths.get(ROOT_PATH + "//" + file5.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				ruta.setFoto5(file5.getOriginalFilename());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		rutasJpaRepository.save(ruta);
		
		}

	}

	@Override
	public void borrarRutas(int idRuta) {
		Rutas ruta = rutasJpaRepository.findById(idRuta).orElse(null);

		try {
			Path rutaCompletaImagen1 = Paths.get(ROOT_PATH + "//" + ruta.getFoto1());
			Files.deleteIfExists(rutaCompletaImagen1);
			Path rutaCompletaImagen2 = Paths.get(ROOT_PATH + "//" + ruta.getFoto2());
			Files.deleteIfExists(rutaCompletaImagen2);
			Path rutaCompletaImagen3 = Paths.get(ROOT_PATH + "//" + ruta.getFoto3());
			Files.deleteIfExists(rutaCompletaImagen3);
			Path rutaCompletaImagen4 = Paths.get(ROOT_PATH + "//" + ruta.getFoto4());
			Files.deleteIfExists(rutaCompletaImagen4);
			Path rutaCompletaImagen5 = Paths.get(ROOT_PATH + "//" + ruta.getFoto5());
			Files.deleteIfExists(rutaCompletaImagen5);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		rutasJpaRepository.deleteById(idRuta);

	}

	@Override
	public List<Rutas> todasLasRutas() {
		// TODO Auto-generated method stub
		return rutasJpaRepository.findAll();
	}

	@Override
	public Rutas unRutas(int idRutas) {
		// TODO Auto-generated method stub
		return rutasJpaRepository.findById(idRutas).orElse(null);
	}

}

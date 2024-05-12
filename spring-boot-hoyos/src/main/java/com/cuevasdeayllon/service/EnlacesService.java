package com.cuevasdeayllon.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cuevasdeayllon.entity.Enlaces;

public interface EnlacesService {
	
	void salvarEnlace(Enlaces enlaces,MultipartFile file1,MultipartFile file2);
	void editarEnlace(Enlaces enlaces,MultipartFile file1,MultipartFile file2);
	void borrarEnlace(int idEnlaces);
	List<Enlaces> todosLosElaces();
	Enlaces unEnlace(int idEnlaces);
	

}

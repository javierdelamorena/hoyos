package com.cuevasdeayllon.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cuevasdeayllon.entity.Mercadillo;

public interface MercadilloRepository {
	
	
	List<Mercadillo> todosLosMercadillos();
	
	Page<Mercadillo> todasPaginasMercadillo(Pageable page);
	
	List<Mercadillo> todosLosMercadillosiIdUsuario(int idUsuario);
	
	Mercadillo findById(int id);
	
	
	Mercadillo findByTipoServicio(String tipoServicio);
	
	List<Mercadillo> findByTipo_servicio(String tipo_servicio);
	
	List<Mercadillo> findByTipoServicioPrecioMax(String tipo_servicio,int precioMax);
	List<Mercadillo> findByTipoServicioPrecioMin(String tipo_servicio,int precioMin);
	Page<Mercadillo> findPaginaByTipo_servicio(Pageable page,String tipo_servicio);
	Page<Mercadillo> findPaginaByNombre_servicio(Pageable page,String nombre_servicio);
	List<Mercadillo> findByTipoServicioPrecioMaxMin(String tipo_servicio,int precioMin ,int precioMax);
	Page<Mercadillo> findPaginasByTipoServicioPrecioMax(Pageable page,String tipo_servicio,int precioMax);
	Page<Mercadillo> findPaginasByTipoServicioPrecioMin(Pageable page,String tipo_servicio,int precioMin);
	Page<Mercadillo> findPaginasByTipoServicioPrecioMaxMin(Pageable page,String tipo_servicio,int precioMin ,int precioMax);
	
	void insertarMercadillo(Mercadillo mercadillo);
	
	
	void borrarMercadillo(int id);
	
	void actualizarMercadillo(Mercadillo mercadillo);

}

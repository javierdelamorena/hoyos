package com.cuevasdeayllon.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cuevasdeayllon.entity.Mercadillo;

@Repository
public class MercadilloRepositoryImpl implements MercadilloRepository {
	
	@Autowired
	private MercadilloJpaRepository mercadilloJpaRepository;
	
	@Override
	@Transactional(readOnly=true)
	public List<Mercadillo> todosLosMercadillos() {
		
		
		
		return mercadilloJpaRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Mercadillo findById(int id) {
		
		return mercadilloJpaRepository.findById(id).orElse(null);
	}

	
	@Override
	@Transactional(readOnly=true)
	public Mercadillo findByTipoServicio(String tipoServicio) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public void insertarMercadillo(Mercadillo mercadillo) {
		Mercadillo merdado=new Mercadillo();
		merdado.setId_usuario(mercadillo.getId_usuario());
		merdado.setNombre(mercadillo.getNombre());
		merdado.setTelefono(mercadillo.getTelefono());
		merdado.setNombre_servicio(mercadillo.getNombre_servicio().trim());
		merdado.setTipo_servicio(mercadillo.getTipo_servicio().trim());
		merdado.setPrecio(mercadillo.getPrecio());
		merdado.setTexto(mercadillo.getTexto());
		merdado.setFoto1(mercadillo.getFoto1());
		merdado.setFoto2(mercadillo.getFoto2());
		merdado.setFoto3(mercadillo.getFoto3());
		merdado.setFecha(new Date());
		
		
		
		mercadilloJpaRepository.save(merdado);
		
	}

	@Override
	public void borrarMercadillo(int id) {
		Mercadillo mercadillo=	this.findById(id);
		mercadilloJpaRepository.delete(mercadillo);
		
	}
	
	@Override
	@Transactional
	public void actualizarMercadillo(Mercadillo mercadillo) {
		Mercadillo mercado =new Mercadillo();
		
//		mercado.setId(mercadillo.getId());
//		mercado.setNombre(mercadillo.getNombre());
//		mercado.setPrecio(mercadillo.getPrecio());
//		mercado.setTelefono(mercadillo.getTelefono());
//		mercado.setId_usuario(mercadillo.getId_usuario());
//		mercado.setTipo_servicio(mercadillo.getTipo_servicio());
//		mercado.setTexto(mercadillo.getTexto());
//		mercado.setFoto1(mercadillo.getFoto1());
//		mercado.setFoto2(mercadillo.getFoto2());
//		mercado.setFoto3(mercadillo.getFoto3());
//		mercado.setFecha(new Date());
//		mercado.setNombre_servicio(mercadillo.getNombre_servicio());
		
		
		mercadilloJpaRepository.save(mercadillo);
		
		
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Mercadillo> todosLosMercadillosiIdUsuario(int idUsuario) {
		
		return mercadilloJpaRepository.findByIdUsuario(idUsuario);
	}

	@Override
	public List<Mercadillo> findByTipo_servicio(String tipo_servicio) {
		// TODO Auto-generated method stub
		return mercadilloJpaRepository.findByTipo_servicio(tipo_servicio);
	}

	@Override
	public List<Mercadillo> findByTipoServicioPrecioMax(String tipo_servicio, int precioMax) {
		
		return mercadilloJpaRepository.findByTipo_servicioPreciMax(tipo_servicio, Double.valueOf(precioMax));
	}

	@Override
	public List<Mercadillo> findByTipoServicioPrecioMin(String tipo_servicio, int precioMin) {
		// TODO Auto-generated method stub
		return mercadilloJpaRepository.findByTipo_servicioPreciMin(tipo_servicio, Double.valueOf(precioMin));
	}

	@Override
	public List<Mercadillo> findByTipoServicioPrecioMaxMin(String tipo_servicio,int precioMin ,int precioMax) {
		// TODO Auto-generated method stub
		return mercadilloJpaRepository.findByTipo_servicioPreciMaxMin(tipo_servicio, Double.valueOf(precioMin), Double.valueOf(precioMax));
	}

	@Override
	public Page<Mercadillo> todasPaginasMercadillo(Pageable page) {
		// TODO Auto-generated method stub
		return mercadilloJpaRepository.findAll(page);
	}

	@Override
	public Page<Mercadillo> findPaginasByTipoServicioPrecioMax(Pageable page,String tipo_servicio, int precioMax) {
		// TODO Auto-generated method stub
		return mercadilloJpaRepository.findPaginaByTipo_servicioPreciMax(page,tipo_servicio, precioMax);
	}

	@Override
	public Page<Mercadillo> findPaginasByTipoServicioPrecioMin(Pageable page,String tipo_servicio, int precioMin) {
		// TODO Auto-generated method stub
		return mercadilloJpaRepository.findPaginaByTipo_servicioPreciMin(page,tipo_servicio, precioMin);
	}

	@Override
	public Page<Mercadillo> findPaginasByTipoServicioPrecioMaxMin(Pageable page,String tipo_servicio, int precioMin, int precioMax) {
		// TODO Auto-generated method stub
		return mercadilloJpaRepository.findPaginaByTipo_servicioPreciMaxMin(page,tipo_servicio, precioMin, precioMax);
	}

	@Override
	public Page<Mercadillo> findPaginaByTipo_servicio(Pageable page, String tipo_servicio) {
		// TODO Auto-generated method stub
		return mercadilloJpaRepository.findPaginaByTipo_servicio(page, tipo_servicio);
	}

}

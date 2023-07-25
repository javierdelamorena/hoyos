package com.cuevasdeayllon.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cuevasdeayllon.dto.EstadosPropuestas;
import com.cuevasdeayllon.entity.Propuestas;

public interface PropuestaJpaRepository extends JpaRepository<Propuestas, Integer>{
	
	
	@Query("select e from Propuestas e where id_Propuesta=?1 and activa='si'")
	Propuestas findById(int idPropuesta);
	
	@Query("select e from Propuestas e where propuesta=?1 and activa='si'")
	Propuestas findById(String  propuesta);
	
	Propuestas findByTitulo(String titulo);
	
	@Query("select e from Propuestas e where id_usuario=?1 and activa='si'")
	List<Propuestas> findById_Uusuario(int id_usuario);
	

	
	@Query("select e from Propuestas e where  activa='si'")
	List<Propuestas> findTodas();
	
	
	String query="slect * from propuestas p inner join usuarios u on p.id_usuario=u.id_usuario";
	@Query(value=query,nativeQuery = true)
	List<Propuestas> findTodasQ();
	
	

}

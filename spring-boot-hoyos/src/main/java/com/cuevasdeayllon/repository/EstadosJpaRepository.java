package com.cuevasdeayllon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cuevasdeayllon.entity.Estados;

public interface EstadosJpaRepository extends JpaRepository<Estados,Integer>{
	
	
	@Query("select e from Estados e where id_propuesta=?1")
	Estados findByIdPropuesta(int idPropuesta);

}

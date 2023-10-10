package com.back.crud.repository;

import com.back.crud.entity.Persona;
import org.springframework.data.repository.Repository;
import java.util.List;

public interface ProductoRepository extends Repository<Persona, Integer>{

	List<Persona>findAll();
	Persona findById(int id);
	Persona save(Persona p);
	void delete(Persona p);
	
}

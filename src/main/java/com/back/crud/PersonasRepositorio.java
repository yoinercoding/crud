package com.back.crud;

import org.springframework.data.repository.Repository;
import java.util.List;

public interface PersonasRepositorio extends Repository<Personas, Integer>{

	List<Personas>findAll();
	Personas findById(int id);
	Personas save(Personas p);
	void delete(Personas p);
	
}

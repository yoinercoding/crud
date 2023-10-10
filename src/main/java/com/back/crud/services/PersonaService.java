package com.back.crud.services;
import java.util.List;
import com.back.crud.entity.Persona;
public interface ProductoService {

	List<Persona>listar();
	Persona listarId(int id);
	Persona add(Persona p);
	Persona edit(Persona p);
	Persona delete(int id);
}

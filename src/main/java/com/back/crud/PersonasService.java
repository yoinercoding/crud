package com.back.crud;
import java.util.List;
import org.springframework.stereotype.Service;


public interface PersonasService {

	List<Personas>listar();
	Personas listarId(int id);
	Personas add(Personas p);
	Personas edit(Personas p);
	Personas delete(int id);
}

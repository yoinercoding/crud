package com.back.crud.services;

import java.util.List;
import java.util.Optional;

import com.back.crud.entity.Persona;
import com.back.crud.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImp implements PersonaService {
	
	@Autowired
	private PersonaRepository repository;

    @Override
	public List<Persona> listar() {
		return repository.findAll();
	}

	@Override
    public Persona listarId(int id) {
        Optional<Persona> persona = Optional.ofNullable(repository.findById(id));
        if (persona.isPresent()) {
            return persona.get();
        }
        throw new RuntimeException("Persona no encontrada por id" + id);
    }

    @Override
    public Persona add(Persona p) {
        return repository.save(p);
    }

    @Override
    public Persona edit(Persona p) {
        return repository.save(p);
    }

    @Override
    public Persona delete(int id) {
        Persona p=repository.findById(id);
        if(p!=null){
        	repository.delete(p);
        }
       return p;
    }
}

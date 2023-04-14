package com.back.crud;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImp implements PersonasService {
	
	@Autowired
	private PersonasRepositorio repository;
	
	@Override
	public List<Personas> listar() {
		return repository.findAll();
	}

	@Override
    public Personas listarId(int id) {
        return repository.findById(id);
    }

    @Override
    public Personas add(Personas p) {
        return repository.save(p);
    }

    @Override
    public Personas edit(Personas p) {
        return repository.save(p);
    }

    @Override
    public Personas delete(int id) {
        Personas p=repository.findById(id);
        if(p!=null){
        	repository.delete(p);
        }
       return p;
    }
    
	
}

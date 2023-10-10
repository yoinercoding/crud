package com.back.crud.services;

import java.util.List;
import com.back.crud.entity.Persona;
import com.back.crud.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImp implements ProductoService {
	
	@Autowired
	private ProductoRepository repository;

    public static List<Persona> getAllProducto() {
        return getAllProducto();
    }

    @Override
	public List<Persona> listar() {
		return repository.findAll();
	}

	@Override
    public Persona listarId(int id) {
        return repository.findById(id);
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

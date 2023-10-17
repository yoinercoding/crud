package com.back.crud.controller;

import java.util.List;
import com.back.crud.entity.Persona;
import com.back.crud.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Controller {
	
	@Autowired
    PersonaService service;
	
	@GetMapping("/api/person")
	private List<Persona>getAllPersona() {
        return service.listar();
	}
	
	@PostMapping("/api/person/add")
    public Persona agregar(@RequestBody Persona p){
        return service.add(p);
    }

    @GetMapping({"/api/person/id"})
    public Persona listarId(@Param("id") int id){
        return service.listarId(id);
    }
    @PutMapping({"/api/person/edit"})
    public Persona editar(@RequestBody Persona p, @Param("id") int id){
        p.setId(id);
        return service.edit(p);
    }

    @DeleteMapping({"/api/person/delete"})
    public Persona delete(@Param("id") int  id){
        return service.delete(id);
    }
}

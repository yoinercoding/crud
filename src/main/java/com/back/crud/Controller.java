package com.back.crud;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/personas"})
public class Controller {
	
	@Autowired
	PersonasService service;
	
	@GetMapping("/personas")
	public List<Personas>listar() {
		return service.listar();
	}
	
	@PostMapping("/agregar")
    public Personas agregar(@RequestBody Personas p){
        return service.add(p);
    }
    @GetMapping(path = {"/{id}"})
    public Personas listarId(@PathVariable("id")int id){
        return service.listarId(id);
    }
    @PutMapping(path = {"/{id}"})
    public Personas editar(@RequestBody Personas p,@PathVariable("id") int id){
        p.setId(id);
        return service.edit(p);
    }
    @DeleteMapping(path = {"/{id}"})
    public Personas delete(@PathVariable("id") int  id){
        return service.delete(id);
    }
    
}

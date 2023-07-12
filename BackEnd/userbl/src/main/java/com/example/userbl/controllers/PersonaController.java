package com.example.userbl.controllers;

import com.example.userbl.models.Persona;
import com.example.userbl.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping()
    public ArrayList<Persona> obtenerPersonas(){
        return personaService.obtenerPersonas();
    }

    @PostMapping()
    public Persona guardarPersona(@RequestBody Persona persona){
        return this.personaService.guardarPersona(persona);
    }

    @GetMapping(path = {"/{id}"})
    public Optional<Persona> obtenerPorId(@PathVariable("id")Long id){
        return this.personaService.obtenerPorId(id);
    }

    @PutMapping(path = {"/{id}"})
    public Persona editarPersona(@RequestBody Persona persona,@PathVariable("id")Long id){
        persona.setId(id);
        return this.personaService.editarPersona(persona);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id")Long id){
        boolean ok=this.personaService.eliminarPersona(id);
        if (ok){
            return "eliminado";
        }else {
            return "no eliminado" ;
        }
    }
}

package com.example.userbl.services;

import com.example.userbl.models.Persona;
import com.example.userbl.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PersonaService {
    @Autowired
    PersonaRepository personaRepository;

    public ArrayList<Persona> obtenerPersonas(){

        return (ArrayList<Persona>) personaRepository.findAll();
    }

    public Persona guardarPersona(Persona persona){

        return personaRepository.save(persona);
    }

    public Optional<Persona> obtenerPorId(Long id){

        return personaRepository.findById(id);
    }

    public Persona editarPersona(Persona persona){

        return personaRepository.save(persona);
    }

    public boolean eliminarPersona(Long id){
        try {
            personaRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}

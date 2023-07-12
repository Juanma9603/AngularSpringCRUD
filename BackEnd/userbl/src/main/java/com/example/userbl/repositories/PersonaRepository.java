package com.example.userbl.repositories;

import com.example.userbl.models.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PersonaRepository extends CrudRepository<Persona,Long> {

}

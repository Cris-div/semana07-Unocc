package com.tecsup.model.daos;

import com.tecsup.model.entities.Curso;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CursoRepository extends CrudRepository<Curso,Integer> {
    List<Curso> findByNombreContainingIgnoreCase(String nombre);
}

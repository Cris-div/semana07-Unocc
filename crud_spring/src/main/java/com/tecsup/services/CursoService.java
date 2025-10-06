package com.tecsup.services;

import com.tecsup.model.entities.Curso;

import java.util.List;

public interface CursoService {
    List<Curso> findByNombre(String nombre);
    public List<Curso> findAllCourse();
    public Curso findById(Integer id);
    public void saveCourse(Curso curso);
    public void deleteCourse(Integer id);

}

package com.tecsup.services;

import com.tecsup.model.daos.CursoRepository;
import com.tecsup.model.entities.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository dao;
    @Override
    public List<Curso> findAllCourse() {
        return (List<Curso>) dao.findAll() ;
    }

    @Override
    public Curso findById(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public void saveCourse(Curso curso) {
        dao.save(curso);
    }

    @Override
    public void deleteCourse(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public Object findByNombre(String nombre) {
        return null;
    }
}

package com.tecsup.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="curso")
public class Curso {
    @Id
    @NotNull
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column
    @NotNull
    private String nombre;
    @Column
    @NotNull
    private String creditos;
    public Curso() {

    }

    public Curso(int id, String nombre, String creditos) {
        this.id = id;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCreditos() {
        return creditos;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }

    @Override
    public String toString() {
        return "Curso{"+
                "id="+ id +
                ", nombre='" + nombre +'\'' +
                ", creditos=" + creditos +
                '}';
    }
}

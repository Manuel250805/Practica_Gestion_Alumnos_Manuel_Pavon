package com.example.interfaz;

import java.util.List;

import com.example.modelo.Alumno;

public interface AlumnoInterfaz {

    void insertar(Alumno alumno);

    List<Alumno> listar();
}

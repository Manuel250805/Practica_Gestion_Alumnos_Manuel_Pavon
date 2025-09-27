package com.example.controlador;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.modelo.Alumno;
import com.example.modelo.AlumnoModelo;

public class AlumnoTest {

    private Alumno alumno;
    private AlumnoControlador controlador;

    @BeforeEach
    void setUp() {
        alumno = new Alumno("Manuel", "Pavon", 20);
        AlumnoModelo modelo = new AlumnoModelo();
        controlador = new AlumnoControlador(modelo);
    }

    @Test
    void insertar() {
        // Llamada correcta al método existente
        controlador.agregarAlumno("Manuel", "Pavon", 20);

        // Verificamos que se haya agregado
        List<Alumno> alumnos = controlador.obtenerAlumnos();
        assertEquals(1, alumnos.size());
        assertEquals("Manuel", alumnos.get(0).getNombre());
        assertEquals("Pavon", alumnos.get(0).getApellido());
        assertEquals(20, alumnos.get(0).getEdad());
    }

    @Test
    void insertarAlumnoInvalido() {
        var ex = assertThrows(IllegalArgumentException.class, () -> {
            controlador.agregarAlumno("", "Pavon", 20);
        });
        List<Alumno> alumnos = controlador.obtenerAlumnos();
        assertEquals(0, alumnos.size(), ex.getMessage());
    }

    @Test
    void insertarAlumnoConEdadNegativa() {
        var ex = assertThrows(IllegalArgumentException.class, () -> {
            controlador.agregarAlumno("Manuel", "Pavon", -5);
        });
        assertEquals("Datos del alumno inválidos", ex.getMessage());
    }

    @Test
    void insertarAlumnoConCamposVacios() {
        var ex = assertThrows(IllegalArgumentException.class, () -> {
            controlador.agregarAlumno("", "", 0);
        });
        assertEquals("Datos del alumno inválidos", ex.getMessage());
    }
}

package com.example.controlador;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.interfaz.AlumnoInterfaz;
import com.example.modelo.Alumno;

@ExtendWith(MockitoExtension.class) //  Esto activa Mockito solo en esta clase
public class AlumnoControladorTest {

    @Mock
    AlumnoInterfaz mockModelo; //  El modelo es simulado

    @InjectMocks
    AlumnoControlador controlador; //  Se prueba el controlador real

    @Test
    void testObtenerAlumnosConMock() {
        Alumno alumno = new Alumno("Juan", "Pérez", 20);

        // Simulamos la respuesta del "modelo"
        when(mockModelo.listar()).thenReturn(Arrays.asList(alumno));

        // Llamamos al método del controlador
        List<Alumno> resultado = controlador.obtenerAlumnos();

        // Comprobaciones
        assertEquals(1, resultado.size());
        assertEquals("Juan", resultado.get(0).getNombre());

        // Verificamos que el mock fue usado
        verify(mockModelo).listar();
    }

    @Test
    void testAgregarAlumnoConMock() {
        // Llamamos al método del controlador
        controlador.agregarAlumno("Ana", "García", 22);
        // Verificamos que el mock fue usado
        verify(mockModelo).insertar(any(Alumno.class));
    }
}


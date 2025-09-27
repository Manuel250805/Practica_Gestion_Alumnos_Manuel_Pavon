package com.example.vista;

import java.util.List;
import java.util.Scanner;

import com.example.controlador.AlumnoControlador;
import com.example.modelo.Alumno;

public class AlumnoView {

    public static final int OPCION_INSERTAR_ALUMNO = 1;
    public static final int OPCION_LISTAR_ALUMNOS = 2;
    public static final int OPCION_SALIR = 3;
    private final Scanner scanner = new Scanner(System.in);
    private final AlumnoControlador controlador;

    public AlumnoView(AlumnoControlador controlador) {
        this.controlador = controlador;
    }

    private String pedirCampo(String campo) {
        System.out.println("Introduzca el " + campo + " del alumno:");
        return scanner.nextLine();
    }

    private int pedirEdad() {
        while (true) {
            String edadtexto = pedirCampo("edad");
            try {
                return Integer.parseInt(edadtexto);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número válido para la edad.");
            }
        }
    }

    public void insertarAlumno() {
        String nombre = pedirCampo("nombre");
        String apellido = pedirCampo("apellido");
        int edad = pedirEdad();
        while (true) {
            try {
                controlador.agregarAlumno(nombre, apellido, edad);
                System.out.println("Alumno agregado correctamente.");
                break; // salir del bucle
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                return;
            }

        }
    }

    public void listarAlumno() {
        List<Alumno> alumnos = controlador.obtenerAlumnos();
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos");
        } else {
            for (Alumno a1 : alumnos) {
                System.out.println(a1.toString());

            }
        }
    }

    private void mostrarMenu() {
        System.out.println(OPCION_INSERTAR_ALUMNO + ". Insertar Alumno");
        System.out.println(OPCION_LISTAR_ALUMNOS + ". Listar Alumno");
        System.out.println(OPCION_SALIR + ". Salir");
        System.out.println("Elige una opción:");
    }

    public void iniciar() {
        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            String opciontexto = scanner.nextLine();
            int opcion;
            try {
                opcion = Integer.parseInt(opciontexto);
            } catch (NumberFormatException e) {
                System.out.println("Opcion no valida, introduce un número");
                continue;
            }
            switch (opcion) {
                case OPCION_INSERTAR_ALUMNO:
                    insertarAlumno();
                    break;
                case OPCION_LISTAR_ALUMNOS:
                    listarAlumno();
                    break;
                case OPCION_SALIR:
                    System.out.println("Salir...");
                    continuar = false;
                    break;

                default:
                    System.out.println("Esa opción no esta disponible");

            }
        }
    }
}

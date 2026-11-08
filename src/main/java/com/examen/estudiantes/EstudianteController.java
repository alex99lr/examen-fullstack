package com.examen.estudiantes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class EstudianteController {

    @GetMapping("/estudiantes")
    public RespuestaEstudiantes listar() {
        ArrayList<Estudiante> lista = new ArrayList<>();

        lista.add(crearEstudiante(100799, "Alex Lopez", "lopezalex@gmail.com",
                "5644122023", "Maravillas", "Benito Juarez", "Mexico"));
        lista.add(crearEstudiante(220503, "Angel Lopez", "angel99@gmail.com",
                "5632157894", "Bamba", "Benito Juarez", "Nezahualcoyotl"));
        lista.add(crearEstudiante(100798, "Roberto Lopez", "robertolopez@gmail.com",
                "5644122024", "Me voy", "Esperanza", "Nezahualcoyotl"));
        lista.add(crearEstudiante(230115, "Cristian Luna", "cristian.luna@gmail.com",
                "5598761234", "Reforma 45", "Esperanza", "Nezahualcoyotl"));
        lista.add(crearEstudiante(100797, "Diana Perez", "diana.perez@gmail.com",
                "5512345678", "Las Flores", "Poligonos", "Ecatepec"));

        RespuestaEstudiantes r = new RespuestaEstudiantes();
        r.status = 200;
        r.mensaje = "OK";
        r.estudiantes = lista;

        return r;
    }

    private Estudiante crearEstudiante(int numeroControl, String nombre, String email,
                                       String telefono, String calle, String colonia, String ciudad) {
        Direccion d = new Direccion();
        d.calle = calle;
        d.colonia = colonia;
        d.ciudad = ciudad;

        Estudiante e = new Estudiante();
        e.numeroControl = numeroControl;
        e.nombre = nombre;
        e.email = email;
        e.telefono = telefono;
        e.direccion = d;

        return e;
    }
}
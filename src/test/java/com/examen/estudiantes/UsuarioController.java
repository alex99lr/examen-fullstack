package com.examen.estudiantes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository repositorio;

    public UsuarioController(UsuarioRepository repositorio) {
        this.repositorio = repositorio;
    }

    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {
        return repositorio.save(usuario);
    }

    @GetMapping
    public List<Usuario> listar() {
        return repositorio.findAll();
    }
}
package com.examen.estudiantes;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository repositorio;
    private final PasswordEncoder encoder;

    public UsuarioController(UsuarioRepository repositorio, PasswordEncoder encoder) {
        this.repositorio = repositorio;
        this.encoder = encoder;
    }

    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {
        usuario.password = encoder.encode(usuario.password);
        return repositorio.save(usuario);
    }

    @GetMapping
    public List<Usuario> listar() {
        return repositorio.findAll();
    }

    @GetMapping("/{id}")
    public Usuario obtener(@PathVariable Long id) {
        return repositorio.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));
    }

    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Long id, @RequestBody Usuario datos) {
        Usuario u = repositorio.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));
        u.nombre = datos.nombre;
        u.email = datos.email;
        if (datos.password != null && !datos.password.isBlank()) {
            u.password = encoder.encode(datos.password);
        }
        return repositorio.save(u);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        if (!repositorio.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
        }
        repositorio.deleteById(id);
    }
}
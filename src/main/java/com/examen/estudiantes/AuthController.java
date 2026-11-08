package com.examen.estudiantes;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioRepository repositorio;
    private final PasswordEncoder encoder;
    private final JwtService jwt;

    public AuthController(UsuarioRepository repositorio, PasswordEncoder encoder, JwtService jwt) {
        this.repositorio = repositorio;
        this.encoder = encoder;
        this.jwt = jwt;
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginRequest datos) {
        Usuario usuario = repositorio.findByEmail(datos.email())
                .filter(u -> encoder.matches(datos.password(), u.password))
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED, "Credenciales invalidas"));

        return new TokenResponse(jwt.generarToken(usuario.email));
    }
}
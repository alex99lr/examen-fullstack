package com.examen.estudiantes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HolaController {
    @GetMapping("/hola")
    public String hola() {
        return "Hola mundo";
    }

        @GetMapping("/adios")
                public String adios() {
            return "Adios mundo";


    }
}

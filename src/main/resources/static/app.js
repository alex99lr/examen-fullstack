fetch("/estudiantes")
    .then(respuesta => respuesta.json())
    .then(datos => {
        document.getElementById("resultado").textContent =
            datos.mensaje + " - total: " + datos.estudiantes.length;

        let filas = "";
        datos.estudiantes.forEach(e => {
            filas += "<tr>" +
                "<td>" + e.numeroControl + "</td>" +
                "<td>" + e.nombre + "</td>" +
                "<td>" + e.email + "</td>" +
                "<td>" + e.direccion.calle + ", " + e.direccion.colonia + ", " + e.direccion.ciudad + "</td>" +
                "<td>" + e.telefono + "</td>" +
                "</tr>";
        });

        document.getElementById("tabla").innerHTML = filas;
    });
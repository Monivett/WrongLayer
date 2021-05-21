
$(document).ready(function () {
    $("#form").submit(function (event) {
        event.preventDefault(); //prevenimos  que se ejecute otra accion del form
        $.ajax({
            //data:{"correo":"Brandon", "contrasenia":"Oscar"},
            data: $(this).serialize(),
            type: "POST",
            dataType: "json",
            url: "Login"
        }).done(function (data, textEstado, jqXHR) {
            console.log("la solicitud se ha compleado correctamente");
            console.log(data);
            if (data.Respuesta) {
                
               location.href = "PreguntasPrincipal";
            } else {
                 document.getElementById('ERROR').style.display = 'block'; 
            }
        }).fail(function (jqXHR, textEstado) {
            console.log("la solicitud fallos porque: " + textEstado);
        });
    });

});
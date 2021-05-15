
const formularioEditar = document.getElementById('FormEditar'); //ACCEDEMOS AL FORMULARIO
let BTNEditar = document.querySelector('#BTN_EDITAR'); //ACCEDEMOS AL BOTÓN SUBMIT
let Nombre = document.getElementById('#Nombre'); //ACCEDEMOS AL FORMULARIO
const inputs = document.querySelectorAll('#FormEditar input'); //ACCEDEMOS A TODOS LOS INPUTS

//CONSEGUIMOS LA FECHA DE HOY-----------------------
var today = new Date();
var dd = today.getDate();
var mm = today.getMonth() + 1; //Enero es 0 
var yyyy = today.getFullYear();
if (dd < 10) {
    dd = '0' + dd;
}
if (mm < 10) {
    mm = '0' + mm;
}

today = yyyy + '-' + mm + '-' + dd;


//-----------------------------------------
//VARIABLES PARA LOS ERRORES 
var ERRORFECHA = new Boolean (true);
var ERRORCONTRA = new Boolean (true);
 var ERRORCONTRA2 = new Boolean (true);
 //---------------------------------------------------------------
BTNEditar.addEventListener('click',() => { //CUANDO DE CLICK AL BOTÓN DE EDITAR
    //Habilita los botones para poder editar
    document.getElementById("Nombre").disabled = false;
    document.getElementById("Apellido").disabled = false;
    document.getElementById("Correo").disabled = false;
     document.getElementById("NombreUsuario").disabled = false;
    //Oculta el input de edad
    document.getElementById("Edad").style.display = "none";
    //MUESTRA INFO
    document.getElementById("Fecha").style.display = "block";
    document.getElementById("Ocultar").style.display = "block";
    document.getElementById("BTN_EDITAR").style.display = "none";
    document.getElementById("BTN_MODIFICAR").style.display = "block";
  
});
function SoloLetras(e) { //FUNCIÓN PARA VALIDAR SÓLO LETRAS (NOMBRE Y APELLIDO)
    key = e.keyCode || e.which;  //Agarra el evento cuando presiono el teclado
    tecla = String.fromCharCode(key).toString();
    letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZÁÉÍÓÚabcdefghijklmnopqrstuvwxyzáéíóúñÑ";

    especiales = [8, 13, 32, 164, 165];
    tecla_especial = false;
    for (var i in especiales) {
        if (key === especiales[i]) {
            tecla_especial = true;
            break;
        }
    }

    if (letras.indexOf(tecla) === -1 && !tecla_especial) {

        alert("Ingresar solo letras");

        return false;
    }
} 
function Fecha() {
 
    var fechaFormulario = document.getElementById("FechaNac").value;
 
    if (fechaFormulario > today) {
        
        ERRORFECHA = false;
        
        document.getElementById('ErrorFecha').style.display = 'block';
        
       
    }
    else {
        ERRORFECHA = true;
        document.getElementById('ErrorFecha').style.display = 'none'; 
      
        
    }

    
}
function validarContraseña1(password){
   	
    var mayuscula = false;
    var minuscula = false;
    var numero = false;
    var caracter_raro = false;
    
    for(var i = 0;i<password.length;i++){
        if(password.charCodeAt(i) >= 65 && password.charCodeAt(i) <= 90){
            mayuscula = true;
          
        }
        else{
            
        }
        if(password.charCodeAt(i) >= 97 && password.charCodeAt(i) <= 122)
        {
            minuscula = true;
           
        }
        else{
           
        }
        if(password.charCodeAt(i) >= 48 && password.charCodeAt(i) <= 57)
        {
            numero = true;
        }
        else
        {
            caracter_raro = true;
        }
    }
    if(mayuscula === true && minuscula === true && caracter_raro === true && numero === true){
        document.getElementById('ErrorContra').style.display = 'none';
        ERRORCONTRA = true;
        return true;
        
    }
    else{
        document.getElementById('ErrorContra').style.display = 'block';
        ERRORCONTRA = false;
    }

return false;
}
const validarContraseña2 = () => { //VALIDAR CONTRASEÑAS SI SON IGUALES
    const Contraseña1 = document.getElementById('Contraseña');
    const Contraseña2 = document.getElementById('Contraseña2');
    if (Contraseña1.value !== Contraseña2.value) {

        document.getElementById('ErrorContra2').style.display = 'block';
        ERRORCONTRA2 = false;
        
    }
    else {
        document.getElementById('ErrorContra2').style.display = 'none';
        ERRORCONTRA2 = true;
       
    }
}
const validarFormulario = (e) => {
    switch (e.target.name) {//Identifica el name del INPUT
        case "FechaNac":
           
            Fecha();
            break;
       
        case "username":

            break;
        case "contra":
         
          validarContraseña2();
            break;
        case "Contraseña2":
           validarContraseña2();
            break;
    }
}
inputs.forEach((input) => { //POR CADA INPUT EJECUTA LA FUNCIÓN
    input.addEventListener('keyup', validarFormulario);//Cuando suelte la tecla se ejecuta
    input.addEventListener('blur', validarFormulario);//Cuando de click en otro lugar se ejecuta

});

formularioEditar.addEventListener("submit", e=>{
   
   e.preventDefault();
    const password = document.getElementById('Contraseña').value; //ACCEDEMOS AL INPUT CONTRASEÑA
    validarContraseña1(password);
    if (ERRORFECHA === true && ERRORCONTRA === true && ERRORCONTRA2 === true) {
      // Agregas la validación del «ReCaptcha».
      formularioEditar.submit();
      alert("Se ha modificado tu cuenta correctamente");
      formularioEditar.reset();
      
      // Envías el formulario en caso de cumplir el «IF»
    } else {
      alert("Profavor ingrese los datos correctamente");
    
    }
   
  });
  document.getElementById('foto').onchange=function(e){//FUNCIÓN PARA PREVISUALIZAR LA IMAGEN
    let reader = new FileReader(); //Crea un obj para almacenar la imagen
    reader.readAsDataURL(e.target.files[0]); //Pasamos las propiedades de la imagen
    
    reader.onload = function(){//Cuando se cargue la imagen
        let preview = document.getElementById('usuarioFoto'); //Relacion con el div usuario
        Image = document.createElement('img');
        Image.src=reader.result;//Accedemos a la propiedad del img
        //Cambiamos el tamaño
        Image.style.width="300px";
        Image.style.height="300px";
      
      

        preview.innerHTML='';
        preview.append(Image);

    }


} 

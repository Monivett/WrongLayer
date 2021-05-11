// var ambito global
// let ambito bloque
// const ambito bloque

// alert("Hola");
console.log("Hola");
function holaMundo() {
  var hola = "hola";
  console.log(hola);
}

function adiosMundo() {
  let adios = "test";
  console.log(adios);
}

function loop() {
  let arr = [5, 8, 7, 9, 4, 9, 2, 1, 5, 8, 9, 6];
  console.warn("For");
  for (let i = 0; i < arr.length; i++) {
    console.log(arr[i]);
  }
  console.log("Foreach");
  for (const item of arr) {
    console.log(item);
  }
}

function hola(name = "Jose") {
    alert(`Hola ${name}`);
}

holaMundo();
adiosMundo();
loop();
hola();

// = Asignacion
// == Comparacion de valor
// === Comparacion de valor y tipo

function hola(callback) {
  let number = "agua";
  let chain = "kt";
  number = 5;
  chain = 4;
  console.log(number + +chain);
  callback();
}

function mundo() {
  console.log("mundo");
}

let suma = (a, b) => a + b;

hola(mundo);
console.log(suma(3, 5));

var req = new XMLHttpRequest();
req.onreadystatechange = function () {
  if (this.readyState === 4 && this.status === 200) {
    console.log(this.responseText);
  }
};
req.open("GET", "https://api.openbrewerydb.org/breweries");
req.send();
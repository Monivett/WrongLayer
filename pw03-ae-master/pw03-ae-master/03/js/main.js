function detectForm(e) {
  let formularioReg = document.querySelector("form#registro");
  let errorMessage = null;
  e.preventDefault();
  console.log(e);
  if (formularioReg.password.value.length < 8) {
    formularioReg.password.classList.add("input-error");
    // showError(true, "Verifique password");
    errorMessage += "verifique password";
    appendError("verifique password");
  }
  if (formularioReg.password.value.length >= 8) {
    formularioReg.password.classList.remove("input-error");
    formularioReg.password.classList.add("input-valid");

    // showError(false);
  }
  if (formularioReg.name.value.length < 3) {
    formularioReg.name.classList.add("input-error");
    errorMessage += "verifique nombre";
    appendError("verifique nombre");
    // showError(true, "Verifique nombre");
  }
  if (formularioReg.name.value.length >= 8) {
    formularioReg.name.classList.remove("input-error");
    formularioReg.name.classList.add("input-valid");
    // showError(false);
  }
  //   appendError(errorMessage);
  displayError(errorMessage);
}

function showError(show, message = "") {
  let errorMessage = document.querySelector("div#error-message");
  errorMessage.innerHTML = "";
  if (show) {
    errorMessage.classList.remove("hide");
  } else {
    errorMessage.classList.add("hide");
  }
  errorMessage.append(message);
}

function appendError(message) {
  let errorMessage = document.querySelector("div#error-message");
  errorMessage.innerHTML += `${message}<br>`;
}

function displayError(show) {
  let errorMessage = document.querySelector("div#error-message");
  if (show) {
    errorMessage.classList.remove("hide");
  } else {
    errorMessage.classList.add("hide");
  }
}

window.onload = () => {
  let formularioRegistro = document.querySelector("form#registro");
  let formularios = document.forms;
  let formularioReg = formularios["registro"];

  formularioReg.addEventListener("submit", detectForm);

  console.log(formularioRegistro);
  console.log(formularios);
  console.log(formularioReg);
  if (formularioRegistro === formularios) {
    console.log("Formularios y registro");
  }
  if (formularioRegistro === formularioReg) {
    console.log("Formularios y formulario");
  }

  //   formularioReg.name.value = "Jose";
  let name = formularioReg?.name?.value;
  let age = formularioReg?.age?.value;
  let email = formularioReg?.email?.value;
  let password = formularioReg?.password?.value;

  console.log(name);
  console.log(age);
  console.log(email);
  console.log(password);
};

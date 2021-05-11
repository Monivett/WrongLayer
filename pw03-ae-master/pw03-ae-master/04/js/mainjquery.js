var breweryBlock = (name, state, city, website) => {
  return `
    <div class="brewerie-block">
        <h3>Name: ${name}</h3>
        <p>State: ${state}</p>
        <p>City: ${city}</p>
        <p>Web: ${website}</p>
    </div>
        `;
};

function showRed() {
  $("#red").show();
}

function hideRed() {
  $("#red").hide();
}

function createTitle() {
  $("#titles").append('<div class="title">Titulo</div>');
}

function deleteTitle() {
  $("#titles > .title:nth-of-type(1)").remove();
}

function fetchAJAX() {
  $.ajax({
    method: "GET",
    url: "https://api.openbrewerydb.org/breweries",
  }).done(function (data) {
    if (data) {
      console.log(data);
      $("#AJAX").append(data);
      $.each(data, (k, v) => {
        console.log(v);
        $("#AJAX").append(breweryBlock(v.name, v.state, v.city, v.website_url));
      });
    }
  });
}

//windows.onready
$(function () {
  // alert('Termino de Cargar');
});

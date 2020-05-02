var firebaseConfig = {
    apiKey: "AIzaSyBlLJVRAdZU-G34e1cCLupAQDiQ2qd7aHc",
    authDomain: "ecosistemas-db53e.firebaseapp.com",
    databaseURL: "https://ecosistemas-db53e.firebaseio.com",
    projectId: "ecosistemas-db53e",
    storageBucket: "ecosistemas-db53e.appspot.com",
    messagingSenderId: "604406873222",
    appId: "1:604406873222:web:587457aa9aa762d3dd6507",
    measurementId: "G-KKRX9S4LYF"
  };
// Initialize Firebase
firebase.initializeApp(firebaseConfig);



const firstnameIT = document.getElementById("firstnameIT");
const secondnameIT = document.getElementById("secondnameIT");
const codeIT = document.getElementById("codeIT");
const registerBtn = document.getElementById("registerBtn");
const contenedorBase = document.getElementById("contenedorBase");
const database = firebase.database();
const storage = window.localStorage;

var imagenSeleccionada = "";



registerBtn.addEventListener("click", registrar);

function registrar() {

    let nombre = firstnameIT.value;
    let apellido = secondnameIT.value;
    let code = codeIT.value;

    let id = database.ref().child("estudiantes").push().key;

   
    let estudiante = new Estudiante(id, nombre, apellido, code, imagenSeleccionada);

    console.log(estudiante);

    //Registrar estudiante en una rama
    database.ref().child("estudiantes").child(id).set(estudiante);

}


//Leer lista optimamente
database.ref().child("estudiantes").on("child_added", function(snapshot){

  var estObj = snapshot.val();

  var item = document.createElement("li");

  var img = document.createElement("img");
  img.src = estObj.url;
  img.width = 36;

  var enlace = document.createElement("a");
  enlace.innerHTML = estObj.nombre + " "+estObj.apellido;
  enlace.href = "#";
  enlace.id = estObj.id;
  //<a href="" id="idFirebase">Enlace</a>
  item.appendChild(img);
  item.appendChild(enlace);
  contenedorBase.appendChild(item);

  //Crear listener para el elemento:
  document.getElementById(estObj.id).addEventListener("click", function(event){
    event.preventDefault();
    storage.setItem("id", estObj.id);
    window.location.href = "/agregarmaterias.html"

  });

});

document.querySelectorAll(".avatar").forEach(
  item => {
    item.addEventListener("click", function(){
      restoreButtons();
      item.width = 128;
      imagenSeleccionada = item.src;
      console.log(imagenSeleccionada);
    }); 
  }
);

function restoreButtons(){
  document.querySelectorAll(".avatar").forEach(
    item => {
      item.width = 96;
    }
  );
}
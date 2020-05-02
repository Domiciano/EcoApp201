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



const estudiantenombre = document.getElementById("estudiantenombre");
const nombreIT = document.getElementById("nombreIT");
const profesorIT= document.getElementById("profesorIT");
const registrarBtn= document.getElementById("registrarBtn");
const materiasContainer = document.getElementById("materiasContainer");
const database = firebase.database();
const storage = window.localStorage;


//Recuperación de datos
const idEst = storage.getItem("id");



//Leer un objeto
database.ref().child("estudiantes").child(idEst).on("value", function(snapshot){
  
    var estObj = snapshot.val();
    console.log(estObj.nombre);

    estudiantenombre.innerHTML = "Perfil de " + estObj.nombre + " " + estObj.apellido;
  
});


registrarBtn.addEventListener("click", function(){
    
    var id = database.ref().child("estudiantes").child(idEst).child("materias").push().key;
    //CUal rama va a contener las materias
    
    var nombre = nombreIT.value;
    var profesor = profesorIT.value;

    var materia = new Materia(id, nombre, profesor);

    database.ref().child("estudiantes").child(idEst).child("materias")
        .child(id).set(materia);

});

//Leer lista de materias del estudiante
database.ref().child("estudiantes").child(idEst).child("materias")
    .on("child_added", function(snapshot){
        var materia = snapshot.val();
        var item = document.createElement("p");
        item.innerHTML = materia.nombre + " ("+materia.profesor+")";
        materiasContainer.appendChild(item);
    });
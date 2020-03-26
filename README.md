﻿![Universidad Icesi](https://www.icesi.edu.co/launiversidad/images/La_universidad/logosimbolos/Logo_icesi_JPG.jpg)
# ECOSISTEMAS DE APLICACIONES
### Semestre 2020-1

Bienvenido al curso de Ecosistemas de Aplicaciones. Aquí podrá encontrar los recursos del curso.


### Examen teórico 1
[![Examen de prerrequisitos](http://www.iconninja.com/files/825/688/946/pencil-list-done-checkmark-todo-exam-icon.png)](https://forms.gle/5EQ4p1rUEfXTxLFq5)


### Calendario de entregas
(Semana 10) Jueves, Entrega de Gameplay


### Recibir líneas
```
String line = reader.readLine();
System.out.println(line);
```

### Mandar lineas
```
writer.write("Hola desde Android\n");
writer.flush();
```

### Inicializar lector de datos (Ambos)
```
InputStream is = socket.getInputStream();
InputStreamReader isr = new InputStreamReader(is);
BufferedReader reader = new BufferedReader(isr);
            
```

### Inicializar escritor de datos (Ambos)
```
try {
    //Estamos definiciendo la corriente de salida
    OutputStream os = socket.getOutputStream();
    //Como necesitamos mandar Strings, entonces vamos a definir los siguientes objetos
    OutputStreamWriter osw = new OutputStreamWriter(os);
    //Esta linea nos permite crear un objeto que manda Strings pero con un buffer
    BufferedWriter writer = new BufferedWriter(osw);
} catch (IOException e) {
    e.printStackTrace();
}
```

### Pedir conexiones (Cliente)
```
Socket socket = new Socket("10.0.2.2", 5000);
```



### Recibir conexiones (Servidor)
```
ServerSocket server = new ServerSocket(5000);
//Esta linea me permite aceptar la conexion entrante
System.out.println("Esperando...");
Socket socket = server.accept();
System.out.println("Conexion fue aceptada");
```


### Método para hacer una consulta por internet
```
public String getToURL(String site) {
    try {
        URL url = new URL(site);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
		InputStreamReader isr = new InputStreamReader(connection.getInputStream());
		BufferedReader in = new BufferedReader(isr);
        String message = "";
        String line = "";
        while ((line = in.readLine()) != null) {
            message += line;
        }
        in.close();
        return message;
    }catch(IOException ex) {
        System.out.println(ex.getMessage());
        return null;
    }
}
```

### Elementos para comprar
- Protoboard grande (1 x Grupo)
- Resistencias de 220ohm / 240ohm (12 x Grupo)
- Resistencias de 1K (10 x Grupo)
- Resistencias de 10K (10 x Grupo)
- Led de colores surtidos (12 x grupo)
- Potenciometro para protoboard (4 x grupo)
- Fotocelda (4 x grupo)
- Botón para protoboard (6 x grupo)
- Cable estañado o de prototipado rapido para protoboard (x12)

### Examen de prerrequisitos
[![Examen de prerrequisitos](http://www.iconninja.com/files/825/688/946/pencil-list-done-checkmark-todo-exam-icon.png)](https://forms.gle/sQSAymwBBJJiYfeo6)


### Correo electrónico del profesor
domiciano.rincon@correounivalle.edu.co
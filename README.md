![Universidad Icesi](https://www.icesi.edu.co/launiversidad/images/La_universidad/logosimbolos/Logo_icesi_JPG.jpg)
# ECOSISTEMAS DE APLICACIONES
### Semestre 2020-1

Bienvenido al curso de Ecosistemas de Aplicaciones. Aquí podrá encontrar los recursos del curso.


### Calendario de entregas
(Semana 8) Lunes, marzo 9: Propuesta de diseño y ficha técnica 
 
(Semana 10) Domingo, marzo 29: Código implementado 

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
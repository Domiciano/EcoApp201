#include <SPI.h>
#include <Ethernet.h>
byte mac[] = {0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED};
IPAddress ip(169, 254, 9, 100);
EthernetServer server(80);

void setup() {
  Serial.begin(9600);  
  Ethernet.begin(mac, ip);
  server.begin();
}

void loop() {
  EthernetClient client = server.available();
  if (client) {
    // Si entra al if, es porque alguien está entrando a la página
    // que expone el arduino.

    boolean currentLineIsBlank = true;

    // Mientras estamos conectados
    while (client.connected()) {
      if (client.available()) {
        char c = client.read();
        Serial.write(c);
        // El cliente manda un mensaje pidiendo la página
        // Pero cuando el mensaje tiene un salto de línea
        // es porque el mensaje del cliente terminó

        // Cuando el mensaje del cliente es recibido
        // Desde arduino respondemos con una página WEB
        
        if (c == '\n' && currentLineIsBlank) {
          // Si entramos a este if es porque el mensaje del usuario terminó

          // Respondemos la página web
          client.println("HTTP/1.1 200 OK");
          client.println("Content-Type: text/html");
          client.println("Connection: close");
          client.println("Refresh: 5");
          client.println();

          //AQUI ES DONDE IMPRIMO LO QUE NECESITO PUBLICAR!!!
          client.print("Hola desde arduino");
          break;
        }

        // Si el caracter recibido es \n es porque el mensaje del cliente aún no termina
        if (c == '\n') {
          currentLineIsBlank = true;
        } 

        // Si el caracter es diferente de el caracter \r es porque aún no termina el mensaje
        // del cliente. También puede interpretarse como que si el caracter es diferente de \r
        // es porque es un caracter correspondiente a una letra o número
        else if (c != '\r') {
          currentLineIsBlank = false;
        }
      }
    }
    // Damos tiempo al navegador para recibir los datos
    delay(1);
    // Finalizar la conexión con el cliente
    client.stop();
  }
}

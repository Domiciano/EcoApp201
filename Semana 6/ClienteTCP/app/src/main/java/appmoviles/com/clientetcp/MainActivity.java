package appmoviles.com.clientetcp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    private Button accion;
    Socket socket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accion = findViewById(R.id.accion);
        //Hacemos la solicitud de conexión al Servidor
        new Thread(
                ()->{
                    try {
                        //Con esta linea enviamos solicitud de conexión
                        //En la seccion del host voy a poner la direccion IP del servidor
                        //En el puerto voy a poner el puerto en el que escucha el servidor
                        socket = new Socket("10.0.2.2", 5000);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        ).start();

        accion.setOnClickListener(
                (v) -> {
                    new Thread(
                            ()->{
                                try {
                                    //Estamos definiciendo la corriente de salida
                                    OutputStream os = socket.getOutputStream();
                                    //Como necesitamos mandar Strings, entonces vamos a definir los siguientes objetos
                                    OutputStreamWriter osw = new OutputStreamWriter(os);
                                    //Esta linea nos permite crear un objeto que manda Strings pero con un buffer
                                    BufferedWriter writer = new BufferedWriter(osw);
                                    writer.write("Hola desde Android\n");
                                    writer.flush();




                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                    ).start();
                }
        );

    }
}

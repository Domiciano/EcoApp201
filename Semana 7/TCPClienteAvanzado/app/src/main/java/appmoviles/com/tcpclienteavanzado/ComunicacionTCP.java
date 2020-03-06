package appmoviles.com.tcpclienteavanzado;

import android.content.Intent;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import androidx.appcompat.app.AppCompatActivity;

public class ComunicacionTCP extends Thread{

    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private String ip;

    private AppCompatActivity app;

    public ComunicacionTCP(AppCompatActivity app){
        this.app = app;
    }

    //Hilo de recepción
    @Override
    public void run() {
        try {
            this.socket = new Socket(this.ip,5000);

            //Reader
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            this.reader = new BufferedReader(isr);

            //Writer
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            this.writer = new BufferedWriter(osw);

            while(true) {
                recibirMensaje();
            }



        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //Solicitar conexion
    public void solicitarConexion(String ip){
        this.ip = ip;
        this.start();
    }

    //Mandar un mensaje
    public void mandarMensaje(String mensaje){
        new Thread(
                ()->{
                    try {
                        writer.write(mensaje+"\n");
                        writer.flush();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
        ).start();
    }

    //Recibir mensaje
    public void recibirMensaje() throws IOException{
        String line = reader.readLine();
        System.out.println("<<<"+line);
        if(line.equals("SI")){
            Intent i = new Intent(app, MainActivity.class);
            app.startActivity(i);
        }
        if(line.equals("NO")){
            //CUMPLE CON LAS REGLAS DE ANDROID!
            app.runOnUiThread(
                    ()->{
                        Toast.makeText(app, "El correo esta MAL", Toast.LENGTH_SHORT).show();
                    }
            );

        }
    }

    public void cerrarConexion(){
        try {
            socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

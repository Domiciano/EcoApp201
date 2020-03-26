package appmoviles.com.videoguia23;

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

    private static ComunicacionTCP instance;

    public static ComunicacionTCP getInstance(){
        if(instance == null){
            instance = new ComunicacionTCP();
            return instance;
        }else{
            return instance;
        }
    }


    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private String ip;

    private OnMessageListener observer;

    public void setObserver(OnMessageListener observer){
        this.observer = observer;
    }

    private ComunicacionTCP(){

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
        observer.onMessage(line);
    }

    public void cerrarConexion(){
        try {
            socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    public interface OnMessageListener{
        void onMessage(String mensaje);
    }

}

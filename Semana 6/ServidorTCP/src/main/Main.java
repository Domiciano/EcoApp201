package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import processing.core.PApplet;

public class Main extends PApplet{

	public static void main(String... strings) {
		PApplet.main("main.Main");
	}
	
	public void settings() {
		size(500,500);
	}
	
	public void setup() {
		//Este elemento nos permite esperar una conexion
		try {
			ServerSocket server = new ServerSocket(5000);
			//Esta linea me permite aceptar la conexion entrante
			System.out.println("Esperando...");
			Socket socket = server.accept();
			System.out.println("Conexion fue aceptada");
			
			
			
			InputStream is = socket.getInputStream();
            
            InputStreamReader isr = new InputStreamReader(is);
          
            BufferedReader reader = new BufferedReader(isr);
            
            String line = reader.readLine();
			System.out.println(line);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void draw() {
		
	}
}




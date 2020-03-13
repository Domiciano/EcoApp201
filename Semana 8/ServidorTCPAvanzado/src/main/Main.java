package main;

import comm.ComunicacionTCP;
import processing.core.PApplet;

public class Main extends PApplet{
	public static void main(String[] args) {
		PApplet.main("main.Main");
	}
	
	ComunicacionTCP comm;
	
	public void settings() {
		size(500,500);
	}
	
	public void setup() {
		
		Logica logica = new Logica(this);
		
		comm = new ComunicacionTCP();
		comm.esperarConexion();
	}
	
	public void draw() {
		background(255);
		
	}
	
	public void mousePressed() {
		comm.mandarMensaje("NO");
	}
}

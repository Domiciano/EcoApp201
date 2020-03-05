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
		comm = new ComunicacionTCP();
		comm.esperarConexion();
	}
	
	public void draw() {
		background(255);
		
	}
}

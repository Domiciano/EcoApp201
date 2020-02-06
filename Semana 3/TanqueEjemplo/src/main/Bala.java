package main;

import processing.core.PApplet;
import processing.core.PVector;

public class Bala {

	PApplet app;
	PVector posicion;
	PVector direccion;
	
	public Bala(PApplet app, float x, float y, float angle) {
		this.app = app;
		direccion = new PVector(0,5);
		direccion.rotate(angle);
		posicion = new PVector(x,y);
	}
	
	public void draw() {
		app.rectMode(app.CENTER);
		app.fill(255,0,0);
		app.ellipse(posicion.x,posicion.y,10,10);
	}
	
	public void move() {
		posicion.add(direccion);
	}

}

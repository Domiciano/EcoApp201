package main;

import processing.core.PApplet;
import processing.core.PVector;

public class Tanque {
	private PApplet app;
	private PVector posicion;
	private PVector direccion;
	
	public Tanque(PApplet app) {
		this.app = app;
		direccion = new PVector(0,5);
		posicion = new PVector(250,250);
	}
	
	public void draw() {
		app.pushMatrix();
		app.translate(posicion.x,posicion.y);
		app.rotate(direccion.heading());
		app.rectMode(app.CENTER);
		app.rect(0,0,60,60);
		app.popMatrix();
	}
	
	public void rotateClock() {
		direccion.rotate(app.PI/100);
	}
	
	public void rotateAntiClock() {
		direccion.rotate(-app.PI/100);
	}
	
	public void setAngle(float angulo) {
		direccion.rotate(-direccion.heading());
		direccion.rotate(angulo);
	}
	
	public void move() {
		posicion.add(direccion);
	}
	
}

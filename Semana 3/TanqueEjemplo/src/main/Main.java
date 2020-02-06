package main;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.serial.Serial;

public class Main extends PApplet{

	public static void main(String[] args) {
		PApplet.main("main.Main");
	}

	Tanque tanque;
	ArrayList<Bala> balas;
	
	public void settings() {
		size(500,500);
	}
	
	public void setup() {
		balas = new ArrayList<>();
		tanque = new Tanque(this);
		printArray(  Serial.list()  );
	}
	
	public void draw() {
		background(255);
		tanque.draw();
		for(int i=0 ; i<balas.size() ; i++) {
			balas.get(i).draw();
			balas.get(i).move();
		}
	}
	
	public void keyPressed() {
		if(keyCode == RIGHT) {
			tanque.rotateClock();
		}else if(keyCode == LEFT) {
			tanque.rotateAntiClock();
		}else if(keyCode == UP) {
			tanque.move();
		}
		
		
		else if(key == 'a') {
			disparar();
		}
		
		
	}

	private void disparar() {
		balas.add(new Bala(this, tanque.getPos().x, tanque.getPos().y, tanque.getAngle() ));
	}

}

package main;

import processing.core.PApplet;
import processing.serial.Serial;

public class Main extends PApplet{

	public static void main(String[] args) {
		PApplet.main("main.Main");
	}

	Tanque tanque;
	
	public void settings() {
		size(500,500);
	}
	
	public void setup() {
		tanque = new Tanque(this);
		printArray(  Serial.list()  );
	}
	
	public void draw() {
		background(255);
		tanque.draw();
	}
	
	public void keyPressed() {
		if(keyCode == RIGHT) {
			tanque.rotateClock();
		}else if(keyCode == LEFT) {
			tanque.rotateAntiClock();
		}else if(keyCode == UP) {
			tanque.move();
		}
		
		
		else if(key == 'A') {
			tanque.setAngle(PI/4);
		}else if(key == 'S') {
			tanque.setAngle(PI/2);
		}
		
		
	}

}

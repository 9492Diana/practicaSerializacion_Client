import java.util.ArrayList;

import processing.core.PApplet;


public class EjecutableClient extends PApplet{
	
	Comunicacion com;
	ArrayList<Clic> clics;
	
	@Override
	public void setup() {
		clics = new ArrayList<Clic>();
		com = new Comunicacion(clics);
		com.start();
	}
	
	@Override
	public void draw() {
		
	}
	
	@Override
	public void mousePressed() {
		com.enviar(mouseX, mouseY);
	}
	
}

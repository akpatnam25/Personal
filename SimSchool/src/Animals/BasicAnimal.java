package Animals;

import java.awt.Color;  

import SchoolObjects.SchoolObject;
import gpdraw.DrawingTool;
import shapes.*;

public class BasicAnimal extends SchoolObject {
	private int xpos;
	private int ypos;
	private Color c;
	
	public BasicAnimal() {
		xpos = 0;
		ypos = 0;
	}
	
	public BasicAnimal(int xpos, int ypos) {
		this.xpos = xpos;
		this.ypos = ypos;
	}
	
	public BasicAnimal(int xpos, int ypos, Color c) {
		this.xpos = xpos;
		this.ypos = ypos;
		this.c = c;
	}
	
	public void draw(DrawingTool marker) {
		Circle head = new Circle(xpos , ypos, 50, 5, c);
		head.draw(marker);
		Rectangle body = new Rectangle(xpos + 200, ypos - 60, 100, 300, 5, c);
		body.draw(marker);
		Line frontLeg = new Line();
		frontLeg.addLineByCoordinates(marker, xpos + 80, ypos - 110, xpos + 80, ypos - 250, 5, c);
		Line backLeg = new Line();
		backLeg.addLineByCoordinates(marker, xpos + 300, ypos - 110, xpos + 300, ypos - 250, 5, c);
		Circle frontLegFoot = new Circle(xpos + 80, ypos - 250 , 5, 10, c);
		frontLegFoot.draw(marker);
		Circle backLegFoot = new Circle(xpos + 300, ypos - 250, 5 , 10, c);
		backLegFoot.draw(marker);
		Circle rightEye = new Circle(xpos + 20, ypos + 10 , 2, 5, c);
		rightEye.draw(marker);
		Circle leftEye = new Circle(xpos - 20, ypos + 10, 2, 5, c);
		leftEye.draw(marker);
		Line mouth = new Line();
		mouth.addLineByCoordinates(marker, xpos - 20, ypos - 20, xpos + 20 , ypos - 20, 5, c);
	}
	
	public int getXPos() {
		return xpos;
	}
	
	public int getYPos() {
		return ypos;
	}
	
	public void setXPos(int xpos) {
		this.xpos = xpos;
	}
	
	public void setYPos(int ypos) {
		this.ypos = ypos;
	}
	
	public void setColor(Color newColor) {
		  c = newColor;
	  }
}

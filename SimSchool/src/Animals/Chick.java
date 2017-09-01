package Animals;
import java.awt.Color; 

import shapes.*;
import gpdraw.DrawingTool;
public class Chick extends BasicAnimal implements Animal {
	private String myType;
	private String mySound;
	private int xpos;
	private int ypos;
	
	public Chick() {
		myType = "chick";
		mySound = "chirp";		
	}
	
	public Chick(int n) {
		myType = "chick";
		mySound = getSound();
	}
	
	public Chick(String myType , String sound) {
		sound = getSound();
		mySound = sound;
		this.myType = myType;
	}
	
	public Chick(int xpos , int ypos) {
		super(xpos, ypos);
		this.xpos = xpos;
		this.ypos = ypos;
	}
	
	public String getSound() {
		double number = Math.random();
		if (number >= 0.66)
			mySound = "cluck";
		else if (number <= 0.33)
			mySound = "cheep";
		else 
			mySound = "cluck" + " cheep";
		return mySound;
	}
	
	public String getType() {
		return myType;
	}
	
	public String toString() {
		return "The " + getType() + " goes " + getSound();
	}

	public void draw(DrawingTool marker) {
		super.draw(marker);
		Line topLine = new Line();
		topLine.addLineByCoordinates(marker,xpos - 10, ypos, xpos , ypos + 5, 2, Color.BLACK);
		Line bottomLine = new Line();
		bottomLine.addLineByCoordinates(marker, xpos - 10, ypos, xpos , ypos - 5, 2, Color.BLACK);
		marker.up();
		marker.move(xpos + 100, ypos - 50 );
		marker.down();
		marker.drawString("Chick");
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
	
	 public void setSound(String sound) {
		 mySound = sound;
	}
		
	 public void setType(String type) {
		 myType = type;
	}
	
}

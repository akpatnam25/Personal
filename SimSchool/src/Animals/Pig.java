package Animals;
import java.awt.Color; 

import shapes.Circle;
import gpdraw.DrawingTool;;

public class Pig extends BasicAnimal implements Animal {
	private String myType;
	private String mySound;
	private int xpos;
	private int ypos;
	
	public Pig() {
		super();
		myType = "pig";
		mySound = "oink";		
	}
	
	public Pig(String myType , String mySound) {
		super();
		this.myType = myType;
		this.mySound = mySound;
	}
	
	public Pig(int xpos, int ypos) {
		super(xpos, ypos);
		this.xpos = xpos;
		this.ypos = ypos;
	}
	
	public String getSound() {
		return mySound;
	}
	
	public String getType() {
		return myType;
	}
	
	public String toString() {
		return "The " + getType() + " goes " + getSound();
	  }

	// Pigs are ALWAYS PINK, and have circle noses.
	public void draw(DrawingTool marker) {
		super.draw(marker);
		int xpos = super.getXPos();
		int ypos = super.getYPos();
		Circle nose = new Circle(xpos , ypos - 5, 5, 10, Color.BLACK);
		nose.draw(marker);
		marker.up();
		marker.move(xpos + 100, ypos - 50 );
		marker.down();
		marker.drawString("Pig");
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

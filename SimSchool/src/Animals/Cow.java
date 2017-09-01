package Animals;
import java.awt.Color; 
import shapes.*;
import gpdraw.DrawingTool;

public class Cow extends BasicAnimal implements Animal{
  private String myType;
  private String mySound;
  private int xpos;
  private int ypos;

  public Cow() {
    myType = "cow";
    mySound = "moo";
  }
  
  public Cow(String myType, String mySound) {
	  this.myType = myType;
	  this.mySound = mySound;
  }
  
  public Cow(int xpos, int ypos) {
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
  
  	// Cows are ALWAYS BLACK, and have 2 circles to represent their nose.
  public void draw(DrawingTool marker) {
	super.draw(marker);
	Circle leftNostril = new Circle(xpos - 10, ypos - 5, 5 , 5, Color.BLACK);
	leftNostril.draw(marker);
	Circle rightNostril = new Circle(xpos + 10, ypos - 5, 5, 5, Color.BLACK);
	rightNostril.draw(marker);
	marker.up();
	marker.move(xpos + 100, ypos - 50 );
	marker.down();
	marker.drawString("Cow");
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

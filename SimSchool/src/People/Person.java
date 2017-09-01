package People;
import java.awt.Color; 
import java.util.ArrayList;

import shapes.Circle;
import shapes.Line;
import gpdraw.DrawingTool;
import SchoolObjects.*;

/**
 * L.A.11.1
 *
 * The root of the Person hierarchy.  All persons have
 * a name and an age and a gender
 */
public class Person extends SchoolObject  {
  private String myName ;   // name of the person
  private int myAge;        // person's age
  private String myGender;
  private int xpos;
  private int ypos;
  private Color c;
  // 'M' for male, 'F' for female
  
  // constructor
  public Person(String name, int age, String gender) {
    myName = name;
    myAge = age;
    myGender = gender;
  }
  
  public Person(int xpos, int ypos) {
	  this.xpos = xpos;
	  this.ypos = ypos;
  }
  
  
  public Person(int xpos, int ypos, Color c) {
	  this.xpos = xpos;
	  this.ypos = ypos;
	  this.c = c;
  }

  public String getName() {
    return myName;
  }

  public int getAge() {
    return myAge;
  }

  public String getGender() {
    return myGender;
  }

  public void setName(String name) {
    myName = name;
  }

  public void setAge(int age) {
    myAge = age;
  }

  public void setGender(String gender) {
    myGender = gender;
  }
  
  public void setColor(Color newColor) {
	  c = newColor;
  }

  public String toString() {
    return myName + " " + myAge + " " + myGender + " ";
  }
  
  public void draw(DrawingTool marker) {
	  Circle face = new Circle(xpos , ypos, 50, 5, c);
	  face.draw(marker);
	  Line body = new Line();
	  body.addLineByCoordinates(marker, xpos, ypos - 50, xpos, ypos - 150, 5, c);
	  Line leftLeg = new Line();
	  leftLeg.addLineByCoordinates(marker, xpos, ypos - 150, xpos - 50, ypos - 250, 5, c);
	  Line rightLeg = new Line();
	  rightLeg.addLineByCoordinates(marker, xpos, ypos - 150, xpos + 50, ypos - 250, 5, c);
	  Line hands = new Line();
	  hands.addLineByCoordinates(marker, xpos - 50, ypos - 100, xpos + 50, ypos - 100, 5, c);
	  Circle rightEye = new Circle(xpos + 20 , ypos + 10, 7 , 5 , c);
	  rightEye.draw(marker);
	  Circle leftEye = new Circle(xpos - 20, ypos + 10, 7 , 5, c);
	  leftEye.draw(marker);
	  Line mouth = new Line();
	  mouth.addLineByCoordinates(marker, xpos - 15, ypos - 30, xpos + 15, ypos - 30, 5, c);
	  Circle nose = new Circle(xpos, ypos - 10, 5 , 6, c);
	  nose.draw(marker);
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
}
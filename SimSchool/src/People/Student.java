package People;
import java.awt.Color; 

import gpdraw.DrawingTool;
import shapes.*;

/**
 * L.A.11.1
 *
 * A student, is a Person with an id number and
 * a grade point average
 */

public class Student extends Person {
	  private String myIdNum; 
	  private double myGPA;  
	  private int xpos;
	  private int ypos;

	  public Student(String name, int age, String gender, String idNum, double gpa) {
	    super(name, age, gender);	
	    myIdNum = idNum;
	    myGPA = gpa;
	  }
	  
	  public Student(int xpos, int ypos) {
		  super(xpos, ypos);
		  this.xpos = xpos;
		  this.ypos = ypos;
	  }
	
	  public String getIdNum() {
	    return myIdNum;
	  }
	
	  public double getGPA() {
	    return myGPA;
	  }
	
	  public void setIdNum(String idNum) {
	    myIdNum = idNum;
	  }
	
	  public void setGPA(double gpa) {
	    myGPA = gpa;
	  }
	
	  public String toString()	{
	    return super.toString()  + myIdNum  + " " +  myGPA + " ";
	  }
	  
	  public void draw(DrawingTool marker) {
		  Rectangle backpack = new Rectangle(xpos, ypos - 100 , 100 ,70, 5, Color.BLACK);
		  backpack.draw(marker);
		  super.draw(marker);
		  Person person = new Person(xpos , ypos);
		  person.draw(marker);
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

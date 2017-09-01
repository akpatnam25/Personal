package People;
import java.awt.Color;

import gpdraw.DrawingTool;
import shapes.*;

public class Teacher extends Person {
	private String mySubject;
	private double mySalary;
	private int xpos;
	private int ypos;
	
	public Teacher(String myName, int myAge, String myGender, String subject, double salary) {
		super(myName, myAge, myGender);
		mySubject = subject;
		mySalary = salary;
	}
	
	public Teacher(int xpos, int ypos) {
		super(xpos, ypos);
		this.xpos = xpos;
		this.ypos = ypos;
	}
	
	public String getSubject() {
		return mySubject;
	}
	
	public double getSalary() {
		return mySalary;
	}
	
	public void setSubject(String subject) {
		mySubject = subject;
	}
	
	public void setSalary(double salary) {
		mySalary = salary;
	}
	
	public String toString() {
		return super.toString()  + mySubject + " " + mySalary;
	}
	
	// Teachers are ALWAYS GRAY. 
	public void draw(DrawingTool marker) {
		super.draw(marker);
		Line stache = new Line();
		stache.addLineByCoordinates(marker, xpos - 10, ypos - 20, xpos + 10, ypos - 20, 8, Color.BLACK);
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

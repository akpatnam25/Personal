package People;
import java.awt.Color;

import shapes.*;
import gpdraw.DrawingTool;

public class CollegeStudent  extends Student {
	private String myMajor;
	private int myYear;
	private int xpos;
	private int ypos;
	private Color c;
	
	public CollegeStudent(String myName, int myAge, String myGender, String myIdNum, double myGPA, int year, String major) {
		super(myName, myAge, myGender, myIdNum, myGPA);
		myMajor = major;
		myYear = year;
	}
	
	public CollegeStudent(int xpos, int ypos) {
		super(xpos, ypos);
		this.xpos = xpos;
		this.ypos = ypos;
	}
	
	public int getYear() {
		return myYear;
	}
	
	public String getMajor() {
		return myMajor;
	}
	
	public void setYear(int year) {
		myYear = year;
	}
	
	public void setMajor(String major) {
		myMajor = major;
	}
	
	public String toString() {
		return super.toString()  + myMajor  + " "+   myYear;
	}
	
	public void draw(DrawingTool marker) {
		super.draw(marker);
		Circle headphoneRight = new Circle(xpos + 50, ypos, 6, 10, Color.RED);
		headphoneRight.draw(marker);
		Circle headphoneLeft = new Circle(xpos - 50, ypos, 6, 10, Color.RED);
		headphoneLeft.draw(marker);
		Line rightStick = new Line();
		rightStick.addLineByCoordinates(marker, xpos + 50, ypos , xpos + 50, ypos + 50, 5, Color.BLUE);
		Line leftStick = new Line();
		leftStick.addLineByCoordinates(marker, xpos - 50, ypos, xpos - 50, ypos + 50, 5, Color.BLUE);
		Line topStick = new Line();
		topStick.addLineByCoordinates(marker,xpos + 50, ypos + 50, xpos -50, ypos + 50, 5, Color.BLUE);
		
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

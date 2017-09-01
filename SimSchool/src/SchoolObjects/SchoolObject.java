package SchoolObjects;


import gpdraw.DrawingTool;


public abstract class SchoolObject implements Drawable {
	private int xpos;
	private int ypos;
	
	public SchoolObject() {
		xpos = 0;
		ypos = 0;
	}
	
	public SchoolObject(int xpos, int ypos) {
		this.xpos = xpos;
		this.ypos = ypos;
	}
	
	public void setXPos(int xpos) {
		this.xpos = xpos;
	}
	
	public void setYPos(int ypos) {
		this.ypos = ypos;
	}
	
	public int getXPos() {
		return xpos;
	}
	
	public int getYPos() {
		return ypos;
	}
	
	public abstract void draw(DrawingTool marker);
	
}

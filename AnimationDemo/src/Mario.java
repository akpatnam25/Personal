

import java.awt.*;

import javax.swing.*;

import java.awt.geom.Rectangle2D;
import java.awt.image.*;
import java.util.*;

public class Mario extends MovingImage {
	
	public static final int MARIO_WIDTH = 40;
	public static final int MARIO_HEIGHT = 60;
	
	private double vx , vy;
	private boolean isOnASurface;
	public Mario(int x, int y) {
		super("mario.png", x, y, MARIO_WIDTH, MARIO_HEIGHT);
		vx = 0;
		vy = 0;
	}

	// METHODS
	public void walk(int dir) {
		// WALK!
		vx = 5 * dir;
	}

	public void jump() {
		// JUMP!
		if (isOnASurface)
			vy -= 15;
	}

	public void act(ArrayList<Shape> obstacles) {
		// FINISH ME!
		boolean isOnASurface = false;
		vy += 0.65;
		Rectangle2D.Double motionRY = new Rectangle2D.Double(x , y , width , height + vy);
		for (Shape s : obstacles) {
			if (s.intersects(motionRY)) {
				isOnASurface = true;
				//vy = -vy * .5;
				vy = 0;
				Rectangle2D shapeR = s.getBounds2D();
				y = shapeR.getMinY() - height;
			} else {
				
			}
		}
		this.isOnASurface = isOnASurface;
		x += vx;
		y+=vy;
	}


}

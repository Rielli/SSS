package sss.lwjglprot;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Prototype {
	double x = 400;
	double y = 300;
	int size = 100;
	double rot = 0;

	public static void main(String args[]) {
		Prototype prototype = new Prototype();
		prototype.start();
	}

	public void start() {
		// start a new display
		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		// set up drawing the "ship"
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 800, 0, 600, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		while (!Display.isCloseRequested()) {
			drawShip();
			updateInput();
			Display.update();
		}
		// when we close this destroy the Display
		Display.destroy();
	}

	public void updateInput() {
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			y += 0.1;
			System.out.println("W pressed");
		} else if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			y -= 0.1;
			System.out.println("S pressed");
		} else if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			rot -= 0.01;
			System.out.println("A pressed");
		} else if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			rot += 0.01;
			System.out.println("D pressed");
		}
		printValues();
	}

	public void drawShip() {
		// clear screen
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		// set the color
		GL11.glColor3f(1f, 1f, 1.0f);
		// draw quad
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2d(x - size, y - size); // bottom left
		GL11.glVertex2d(x + size, y - size); // top left
		GL11.glVertex2d(x + size, y + size); // top right
		GL11.glVertex2d(x - size, y + size); // bottom right
		GL11.glRotated(rot, 0, 0, 0);
		GL11.glEnd();
	}

	public void printValues() {
		System.out.println("X: " + x);
		System.out.println("Y: " + y);
		System.out.println("Rot: " + rot);
	}
}

package com.sss.main;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import com.sss.util.ResourceUtil;

public class SSS {

	private final int DefaultWidth = 800, DefaultHeight = 600;
	
	public SSS(){
		
	}
	
	/**
	 * Begins the SSS
	 */
	public void run(){
		ResourceUtil.getResources();
		createOpenGL();
		while(!Display.isCloseRequested()){
			
		}
		Display.destroy();
		System.exit(0);
	}
	
	/**
	 * Inits the OpenGL display
	 */
	public void createOpenGL(){
		try {
			Display.setDisplayMode(new DisplayMode(DefaultWidth, DefaultHeight));
			Display.setTitle("Sunset Space Simulation");
			Display.create();
			Keyboard.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SSS sss = new SSS();
		sss.run();
	}
	
}

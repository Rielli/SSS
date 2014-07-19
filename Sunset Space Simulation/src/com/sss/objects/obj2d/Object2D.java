package com.sss.objects.obj2d;

import org.newdawn.slick.opengl.Texture;

public class Object2D {
	
	private float width, height, x, y;
	private Texture texture;
	
	/**
	 * Base of 2D object
	 */
	public Object2D(){
		
	}
	
	/**
	 * Checks if the click was performed over this object
	 * @param clickx the x value of the click
	 * @param clicky the y value of the click
	 * @return true if the click "touched" this object.
	 */
	public boolean checkClick(float clickx, float clicky){
		if(clickx >= x - width/2 && clickx <= x + width/2)
			if(clicky >= y - height/2 && clicky <= y + height/2)
				return true;
		return false;
	}
	
	/**
	 * Sets the texture of this object
	 * @param t the new texture
	 */
	public void setTexture(Texture t){
		texture = t;
	}
	
}

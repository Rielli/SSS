package com.SSS.engine;

public class Transform {
	private Vector3f translation;
	
	public Transform() {
		translation = new Vector3f(0, 0, 0);
	}
	public Vector3f getTranslation() {
		return translation;
	}
	public void setTranslation(Vector3f translation) {
		this.translation = translation;
	}
}
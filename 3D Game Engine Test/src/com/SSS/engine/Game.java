package com.SSS.engine;
import org.lwjgl.input.Keyboard;

public class Game {
	private Mesh mesh;
	private Shader shader;
	
	public Game() {
		mesh = new Mesh();
		shader = new Shader();
		Vertex[] data = new Vertex[] {	new Vertex(new Vector3f(-1, -1, 0)),
									 	new Vertex(new Vector3f(-1, 1, 0)),
									 	new Vertex(new Vector3f(0, 1, 0)),
									 };
		mesh.addVertices(data);
		
		//load an external shader
		shader.addVertexShader(ResourceLoader.loadShader("basicVertex.vs"));
		shader.addFragmentShader(ResourceLoader.loadShader("basicFragment.fs"));
		//compile the external shaders
		shader.compileShader();
		
		shader.addUniform("uniformFloat");
	}
	public void input() {
		if (Input.getKeyDown(Keyboard.KEY_UP)) {
			System.out.println("pressed up");
		}
		if (Input.getKeyUp(Keyboard.KEY_UP)) {
			System.out.println("released up");
		}
		if (Input.getMouseDown(1)) {
			System.out.println("pressed right button at " + Input.getMousePosition().toString());
		}
		if (Input.getMouseUp(1)) {
			System.out.println("released right button");
		}
	}
	float temp = 0.0f;
	public void update() {
		temp += Time.getDelta();
		
		shader.setUniformf("uniformFloat", (float)(Math.abs(Math.sin(temp))));
	}
	public void render() {
		shader.bind();
		mesh.draw();
	}
}
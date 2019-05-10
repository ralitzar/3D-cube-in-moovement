package shaders;

import org.lwjgl.util.vector.Matrix4f;

import entities.Camera;
import utilities.Mathematic;

public class StaticShader extends ShaderProgram {
	
	private static final String VERTEX_FILE = "src/shaders/vetexShader.txt";
	private static final String FRAGMENT_FILE = "src/shaders/fragmentShader.txt";
	
	private int locationOfTransformationMatrix;
	private int locationOfProjectionMatrix;
	private int locationOfViewMatrix;

	public StaticShader() {
		super(VERTEX_FILE, FRAGMENT_FILE);
	}

	@Override
	protected void bindAttributes() {
		super.bindAttribute(0, "position");
		super.bindAttribute(1, "textureCoords");
	}

	@Override
	protected void getAllUniformLocations() {
		locationOfTransformationMatrix = super.getUniformLocation("transformationMatrix");
		locationOfProjectionMatrix = super.getUniformLocation("projectionMatrix");
		locationOfViewMatrix = super.getUniformLocation("viewMatrix");
	}
	
	public void loadTransformationMatrix(Matrix4f matrix) {
		super.loadMatrix(locationOfTransformationMatrix, matrix);
	}
	
	public void loadViewMatrix(Camera camera) {
		Matrix4f viewMatrix = Mathematic.createViewMatrix(camera);
		super.loadMatrix(locationOfViewMatrix, viewMatrix);
	}
	
	public void loadProjectionMatrix(Matrix4f projection) {
		super.loadMatrix(locationOfProjectionMatrix, projection);
	}
}

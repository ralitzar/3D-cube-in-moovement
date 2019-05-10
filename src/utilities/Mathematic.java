package utilities;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

import entities.Camera;

public class Mathematic {
	
	private static final float POV = 70;
	private static final float NEAR_PLANE = 0.1f;
	private static final float FAR_PLANE = 1000f;
	
	public static Matrix4f createTransformation(Vector3f translation, 
										float rx, float ry, float rz, 
										float scale) {
		Matrix4f matrix = new Matrix4f();
		
		matrix.setIdentity();
		
		Matrix4f.translate(translation, matrix, matrix);
		Matrix4f.rotate((float) Math.toRadians(rx), new Vector3f(1,0,0), matrix, matrix);
		Matrix4f.rotate((float) Math.toRadians(ry), new Vector3f(0,1,0), matrix, matrix);
		Matrix4f.rotate((float) Math.toRadians(rz), new Vector3f(0,0,1), matrix, matrix);
		Matrix4f.scale(new Vector3f(scale, scale, scale), matrix, matrix);
		
		return matrix;
		
	}
	
	public static Matrix4f createProjectionMatrix() {
		 float aspectRatio = (float)Display.getWidth()/(float)Display.getHeight();
		 float yScale = (float) ((1f/Math.tan(Math.toRadians(POV/2f))) * aspectRatio);
		 float xScale = yScale / aspectRatio;
		 float frustum = FAR_PLANE - NEAR_PLANE;
		 
		 Matrix4f projectionMatrix = new Matrix4f();
		 
		 projectionMatrix.m00 = xScale;
		 projectionMatrix.m11 = yScale;
		 projectionMatrix.m22 = -((FAR_PLANE + NEAR_PLANE) / frustum);
		 projectionMatrix.m23 = -1;
		 projectionMatrix.m32 = -((2*NEAR_PLANE*FAR_PLANE)/frustum);
		 projectionMatrix.m33 = 0;
		 
		 return projectionMatrix;
	 }
	
	public static Matrix4f createViewMatrix(Camera camera) {
		
		Matrix4f viewMatrix = new Matrix4f();
		
		viewMatrix.setIdentity();
		
		Matrix4f.rotate((float) Math.toRadians(camera.getPitch()), new Vector3f(1,0,0), viewMatrix, viewMatrix);
		Matrix4f.rotate((float) Math.toRadians(camera.getYaw()), new Vector3f(0,1,0), viewMatrix, viewMatrix);
		Matrix4f.rotate((float) Math.toRadians(camera.getRoll()), new Vector3f(0,0,1), viewMatrix, viewMatrix);
		Vector3f cameraPosition = camera.getPosition();
		Vector3f cameraNegativePosition = new Vector3f(-cameraPosition.x, -cameraPosition.y, -cameraPosition.z);
		Matrix4f.translate(cameraNegativePosition, viewMatrix, viewMatrix);
		
		return viewMatrix;
		
	}
	

}

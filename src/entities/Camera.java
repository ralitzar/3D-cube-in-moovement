package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

public class Camera {
	
	private Vector3f position = new Vector3f(0,0,0);
	private float pitch;
	private float yaw;
	private float roll;
	
	public Camera() {}
	
	public void moveCamera() {
		if(Keyboard.isKeyDown(Keyboard.KEY_Z)) {
			position.z -= 0.02f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_O)) {
			position.z += 0.02f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_L)) {
			position.x += 0.02f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_R)) {
			position.x -= 0.02f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_U)) {
			position.y -= 0.02f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
			position.y += 0.02f;
		}
	}

	public Vector3f getPosition() {
		return position;
	}

	public float getPitch() {
		return pitch;
	}

	public float getYaw() {
		return yaw;
	}

	public float getRoll() {
		return roll;
	}

}

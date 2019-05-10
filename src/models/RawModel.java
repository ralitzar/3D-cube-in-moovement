package models;

public class RawModel {
	
	private int vaoID;
	private int vetexCount;
	
	public RawModel(int vaoID, int vertexCount) {
		this.vaoID = vaoID;
		this.vetexCount = vertexCount;
	}

	public int getVaoID() {
		return vaoID;
	}

	public void setVaoID(int vaoID) {
		this.vaoID = vaoID;
	}

	public int getVetexCount() {
		return vetexCount;
	}

	public void setVetexCount(int vetexCount) {
		this.vetexCount = vetexCount;
	}
}

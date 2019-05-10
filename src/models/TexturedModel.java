package models;

import textures.TextureModel;

public class TexturedModel {
	
	private RawModel rawModel;
	private TextureModel texture;
	
	public TexturedModel(RawModel model, TextureModel texture) {
		this.rawModel = model;
		this.texture = texture;
	}

	public RawModel getRawModel() {
		return rawModel;
	}

	public TextureModel getTexture() {
		return texture;
	}

}

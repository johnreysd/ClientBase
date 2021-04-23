package dev.zihasz.clientbase.gui.clickgui;

public abstract class Component {

	private float x, y;

	public Component(float x, float y) {

	}

	public abstract void render();
	public abstract void onMouseDown();
	public abstract void onMouseUp();
	public abstract void onKeyTyped();

	public abstract float width();
	public abstract float height();

	public float getX() { return x; }
	public float getY() { return y; }

}

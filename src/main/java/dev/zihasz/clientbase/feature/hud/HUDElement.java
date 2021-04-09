package dev.zihasz.clientbase.feature.hud;

import dev.zihasz.clientbase.feature.Feature;
import dev.zihasz.clientbase.feature.traits.IToggleable;

import java.awt.*;

public abstract class HUDElement extends Feature implements IToggleable {

	public boolean enabled;
	public float x, y;

	public boolean drag = false;
	public float dragX, dragY;

	public HUDElement(String name, String description) {
		super(name, description);
	}

	public abstract void render();

	public abstract float width();
	public abstract float height();

	public boolean isEnabled() { return enabled; }
	public void setEnabled(boolean enabled) { this.enabled = enabled; }

}

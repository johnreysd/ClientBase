package dev.zihasz.clientbase.feature.traits;

import dev.zihasz.clientbase.feature.ITrait;

public interface IToggleable extends ITrait {

	boolean enabled = false;

	void enable();
	void disable();
	void toggle();

	boolean isEnabled();
	void setEnabled(boolean enabled);

	public void onEnable();
	public void onDisable();

}

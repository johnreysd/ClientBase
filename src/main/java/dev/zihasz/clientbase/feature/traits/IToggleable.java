package dev.zihasz.clientbase.feature.traits;

public interface IToggleable {

	boolean enabled = false;

	void enable();
	void disable();
	void toggle();

	boolean isEnabled();
	void setEnabled(boolean enabled);

	public void onEnable();
	public void onDisable();

}

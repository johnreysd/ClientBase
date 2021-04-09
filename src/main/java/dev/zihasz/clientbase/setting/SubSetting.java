/**
@author ZihaszDa1337coder
package dev.zihasz.clientbase.setting;

public class SubSetting<T> extends Setting<T> {

	private Setting<?> parent;

	public SubSetting(Setting<?> parent, String name, String description, T value, T min, T max) {
		super(name, description, value, min, max);
		this.parent = parent;
	}

	public SubSetting(Setting<?> parent, String name, String description, T value) {
		super(name, description, value);
		this.parent = parent;
	}

	public SubSetting(Setting<?> parent, String name, T value, T min, T max) {
		super(name, value, min, max);
		this.parent = parent;
	}

	public SubSetting(Setting<?> parent, String name, T value) {
		super(name, value);
		this.parent = parent;
	}

	public Setting<?> getParent() { return parent; }

}*/

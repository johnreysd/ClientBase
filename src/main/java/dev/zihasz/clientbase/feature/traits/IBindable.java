package dev.zihasz.clientbase.feature.traits;

import org.lwjgl.input.Keyboard;

public interface IBindable {

	int bind = Keyboard.KEY_NONE;

	int getBind();
	void setBind(int bind);

}

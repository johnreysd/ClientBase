package dev.zihasz.clientbase.feature.traits;

import dev.zihasz.clientbase.feature.ITrait;
import org.lwjgl.input.Keyboard;

public interface IBindable extends ITrait {

	int bind = Keyboard.KEY_NONE;

	int getBind();
	void setBind(int bind);

}

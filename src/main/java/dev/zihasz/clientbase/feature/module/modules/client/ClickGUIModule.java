package dev.zihasz.clientbase.feature.module.modules.client;

import dev.zihasz.clientbase.feature.module.Category;
import dev.zihasz.clientbase.feature.module.Module;
import org.lwjgl.input.Keyboard;

public class ClickGUIModule extends Module {

	public ClickGUIModule() {
		super("ClickGUI", "The \"control panel\" for your client", Category.CLIENT, Keyboard.KEY_RSHIFT);
	}

	@Override
	public void onEnable() {
		if (mc.currentScreen == null)
			mc.displayGuiScreen(null); /* TODO: Replace "null" with the actual ClickGUI class. */
	}

	@Override
	public void onDisable() {
		if (mc.currentScreen == null) /* TODO: Replace "null" with the actual ClickGUI class. */
			mc.displayGuiScreen(null);
	}
}

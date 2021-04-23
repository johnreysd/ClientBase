package dev.zihasz.clientbase.feature.module.modules.client;

import dev.zihasz.clientbase.feature.module.Category;
import dev.zihasz.clientbase.feature.module.Module;
import dev.zihasz.clientbase.setting.Setting;
import org.lwjgl.input.Keyboard;

import java.awt.*;

public class ClickGUIModule extends Module {

	public ClickGUIModule() {
		super("ClickGUI", "The \"control panel\" for your client", Category.CLIENT, Keyboard.KEY_RSHIFT);
	}

	Setting<Color> foregroundColor = new Setting<>("ForegroundColor", "The foreground color for the GUI.", new Color(152, 255, 152, 250));
	Setting<Color> backgroundColor = new Setting<>("BackgroundColor", "The background color for the GUI.", new Color(100, 100, 100, 125));
	Setting<Color> fontColor 	   = new Setting<>("FontColor", 	  "The font color for the GUI.", 	   new Color(255, 255, 255, 250));

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

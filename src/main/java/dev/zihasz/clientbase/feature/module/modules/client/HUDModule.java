package dev.zihasz.clientbase.feature.module.modules.client;

import dev.zihasz.clientbase.feature.hud.HUDElement;
import dev.zihasz.clientbase.feature.module.Category;
import dev.zihasz.clientbase.feature.module.Module;
import dev.zihasz.clientbase.gui.hud.HUDEditor;

public class HUDModule extends Module {

	public HUDModule() {
		super("HUD", "Enables the drawing of the HUD", Category.CLIENT);
	}

	@Override
	public void onRender() {
		HUDEditor.elements.stream().filter(HUDElement::isEnabled).forEach(HUDElement::render);
	}

}

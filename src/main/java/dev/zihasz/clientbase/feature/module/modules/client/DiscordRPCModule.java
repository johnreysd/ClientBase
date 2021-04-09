package dev.zihasz.clientbase.feature.module.modules.client;

import dev.zihasz.clientbase.DiscordPresence;
import dev.zihasz.clientbase.feature.module.Category;
import dev.zihasz.clientbase.feature.module.Module;

public class DiscordRPCModule extends Module {

	public DiscordRPCModule() {
		super("DiscordRPC", "Turns the Discord Rich Presence on/off", Category.CLIENT);
	}

	@Override
	public void onEnable() {
		DiscordPresence.start();
	}

	@Override
	public void onDisable() {
		DiscordPresence.stop();
	}
}

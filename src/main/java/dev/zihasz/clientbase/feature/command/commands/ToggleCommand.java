package dev.zihasz.clientbase.feature.command.commands;

import dev.zihasz.clientbase.feature.command.Command;
import dev.zihasz.clientbase.manager.managers.ModuleManager;
import net.minecraft.util.text.TextComponentString;

public class ToggleCommand extends Command {

	public ToggleCommand() {
		super("Toggle", "Toggles the specified module.", "toggle", "t", "togglemodule");
	}

	@Override
	public void run(String[] args) {
		if (args.length < 1) {
			mc.player.sendMessage(new TextComponentString("Give at least one argument"));
			return;
		}
		ModuleManager.getModule(args[0]).toggle();
	}
}
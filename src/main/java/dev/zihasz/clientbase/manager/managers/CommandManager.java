package dev.zihasz.clientbase.manager.managers;

import dev.zihasz.clientbase.feature.command.Command;
import dev.zihasz.clientbase.feature.module.Module;
import dev.zihasz.clientbase.manager.Manager;
import dev.zihasz.clientbase.setting.Setting;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class CommandManager extends Manager {

	private static List<Command> commands = new ArrayList<>();
	public static String commandPrefix = "&";

	public CommandManager() {
		MinecraftForge.EVENT_BUS.register(this);
		Set<Class> commandClasses = findClasses("dev.zihasz.clientbase.feature.command.commands", Command.class);
		commandClasses.forEach(commandClass -> {
			try {
				Command module = (Command) commandClass.getConstructor().newInstance();
				commands.add(module);
			}
			catch (InvocationTargetException e) { e.getCause().printStackTrace(); }
			catch (Exception e) { e.printStackTrace(); }
		});
	}

	public static void parseCommand(String... lines) {
		for (String line : lines) {
			String[] split = line.split(" ");

			String nameIn = split[0];
			String[] args = Arrays.copyOfRange(split, 1, split.length);

			for (Command command : commands) {
				for (String alias : command.getAliases()) {
					if (nameIn.equalsIgnoreCase(alias)) command.run(args);
				}
			}
		}
	}

	@SubscribeEvent
	public void onChat(ClientChatEvent event) {
		if (event.getMessage().startsWith(commandPrefix)) {
			CommandManager.parseCommand(event.getMessage().replaceFirst(commandPrefix, ""));
			event.setCanceled(true);

			Minecraft.getMinecraft().ingameGUI.getChatGUI().addToSentMessages(event.getMessage());
		}
	}

	public static Set<Class> findClasses(String pack, Class subType) {
		Reflections reflections = new Reflections(pack);
		return reflections.getSubTypesOf(subType);
	}

}

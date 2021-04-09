package dev.zihasz.clientbase.manager.managers;

import dev.zihasz.clientbase.feature.module.Category;
import dev.zihasz.clientbase.feature.module.Module;
import dev.zihasz.clientbase.manager.Manager;
import dev.zihasz.clientbase.setting.Setting;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import dev.zihasz.clientbase.util.utils.ReflectionUtils;
import org.reflections.Reflections;

public class ModuleManager extends Manager {

	private static List<Module> modules = new ArrayList<>();

	public ModuleManager() {
		Set<Class> moduleClasses = ReflectionUtils.findClasses("dev.zihasz.clientbase.feature.module.modules", Module.class);
		moduleClasses.forEach(moduleClass -> {
			try {
				addMod((Module) moduleClass.newInstance());
			}
			catch (Exception e) { e.printStackTrace(); }
		});
	}

	private void addMod(Module module) {
		try {
			for(Field field : module.getClass().getDeclaredFields()) {
				if (field.getType().equals(Setting.class)) {
					if (!field.isAccessible()) field.setAccessible(true);
					final Setting<?> setting = (Setting<?>) field.get(module);
					module.addSetting(setting);
				}
			}
		} catch (Exception e) { e.printStackTrace(); }

		modules.add(module);
	}

	public static List<Module> getModules() { return modules; }
	public static List<Module> getModules(Category category) { return modules.stream().filter(module -> module.getCategory() == category).collect(Collectors.toList()); }

	public static Module getModule(String name) { return modules.stream().filter(module -> module.getName().equalsIgnoreCase(name)).findFirst().orElse(null); }
	public static Module getModule (Class<? extends Module> clazz) { return modules.stream().filter(module -> module.getClass().equals(clazz)).findFirst().orElse(null); }

}

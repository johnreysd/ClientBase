package dev.zihasz.clientbase.feature.module.modules.movement;

import dev.zihasz.clientbase.feature.module.Category;
import dev.zihasz.clientbase.feature.module.Module;
import dev.zihasz.clientbase.setting.Setting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Sprint extends Module {

	public Sprint() {
		super("Sprint", "Automatically sprints", Category.MOVEMENT);
	}

	private final Setting<Boolean> safe = new Setting<>("Safe", "Only sprint when you have enough food level", true);

	@SubscribeEvent
	public void onTick(TickEvent.ClientTickEvent event) {
		if (safe.getValue()) mc.player.setSprinting(mc.player.foodStats.getFoodLevel() > 6);
		else mc.player.setSprinting(true);
	}

}

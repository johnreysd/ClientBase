package dev.zihasz.clientbase.feature.module.modules.render;

import dev.zihasz.clientbase.feature.module.Category;
import dev.zihasz.clientbase.feature.module.Module;
import dev.zihasz.clientbase.setting.Setting;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;

public class FullBright extends Module {

	public FullBright() {
		super("FullBright", "Makes everything maximum brightness", Category.RENDER);
	}

	private final Setting<Mode> mode = new Setting<>("Mode", "The mode to use for brightening the game", Mode.POTION);

	private float oldGamma = 0f;

	@Override
	public void onEnable() {
		switch (mode.getValue()) {
			case POTION:
				mc.player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 9999));
				break;
			case GAMMA:
				oldGamma = mc.gameSettings.gammaSetting;
				mc.gameSettings.gammaSetting = 100f;
		}
	}

	@Override
	public void onDisable() {
		switch (mode.getValue()) {
			case POTION:
				mc.player.removePotionEffect(MobEffects.NIGHT_VISION);
				break;
			case GAMMA:
				mc.gameSettings.gammaSetting = oldGamma;
				break;
		}
	}

	private enum Mode {
		POTION,
		GAMMA,
	}

}

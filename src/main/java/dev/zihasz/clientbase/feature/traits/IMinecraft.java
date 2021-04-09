package dev.zihasz.clientbase.feature.traits;

import dev.zihasz.clientbase.feature.ITrait;
import net.minecraft.client.Minecraft;

public interface IMinecraft extends ITrait {

	Minecraft mc = Minecraft.getMinecraft();

}

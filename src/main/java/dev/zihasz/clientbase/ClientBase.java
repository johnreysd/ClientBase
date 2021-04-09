package dev.zihasz.clientbase;

import dev.zihasz.clientbase.event.EventProcessor;
import dev.zihasz.clientbase.manager.managers.CommandManager;
import dev.zihasz.clientbase.manager.managers.ModuleManager;
import dev.zihasz.clientbase.mixin.MixinLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ClientBase.MOD_ID, name = ClientBase.MOD_NAME, version = ClientBase.MOD_VER)
public class ClientBase {

    public static final String MOD_NAME = "ClientBase";
    public static final String MOD_ID   = "clientbase";
    public static final String MOD_VER  = "v1.0";

    public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);
    public static final EventBus EVENT_BUS = new EventBus();

    public static EventProcessor eventProcessor;
    public static MixinLoader mixinLoader;

    // Managers
    public static CommandManager commandManager;
    public static ModuleManager moduleManager;

    // Load mixins and commands here
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        eventProcessor = new EventProcessor();
        mixinLoader = new MixinLoader();
    }

    // Load features here
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

        commandManager = new CommandManager();
        moduleManager = new ModuleManager();

    }

    // Load events, capes, rich presence here
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

}

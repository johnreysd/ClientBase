package dev.zihasz.clientbase.feature.module;

import dev.zihasz.clientbase.ClientBase;
import dev.zihasz.clientbase.feature.Feature;
import dev.zihasz.clientbase.feature.traits.IBindable;
import dev.zihasz.clientbase.feature.traits.IMinecraft;
import dev.zihasz.clientbase.feature.traits.IToggleable;
import dev.zihasz.clientbase.feature.traits.IVisible;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.input.Keyboard;

public abstract class Module extends Feature implements IBindable, IToggleable, IVisible, IMinecraft {

    private Category category;

    private int bind;
    private boolean enabled;
    private boolean visible;

    public Module(String name, String description, Category category, int bind, boolean visible) {
        super(name, description);
        this.category = category;
        this.bind = bind;
        this.visible = visible;
    }
    public Module(String name, String description, Category category, int bind) { this(name, description, category, bind, true); }
    public Module(String name, String description, Category category)           { this(name, description, category, Keyboard.KEY_NONE); }
    public Module(String name, Category category)                               { this(name, "", category); }

    public void enable() {
        this.onPreEnable();
        this.enabled = true;
        MinecraftForge.EVENT_BUS.register(this);
        ClientBase.EVENT_BUS.register(this);
        this.onEnable();
    }
    public void disable() {
        this.onPreDisable();
        this.enabled = false;
        MinecraftForge.EVENT_BUS.unregister(this);
        ClientBase.EVENT_BUS.unregister(this);
        this.onDisable();
    }
    public void toggle() {
        if (enabled) disable();
        else enable();
    }

    public void onClientTick() {}
    public void onServerTick() {}
    public void onPlayerTick() {}
    public void onWorldTick() {}
    public void onRender() {}
    public void onWorldRender(RenderWorldLastEvent event) {}

    public void onPreEnable() {}
    public void onPreDisable() {}
    public void onEnable() {}
    public void onDisable() {}

    public Category getCategory() { return category; }
    public int getBind() { return bind; }
    public boolean isEnabled() { return enabled; }
    public boolean isVisible() { return visible; }

    public void setCategory(Category category) { this.category = category; }
    public void setBind(int bind) { this.bind = bind; }

    /**
     * NOTE: doesnt subscribe modules to event bus also doesnt call onEnable() or onDisable()
      * @param enabled new enabled value
     */
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
    public void setVisible(boolean visible) { this.visible = visible; }
}

package dev.zihasz.clientbase.feature.command;

import dev.zihasz.clientbase.feature.Feature;

public abstract class Command extends Feature implements ICommand {

    private String[] aliases;

    public Command(String name, String description, String... aliases) {
        super(name, description);
        this.aliases = aliases;
    }

    public void run(String[] args) {}

    public String[] getAliases() { return aliases; }
}

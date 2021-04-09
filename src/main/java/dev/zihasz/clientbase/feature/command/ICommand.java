package dev.zihasz.clientbase.feature.command;


public interface ICommand {

	String[] aliases = new String[] {};
	String[] getAliases();

	void run(String[] args);

}

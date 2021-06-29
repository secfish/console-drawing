package com.yong.consoledrawing.command;


public class QuitCommand implements Command {
    public static String helpMessage = "Q               Should quit the program.";
    
	@Override
	public void execute() {
        System.out.println("Exiting...");
        System.exit(0);
	}

}
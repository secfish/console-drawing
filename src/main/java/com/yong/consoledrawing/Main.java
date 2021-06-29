package com.yong.consoledrawing;

import com.yong.consoledrawing.command.*;
import com.yong.consoledrawing.model.Canvas;


import java.util.Scanner;

public class Main {
    private static Canvas         canvas;
   
    public static void main(String[] args) throws NumberFormatException, InterruptedException {
    	// show  menu
        printMenu();
        
        // process command from console
        System.out.println("Enter command:");
        try( Scanner scanner = new Scanner(System.in)){
	        while (true) {
	            process(scanner.nextLine());
	            System.out.println("Enter command:");
	        }
        }
    }
 
    /**
     * process commands from console
     * @param commandLine  
     */
    private static void process(String commandLine) {
        Command command = null;
        try {
            command = CommandFactory.getCommand(commandLine);
        } catch (InvalidCommandException e) {
            System.out.println("Please enter a valid command.");
            printMenu();
        } catch (InvalidCommandParams invalidCommandParams) {
            System.out.println("Command syntax is not correct: " + invalidCommandParams.getMessage());
            System.out.println("Refer to following correct syntax: \n" + invalidCommandParams.getHelpMessage());
        }        
        if (command instanceof CreateCommand) {
        	command.execute();
        	// update new canvas 
            canvas = ((CreateCommand)command).getCanvas();
        }
        else if (command instanceof QuitCommand) {
        	command.execute();
        }
        else if (command instanceof DrawEntityCommand) {
        	// draw it 
        	((DrawEntityCommand)command).setCanvas(canvas);
        	command.execute();
        }
    }
    
    /**
     *  show command menu 
     */
    private static void printMenu() {
        System.out.println("**************************************************************");
        System.out.println("* C w h          Create a new canvas of width w and height h *");
        System.out.println("* L x1 y1 x2 y2  Draw a new line from (x1,y1) to (x2,y2)     *");
        System.out.println("* R x1 y1 x2 y2  Draw a rectangle with (x1,y1)->(x2,y2)      *");
        System.out.println("* Q              to Exit                                     *");
        System.out.println("**************************************************************");
    }
}

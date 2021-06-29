package com.yong.consoledrawing.command;


import com.yong.consoledrawing.model.Canvas;
import com.yong.consoledrawing.model.ConsoleCanvas;
import com.yong.consoledrawing.util.Utils;

public class CreateCommand implements Command {

    private static String helpMessage = "C w h           Create a new canvas of width w and height h. w, h should be > 0";
    private int height;
    private int width;
    private Canvas canvas;
    
    public CreateCommand(String... params) {
        if (params.length < 2)
            throw new InvalidCommandParams("Create command expects 2 params", helpMessage);
        try {
            width = Utils.toPositiveInt(params[0]);
            height = Utils.toPositiveInt(params[1]);
            canvas = new ConsoleCanvas(this.width, this.height);
        } catch (IllegalArgumentException e) {
            throw new InvalidCommandParams("Number must >= 0", helpMessage);
        }
    }   

    public Canvas getCanvas() {
      return canvas;
    }
    
    public int getHeight() {
        return height;
    }

    public CreateCommand setHeight(int height) {
        this.height = height;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public CreateCommand setWidth(int width) {
        this.width = width;
        return this;
    }

	@Override
	public void execute() {
        System.out.println(canvas.render());		
	}
}
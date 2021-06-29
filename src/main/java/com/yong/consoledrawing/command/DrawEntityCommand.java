package com.yong.consoledrawing.command;

import com.yong.consoledrawing.model.Canvas;
import com.yong.consoledrawing.model.EntityFactory;
import com.yong.consoledrawing.model.InvalidEntityException;

public class DrawEntityCommand implements Command {
	protected Canvas canvas;

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	public void execute() {
		if (canvas == null) {
			System.out.println("You need to create a canvas first");
			return;
		}
		try {
			canvas.addEntity(EntityFactory.getEntity(this));
			System.out.println(canvas.render());
		} catch (InvalidEntityException e) {
			System.out.println("Can not add the model to canvas: " + e.getMessage());
		}
	}

}

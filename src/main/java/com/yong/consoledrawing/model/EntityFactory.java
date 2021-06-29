package com.yong.consoledrawing.model;

import com.yong.consoledrawing.command.BucketFillCommand;
import com.yong.consoledrawing.command.DrawEntityCommand;
import com.yong.consoledrawing.command.DrawLineCommand;
import com.yong.consoledrawing.command.DrawRectangleCommand;

public class EntityFactory {

    public static Entity getEntity(DrawEntityCommand command) {
        if (command instanceof DrawLineCommand) {
        	// line 
            DrawLineCommand cmd = (DrawLineCommand) command;
            return new Line(cmd.getX1(), cmd.getY1(), cmd.getX2(), cmd.getY2());
        } else if (command instanceof DrawRectangleCommand) {
        	// rectangle
            DrawRectangleCommand cmd = (DrawRectangleCommand) command;
            return new Rectangle(cmd.getX1(), cmd.getY1(), cmd.getX2(), cmd.getY2());
        } else if (command instanceof BucketFillCommand) {
        	// bucketfill
            BucketFillCommand cmd = (BucketFillCommand) command;
            return new BucketFill(cmd.getX(), cmd.getY(), cmd.getCharacter());
        }
        return null;
    }
}

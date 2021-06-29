package com.yong.consoledrawing.model;

public interface Canvas {

    public void addEntity(Entity entity) throws InvalidEntityException;

    public String render();
}

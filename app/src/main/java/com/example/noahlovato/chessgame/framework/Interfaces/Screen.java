package com.example.noahlovato.chessgame.framework.Interfaces;

/**
 * Created by noah.lovato on 7/28/2017.
 */

public abstract class Screen {

    protected final Game game;

    public Screen(Game game) {
        this.game = game;
    }

    public abstract void update(float deltaTime);

    public abstract void present(float deltaTime);

    public abstract void pause();

    public abstract void resume();

    public abstract void dispose();

}

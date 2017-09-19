package com.example.noahlovato.chessgame.framework.Interfaces;

/**
 * Created by noah.lovato on 7/28/2017.
 */

public interface Game {

    public Input getInput();

    public FileIO getFileIO();

    public Graphics getGraphics();

    public Audio getAudio();

    public void setScreen(Screen screen);

    public Screen getCurrentScreen();

    public Screen getStartScreen();

}

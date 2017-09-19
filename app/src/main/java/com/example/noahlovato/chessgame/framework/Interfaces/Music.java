package com.example.noahlovato.chessgame.framework.Interfaces;

/**
 * Created by noah.lovato on 7/28/2017.
 */

public interface Music {

    public void play();

    public void stop();

    public void pause();

    public void setLooping(boolean looping);

    public void setVolume(float volume);

    public boolean isPlaying();

    public boolean isStopped();

    public boolean isLooping();

    public void dispose();

}

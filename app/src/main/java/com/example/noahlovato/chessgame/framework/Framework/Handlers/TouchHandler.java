package com.example.noahlovato.chessgame.framework.Framework.Handlers;

import android.view.View;

import com.example.noahlovato.chessgame.framework.Interfaces.Input;

import java.util.List;

/**
 * Created by noah.lovato on 7/31/2017.
 */

public interface TouchHandler extends View.OnTouchListener {

    public boolean isTouchDown(int pointer);
    public int getTouchX(int pointer);
    public int getTouchY(int pointer);
    public List<Input.TouchEvent> getTouchEvents();

}

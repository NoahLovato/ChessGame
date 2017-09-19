package com.example.noahlovato.chessgame.framework.Framework;

import android.content.Context;
import android.view.View;

import com.example.noahlovato.chessgame.framework.Framework.Handlers.AccelerometerHandler;
import com.example.noahlovato.chessgame.framework.Framework.Handlers.KeyboardHandler;
import com.example.noahlovato.chessgame.framework.Framework.Handlers.MultiTouchHandler;
import com.example.noahlovato.chessgame.framework.Framework.Handlers.TouchHandler;
import com.example.noahlovato.chessgame.framework.Interfaces.Input;

import java.util.List;

/**
 * Created by noah.lovato on 7/31/2017.
 */

public class AndroidInput implements Input{

    AccelerometerHandler accelerometerHandler;
    KeyboardHandler keyboardHandler;
    TouchHandler touchHandler;

    public AndroidInput(Context context, View view, float scaleX, float scaleY ){

        accelerometerHandler = new AccelerometerHandler(context);
        keyboardHandler = new KeyboardHandler(view);
        touchHandler = new MultiTouchHandler(view , scaleX, scaleY);

    }

    @Override
    public boolean isKeyPressed(int keyCode) {
        return keyboardHandler.isKeyPressed(keyCode);
    }

    @Override
    public boolean isTouchDown(int pointer) {
        return touchHandler.isTouchDown(pointer);
    }

    @Override
    public int getTouchX(int pointer) {
        return touchHandler.getTouchX(pointer);
    }

    @Override
    public int getTouchY(int pointer) {
        return touchHandler.getTouchY(pointer);
    }

    @Override
    public float getAccelX() {
        return accelerometerHandler.getAccelX();
    }

    @Override
    public float getAccelY() {
        return accelerometerHandler.getAccelY();
    }

    @Override
    public float getAccelZ() {
        return accelerometerHandler.getAccelZ();
    }

    @Override
    public List<TouchEvent> getTouchEvents() {
        return touchHandler.getTouchEvents();
    }

    @Override
    public List<KeyEvent> getKeyEvents() {
        return keyboardHandler.getKeyEvents();
    }

}

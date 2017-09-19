package com.example.noahlovato.chessgame.framework.Framework;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.example.noahlovato.chessgame.framework.Interfaces.Audio;
import com.example.noahlovato.chessgame.framework.Interfaces.FileIO;
import com.example.noahlovato.chessgame.framework.Interfaces.Game;
import com.example.noahlovato.chessgame.framework.Interfaces.Graphics;
import com.example.noahlovato.chessgame.framework.Interfaces.Input;
import com.example.noahlovato.chessgame.framework.Interfaces.Screen;
import com.example.noahlovato.chessgame.model.pieces.Pawn;
import com.example.noahlovato.chessgame.model.pieces.Piece;

/**
 * Created by noah.lovato on 7/31/2017.
 */

public class AndroidGame extends Activity implements Game {

    AndroidFastRenderView renderView;
    Graphics graphics;
    Audio audio;
    Input input;
    FileIO fileIO;
    Screen screen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        boolean isLandscape = getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_LANDSCAPE;

        int frameBufferWidth = isLandscape ? 1024 : 576;
        int frameBufferHeight = isLandscape ? 576 : 1024;
        Bitmap frameBuffer = Bitmap.createBitmap(frameBufferWidth, frameBufferHeight,
                Bitmap.Config.RGB_565);

        float scaleX = (float) frameBufferWidth / getWindowManager().getDefaultDisplay().
                getWidth();

        float scaleY = (float) frameBufferWidth / getWindowManager().getDefaultDisplay().
                getHeight();

        renderView = new AndroidFastRenderView(this, frameBuffer);
        graphics = new AndroidGraphics(getAssets(), frameBuffer);
        fileIO = new AndroidFileIO(this);
        audio = new AndroidAudio(this);
        input = new AndroidInput(this, renderView, scaleX, scaleY);
        screen = getStartScreen();
        setContentView(renderView);

    }

    @Override
    protected void onResume() {
        super.onResume();
        screen.resume();
        renderView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        renderView.pause();
        screen.pause();

        if(isFinishing())
            screen.dispose();

    }

    @Override
    public Input getInput() {
        return input;
    }

    @Override
    public FileIO getFileIO() {
        return fileIO;
    }

    @Override
    public Graphics getGraphics() {
        return graphics;
    }

    @Override
    public Audio getAudio() {
        return audio;
    }

    public void setScreen(Screen screen) {

        if(screen == null)
            throw new IllegalArgumentException("Screen must not be null");

        this.screen.pause();
        this.screen.dispose();
        screen.resume();
        screen.update(0);
        this.screen = screen;

    }

    @Override
    public Screen getCurrentScreen() {
        return screen;
    }

    @Override
    public Screen getStartScreen() {
        return null;
    }
}

package com.example.noahlovato.chessgame;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.noahlovato.chessgame.framework.Framework.AndroidGame;
import com.example.noahlovato.chessgame.framework.Interfaces.Screen;
import com.example.noahlovato.chessgame.model.Board;

public class ChessGame extends AndroidGame {

    @Override
    public Screen getStartScreen() {
        return new LoadingScreen(this);
    }

}

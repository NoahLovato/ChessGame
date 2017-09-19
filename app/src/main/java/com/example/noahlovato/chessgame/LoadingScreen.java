package com.example.noahlovato.chessgame;

import com.example.noahlovato.chessgame.framework.Interfaces.Game;
import com.example.noahlovato.chessgame.framework.Interfaces.Graphics;
import com.example.noahlovato.chessgame.framework.Interfaces.Screen;

/**
 * Created by noah.lovato on 8/28/2017.
 */

public class LoadingScreen extends Screen {

    public LoadingScreen(Game game){
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        Assets.board = g.newPixmap("chess_board.png", Graphics.PixmapFormat.RGB565);
        Assets.pieces = g.newPixmap("chess_pieces.png", Graphics.PixmapFormat.RGB565);
        Assets.loadingScreen = g.newPixmap("loading.png", Graphics.PixmapFormat.RGB565);
        game.setScreen(new GameScreen(game));
    }

    @Override
    public void present(float deltaTime) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
}

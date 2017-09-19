package com.example.noahlovato.chessgame.model.pieces;

import com.example.noahlovato.chessgame.model.pieces.Piece;

/**
 * Created by noah.lovato on 8/28/2017.
 */

public class Queen extends Piece {

    //coordinates of screen pixels to start drawing at
    public final static int X_START = 23;
    public final static int Y_START = 267;

    //dimensions of queen image
    public final static int WIDTH = 63;
    public final static int HEIGHT = 60;

    //coordinates of white queen image in pieces.png
    public final static int WHITE_X_COORD = 289;
    public final static int WHITE_Y_COORD = 14;

    //coordinates of the black queen image in pieces.png
    public final static int BLACK_X_COORD = 289;
    public final static int BLACK_Y_COORD = 86;

    public Queen(int color){
        super(PieceAttribute.TYPE_QUEEN, color);
    }

    @Override
    public boolean canMoveTo(int destX, int destY) {
        return false;
    }

    @Override
    public void moveTo(int destX, int destY) {

    }
}

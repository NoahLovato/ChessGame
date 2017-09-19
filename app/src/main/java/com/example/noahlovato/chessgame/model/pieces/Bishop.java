package com.example.noahlovato.chessgame.model.pieces;

/**
 * Created by noah.lovato on 8/28/2017.
 */

public class Bishop extends Piece {

    //coordinates of screen pixels to start drawing at
    public final static int X_START = 23;
    public final static int Y_START = 272;

    //dimensions of bishop image
    public final static int WIDTH = 62;
    public final static int HEIGHT = 54;

    //coordinates of white bishop image in pieces.png
    public final static int WHITE_X_COORD = 149;
    public final static int WHITE_Y_COORD = 19;

    //coordinates of the black bishop image in pieces.png
    public final static int BLACK_X_COORD = 149;
    public final static int BLACK_Y_COORD = 91;

    public Bishop(int color){
        super(PieceAttribute.TYPE_BISHOP, color);
    }

    @Override
    public boolean canMoveTo(int destX, int destY) {
        return false;
    }

    @Override
    public void moveTo(int destX, int destY) {

    }
}

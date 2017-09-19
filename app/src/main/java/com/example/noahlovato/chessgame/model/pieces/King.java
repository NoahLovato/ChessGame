package com.example.noahlovato.chessgame.model.pieces;

/**
 * Created by noah.lovato on 8/28/2017.
 */

public class King extends Piece {

    //coordinates of screen pixels to start drawing at
    public final static int X_START = 23;
    public final static int Y_START = 257;

    //dimensions of king image
    public final static int WIDTH = 63;
    public final static int HEIGHT = 70;

    //coordinates of white king image in pieces.png
    public final static int WHITE_X_COORD = 359;
    public final static int WHITE_Y_COORD = 4;

    //coordinates of the black king image in pieces.png
    public final static int BLACK_X_COORD = 359;
    public final static int BLACK_Y_COORD = 76;

    public King(int color){
        super(PieceAttribute.TYPE_KING, color);
    }

    @Override
    public boolean canMoveTo(int destX, int destY) {
        return false;
    }

    @Override
    public void moveTo(int destX, int destY) {

    }
}

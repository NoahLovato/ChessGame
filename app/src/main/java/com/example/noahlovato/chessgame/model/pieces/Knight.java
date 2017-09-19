package com.example.noahlovato.chessgame.model.pieces;

/**
 * Created by noah.lovato on 8/28/2017.
 */

public class Knight extends Piece {

    //coordinates of screen pixels to start drawing at
    public final static int X_START = 22;
    public final static int Y_START = 276;

    //dimensions of knight image
    public final static int WIDTH = 64;
    public final static int HEIGHT = 51;

    //coordinates of white knight image in pieces.png
    public final static int WHITE_X_COORD = 217;
    public final static int WHITE_Y_COORD = 23;

    //coordinates of the black knight image in pieces.png
    public final static int BLACK_X_COORD = 217;
    public final static int BLACK_Y_COORD = 95;

    public Knight(int color){
        super(PieceAttribute.TYPE_KNIGHT, color);
    }

    @Override
    public boolean canMoveTo(int destX, int destY) {
        return false;
    }

    @Override
    public void moveTo(int destX, int destY) {

    }
}

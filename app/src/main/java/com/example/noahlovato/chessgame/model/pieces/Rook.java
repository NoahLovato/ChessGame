package com.example.noahlovato.chessgame.model.pieces;

import com.example.noahlovato.chessgame.model.pieces.Piece;

/**
 * Created by noah.lovato on 8/28/2017.
 */

public class Rook extends Piece {

    //coordinates of screen pixels to start drawing at
    public final static int X_START = 23;
    public final static int Y_START = 278;

    //dimensions of rook image
    public final static int WIDTH = 63;
    public final static int HEIGHT = 49;

    //coordinates of white rook image in pieces.png
    public final static int WHITE_X_COORD = 79;
    public final static int WHITE_Y_COORD = 25;

    //coordinates of the black rook image in pieces.png
    public final static int BLACK_X_COORD = 79;
    public final static int BLACK_Y_COORD = 97;

    public Rook(int color){
        super(PieceAttribute.TYPE_ROOK, color);
    }

    @Override
    public boolean canMoveTo(int destX, int destY) {
        return false;
    }

    @Override
    public void moveTo(int destX, int destY) {

    }
}

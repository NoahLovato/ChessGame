package com.example.noahlovato.chessgame.model.pieces;

/**
 * Created by noah.lovato on 8/28/2017.
 */

public abstract class Piece {

    public class PieceAttribute {

        public static final int TYPE_PAWN = 1;
        public static final int TYPE_KNIGHT = 2;
        public static final int TYPE_BISHOP = 3;
        public static final int TYPE_ROOK = 4;
        public static final int TYPE_QUEEN = 5;
        public static final int TYPE_KING = 6;

        public static final int COLOR_BLACK = 7;
        public static final int COLOR_WHITE = 8;

    }

    public int x,y;
    public int type;
    public int color;

    public Piece() {
        this.type = 0;
        this.color = 0;
        this.x = 0;
        this.y = 0;
    }


    public Piece(int type, int color){
        this.type = type;
        this.color = color;
        this.x = 0;
        this.y = 0;
    }

    public abstract boolean canMoveTo(int destX, int destY);
    public abstract void moveTo(int destX, int destY);

}

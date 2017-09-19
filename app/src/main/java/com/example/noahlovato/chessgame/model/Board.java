package com.example.noahlovato.chessgame.model;

import com.example.noahlovato.chessgame.model.pieces.Bishop;
import com.example.noahlovato.chessgame.model.pieces.King;
import com.example.noahlovato.chessgame.model.pieces.Knight;
import com.example.noahlovato.chessgame.model.pieces.Pawn;
import com.example.noahlovato.chessgame.model.pieces.Piece;
import com.example.noahlovato.chessgame.model.pieces.Queen;
import com.example.noahlovato.chessgame.model.pieces.Rook;

/**
 * Created by noah.lovato on 8/28/2017.
 */

public class Board {

    //Offset used to calculate piece pixel position on board
    public final static int X_OFFSET = 67;
    public final static int Y_OFFSET = 63;

    public Piece[][] grid;

    //Standard board is 8x8 squares.
    public Board(){
       this.grid = new Piece[8][8];
    }

    public void addPiece(Piece piece, int x, int y){
        this.grid[x][y] = piece;
    }

    public void removePieceAt(int x, int y){
        this.grid[x][y] = null;
    }

    //Returns the piece currently in that spot on the board.
    //Coordinates origin of 2d array is (0,0) in top left corner.
    public Piece pieceAt(int x, int y){
        return grid[x][y];
    }

    //Moves piece in square srcX, srcY to square destX, destY
    public void movePiece(int srcX, int srcY, int destX, int destY){

        Piece pieceToMove = pieceAt(srcX,srcY);
        if(pieceToMove != null) {
            addPiece(pieceToMove, destX, destY);
            removePieceAt(srcX, srcY);
        }

    }

    //Fills board with all pieces in starting position
    public void populate(){
        addWhitePieces();
        addBlackPieces();
    }

    //Puts white pieces to starting positions on board
    //Need to make individual pieces so references are not shared
    private void addWhitePieces() {

        //Create and add pawns
        Pawn whitePawn1 = new Pawn(Piece.PieceAttribute.COLOR_WHITE);
        Pawn whitePawn2 = new Pawn(Piece.PieceAttribute.COLOR_WHITE);
        Pawn whitePawn3 = new Pawn(Piece.PieceAttribute.COLOR_WHITE);
        Pawn whitePawn4 = new Pawn(Piece.PieceAttribute.COLOR_WHITE);
        Pawn whitePawn5 = new Pawn(Piece.PieceAttribute.COLOR_WHITE);
        Pawn whitePawn6 = new Pawn(Piece.PieceAttribute.COLOR_WHITE);
        Pawn whitePawn7 = new Pawn(Piece.PieceAttribute.COLOR_WHITE);
        Pawn whitePawn8 = new Pawn(Piece.PieceAttribute.COLOR_WHITE);
        addPiece(whitePawn1,0,1);
        addPiece(whitePawn2,1,1);
        addPiece(whitePawn3,2,1);
        addPiece(whitePawn4,3,1);
        addPiece(whitePawn5,4,1);
        addPiece(whitePawn6,5,1);
        addPiece(whitePawn7,6,1);
        addPiece(whitePawn8,7,1);

        //Create and add knights
        Knight whiteKnight1 = new Knight(Piece.PieceAttribute.COLOR_WHITE);
        Knight whiteKnight2 = new Knight(Piece.PieceAttribute.COLOR_WHITE);
        addPiece(whiteKnight1,1,0);
        addPiece(whiteKnight2,6,0);

        //Create and add bishops
        Bishop whiteBishop1 = new Bishop(Piece.PieceAttribute.COLOR_WHITE);
        Bishop whiteBishop2 = new Bishop(Piece.PieceAttribute.COLOR_WHITE);
        addPiece(whiteBishop1,2,0);
        addPiece(whiteBishop2,5,0);

        //Create and add rooks
        Rook whiteRook1 = new Rook(Piece.PieceAttribute.COLOR_WHITE);
        Rook whiteRook2 = new Rook(Piece.PieceAttribute.COLOR_WHITE);
        addPiece(whiteRook1,0,0);
        addPiece(whiteRook2,7,0);

        //Create and add queen
        Queen whiteQueen = new Queen(Piece.PieceAttribute.COLOR_WHITE);
        addPiece(whiteQueen,3,0);

        //Create and add king
        King whiteKing = new King(Piece.PieceAttribute.COLOR_WHITE);
        addPiece(whiteKing,4,0);

    }

    //Puts black pieces to starting positions on board
    //Need to make individual pieces so references are not shared
    private void addBlackPieces() {

        //Create and add pawns
        Pawn blackPawn1 = new Pawn(Piece.PieceAttribute.COLOR_BLACK);
        Pawn blackPawn2 = new Pawn(Piece.PieceAttribute.COLOR_BLACK);
        Pawn blackPawn3 = new Pawn(Piece.PieceAttribute.COLOR_BLACK);
        Pawn blackPawn4 = new Pawn(Piece.PieceAttribute.COLOR_BLACK);
        Pawn blackPawn5 = new Pawn(Piece.PieceAttribute.COLOR_BLACK);
        Pawn blackPawn6 = new Pawn(Piece.PieceAttribute.COLOR_BLACK);
        Pawn blackPawn7 = new Pawn(Piece.PieceAttribute.COLOR_BLACK);
        Pawn blackPawn8 = new Pawn(Piece.PieceAttribute.COLOR_BLACK);
        addPiece(blackPawn1,0,6);
        addPiece(blackPawn2,1,6);
        addPiece(blackPawn3,2,6);
        addPiece(blackPawn4,3,6);
        addPiece(blackPawn5,4,6);
        addPiece(blackPawn6,5,6);
        addPiece(blackPawn7,6,6);
        addPiece(blackPawn8,7,6);

        //Create and add knights
        Knight blackKnight1 = new Knight(Piece.PieceAttribute.COLOR_BLACK);
        Knight blackKnight2 = new Knight(Piece.PieceAttribute.COLOR_BLACK);
        addPiece(blackKnight1,1,7);
        addPiece(blackKnight2,6,7);

        //Create and add bishops
        Bishop blackBishop1 = new Bishop(Piece.PieceAttribute.COLOR_BLACK);
        Bishop blackBishop2 = new Bishop(Piece.PieceAttribute.COLOR_BLACK);
        addPiece(blackBishop1,2,7);
        addPiece(blackBishop2,5,7);

        //Create and add rooks
        Rook blackRook1 = new Rook(Piece.PieceAttribute.COLOR_BLACK);
        Rook blackRook2 = new Rook(Piece.PieceAttribute.COLOR_BLACK);
        addPiece(blackRook1,0,7);
        addPiece(blackRook2,7,7);

        //Create and add queen
        Queen blackQueen = new Queen(Piece.PieceAttribute.COLOR_BLACK);
        addPiece(blackQueen,4,7);

        //Create and add king
        King blackKing = new King(Piece.PieceAttribute.COLOR_BLACK);
        addPiece(blackKing,3,7);

    }

}

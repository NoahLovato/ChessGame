package com.example.noahlovato.chessgame;

import android.util.Log;

import com.example.noahlovato.chessgame.framework.Interfaces.Game;
import com.example.noahlovato.chessgame.framework.Interfaces.Graphics;
import com.example.noahlovato.chessgame.framework.Interfaces.Input;
import com.example.noahlovato.chessgame.framework.Interfaces.Screen;
import com.example.noahlovato.chessgame.model.Board;
import com.example.noahlovato.chessgame.model.pieces.Bishop;
import com.example.noahlovato.chessgame.model.pieces.King;
import com.example.noahlovato.chessgame.model.pieces.Knight;
import com.example.noahlovato.chessgame.model.pieces.Pawn;
import com.example.noahlovato.chessgame.model.pieces.Piece;
import com.example.noahlovato.chessgame.model.pieces.Queen;
import com.example.noahlovato.chessgame.model.pieces.Rook;

import java.util.List;

/**
 * Created by noah.lovato on 8/28/2017.
 */

public class GameScreen extends Screen {

    int boardX = -1;
    int boardY = -1;
    int selectedX = -1;
    int selectedY = -1;
    Piece selectedPiece;
    Board board;

    public GameScreen(Game game){
        super(game);
        board = new Board();
        board.populate();
    }

    @Override
    public void update(float deltaTime) {

        List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();

        int len = touchEvents.size();
        for(int i = 0; i < len; i++){
            Input.TouchEvent event = touchEvents.get(i);
            if(event.type == Input.TouchEvent.TOUCH_UP) {

                int boardX = translateXToBoard(event.x);
                int boardY = translateYToBoard(event.y);

                //Checks that click is within board bounds
                if(boardX < 8 && boardX > -1 && boardY < 8 && boardY > -1) {
                    //selectedPiece will be null if no piece selected
                    //if(selectedPiece == null) {
                    //    selectedPiece = board.pieceAt(boardX, boardY);

                    //    selectedX = boardX;
                    //    selectedY = boardY;
                    //}
                    //selectedPiece will be valid if choosing where to move
                    //selectedPiece gets reset to null on second click no matter what
                    //else {
                    //    board.movePiece(selectedX, selectedY, boardX, boardY);
                    //    selectedPiece = null;
                    //    selectedX = -1;
                    //    selectedY = -1;
                    //}
                    if(selectedPiece != null) {
                        board.addPiece(selectedPiece, boardX, boardY);
                    }
                    //Reset piece being held after let go
                    selectedPiece = null;
                }
            }
            else if(event.type == Input.TouchEvent.TOUCH_DOWN) {
                Log.d("TouchTest", "Touch down event detected.");

                boardX = translateXToBoard(event.x);
                boardY = translateYToBoard(event.y);

                if(selectedPiece == null) {
                    selectedPiece = board.pieceAt(boardX, boardY);
                }

            }
            else if(event.type == Input.TouchEvent.TOUCH_DRAGGED) {

                if(selectedPiece != null) {

                    if(boardX != -1 && boardY != -1) {
                        board.removePieceAt(boardX,boardY);
                    }
                    selectedX = event.x;
                    selectedY = event.y;
                    Log.d("TouchTest", "Coordinates of drag = " + selectedX + ", " + selectedY);

                }
            }
        }

    }

    @Override
    public void present(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawPixmap(Assets.board, 0, 0);

        //Iterate over board to draw each piece
        for(int j = 0; j < 8; j++){
            for(int k = 0; k < 8; k++){

                Piece piece = board.pieceAt(j,k);
                if(piece != null){
                    updatePiece(piece,j,k, true);
                }

            }
        }

        //Draw piece being "held" when dragging
        if(selectedPiece != null) {
            updatePiece(selectedPiece, selectedX, selectedY, false);
        }

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

    //Draws piece at coordinates x,y
    private void updatePiece(Piece piece, float x, float y, boolean isOnBoard){

        boolean pieceIsWhite = (piece.color == Piece.PieceAttribute.COLOR_WHITE);

        //draws piece image depending on type
        switch (piece.type) {

            //draws pawn
            case Piece.PieceAttribute.TYPE_PAWN:
                if (pieceIsWhite) {
                    drawPawn(Piece.PieceAttribute.COLOR_WHITE, x, y, isOnBoard);
                } else {
                    drawPawn(Piece.PieceAttribute.COLOR_BLACK, x, y, isOnBoard);
                }
                break;

            //draws knight
            case Piece.PieceAttribute.TYPE_KNIGHT:
                if (pieceIsWhite) {
                    drawKnight(Piece.PieceAttribute.COLOR_WHITE, x, y);
                } else {
                    drawKnight(Piece.PieceAttribute.COLOR_BLACK, x, y);
                }
                break;

            //draws bishop
            case Piece.PieceAttribute.TYPE_BISHOP:
                if (pieceIsWhite) {
                    drawBishop(Piece.PieceAttribute.COLOR_WHITE, x, y);
                } else {
                    drawBishop(Piece.PieceAttribute.COLOR_BLACK, x, y);
                }
                break;

            //draws rook
            case Piece.PieceAttribute.TYPE_ROOK:
                if (pieceIsWhite) {
                    drawRook(Piece.PieceAttribute.COLOR_WHITE, x, y);
                } else {
                    drawRook(Piece.PieceAttribute.COLOR_BLACK, x, y);
                }
                break;

            //draws queen
            case Piece.PieceAttribute.TYPE_QUEEN:
                if (pieceIsWhite) {
                    drawQueen(Piece.PieceAttribute.COLOR_WHITE, x, y);
                } else {
                    drawQueen(Piece.PieceAttribute.COLOR_BLACK, x, y);
                }
                break;

            //draws king
            case Piece.PieceAttribute.TYPE_KING:
                if (pieceIsWhite) {
                    drawKing(Piece.PieceAttribute.COLOR_WHITE, x, y);
                } else {
                    drawKing(Piece.PieceAttribute.COLOR_BLACK, x, y);
                }
                break;

        }

    }


    private void drawPawn(int pieceColor, float x , float y, boolean isOnBoard){
        Graphics g = game.getGraphics();
        int pixelX;
        int pixelY;

        //Determines whether to use "constrained" board coordinates to draw or
        //"free" screen coordinates to draw
        if(isOnBoard) {
            pixelX = (int) (Pawn.X_START + x * Board.X_OFFSET);
            pixelY = (int) (Pawn.Y_START + y * Board.Y_OFFSET);
        }
        else {
            pixelX = (int) x;
            pixelY = (int) y;
            Log.d("Test", "Drag draw coordinates: " + pixelX + ", " + pixelY);
        }

        //draw white pawn
        if(pieceColor == Piece.PieceAttribute.COLOR_WHITE) {
            g.drawPixmap(Assets.pieces,
                    pixelX,
                    pixelY,
                    Pawn.WHITE_X_COORD,
                    Pawn.WHITE_Y_COORD,
                    Pawn.WIDTH,
                    Pawn.HEIGHT);
        }
        //draw black pawn
        else {
            g.drawPixmap(Assets.pieces,
                    pixelX,
                    pixelY,
                    Pawn.BLACK_X_COORD,
                    Pawn.BLACK_Y_COORD,
                    Pawn.WIDTH,
                    Pawn.HEIGHT);

        }

    }

    private void drawKnight(int pieceColor, float x , float y){
        Graphics g = game.getGraphics();

        //draw white knight
        if(pieceColor == Piece.PieceAttribute.COLOR_WHITE) {
            g.drawPixmap(Assets.pieces,
                    (int) (Knight.X_START + x * Board.X_OFFSET),
                    (int) (Knight.Y_START + y * Board.Y_OFFSET),
                    Knight.WHITE_X_COORD,
                    Knight.WHITE_Y_COORD,
                    Knight.WIDTH,
                    Knight.HEIGHT);
        }
        //draw black knight
        else {
            g.drawPixmap(Assets.pieces,
                    (int) (Knight.X_START + x * Board.X_OFFSET),
                    (int) (Knight.Y_START + y * Board.Y_OFFSET),
                    Knight.BLACK_X_COORD,
                    Knight.BLACK_Y_COORD,
                    Knight.WIDTH,
                    Knight.HEIGHT);

        }

    }

    private void drawBishop(int pieceColor, float x , float y){
        Graphics g = game.getGraphics();

        //draw white bishop
        if(pieceColor == Piece.PieceAttribute.COLOR_WHITE) {
            g.drawPixmap(Assets.pieces,
                    (int) (Bishop.X_START + x * Board.X_OFFSET),
                    (int) (Bishop.Y_START + y * Board.Y_OFFSET),
                    Bishop.WHITE_X_COORD,
                    Bishop.WHITE_Y_COORD,
                    Bishop.WIDTH,
                    Bishop.HEIGHT);
        }
        //draw black bishop
        else {
            g.drawPixmap(Assets.pieces,
                    (int) (Bishop.X_START + x * Board.X_OFFSET),
                    (int) (Bishop.Y_START + y * Board.Y_OFFSET),
                    Bishop.BLACK_X_COORD,
                    Bishop.BLACK_Y_COORD,
                    Bishop.WIDTH,
                    Bishop.HEIGHT);

        }

    }

    private void drawRook(int pieceColor, float x , float y){
        Graphics g = game.getGraphics();

        //draw white rook
        if(pieceColor == Piece.PieceAttribute.COLOR_WHITE) {
            g.drawPixmap(Assets.pieces,
                    (int) (Rook.X_START + x * Board.X_OFFSET),
                    (int) (Rook.Y_START + y * Board.Y_OFFSET),
                    Rook.WHITE_X_COORD,
                    Rook.WHITE_Y_COORD,
                    Rook.WIDTH,
                    Rook.HEIGHT);
        }
        //draw black rook
        else {
            g.drawPixmap(Assets.pieces,
                    (int) (Rook.X_START + x * Board.X_OFFSET),
                    (int) (Rook.Y_START + y * Board.Y_OFFSET),
                    Rook.BLACK_X_COORD,
                    Rook.BLACK_Y_COORD,
                    Rook.WIDTH,
                    Rook.HEIGHT);

        }

    }

    private void drawQueen(int pieceColor, float x , float y){
        Graphics g = game.getGraphics();

        //draw white queen
        if(pieceColor == Piece.PieceAttribute.COLOR_WHITE) {
            g.drawPixmap(Assets.pieces,
                    (int) (Queen.X_START + x * Board.X_OFFSET),
                    (int) (Queen.Y_START + y * Board.Y_OFFSET),
                    Queen.WHITE_X_COORD,
                    Queen.WHITE_Y_COORD,
                    Queen.WIDTH,
                    Queen.HEIGHT);
        }
        //draw black queen
        else {
            g.drawPixmap(Assets.pieces,
                    (int) (Queen.X_START + x * Board.X_OFFSET),
                    (int) (Queen.Y_START + y * Board.Y_OFFSET),
                    Queen.BLACK_X_COORD,
                    Queen.BLACK_Y_COORD,
                    Queen.WIDTH,
                    Queen.HEIGHT);

        }

    }

    private void drawKing(int pieceColor, float x , float y){
        Graphics g = game.getGraphics();

        //draw white king
        if(pieceColor == Piece.PieceAttribute.COLOR_WHITE) {
            g.drawPixmap(Assets.pieces,
                    (int) (King.X_START + x * Board.X_OFFSET),
                    (int) (King.Y_START + y * Board.Y_OFFSET),
                    King.WHITE_X_COORD,
                    King.WHITE_Y_COORD,
                    King.WIDTH,
                    King.HEIGHT);
        }
        //draw black king
        else {
            g.drawPixmap(Assets.pieces,
                    (int) (King.X_START + x * Board.X_OFFSET),
                    (int) (King.Y_START + y * Board.Y_OFFSET),
                    King.BLACK_X_COORD,
                    King.BLACK_Y_COORD,
                    King.WIDTH,
                    King.HEIGHT);

        }

    }

    //Helper method converts pixel coordinates retrieved from touch events
    //to board square coordinates
    private int translateXToBoard(int touchX){
        int boardX = -1;

        //Column 1
        if(touchX > 15 && touchX < 84){
            boardX = 0;
        }
        //Column 2
        else if(touchX > 85 && touchX < 150){
            boardX = 1;
        }
        //column 3
        else if(touchX > 151 && touchX < 216){
            boardX = 2;
        }
        //Column 4
        else if(touchX > 217 && touchX < 281){
            boardX = 3;
        }
        //Column 5
        else if(touchX > 282 && touchX < 351){
            boardX = 4;
        }
        //Column 6
        else if(touchX > 352 && touchX < 415){
            boardX = 5;
        }
        //Column 7
        else if(touchX > 416 && touchX < 484){
            boardX = 6;
        }
        //Column 8
        else if(touchX > 485 && touchX < 555){
            boardX = 7;
        }

        return boardX;
    }

    //Helper method converts pixel coordinates retrieved from touch events
    //to board square coordinates
    private int translateYToBoard(int touchY){
        int boardY = -1;

        //Row 1
        if(touchY > 145 && touchY < 179){
            boardY = 0;
        }
        //Row 2
        else if(touchY > 180 && touchY < 215){
            boardY = 1;
        }
        //Row 3
        else if(touchY > 216 && touchY < 249){
            boardY = 2;
        }
        //Row 4
        else if(touchY > 250 && touchY < 287){
            boardY = 3;
        }
        //Row 5
        else if(touchY > 288 && touchY < 322){
            boardY = 4;
        }
        //Row 6
        else if(touchY > 323 && touchY < 360){
            boardY = 5;
        }
        //Row 7
        else if(touchY > 361 && touchY < 391){
            boardY = 6;
        }
        //Row 8
        else if(touchY > 392 && touchY < 427){
            boardY = 7;
        }

        return boardY;
    }
}

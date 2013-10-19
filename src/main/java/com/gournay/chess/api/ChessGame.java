package com.gournay.chess.api;

import java.util.List;

import com.gournay.chess.enums.Piece;
import com.gournay.chess.models.Play;
import com.gournay.chess.models.Position;

/**
 * @author Kitchen
 * @since 17/10/13
 */
public class ChessGame {

	final private Play play = new Play();

	public void move(Position from, Position to) throws IllegalArgumentException {
		Piece movingPiece = play.getBoard().get(from);
		checkPieceState(movingPiece);
		play.move(from, to);
	}

	public List<Position> getAvailableMoves(Position piecePosition) throws IllegalArgumentException {
		Piece pieceToCheck = play.getBoard().get(piecePosition);
		checkPieceState(pieceToCheck);
		return play.getAvailableMoves(piecePosition);
	}

	private void checkPieceState(Piece movingPiece) {
		if (movingPiece == null) {
			throw new IllegalArgumentException("not moving a piece");
		}
		else if (play.isWhitePlayer() != movingPiece.isWhite()) {
			throw new IllegalArgumentException(
					String.format("%s player trying to move a wrong piece", play.isWhitePlayer() ? "White" : "Black"));
		}
	}
}

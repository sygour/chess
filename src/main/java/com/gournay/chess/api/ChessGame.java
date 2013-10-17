package com.gournay.chess.api;

import java.util.List;

import com.google.common.collect.Lists;
import com.gournay.chess.enums.Piece;
import com.gournay.chess.models.Play;
import com.gournay.chess.models.Position;

/**
 * @author Kitchen
 * @since 17/10/13
 */
public class ChessGame {

	private Play play;

	public void move(Position from, Position to) throws IllegalArgumentException {
		Piece movingPiece = play.getBoard().get(from);
		checkPieceState(movingPiece);
		play.setWhitePlayer(!play.isWhitePlayer());
	}

	public List<Position> checkAvailablePositions(Position piecePosition) throws IllegalArgumentException {
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
					String.format("Trying to move a %s piece", play.isWhitePlayer() ? "white" : "black"));
		}
	}
}

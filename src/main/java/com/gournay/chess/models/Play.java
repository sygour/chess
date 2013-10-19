package com.gournay.chess.models;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.gournay.chess.enums.Piece;
import com.gournay.chess.enums.PieceType;
import com.gournay.chess.enums.Row;

/**
 * @author Kitchen
 * @since 16/10/13
 */
public class Play {

	private boolean whitePlayer;
	private Map<Position, Piece> board;

	public Play() {
		whitePlayer = true;
		board = createStartingBoard();
	}

	private Map<Position, Piece> createStartingBoard() {
		Map<Position, Piece> aBoard = Maps.newHashMap();
		for (Piece piece : Piece.values()) {
			for (Position pos : piece.getStartingPositions()) {
				aBoard.put(pos, piece);
			}
		}
		return aBoard;
	}

	public boolean isWhitePlayer() {
		return whitePlayer;
	}

	public void setWhitePlayer(boolean whitePlayer) {
		this.whitePlayer = whitePlayer;
	}

	public Map<Position, Piece> getBoard() {
		return board;
	}

	public List<Position> getAvailableMoves(Position from) {
		List<Position> moves = Lists.newArrayList();
		Piece piece = getBoard().get(from);

		getAvailableMovesForType(from, piece.getType(), piece.isWhite());

		return moves;
	}

	private List<Position> getAvailableMovesForType(Position from, PieceType type, boolean isWhite){
		final List<Position> moves = Lists.newArrayList();
		Position checkedPosition;
		switch (type) {
			case PAWN:
				// one step ahead, two if on the starting row (1 for white, 6 for black)
				// check the adjacent case of the first ahead to see if it's occupied by an enemy piece
				boolean startingRow = isWhite ? Row.ONE.equals(from.getRow()) : Row.SIX.equals(from.getRow());
				checkedPosition = move(from, 1, 0, isWhite);
				if (isPositionFree(checkedPosition)) {
					moves.add(checkedPosition);
					checkedPosition = move(from, 2, 0, isWhite);
					if (startingRow && isPositionFree(checkedPosition)) {
						moves.add(checkedPosition);
					}
				}
				checkedPosition = move(from, 1, -1, isWhite);
				if (isPositionToTake(checkedPosition, isWhite)) {
					moves.add(checkedPosition);
				}
				checkedPosition = move(from, 1, 1, isWhite);
				if (isPositionToTake(checkedPosition, isWhite)) {
					moves.add(checkedPosition);
				}
				break;
			case TOWER:
				moves.addAll(getMovesInLine(from, 0, 1, isWhite));
				moves.addAll(getMovesInLine(from, 0, -1, isWhite));
				moves.addAll(getMovesInLine(from, 1, 0, isWhite));
				moves.addAll(getMovesInLine(from, -1, 0, isWhite));
				// TODO add rock possibility for the start position
				break;
			case BISHOP:
				moves.addAll(getMovesInLine(from, 1, 1, isWhite));
				moves.addAll(getMovesInLine(from, -1, -1, isWhite));
				moves.addAll(getMovesInLine(from, 1, -1, isWhite));
				moves.addAll(getMovesInLine(from, -1, 1, isWhite));
				break;
			case HORSE:
				break;
			case QUEEN:
				// same as a tower and a bishop
				moves.addAll(getAvailableMovesForType(from, PieceType.BISHOP, isWhite));
				moves.addAll(getAvailableMovesForType(from, PieceType.TOWER, isWhite));
				break;
			case KING:
				// check possible moves around king
				for (int i=-1; i<=1; i++) {
					for (int j=1; j<=1; j++) {
						checkedPosition = move(from, i, j, isWhite);
						if (isPositionFree(checkedPosition) || isPositionToTake(checkedPosition, isWhite)) {
							moves.add(checkedPosition);
						}
					}
				}
				// TODO add rock possibility for the start position
				break;
		}
		return moves;
	}

	private Position move(Position from, int rowCount, int colCount, boolean isWhite) {
		Position to = from.addRows(rowCount, isWhite);
		if (to != null) {
			to = to.addColumns(colCount);
		}
		return to;
	}

	private boolean isPositionFree(Position p) {
		return p != null
				&& board.get(p) == null;
	}

	private boolean isPositionToTake(Position p, boolean isWhite) {
		return p != null
				&& board.get(p) != null
				&& board.get(p).isWhite() != isWhite;
	}

	private List<Position> getMovesInLine(Position from, int rowShift, int colShift, boolean isWhite) {
		final List<Position> moves = Lists.newArrayList();
		Position checkedPosition = from;
		boolean blocked = false;
		do {
			// get next possible move ahead
			checkedPosition = move(checkedPosition, rowShift, colShift, isWhite);
			if (isPositionFree(checkedPosition)) {
				moves.add(checkedPosition);
			} else if (isPositionToTake(checkedPosition, isWhite)) {
				moves.add(checkedPosition);
				blocked = true;
			}
		} while (checkedPosition != null && !blocked);
		return moves;
	}
}

package com.gournay.chess.enums;

import java.util.List;

import com.google.common.collect.Lists;
import com.gournay.chess.models.Position;

/**
 * @author Kitchen
 * @since 16/10/13
 */
public enum Piece {

	WHITE_PAWN(PieceType.PAWN,
			Boolean.TRUE,
			Lists.newArrayList(
					new Position(Column.A, Row.ONE),
					new Position(Column.B, Row.ONE),
					new Position(Column.C, Row.ONE),
					new Position(Column.D, Row.ONE),
					new Position(Column.E, Row.ONE),
					new Position(Column.F, Row.ONE),
					new Position(Column.G, Row.ONE),
					new Position(Column.H, Row.ONE)
			)
	),
	BLACK_PAWN(PieceType.PAWN,
			Boolean.FALSE,
			Lists.newArrayList(
					new Position(Column.A, Row.SIX),
					new Position(Column.B, Row.SIX),
					new Position(Column.C, Row.SIX),
					new Position(Column.D, Row.SIX),
					new Position(Column.E, Row.SIX),
					new Position(Column.F, Row.SIX),
					new Position(Column.G, Row.SIX),
					new Position(Column.H, Row.SIX)
			)
	),
	WHITE_TOWER(PieceType.TOWER,
			Boolean.TRUE,
			Lists.newArrayList(
					new Position(Column.A, Row.ZERO),
					new Position(Column.H, Row.ZERO)
			)
	),
	BLACK_TOWER(PieceType.TOWER,
			Boolean.FALSE,
			Lists.newArrayList(
					new Position(Column.A, Row.SEVEN),
					new Position(Column.H, Row.SEVEN)
			)
	),
	WHITE_HORSE(PieceType.HORSE,
			Boolean.TRUE,
			Lists.newArrayList(
					new Position(Column.B, Row.ZERO),
					new Position(Column.G, Row.ZERO)
			)
	),
	BLACK_HORSE(PieceType.HORSE,
			Boolean.FALSE,
			Lists.newArrayList(
					new Position(Column.B, Row.SEVEN),
					new Position(Column.G, Row.SEVEN)
			)
	),
	WHITE_BISHOP(PieceType.BISHOP,
			Boolean.TRUE,
			Lists.newArrayList(
					new Position(Column.C, Row.ZERO),
					new Position(Column.F, Row.ZERO)
			)
	),
	BLACK_BISHOP(PieceType.BISHOP,
			Boolean.FALSE,
			Lists.newArrayList(
					new Position(Column.C, Row.SEVEN),
					new Position(Column.F, Row.SEVEN)
			)
	),
	WHITE_QUEEN(PieceType.QUEEN,
			Boolean.TRUE,
			Lists.newArrayList(new Position(Column.D, Row.ZERO)
			)
	),
	BLACK_QUEEN(PieceType.QUEEN,
			Boolean.FALSE,
			Lists.newArrayList(new Position(Column.D, Row.SEVEN)
			)
	),
	WHITE_KING(PieceType.KING,
			Boolean.TRUE,
			Lists.newArrayList(new Position(Column.E, Row.ZERO)
			)
	),
	BLACK_KING(PieceType.KING,
			Boolean.FALSE,
			Lists.newArrayList(new Position(Column.E, Row.SEVEN)
			)
	);

	private Piece(PieceType pieceType, boolean white, List<Position> startingPositions) {
		this.type = pieceType;
		this.white = white;
		this.startingPositions = startingPositions;
	}

	final private PieceType type;
	final private List<Position> startingPositions;
	final private boolean white;

	public PieceType getType() {
		return type;
	}

	public List<Position> getStartingPositions() {
		return startingPositions;
	}

	public boolean isWhite() {
		return white;
	}
}
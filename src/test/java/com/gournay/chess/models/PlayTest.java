package com.gournay.chess.models;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Maps;
import com.gournay.chess.enums.Column;
import com.gournay.chess.enums.Piece;
import com.gournay.chess.enums.Row;

/**
 * @author Kitchen
 * @since 19/10/13
 */
public class PlayTest {

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test
	public void checkStartingBoard() {
		HashMap<Position, Piece> templateBoard = Maps.newHashMap();
		// whites
		templateBoard.put(new Position(Column.A, Row.ZERO), Piece.WHITE_TOWER);
		templateBoard.put(new Position(Column.B, Row.ZERO), Piece.WHITE_HORSE);
		templateBoard.put(new Position(Column.C, Row.ZERO), Piece.WHITE_BISHOP);
		templateBoard.put(new Position(Column.D, Row.ZERO), Piece.WHITE_QUEEN);
		templateBoard.put(new Position(Column.E, Row.ZERO), Piece.WHITE_KING);
		templateBoard.put(new Position(Column.F, Row.ZERO), Piece.WHITE_BISHOP);
		templateBoard.put(new Position(Column.G, Row.ZERO), Piece.WHITE_HORSE);
		templateBoard.put(new Position(Column.H, Row.ZERO), Piece.WHITE_TOWER);
		templateBoard.put(new Position(Column.A, Row.ONE), Piece.WHITE_PAWN);
		templateBoard.put(new Position(Column.B, Row.ONE), Piece.WHITE_PAWN);
		templateBoard.put(new Position(Column.C, Row.ONE), Piece.WHITE_PAWN);
		templateBoard.put(new Position(Column.D, Row.ONE), Piece.WHITE_PAWN);
		templateBoard.put(new Position(Column.E, Row.ONE), Piece.WHITE_PAWN);
		templateBoard.put(new Position(Column.F, Row.ONE), Piece.WHITE_PAWN);
		templateBoard.put(new Position(Column.G, Row.ONE), Piece.WHITE_PAWN);
		templateBoard.put(new Position(Column.H, Row.ONE), Piece.WHITE_PAWN);
		// blacks
		templateBoard.put(new Position(Column.A, Row.SEVEN), Piece.BLACK_TOWER);
		templateBoard.put(new Position(Column.B, Row.SEVEN), Piece.BLACK_HORSE);
		templateBoard.put(new Position(Column.C, Row.SEVEN), Piece.BLACK_BISHOP);
		templateBoard.put(new Position(Column.D, Row.SEVEN), Piece.BLACK_QUEEN);
		templateBoard.put(new Position(Column.E, Row.SEVEN), Piece.BLACK_KING);
		templateBoard.put(new Position(Column.F, Row.SEVEN), Piece.BLACK_BISHOP);
		templateBoard.put(new Position(Column.G, Row.SEVEN), Piece.BLACK_HORSE);
		templateBoard.put(new Position(Column.H, Row.SEVEN), Piece.BLACK_TOWER);
		templateBoard.put(new Position(Column.A, Row.SIX), Piece.BLACK_PAWN);
		templateBoard.put(new Position(Column.B, Row.SIX), Piece.BLACK_PAWN);
		templateBoard.put(new Position(Column.C, Row.SIX), Piece.BLACK_PAWN);
		templateBoard.put(new Position(Column.D, Row.SIX), Piece.BLACK_PAWN);
		templateBoard.put(new Position(Column.E, Row.SIX), Piece.BLACK_PAWN);
		templateBoard.put(new Position(Column.F, Row.SIX), Piece.BLACK_PAWN);
		templateBoard.put(new Position(Column.G, Row.SIX), Piece.BLACK_PAWN);
		templateBoard.put(new Position(Column.H, Row.SIX), Piece.BLACK_PAWN);
		final int pieceCount = templateBoard.keySet().size();
		Assert.assertEquals(32, pieceCount);

		final Play play = new Play();
		int count = 0;
		for (Position key : play.getBoard().keySet()) {
			Assert.assertEquals(
					String.format("for position %s: template=%s, play=%s", key, templateBoard.get(key), play.getBoard().get(key)),
					templateBoard.get(key), play.getBoard().get(key));
			count++;
		}
		Assert.assertEquals(pieceCount, count);
	}
}

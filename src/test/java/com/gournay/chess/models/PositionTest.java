package com.gournay.chess.models;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kitchen
 * @since 19/10/13
 */
public class PositionTest {

	@Test
	public void testAddRows() throws Exception {
		final int colIndex = 1;
		Position from = new Position(colIndex, 1);
		boolean isWhite = true;

		// one ahead
		int shift = 1;
		final Position oneAhead = from.addRows(shift, isWhite);
		int move = shift * (isWhite ? 1 : -1);
		Assert.assertEquals(new Position(colIndex, from.getRow().getIndex() + move), oneAhead);

		// two ahead
		shift = 2;
		final Position twoAhead = from.addRows(shift, isWhite);
		move = shift * (isWhite ? 1 : -1);
		Assert.assertEquals(new Position(colIndex, from.getRow().getIndex() + move), twoAhead);

		// one backward
		shift = -1;
		final Position oneBack = from.addRows(shift, isWhite);
		move = shift * (isWhite ? 1 : -1);
		Assert.assertEquals(new Position(colIndex, from.getRow().getIndex() + move), oneBack);

		// two backward: out of board
		shift = -2;
		boolean exceptionCaught = false;
		try {
			final Position twoBack = from.addRows(shift, isWhite);
		}
		catch (IllegalArgumentException e) {
			exceptionCaught = true;
		}
		Assert.assertTrue(exceptionCaught);

		// test for the black move
		shift = 1;
		final Position oneAheadBlack = from.addRows(shift, isWhite);
		move = shift * (isWhite ? 1 : -1);
		Assert.assertEquals(new Position(colIndex, from.getRow().getIndex() + move), oneAheadBlack);
	}

	@Test
	public void testAddColumns() throws Exception {
		final int rowIndex = 1;
		Position from = new Position(1, rowIndex);

		// one right
		int shift = 1;
		final Position oneRight = from.addColumns(shift);
		Assert.assertEquals(new Position(from.getCol().getIndex() + shift, rowIndex), oneRight);

		// two right
		shift = 2;
		final Position twoRight = from.addColumns(shift);
		Assert.assertEquals(new Position(from.getCol().getIndex() + shift, rowIndex), twoRight);

		// one left
		shift = -1;
		final Position oneLeft = from.addColumns(shift);
		Assert.assertEquals(new Position(from.getCol().getIndex() + shift, rowIndex), oneLeft);

		// two left: out of board
		shift = -2;
		boolean exceptionCaught = false;
		try {
			final Position twoLeft = from.addColumns(shift);
		}
		catch (IllegalArgumentException e) {
			exceptionCaught = true;
		}
		Assert.assertTrue(exceptionCaught);
	}
}

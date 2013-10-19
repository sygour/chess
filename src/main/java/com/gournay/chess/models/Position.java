package com.gournay.chess.models;

import com.gournay.chess.enums.Column;
import com.gournay.chess.enums.Row;

/**
 * @author Kitchen
 * @since 17/10/13
 */
public class Position {
	final private Column col;
	final private Row row;

	public Position(Column c, Row r) {
		col = c;
		row = r;
	}

	public Position(int colIndex, int rowIndex) {
		this(Column.fromIndex(colIndex), Row.fromIndex(rowIndex));
	}

	public Column getCol() {
		return col;
	}

	public Row getRow() {
		return row;
	}

	@Override
	public boolean equals(Object p) {
		return (p instanceof Position)
				&& col.equals(((Position) p).getCol())
				&& row.equals(((Position) p).getRow());
	}

	@Override
	public String toString() {
		return String.format("Position(col:%s, row:%s)", col, row);
	}

	public Position addRows(int rowCount, boolean isWhite) {
		if (!isWhite) {
			return addRows(-rowCount, !isWhite);
		}
		else {
			return new Position(getCol(), getRow().add(rowCount));
		}
	}

	public Position addColumns(int colCount) {
		return new Position(getCol().add(colCount), getRow());
	}
}

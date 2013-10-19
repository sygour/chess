package com.gournay.chess.enums;

/**
 * @author Kitchen
 * @since 16/10/13
 */
public enum Row {

	ZERO(0),
	ONE(1),
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7);

	private Row(int index) {
		this.index = index;
	}

	final private int index;

	public int getIndex() {
		return index;
	}

	public static Row fromIndex(int indexWanted) {
		for (Row row : values()) {
			if (row.getIndex() == indexWanted) {
				return row;
			}
		}
		throw new IllegalArgumentException(String.format("index %s is not a valid row", indexWanted));
	}

	public Row add(int rowCount) {
		int indexWanted = rowCount + getIndex();
		if (indexWanted > SEVEN.getIndex()) {
			return null;
		} else {
			return fromIndex(indexWanted);
		}
	}
}

package com.gournay.chess.enums;

/**
 * @author Kitchen
 * @since 16/10/13
 */
public enum Column {

	A(0),
	B(1),
	C(2),
	D(3),
	E(4),
	F(5),
	G(6),
	H(7);

	private Column(int index) {
		this.index = index;
	}

	final private int index;

	public int getIndex() {
		return index;
	}

	static private Column fromIndex(int indexWanted) {
		for (Column column : values()) {
			if (column.getIndex() == indexWanted) {
				return column;
			}
		}
		throw new IllegalArgumentException(String.format("index %s is not a valid column", indexWanted));
	}

	public Column add(int colCount) {
		int indexWanted = colCount + getIndex();
		if (indexWanted > H.getIndex()) {
			return null;
		} else {
			return fromIndex(indexWanted);
		}
	}
}

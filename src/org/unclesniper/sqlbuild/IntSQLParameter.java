package org.unclesniper.sqlbuild;

import java.sql.SQLException;
import java.sql.PreparedStatement;

public final class IntSQLParameter implements SQLParameter {

	private int value;

	public IntSQLParameter(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setParameter(PreparedStatement statement, int index) throws SQLException {
		statement.setInt(index, value);
	}

}

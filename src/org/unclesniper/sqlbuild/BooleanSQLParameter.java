package org.unclesniper.sqlbuild;

import java.sql.SQLException;
import java.sql.PreparedStatement;

public final class BooleanSQLParameter implements SQLParameter {

	private boolean value;

	public BooleanSQLParameter(boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	public void setParameter(PreparedStatement statement, int index) throws SQLException {
		statement.setBoolean(index, value);
	}

}

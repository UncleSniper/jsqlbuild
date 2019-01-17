package org.unclesniper.sqlbuild;

import java.sql.SQLException;
import java.sql.PreparedStatement;

public final class FloatSQLParameter implements SQLParameter {

	private float value;

	public FloatSQLParameter(float value) {
		this.value = value;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public void setParameter(PreparedStatement statement, int index) throws SQLException {
		statement.setFloat(index, value);
	}

}

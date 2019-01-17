package org.unclesniper.sqlbuild;

import java.sql.SQLException;
import java.sql.PreparedStatement;

public final class ByteSQLParameter implements SQLParameter {

	private byte value;

	public ByteSQLParameter(byte value) {
		this.value = value;
	}

	public byte getValue() {
		return value;
	}

	public void setValue(byte value) {
		this.value = value;
	}

	public void setParameter(PreparedStatement statement, int index) throws SQLException {
		statement.setByte(index, value);
	}

}

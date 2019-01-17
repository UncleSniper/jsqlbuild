package org.unclesniper.sqlbuild;

import java.sql.SQLException;
import java.sql.PreparedStatement;

public final class DoubleSQLParameter implements SQLParameter {

	private double value;

	public DoubleSQLParameter(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public void setParameter(PreparedStatement statement, int index) throws SQLException {
		statement.setDouble(index, value);
	}

}

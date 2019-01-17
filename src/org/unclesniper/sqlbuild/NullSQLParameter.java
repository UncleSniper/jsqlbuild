package org.unclesniper.sqlbuild;

import java.sql.SQLException;
import java.sql.PreparedStatement;

public final class NullSQLParameter implements SQLParameter {

	private SQLType type;

	public NullSQLParameter() {
		this(null);
	}

	public NullSQLParameter(SQLType type) {
		this.type = type == null ? SQLType.NULL : type;
	}

	public SQLType getType() {
		return type;
	}

	public void setType(SQLType type) {
		this.type = type == null ? SQLType.NULL : type;
	}

	public void setParameter(PreparedStatement statement, int index) throws SQLException {
		statement.setNull(index, type.getCode());
	}

}

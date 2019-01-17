package org.unclesniper.sqlbuild;

import java.sql.SQLException;
import java.sql.PreparedStatement;

public final class StringSQLParameter implements SQLParameter {

	public enum ParameterType {
		STRING,
		NSTRING
	}

	public static final ParameterType DEFAULT_TYPE = ParameterType.STRING;

	private String value;

	private ParameterType type;

	public StringSQLParameter(String value) {
		this(value, null);
	}

	public StringSQLParameter(String value, ParameterType type) {
		this.value = value;
		this.type = type == null ? StringSQLParameter.DEFAULT_TYPE : type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ParameterType getType() {
		return type;
	}

	public void setType(ParameterType type) {
		this.type = type == null ? StringSQLParameter.DEFAULT_TYPE : type;
	}

	public void setParameter(PreparedStatement statement, int index) throws SQLException {
		switch(type) {
			case STRING:
				statement.setString(index, value);
				break;
			case NSTRING:
				statement.setNString(index, value);
				break;
			default:
				throw new Doom("Unrecognized ParameterType: " + type.name());
		}
	}

}

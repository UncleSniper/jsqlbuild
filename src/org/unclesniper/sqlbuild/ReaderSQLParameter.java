package org.unclesniper.sqlbuild;

import java.io.Reader;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public final class ReaderSQLParameter implements SQLParameter {

	public enum ParameterType {
		CHARACTER_STREAM,
		CLOB,
		NCHARACTER_STREAM,
		NCLOB
	}

	public static final ParameterType DEFAULT_TYPE = ParameterType.CHARACTER_STREAM;

	private Reader reader;

	private long length;

	private ParameterType type;

	public ReaderSQLParameter(Reader reader) {
		this(reader, -1l, null);
	}

	public ReaderSQLParameter(Reader reader, long length) {
		this(reader, length, null);
	}

	public ReaderSQLParameter(Reader reader, ParameterType type) {
		this(reader, -1l, type);
	}

	public ReaderSQLParameter(Reader reader, long length, ParameterType type) {
		this.reader = reader;
		this.length = length;
		this.type = type == null ? ReaderSQLParameter.DEFAULT_TYPE : type;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public long getLength() {
		return length;
	}

	public void setLength(long length) {
		this.length = length;
	}

	public ParameterType getType() {
		return type;
	}

	public void setType(ParameterType type) {
		this.type = type == null ? ReaderSQLParameter.DEFAULT_TYPE : type;
	}

	public void setParameter(PreparedStatement statement, int index) throws SQLException {
		switch(type) {
			case CHARACTER_STREAM:
				if(length < 0l)
					statement.setCharacterStream(index, reader);
				else if(length <= (long) Integer.MAX_VALUE)
					statement.setCharacterStream(index, reader, (int)length);
				else
					statement.setCharacterStream(index, reader, length);
				break;
			case CLOB:
				if(length < 0l)
					statement.setClob(index, reader);
				else
					statement.setClob(index, reader, length);
				break;
			case NCHARACTER_STREAM:
				if(length < 0l)
					statement.setNCharacterStream(index, reader);
				else
					statement.setNCharacterStream(index, reader, length);
				break;
			case NCLOB:
				if(length < 0l)
					statement.setNClob(index, reader);
				else
					statement.setNClob(index, reader, length);
				break;
			default:
				throw new Doom("Unrecognized ParameterType: " + type.name());
		}
	}

}

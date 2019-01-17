package org.unclesniper.sqlbuild;

import java.sql.Time;
import java.io.Reader;
import java.util.Calendar;
import java.sql.Timestamp;
import java.time.temporal.TemporalAccessor;

public abstract class AbstractSQLBuilder<FluidT> implements SQLBuilder<FluidT> {

	private SQLDialect dialect;

	public AbstractSQLBuilder(SQLDialect dialect) {
		if(dialect == null)
			throw new IllegalArgumentException("SQL dialect may not be null");
		this.dialect = dialect;
	}

	public SQLDialect getDialect() {
		return dialect;
	}

	public void setDialect(SQLDialect dialect) {
		this.dialect = dialect;
	}

	protected abstract FluidT addParam(SQLParameter param);

	public FluidT param(SQLParameter parameter) {
		sql('?');
		return addParam(parameter);
	}

	public FluidT param(boolean value) {
		sql('?');
		return addParam(new BooleanSQLParameter(value));
	}

	public FluidT param(byte value) {
		sql('?');
		return addParam(new ByteSQLParameter(value));
	}

	public FluidT param(java.sql.Date value) {
		sql('?');
		return addParam(new DateSQLParameter(value));
	}

	public FluidT param(java.sql.Date value, Calendar calendar) {
		sql('?');
		return addParam(new DateSQLParameter(value, calendar));
	}

	public FluidT date(java.util.Date value) {
		sql('?');
		return addParam(new DateSQLParameter(new java.sql.Date(value.getTime())));
	}

	public FluidT date(java.util.Date value, Calendar calendar) {
		sql('?');
		return addParam(new DateSQLParameter(new java.sql.Date(value.getTime()), calendar));
	}

	public FluidT date(TemporalAccessor value) {
		sql('?');
		return addParam(new DateSQLParameter(SQLUtils.toSQLDate(value)));
	}

	public FluidT date(TemporalAccessor value, Calendar calendar) {
		sql('?');
		return addParam(new DateSQLParameter(SQLUtils.toSQLDate(value), calendar));
	}

	public FluidT date(long value) {
		sql('?');
		return addParam(new DateSQLParameter(new java.sql.Date(value)));
	}

	public FluidT date(long value, Calendar calendar) {
		sql('?');
		return addParam(new DateSQLParameter(new java.sql.Date(value), calendar));
	}

	public FluidT param(double value) {
		sql('?');
		return addParam(new DoubleSQLParameter(value));
	}

	public FluidT param(float value) {
		sql('?');
		return addParam(new FloatSQLParameter(value));
	}

	public FluidT param(int value) {
		sql('?');
		return addParam(new IntSQLParameter(value));
	}

	public FluidT param(long value) {
		sql('?');
		return addParam(new LongSQLParameter(value));
	}

	public FluidT nullOf(SQLType type) {
		sql('?');
		return addParam(new NullSQLParameter(type));
	}

	public FluidT nullOf() {
		sql('?');
		return addParam(new NullSQLParameter());
	}

	public FluidT param(Reader reader, ReaderSQLParameter.ParameterType type) {
		sql('?');
		return addParam(new ReaderSQLParameter(reader, type));
	}

	public FluidT charStream(Reader reader) {
		sql('?');
		return addParam(new ReaderSQLParameter(reader, ReaderSQLParameter.ParameterType.CHARACTER_STREAM));
	}

	public FluidT clob(Reader reader) {
		sql('?');
		return addParam(new ReaderSQLParameter(reader, ReaderSQLParameter.ParameterType.CLOB));
	}

	public FluidT ncharStream(Reader reader) {
		sql('?');
		return addParam(new ReaderSQLParameter(reader, ReaderSQLParameter.ParameterType.NCHARACTER_STREAM));
	}

	public FluidT nclob(Reader reader) {
		sql('?');
		return addParam(new ReaderSQLParameter(reader, ReaderSQLParameter.ParameterType.NCLOB));
	}

	public FluidT param(short value) {
		sql('?');
		return addParam(new ShortSQLParameter(value));
	}

	public FluidT param(String value) {
		sql('?');
		return addParam(new StringSQLParameter(value));
	}

	public FluidT param(String value, StringSQLParameter.ParameterType type) {
		sql('?');
		return addParam(new StringSQLParameter(value, type));
	}

	public FluidT string(String value) {
		sql('?');
		return addParam(new StringSQLParameter(value, StringSQLParameter.ParameterType.STRING));
	}

	public FluidT nstring(String value) {
		sql('?');
		return addParam(new StringSQLParameter(value, StringSQLParameter.ParameterType.NSTRING));
	}

	public FluidT param(Time value) {
		sql('?');
		return addParam(new TimeSQLParameter(value));
	}

	public FluidT param(Time value, Calendar calendar) {
		sql('?');
		return addParam(new TimeSQLParameter(value, calendar));
	}

	public FluidT time(java.util.Date value) {
		sql('?');
		return addParam(new TimeSQLParameter(new Time(value.getTime())));
	}

	public FluidT time(java.util.Date value, Calendar calendar) {
		sql('?');
		return addParam(new TimeSQLParameter(new Time(value.getTime()), calendar));
	}

	public FluidT time(TemporalAccessor value) {
		sql('?');
		return addParam(new TimeSQLParameter(SQLUtils.toSQLTime(value)));
	}

	public FluidT time(TemporalAccessor value, Calendar calendar) {
		sql('?');
		return addParam(new TimeSQLParameter(SQLUtils.toSQLTime(value), calendar));
	}

	public FluidT time(long value) {
		sql('?');
		return addParam(new TimeSQLParameter(new Time(value)));
	}

	public FluidT time(long value, Calendar calendar) {
		sql('?');
		return addParam(new TimeSQLParameter(new Time(value), calendar));
	}

	public FluidT param(Timestamp value) {
		sql('?');
		return addParam(new TimestampSQLParameter(value));
	}

	public FluidT param(Timestamp value, Calendar calendar) {
		sql('?');
		return addParam(new TimestampSQLParameter(value, calendar));
	}

	public FluidT timestamp(java.util.Date value) {
		sql('?');
		return addParam(new TimestampSQLParameter(new Timestamp(value.getTime())));
	}

	public FluidT timestamp(java.util.Date value, Calendar calendar) {
		sql('?');
		return addParam(new TimestampSQLParameter(new Timestamp(value.getTime()), calendar));
	}

	public FluidT timestamp(TemporalAccessor value) {
		sql('?');
		return addParam(new TimestampSQLParameter(SQLUtils.toSQLTimestamp(value)));
	}

	public FluidT timestamp(TemporalAccessor value, Calendar calendar) {
		sql('?');
		return addParam(new TimestampSQLParameter(SQLUtils.toSQLTimestamp(value), calendar));
	}

	public FluidT timestamp(long value) {
		sql('?');
		return addParam(new TimestampSQLParameter(new Timestamp(value)));
	}

	public FluidT timestamp(long value, Calendar calendar) {
		sql('?');
		return addParam(new TimestampSQLParameter(new Timestamp(value), calendar));
	}

	public FluidT name(String name) {
		return sql(dialect.quoteIdentifier(name));
	}

	public FluidT column(String table, String column) {
		sql(dialect.quoteIdentifier(table));
		sql('.');
		return sql(dialect.quoteIdentifier(column));
	}

}

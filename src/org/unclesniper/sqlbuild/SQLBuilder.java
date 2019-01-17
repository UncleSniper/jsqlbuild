package org.unclesniper.sqlbuild;

import java.sql.Time;
import java.io.Reader;
import java.util.Calendar;
import java.sql.Timestamp;
import java.time.temporal.TemporalAccessor;

public interface SQLBuilder<FluidT> {

	FluidT sql(String fragment);

	FluidT sql(char fragment);

	// parameters

	FluidT param(SQLParameter parameter);

	FluidT param(boolean value);

	FluidT param(byte value);

	FluidT param(java.sql.Date value);

	FluidT param(java.sql.Date value, Calendar calendar);

	FluidT date(java.util.Date value);

	FluidT date(java.util.Date value, Calendar calendar);

	FluidT date(TemporalAccessor value);

	FluidT date(TemporalAccessor value, Calendar calendar);

	FluidT date(long value);

	FluidT date(long value, Calendar calendar);

	FluidT param(double value);

	FluidT param(float value);

	FluidT param(int value);

	FluidT param(long value);

	FluidT nullOf(SQLType type);

	FluidT nullOf();

	FluidT param(Reader reader, ReaderSQLParameter.ParameterType type);

	FluidT charStream(Reader reader);

	FluidT clob(Reader reader);

	FluidT ncharStream(Reader reader);

	FluidT nclob(Reader reader);

	FluidT param(short value);

	FluidT param(String value);

	FluidT param(String value, StringSQLParameter.ParameterType type);

	FluidT string(String value);

	FluidT nstring(String value);

	FluidT param(Time value);

	FluidT param(Time value, Calendar calendar);

	FluidT time(java.util.Date value);

	FluidT time(java.util.Date value, Calendar calendar);

	FluidT time(TemporalAccessor value);

	FluidT time(TemporalAccessor value, Calendar calendar);

	FluidT time(long value);

	FluidT time(long value, Calendar calendar);

	FluidT param(Timestamp value);

	FluidT param(Timestamp value, Calendar calendar);

	FluidT timestamp(java.util.Date value);

	FluidT timestamp(java.util.Date value, Calendar calendar);

	FluidT timestamp(TemporalAccessor value);

	FluidT timestamp(TemporalAccessor value, Calendar calendar);

	FluidT timestamp(long value);

	FluidT timestamp(long value, Calendar calendar);

	// shorthands

	FluidT name(String name);

	FluidT column(String table, String column);

}

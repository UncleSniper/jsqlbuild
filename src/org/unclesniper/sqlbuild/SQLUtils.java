package org.unclesniper.sqlbuild;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

public final class SQLUtils {

	private SQLUtils() {}

	public static Date toSQLDate(TemporalAccessor value) {
		return new Date(value.getLong(ChronoField.INSTANT_SECONDS) * 1000l);
	}

	public static Time toSQLTime(TemporalAccessor value) {
		return new Time(value.getLong(ChronoField.INSTANT_SECONDS) * 1000l
				+ value.getLong(ChronoField.MILLI_OF_SECOND));
	}

	public static Timestamp toSQLTimestamp(TemporalAccessor value) {
		return new Timestamp(value.getLong(ChronoField.INSTANT_SECONDS) * 1000l
				+ value.getLong(ChronoField.MILLI_OF_SECOND));
	}

}

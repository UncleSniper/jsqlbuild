package org.unclesniper.sqlbuild;

import java.util.Calendar;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public final class TimestampSQLParameter implements SQLParameter {

	private Timestamp timestamp;

	private Calendar calendar;

	public TimestampSQLParameter(Timestamp timestamp) {
		this(timestamp, null);
	}

	public TimestampSQLParameter(Timestamp timestamp, Calendar calendar) {
		this.timestamp = timestamp;
		this.calendar = calendar;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public void setParameter(PreparedStatement statement, int index) throws SQLException {
		if(calendar == null)
			statement.setTimestamp(index, timestamp);
		else
			statement.setTimestamp(index, timestamp, calendar);
	}

}

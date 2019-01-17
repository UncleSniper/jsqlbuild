package org.unclesniper.sqlbuild;

import java.sql.Time;
import java.util.Calendar;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public final class TimeSQLParameter implements SQLParameter {

	private Time time;

	private Calendar calendar;

	public TimeSQLParameter(Time time) {
		this(time, null);
	}

	public TimeSQLParameter(Time time, Calendar calendar) {
		this.time = time;
		this.calendar = calendar;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public void setParameter(PreparedStatement statement, int index) throws SQLException {
		if(calendar == null)
			statement.setTime(index, time);
		else
			statement.setTime(index, time, calendar);
	}

}

package org.unclesniper.sqlbuild;

import java.sql.Date;
import java.util.Calendar;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class DateSQLParameter implements SQLParameter {

	private Date date;

	private Calendar calendar;

	public DateSQLParameter(Date date) {
		this(date, null);
	}

	public DateSQLParameter(Date date, Calendar calendar) {
		this.date = date;
		this.calendar = calendar;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public void setParameter(PreparedStatement statement, int index) throws SQLException {
		if(calendar == null)
			statement.setDate(index, date);
		else
			statement.setDate(index, date, calendar);
	}

}

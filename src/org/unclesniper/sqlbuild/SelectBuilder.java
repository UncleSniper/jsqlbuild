package org.unclesniper.sqlbuild;

import java.sql.Time;
import java.io.Reader;
import java.util.Calendar;
import java.sql.Timestamp;
import java.time.temporal.TemporalAccessor;

public class SelectBuilder {

	public enum Ordering {

		EQUAL(" = "),
		UNEQUAL(" <> "),
		LESS(" < "),
		LESS_EQUAL(" <= "),
		GREATER(" > "),
		GREATER_EQUAL(" >= ");

		private final String sql;

		private Ordering(String sql) {
			this.sql = sql;
		}

		public String getSQL() {
			return sql;
		}

	}

	public enum Join {

		CROSS(", "),
		INNER(" JOIN "),
		LEFT(" LEFT JOIN "),
		RIGHT( "RIGHT JOIN " );

		private final String sql;

		private Join(String sql) {
			this.sql = sql;
		}

		public String getSQL() {
			return sql;
		}

	}

	private final SQLDialect dialect;

	private final StatementBuilder select;

	private final StatementBuilder from;

	private StatementBuilder where;

	private StatementBuilder groupBy;

	private StatementBuilder orderBy;

	private String tablePrefix;

	public SelectBuilder(SQLDialect dialect) {
		this(dialect, null);
	}

	public SelectBuilder(SQLDialect dialect, String tablePrefix) {
		this.dialect = dialect;
		select = new StatementBuilder(dialect);
		from = new StatementBuilder(dialect);
		setTablePrefix(tablePrefix);
	}

	public final String getTablePrefix() {
		return tablePrefix;
	}

	public void setTablePrefix(String tablePrefix) {
		if(tablePrefix != null && tablePrefix.length() == 0)
			this.tablePrefix = null;
		else
			this.tablePrefix = tablePrefix;
	}

	public final StatementBuilder selectPart() {
		return select;
	}

	private StatementBuilder preselect() {
		return select.sql(select.isEmpty() ? "SELECT " : ", ");
	}

	public SelectBuilder select(String column) {
		preselect().name(column);
		return this;
	}

	public SelectBuilder select(String table, String column) {
		preselect();
		if(tablePrefix != null)
			select.sql(tablePrefix).sql('.');
		select.column(table, column);
		return this;
	}

	public SelectBuilder select(SQLExpression expression) {
		expression.toSQL(preselect(), dialect, 0);
		return this;
	}

	// BEGIN SELECT PARAMETERS

	public SelectBuilder select(SQLParameter parameter) {
		preselect().param(parameter);
		return this;
	}

	public SelectBuilder select(boolean value) {
		preselect().param(value);
		return this;
	}

	public SelectBuilder select(byte value) {
		preselect().param(value);
		return this;
	}

	public SelectBuilder select(java.sql.Date value) {
		preselect().param(value);
		return this;
	}

	public SelectBuilder select(java.sql.Date value, Calendar calendar) {
		preselect().param(value, calendar);
		return this;
	}

	public SelectBuilder selectDate(java.util.Date value) {
		preselect().date(value);
		return this;
	}

	public SelectBuilder selectDate(java.util.Date value, Calendar calendar) {
		preselect().date(value, calendar);
		return this;
	}

	public SelectBuilder selectDate(TemporalAccessor value) {
		preselect().date(value);
		return this;
	}

	public SelectBuilder selectDate(TemporalAccessor value, Calendar calendar) {
		preselect().date(value, calendar);
		return this;
	}

	public SelectBuilder selectDate(long value) {
		preselect().date(value);
		return this;
	}

	public SelectBuilder selectDate(long value, Calendar calendar) {
		preselect().date(value, calendar);
		return this;
	}

	public SelectBuilder select(double value) {
		preselect().param(value);
		return this;
	}

	public SelectBuilder select(float value) {
		preselect().param(value);
		return this;
	}

	public SelectBuilder select(int value) {
		preselect().param(value);
		return this;
	}

	public SelectBuilder select(long value) {
		preselect().param(value);
		return this;
	}

	public SelectBuilder selectNull(SQLType type) {
		preselect().nullOf(type);
		return this;
	}

	public SelectBuilder selectNull() {
		preselect().nullOf();
		return this;
	}

	public SelectBuilder select(Reader reader, ReaderSQLParameter.ParameterType type) {
		preselect().param(reader, type);
		return this;
	}

	public SelectBuilder selectCharStream(Reader reader) {
		preselect().charStream(reader);
		return this;
	}

	public SelectBuilder selectClob(Reader reader) {
		preselect().clob(reader);
		return this;
	}

	public SelectBuilder selectNcharStream(Reader reader) {
		preselect().ncharStream(reader);
		return this;
	}

	public SelectBuilder selectNclob(Reader reader) {
		preselect().nclob(reader);
		return this;
	}

	public SelectBuilder select(short value) {
		preselect().param(value);
		return this;
	}

	public SelectBuilder selectString(String value) {
		preselect().param(value);
		return this;
	}

	public SelectBuilder select(String value, StringSQLParameter.ParameterType type) {
		preselect().param(value, type);
		return this;
	}

	public SelectBuilder selectNstring(String value) {
		preselect().nstring(value);
		return this;
	}

	public SelectBuilder select(Time value) {
		preselect().param(value);
		return this;
	}

	public SelectBuilder select(Time value, Calendar calendar) {
		preselect().param(value, calendar);
		return this;
	}

	public SelectBuilder selectTime(java.util.Date value) {
		preselect().time(value);
		return this;
	}

	public SelectBuilder selectTime(java.util.Date value, Calendar calendar) {
		preselect().time(value, calendar);
		return this;
	}

	public SelectBuilder selectTime(TemporalAccessor value) {
		preselect().time(value);
		return this;
	}

	public SelectBuilder selectTime(TemporalAccessor value, Calendar calendar) {
		preselect().time(value, calendar);
		return this;
	}

	public SelectBuilder selectTime(long value) {
		preselect().time(value);
		return this;
	}

	public SelectBuilder selectTime(long value, Calendar calendar) {
		preselect().time(value, calendar);
		return this;
	}

	public SelectBuilder select(Timestamp value) {
		preselect().param(value);
		return this;
	}

	public SelectBuilder select(Timestamp value, Calendar calendar) {
		preselect().param(value, calendar);
		return this;
	}

	public SelectBuilder selectTimestamp(java.util.Date value) {
		preselect().timestamp(value);
		return this;
	}

	public SelectBuilder selectTimestamp(java.util.Date value, Calendar calendar) {
		preselect().timestamp(value, calendar);
		return this;
	}

	public SelectBuilder selectTimestamp(TemporalAccessor value) {
		preselect().timestamp(value);
		return this;
	}

	public SelectBuilder selectTimestamp(TemporalAccessor value, Calendar calendar) {
		preselect().timestamp(value, calendar);
		return this;
	}

	public SelectBuilder selectTimestamp(long value) {
		preselect().timestamp(value);
		return this;
	}

	public SelectBuilder selectTimestamp(long value, Calendar calendar) {
		preselect().timestamp(value, calendar);
		return this;
	}

	// END SELECT PARAMETERS

	public final StatementBuilder fromPart() {
		return from;
	}

	private void prefrom(String join) {
		from.sql(from.isEmpty() ? "FROM " : join);
	}

	private void table(String name) {
		if(tablePrefix != null)
			from.sql(tablePrefix).sql('.');
		from.name(name);
	}

	public SelectBuilder from(String table, Join join) {
		prefrom(join.getSQL());
		table(table);
		return this;
	}

	public SelectBuilder from(TableExpression table, Join join) {
		prefrom(join.getSQL());
		table.toSQL(from, dialect, tablePrefix);
		return this;
	}

	public SelectBuilder from(String table) {
		return from(table, Join.CROSS);
	}

	public SelectBuilder from(TableExpression table) {
		return from(table, Join.CROSS);
	}

	public SelectBuilder join(String table) {
		return from(table, Join.INNER);
	}

	public SelectBuilder join(TableExpression table) {
		return from(table, Join.INNER);
	}

	public SelectBuilder leftJoin(String table) {
		return from(table, Join.LEFT);
	}

	public SelectBuilder leftJoin(TableExpression table) {
		return from(table, Join.LEFT);
	}

	public SelectBuilder rightJoin(String table) {
		return from(table, Join.RIGHT);
	}

	public SelectBuilder rightJoin(TableExpression table) {
		return from(table, Join.RIGHT);
	}

	public final StatementBuilder wherePart() {
		if(where == null)
			where = new StatementBuilder(dialect);
		return where;
	}

	private StatementBuilder prewhere() {
		if(where == null) {
			where = new StatementBuilder(dialect);
			return where.sql("WHERE ");
		}
		else
			return where.sql(where.isEmpty() ? "WHERE " : " AND ");
	}

	public SelectBuilder where(String column) {
		prewhere().name(column);
		return this;
	}

	public SelectBuilder where(String leftColumn, Ordering ordering, String rightColumn) {
		prewhere().name(leftColumn).sql(ordering.getSQL()).name(rightColumn);
		return this;
	}

	public SelectBuilder whereEqual(String leftColumn, String rightColumn) {
		return where(leftColumn, Ordering.EQUAL, rightColumn);
	}

	public SelectBuilder whereUnequal(String leftColumn, String rightColumn) {
		return where(leftColumn, Ordering.UNEQUAL, rightColumn);
	}

	public SelectBuilder whereLess(String leftColumn, String rightColumn) {
		return where(leftColumn, Ordering.LESS, rightColumn);
	}

	public SelectBuilder whereLessEqual(String leftColumn, String rightColumn) {
		return where(leftColumn, Ordering.LESS_EQUAL, rightColumn);
	}

	public SelectBuilder whereGreater(String leftColumn, String rightColumn) {
		return where(leftColumn, Ordering.GREATER, rightColumn);
	}

	public SelectBuilder whereGreaterEqual(String leftColumn, String rightColumn) {
		return where(leftColumn, Ordering.GREATER_EQUAL, rightColumn);
	}

	public SelectBuilder where(String leftTable, String leftColumn,
			Ordering ordering, String rightTable, String rightColumn) {
		prewhere();
		if(tablePrefix != null)
			where.sql(tablePrefix).sql('.');
		where.name(leftTable).sql('.').name(leftColumn).sql(ordering.getSQL());
		if(tablePrefix != null)
			where.sql(tablePrefix).sql('.');
		where.name(rightTable).sql('.').name(rightColumn);
		return this;
	}

	public SelectBuilder whereEqual(String leftTable, String leftColumn, String rightTable, String rightColumn) {
		return where(leftTable, leftColumn, Ordering.EQUAL, rightTable, rightColumn);
	}

	public SelectBuilder whereUnequal(String leftTable, String leftColumn, String rightTable, String rightColumn) {
		return where(leftTable, leftColumn, Ordering.UNEQUAL, rightTable, rightColumn);
	}

	public SelectBuilder whereLess(String leftTable, String leftColumn, String rightTable, String rightColumn) {
		return where(leftTable, leftColumn, Ordering.LESS, rightTable, rightColumn);
	}

	public SelectBuilder whereLessEqual(String leftTable, String leftColumn, String rightTable, String rightColumn) {
		return where(leftTable, leftColumn, Ordering.LESS_EQUAL, rightTable, rightColumn);
	}

	public SelectBuilder whereGreater(String leftTable, String leftColumn, String rightTable, String rightColumn) {
		return where(leftTable, leftColumn, Ordering.GREATER, rightTable, rightColumn);
	}

	public SelectBuilder whereGreaterEqual(String leftTable, String leftColumn,
			String rightTable, String rightColumn) {
		return where(leftTable, leftColumn, Ordering.GREATER_EQUAL, rightTable, rightColumn);
	}

	public final StatementBuilder groupByPart() {
		if(groupBy == null)
			groupBy = new StatementBuilder(dialect);
		return groupBy;
	}

	public final StatementBuilder orderByPart() {
		if(orderBy == null)
			orderBy = new StatementBuilder(dialect);
		return orderBy;
	}

}

package org.unclesniper.sqlbuild;

public class JoinExpression implements TableExpression {

	public static final class Joinable {

		private TableExpression table;

		private SQLExpression condition;

		public Joinable(TableExpression table, SQLExpression condition) {
			this.table = table;
			this.condition = condition;
		}

		public TableExpression getTable() {
			return table;
		}

		public void setTable(TableExpression table) {
			this.table = table;
		}

		public SQLExpression getCondition() {
			return condition;
		}

		public void setCondition(SQLExpression condition) {
			this.condition = condition;
		}

	}

	private Iterable<? extends Joinable> tables;

	private SelectBuilder.Join join;

	public JoinExpression(Iterable<? extends Joinable> tables, SelectBuilder.Join join) {
		this.tables = tables;
		this.join = join;
	}

	public Iterable<? extends Joinable> getTables() {
		return tables;
	}

	public void setTables(Iterable<? extends Joinable> tables) {
		this.tables = tables;
	}

	public SelectBuilder.Join getJoin() {
		return join;
	}

	public void setJoin(SelectBuilder.Join join) {
		this.join = join;
	}

	public void toSQL(SQLBuilder<?> sink, SQLDialect dialect, String prefix) {
		sink.sql('(');
		boolean isEmpty = true;
		String joinSQL = join.getSQL();
		for(Joinable table : tables) {
			if(!isEmpty)
				sink.sql(joinSQL);
			table.getTable().toSQL(sink, dialect, prefix);
			if(isEmpty) {
				sink.sql(" ON ");
				table.getCondition().toSQL(sink, dialect, 0);
				isEmpty = false;
			}
		}
		if(isEmpty)
			sink.sql("SELECT NULL AS nothing");
		sink.sql(')');
	}

}

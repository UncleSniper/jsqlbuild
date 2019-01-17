package org.unclesniper.sqlbuild;

public class TableReference implements TableExpression {

	private String tableName;

	public TableReference(String tableName) {
		this.tableName = tableName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public void toSQL(SQLBuilder<?> sink, SQLDialect dialect, String prefix) {
		if(prefix != null) {
			sink.sql(prefix);
			sink.sql('.');
		}
		sink.name(tableName);
	}

}

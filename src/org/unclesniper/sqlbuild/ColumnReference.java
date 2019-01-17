package org.unclesniper.sqlbuild;

public class ColumnReference implements SQLExpression {

	private String tableName;

	private String columnName;

	public ColumnReference(String columnName) {
		this(null, columnName);
	}

	public ColumnReference(String tableName, String columnName) {
		this.tableName = tableName;
		this.columnName = columnName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public void toSQL(SQLBuilder<?> sink, SQLDialect dialect, int minPrecedence) {
		if(tableName != null && tableName.length() > 0) {
			sink.name(tableName);
			sink.sql('.');
		}
		sink.name(columnName);
	}

}

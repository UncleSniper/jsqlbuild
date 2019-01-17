package org.unclesniper.sqlbuild;

public class ColumnEqualityOperation implements SQLExpression {

	private String leftTable;

	private String leftColumn;

	private String rightTable;

	private String rightColumn;

	public ColumnEqualityOperation(String leftColumn, String rightColumn) {
		this(null, leftColumn, null, rightColumn);
	}

	public ColumnEqualityOperation(String leftTable, String leftColumn, String rightTable, String rightColumn) {
		this.leftTable = leftTable;
		this.leftColumn = leftColumn;
		this.rightTable = rightTable;
		this.rightColumn = rightColumn;
	}

	public String getLeftTable() {
		return leftTable;
	}

	public void setLeftTable(String leftTable) {
		this.leftTable = leftTable;
	}

	public String getLeftColumn() {
		return leftColumn;
	}

	public void setLeftColumn(String leftColumn) {
		this.leftColumn = leftColumn;
	}

	public String getRightTable() {
		return rightTable;
	}

	public void setRightTable(String rightTable) {
		this.rightTable = rightTable;
	}

	public String getRightColumn() {
		return rightColumn;
	}

	public void setRightColumn(String rightColumn) {
		this.rightColumn = rightColumn;
	}

	public void toSQL(SQLBuilder<?> sink, SQLDialect dialect, int minPrecedence) {
		int myPrec = dialect.getPrecedence(EqualityOperation.class);
		if(myPrec < minPrecedence)
			sink.sql('(');
		if(leftTable != null) {
			sink.name(leftTable);
			sink.sql('.');
		}
		sink.name(leftColumn);
		sink.sql(" = ");
		if(rightTable != null) {
			sink.name(rightTable);
			sink.sql('.');
		}
		sink.name(rightColumn);
		if(myPrec < minPrecedence)
			sink.sql(')');
	}

}

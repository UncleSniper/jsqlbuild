package org.unclesniper.sqlbuild;

public interface SQLExpression {

	public static final int PREC_INFINITY = Integer.MAX_VALUE;

	void toSQL(SQLBuilder<?> sink, SQLDialect dialect, int minPrecedence);

	public static ColumnReference column(String columnName) {
		return new ColumnReference(columnName);
	}

	public static ColumnReference column(String tableName, String columnName) {
		return new ColumnReference(tableName, columnName);
	}

	// equality

	public static EqualityOperation equality(SQLExpression leftOperand,
			EqualityOperation.Operator operator, SQLExpression rightOperand) {
		return new EqualityOperation(leftOperand, operator, rightOperand);
	}

	public static EqualityOperation equality(String leftColumn,
			EqualityOperation.Operator operator, SQLExpression rightOperand) {
		return new EqualityOperation(new ColumnReference(leftColumn), operator, rightOperand);
	}

	public static EqualityOperation equality(String leftTable, String leftColumn,
			EqualityOperation.Operator operator, SQLExpression rightOperand) {
		return new EqualityOperation(new ColumnReference(leftTable, leftColumn), operator, rightOperand);
	}

	public static EqualityOperation equality(String leftColumn,
			EqualityOperation.Operator operator, String rightColumn) {
		return new EqualityOperation(new ColumnReference(leftColumn), operator, new ColumnReference(rightColumn));
	}

	public static EqualityOperation equality(String leftTable, String leftColumn,
			EqualityOperation.Operator operator, String rightTable, String rightColumn) {
		return new EqualityOperation(new ColumnReference(leftTable, leftColumn),
				operator, new ColumnReference(rightTable, rightColumn));
	}

	// EQUAL

	public static EqualityOperation equal(SQLExpression leftOperand, SQLExpression rightOperand) {
		return new EqualityOperation(leftOperand, EqualityOperation.Operator.EQUAL, rightOperand);
	}

	public static EqualityOperation equal(String leftColumn, SQLExpression rightOperand) {
		return new EqualityOperation(new ColumnReference(leftColumn),
				EqualityOperation.Operator.EQUAL, rightOperand);
	}

	public static EqualityOperation equal(String leftTable, String leftColumn, SQLExpression rightOperand) {
		return new EqualityOperation(new ColumnReference(leftTable, leftColumn),
				EqualityOperation.Operator.EQUAL, rightOperand);
	}

	public static ColumnEqualityOperation equal(String leftColumn, String rightColumn) {
		return new ColumnEqualityOperation(leftColumn, rightColumn);
	}

	public static ColumnEqualityOperation equal(String leftTable, String leftColumn,
			String rightTable, String rightColumn) {
		return new ColumnEqualityOperation(leftTable, leftColumn, rightTable, rightColumn);
	}

	// UNEQUAL

	public static EqualityOperation unequal(SQLExpression leftOperand, SQLExpression rightOperand) {
		return new EqualityOperation(leftOperand, EqualityOperation.Operator.UNEQUAL, rightOperand);
	}

	public static EqualityOperation unequal(String leftColumn, SQLExpression rightOperand) {
		return new EqualityOperation(new ColumnReference(leftColumn),
				EqualityOperation.Operator.UNEQUAL, rightOperand);
	}

	public static EqualityOperation unequal(String leftTable, String leftColumn, SQLExpression rightOperand) {
		return new EqualityOperation(new ColumnReference(leftTable, leftColumn),
				EqualityOperation.Operator.UNEQUAL, rightOperand);
	}

	public static EqualityOperation unequal(String leftColumn, String rightColumn) {
		return new EqualityOperation(new ColumnReference(leftColumn),
				EqualityOperation.Operator.UNEQUAL, new ColumnReference(rightColumn));
	}

	public static EqualityOperation unequal(String leftTable, String leftColumn,
			String rightTable, String rightColumn) {
		return new EqualityOperation(new ColumnReference(leftTable, leftColumn),
				EqualityOperation.Operator.UNEQUAL, new ColumnReference(rightTable, rightColumn));
	}

	// inequality

	public static InequalityOperation inequality(SQLExpression leftOperand,
			InequalityOperation.Operator operator, SQLExpression rightOperand) {
		return new InequalityOperation(leftOperand, operator, rightOperand);
	}

	public static InequalityOperation inequality(String leftColumn,
			InequalityOperation.Operator operator, SQLExpression rightOperand) {
		return new InequalityOperation(new ColumnReference(leftColumn), operator, rightOperand);
	}

	public static InequalityOperation inequality(String leftTable, String leftColumn,
			InequalityOperation.Operator operator, SQLExpression rightOperand) {
		return new InequalityOperation(new ColumnReference(leftTable, leftColumn), operator, rightOperand);
	}

	public static InequalityOperation inequality(String leftColumn,
			InequalityOperation.Operator operator, String rightColumn) {
		return new InequalityOperation(new ColumnReference(leftColumn), operator, new ColumnReference(rightColumn));
	}

	public static InequalityOperation inequality(String leftTable, String leftColumn,
			InequalityOperation.Operator operator, String rightTable, String rightColumn) {
		return new InequalityOperation(new ColumnReference(leftTable, leftColumn),
				operator, new ColumnReference(rightTable, rightColumn));
	}

	// LESS

	public static InequalityOperation less(SQLExpression leftOperand, SQLExpression rightOperand) {
		return new InequalityOperation(leftOperand, InequalityOperation.Operator.LESS, rightOperand);
	}

	public static InequalityOperation less(String leftColumn, SQLExpression rightOperand) {
		return new InequalityOperation(new ColumnReference(leftColumn),
				InequalityOperation.Operator.LESS, rightOperand);
	}

	public static InequalityOperation less(String leftTable, String leftColumn, SQLExpression rightOperand) {
		return new InequalityOperation(new ColumnReference(leftTable, leftColumn),
				InequalityOperation.Operator.LESS, rightOperand);
	}

	public static InequalityOperation less(String leftColumn, String rightColumn) {
		return new InequalityOperation(new ColumnReference(leftColumn),
				InequalityOperation.Operator.LESS, new ColumnReference(rightColumn));
	}

	public static InequalityOperation less(String leftTable, String leftColumn,
			String rightTable, String rightColumn) {
		return new InequalityOperation(new ColumnReference(leftTable, leftColumn),
				InequalityOperation.Operator.LESS, new ColumnReference(rightTable, rightColumn));
	}

	// LESS_EQUAL

	public static InequalityOperation lessEqual(SQLExpression leftOperand, SQLExpression rightOperand) {
		return new InequalityOperation(leftOperand, InequalityOperation.Operator.LESS_EQUAL, rightOperand);
	}

	public static InequalityOperation lessEqual(String leftColumn, SQLExpression rightOperand) {
		return new InequalityOperation(new ColumnReference(leftColumn),
				InequalityOperation.Operator.LESS_EQUAL, rightOperand);
	}

	public static InequalityOperation lessEqual(String leftTable, String leftColumn, SQLExpression rightOperand) {
		return new InequalityOperation(new ColumnReference(leftTable, leftColumn),
				InequalityOperation.Operator.LESS_EQUAL, rightOperand);
	}

	public static InequalityOperation lessEqual(String leftColumn, String rightColumn) {
		return new InequalityOperation(new ColumnReference(leftColumn),
				InequalityOperation.Operator.LESS_EQUAL, new ColumnReference(rightColumn));
	}

	public static InequalityOperation lessEqual(String leftTable, String leftColumn,
			String rightTable, String rightColumn) {
		return new InequalityOperation(new ColumnReference(leftTable, leftColumn),
				InequalityOperation.Operator.LESS_EQUAL, new ColumnReference(rightTable, rightColumn));
	}

	// GREATER

	public static InequalityOperation greater(SQLExpression leftOperand, SQLExpression rightOperand) {
		return new InequalityOperation(leftOperand, InequalityOperation.Operator.GREATER, rightOperand);
	}

	public static InequalityOperation greater(String leftColumn, SQLExpression rightOperand) {
		return new InequalityOperation(new ColumnReference(leftColumn),
				InequalityOperation.Operator.GREATER, rightOperand);
	}

	public static InequalityOperation greater(String leftTable, String leftColumn, SQLExpression rightOperand) {
		return new InequalityOperation(new ColumnReference(leftTable, leftColumn),
				InequalityOperation.Operator.GREATER, rightOperand);
	}

	public static InequalityOperation greater(String leftColumn, String rightColumn) {
		return new InequalityOperation(new ColumnReference(leftColumn),
				InequalityOperation.Operator.GREATER, new ColumnReference(rightColumn));
	}

	public static InequalityOperation greater(String leftTable, String leftColumn,
			String rightTable, String rightColumn) {
		return new InequalityOperation(new ColumnReference(leftTable, leftColumn),
				InequalityOperation.Operator.GREATER, new ColumnReference(rightTable, rightColumn));
	}

	// GREATER_EQUAL

	public static InequalityOperation greaterEqual(SQLExpression leftOperand, SQLExpression rightOperand) {
		return new InequalityOperation(leftOperand, InequalityOperation.Operator.GREATER_EQUAL, rightOperand);
	}

	public static InequalityOperation greaterEqual(String leftColumn, SQLExpression rightOperand) {
		return new InequalityOperation(new ColumnReference(leftColumn),
				InequalityOperation.Operator.GREATER_EQUAL, rightOperand);
	}

	public static InequalityOperation greaterEqual(String leftTable, String leftColumn, SQLExpression rightOperand) {
		return new InequalityOperation(new ColumnReference(leftTable, leftColumn),
				InequalityOperation.Operator.GREATER_EQUAL, rightOperand);
	}

	public static InequalityOperation greaterEqual(String leftColumn, String rightColumn) {
		return new InequalityOperation(new ColumnReference(leftColumn),
				InequalityOperation.Operator.GREATER_EQUAL, new ColumnReference(rightColumn));
	}

	public static InequalityOperation greaterEqual(String leftTable, String leftColumn,
			String rightTable, String rightColumn) {
		return new InequalityOperation(new ColumnReference(leftTable, leftColumn),
				InequalityOperation.Operator.GREATER_EQUAL, new ColumnReference(rightTable, rightColumn));
	}

}

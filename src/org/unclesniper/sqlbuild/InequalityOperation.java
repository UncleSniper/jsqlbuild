package org.unclesniper.sqlbuild;

public class InequalityOperation extends InfixOperation {

	public enum Operator {

		LESS("<"),
		LESS_EQUAL("<="),
		GREATER(">"),
		GREATER_EQUAL(">=");

		private final String sql;

		private Operator(String sql) {
			this.sql = sql;
		}

		public String getSQL() {
			return sql;
		}

	}

	private Operator operator;

	public InequalityOperation(SQLExpression leftOperand, Operator operator, SQLExpression rightOperand) {
		super(leftOperand, rightOperand);
		this.operator = operator;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public void toSQL(SQLBuilder<?> sink, SQLDialect dialect, int minPrecedence) {
		toSQL(sink, dialect, minPrecedence, operator.getSQL());
	}

}

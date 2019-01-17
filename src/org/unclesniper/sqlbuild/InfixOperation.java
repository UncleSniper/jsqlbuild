package org.unclesniper.sqlbuild;

public abstract class InfixOperation implements SQLExpression {

	protected SQLExpression leftOperand;

	protected SQLExpression rightOperand;

	public InfixOperation(SQLExpression leftOperand, SQLExpression rightOperand) {
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}

	public SQLExpression getLeftOperand() {
		return leftOperand;
	}

	public void setLeftOperand(SQLExpression leftOperand) {
		this.leftOperand = leftOperand;
	}

	public SQLExpression getRightOperand() {
		return rightOperand;
	}

	public void setRightOperand(SQLExpression rightOperand) {
		this.rightOperand = rightOperand;
	}

	protected final void toSQL(SQLBuilder<?> sink, SQLDialect dialect, int minPrecedence, String operator) {
		int myPrec = dialect.getPrecedence(getClass());
		if(myPrec < minPrecedence)
			sink.sql('(');
		leftOperand.toSQL(sink, dialect, myPrec);
		sink.sql(' ');
		sink.sql(operator);
		sink.sql(' ');
		rightOperand.toSQL(sink, dialect, myPrec + 1);
		if(myPrec < minPrecedence)
			sink.sql(')');
	}

}

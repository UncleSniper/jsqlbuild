package org.unclesniper.sqlbuild;

import java.util.Map;

public class MSSQLDialect implements SQLDialect {

	public static final SQLDialect instance = new MSSQLDialect();

	private static final Map<Class<? extends SQLExpression>, Integer> PRECEDENCES
			= MapBuilder.<Class<? extends SQLExpression>, Integer>hash()
			.put(ColumnReference.class, SQLExpression.PREC_INFINITY)
			.put(EqualityOperation.class, 4)
			.put(InequalityOperation.class, 4)
			.map();

	public MSSQLDialect() {}

	public String quoteIdentifier(String name) {
		return '[' + name + ']';
	}

	public int getPrecedence(Class<? extends SQLExpression> operator) {
		Integer precedence = MSSQLDialect.PRECEDENCES.get(operator);
		return precedence == null ? -1 : precedence.intValue();
	}

}

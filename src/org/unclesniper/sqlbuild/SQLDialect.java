package org.unclesniper.sqlbuild;

public interface SQLDialect {

	String quoteIdentifier(String name);

	int getPrecedence(Class<? extends SQLExpression> operator);

}

package org.unclesniper.sqlbuild;

import java.util.ArrayList;
import java.util.LinkedList;

public interface TableExpression {

	void toSQL(SQLBuilder<?> sink, SQLDialect dialect, String prefix);

	public static TableReference table(String tableName) {
		return new TableReference(tableName);
	}

	// generic

	public static JoinExpression join(SelectBuilder.Join join, JoinExpression.Joinable... tables) {
		return new JoinExpression(new ArrayIterable<JoinExpression.Joinable>(tables, true), join);
	}

	public static JoinExpression join(SelectBuilder.Join join,
			boolean copyArray, JoinExpression.Joinable... tables) {
		return new JoinExpression(new ArrayIterable<JoinExpression.Joinable>(tables, copyArray), join);
	}

}

package org.unclesniper.sqlbuild;

import java.util.List;
import java.util.LinkedList;
import java.util.Collection;

public class StatementBuilder extends AbstractSQLBuilder<StatementBuilder> {

	private final StringBuilder builder = new StringBuilder();

	private String sql;

	private final List<SQLParameter> parameters = new LinkedList<SQLParameter>();

	public StatementBuilder(SQLDialect dialect) {
		super(dialect);
	}

	public StatementBuilder sql(String fragment) {
		builder.append(fragment);
		sql = null;
		return this;
	}

	public StatementBuilder sql(char fragment) {
		builder.append(fragment);
		sql = null;
		return this;
	}

	protected StatementBuilder addParam(SQLParameter param) {
		parameters.add(param);
		return this;
	}

	public String getSQL() {
		if(sql == null)
			sql = builder.toString();
		return sql;
	}

	public List<SQLParameter> getParameters() {
		return parameters;
	}

	public void appendSQLTo(StringBuilder sink) {
		sink.append(sql == null ? builder : sql);
	}

	public void appendParametersTo(Collection<? super SQLParameter> sink) {
		sink.addAll(parameters);
	}

	public boolean isEmpty() {
		return builder.length() == 0;
	}

}

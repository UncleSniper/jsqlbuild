package org.unclesniper.sqlbuild;

import java.sql.SQLException;
import java.sql.PreparedStatement;

public interface SQLParameter {

	void setParameter(PreparedStatement statement, int index) throws SQLException;

}

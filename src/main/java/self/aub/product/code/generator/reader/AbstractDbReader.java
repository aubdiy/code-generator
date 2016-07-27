package self.aub.product.code.generator.reader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import self.aub.product.code.generator.bean.Table;
import self.aub.product.code.generator.config.GeneratorConfig;

public abstract class AbstractDbReader implements DbReader {
	private static final Logger LOG = LoggerFactory.getLogger(AbstractDbReader.class);

	/**
	 * <B>获取TableBean</B><br>
	 * 
	 * @author aub
	 * @return
	 */
	@Override
	public List<Table> getTableBeans() {
		List<Table> tables = new ArrayList<Table>();
		List<String> tableNames = getTableNames();
		for (String tableName : tableNames) {
			Table table = new Table(tableName, getPrimaryKeyName(tableName), getColumns(tableName));
			tables.add(table);
		}
		return tables;
	}

	protected Connection getConn() {
		try {
			Class.forName(GeneratorConfig.getDbDriver());
		} catch (ClassNotFoundException e) {
			LOG.error("find driver fail :　", e);
		}
		String url = GeneratorConfig.getDbUrl();
		String username = GeneratorConfig.getDbUserName();
		String password = GeneratorConfig.getDbPassword();
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			LOG.error("get connection fail : ", e);
		}
		return null;
	}

	protected void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				LOG.error("close connect fail : ", e);
			}
		}
	}

	protected void closeRS(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				LOG.error("close result set fail : ", e);
			}
		}
	}
}

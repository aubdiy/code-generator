package self.aub.product.code.generator.reader;

import self.aub.product.code.generator.bean.Column;
import self.aub.product.code.generator.bean.Table;

import java.util.List;
import java.util.Map;

public interface DbReader {

	/**
	 * <B>获取TableBean</B><br>
	 * 
	 * @author aub
	 * @return
	 */
	List<Table> getTableBeans();

	/**
	 * <B>获取当前库所有表名</B><br>
	 * 
	 * @author aub
	 * @return
	 */
	List<String> getTableNames();

	/**
	 * <B>获取表的所有列</B><br>
	 * 
	 * @author aub
	 * @param tableName
	 * @return key: column name, value: Column
	 */
	public Map<String, Column> getColumns(String tableName);

	/**
	 * <B>获取表的主键名</B><br>
	 * 
	 * @author aub
	 * @param tableName
	 * @return
	 */
	String getPrimaryKeyName(String tableName);
}

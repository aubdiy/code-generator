package self.aub.product.code.generator.reader;

import self.aub.product.code.generator.bean.Column;
import self.aub.product.code.generator.bean.Table;

import java.util.List;
import java.util.Map;

/**
 * @author aub
 */
public interface DbReader {

    /**
     * <B>获取TableBean</B><br>
     *
     * @return table 列表
     */
    List<Table> getTableBeans();

    /**
     * <B>获取当前库所有表信息（表名，表描述）</B><br>
     *
     * @return table name 列表
     */
    Map<String, String> getTableInfo();

    /**
     * <B>获取表的所有列</B><br>
     *
     * @param tableName 表名
     * @return key: column name, value: Column
     */
    Map<String, Column> getColumns(String tableName);

    /**
     * <B>获取表的主键名</B><br>
     *
     * @param tableName 表名
     * @return 主键名
     */
    String getPrimaryKeyName(String tableName);
}

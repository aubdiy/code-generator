package self.aub.product.code.generator.bean;

import self.aub.product.code.generator.config.GeneratorConfig;
import self.aub.product.code.generator.util.Constant;
import self.aub.product.code.generator.util.ConvertUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * <B>数据库表</B><br>
 *
 * @author aub
 */
public class Table {
    /**
     * 数据库表名，例如“sys_user”
     */
    private final String tableNameDb;
    /**
     * 实体类名，例如“SysUser”
     */
    private final String tableNameClass;
    /**
     * 实体变量名，例如“sysUser”
     */
    private final String tableNameVariable;
    /**
     * 模块名，表名第一个下划线前面的部分，例如表“sys_user”的模块名为“sys”
     */
    private final String modleName;
    /**
     * 主键
     */
    private PrimaryKey primaryKey;
    /**
     * 字段列表
     */
    private final List<Column> columnList;

    public Table(String tableName, String primaryKeyName, Map<String, Column> columnMap) {
        this.tableNameDb = tableName;
        if (primaryKeyName != null) {
            Column pkColumn = columnMap.get(primaryKeyName);
            if (pkColumn != null) {
                this.primaryKey = new PrimaryKey(primaryKeyName, pkColumn.getColumnType());
            }
        }
        this.columnList = new ArrayList<>();
        for (Entry<String, Column> entry : columnMap.entrySet()) {
            this.columnList.add(entry.getValue());
        }
        if (GeneratorConfig.getSeparateModle()) {
            this.modleName = separateModleName(tableName);
        } else {
            this.modleName = "";
        }
        this.tableNameClass = ConvertUtil.convert2CamelCase(tableName);
        this.tableNameVariable = ConvertUtil.conver2VariableName(tableNameClass);
    }

    /**
     * <B>分离模块名</B><br>
     *
     * @param tableName
     * @return
     * @author aub
     */
    public String separateModleName(String tableName) {
        int moduleIndex = tableName.indexOf(Constant.SIGN_UNDERLINE);
        if (moduleIndex != -1) {
            return tableName.substring(0, moduleIndex);
        }
        return "";
    }

    public PrimaryKey getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(PrimaryKey primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getTableNameDb() {
        return tableNameDb;
    }

    public String getTableNameClass() {
        return tableNameClass;
    }

    public String getTableNameVariable() {
        return tableNameVariable;
    }

    public String getModleName() {
        return modleName;
    }

    public List<Column> getColumnList() {
        return columnList;
    }
}

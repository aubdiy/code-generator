package self.aub.product.code.generator.bean;

import self.aub.product.code.generator.util.ConvertUtil;

/**
 * <B>数据库表字段</B><br>
 *
 * @author aub
 */
public class Column {

    /**
     * 对应的java字段名，例如“LoginName”
     */
    private final String columnName;

    /**
     * 对应的java类型名，例如“Integer”
     */
    private final String columnType;

    /**
     * 描述
     */
    private final String columneRemarks;

    /**
     * 数据库字段名，例如“login_name”
     */
    private final String columnNameDb;

    /**
     * 字段变量名，例如“loginName”
     */
    private final String columnNameVariable;

    public Column(String columnNameDb, int dbDateType, String columneRemarks) {
        this.columnName = ConvertUtil.convert2CamelCase(columnNameDb);
        this.columnType = ConvertUtil.conver2JavaType(dbDateType);
        this.columnNameDb = columnNameDb;
        this.columneRemarks = columneRemarks;
        this.columnNameVariable = ConvertUtil.conver2VariableName(columnName);
    }

    public String getColumnName() {
        return columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public String getColumneRemarks() {
        return columneRemarks;
    }

    public String getColumnNameDb() {
        return columnNameDb;
    }

    public String getColumnNameVariable() {
        return columnNameVariable;
    }

}

package self.aub.product.code.generator.bean;


/**
 * @author aub
 */
public class MybatisMapper {

    /**
     * 实体类名，例如“SysUser”
     */
    private final String tableNameClass;
    /**
     * 模块名
     */
    private final String modleName;

    public MybatisMapper(String tableNameClass, String modleName) {
        this.tableNameClass = tableNameClass;
        this.modleName = modleName;
    }

    public String getTableNameClass() {
        return tableNameClass;
    }

    public String getModleName() {
        return modleName;
    }
}

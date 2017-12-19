package self.aub.product.code.generator.generator.db;

import self.aub.product.code.generator.bean.Table;

import java.util.List;

/**
 * @author aub
 */
public interface DbGenerator {

    /**
     * <B>生成代码</B><br>
     *
     * @param table table
     */
    void generate(Table table);

    /**
     * <B>生成配置</B><br>
     *
     * @param tableList table list
     */
    void generateRes(List<Table> tableList);

}
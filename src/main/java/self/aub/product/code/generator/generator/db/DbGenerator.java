package self.aub.product.code.generator.generator.db;

import self.aub.product.code.generator.bean.Table;

import java.util.List;

public interface DbGenerator {

	/**
	 * <B>生成</B><br>
	 * 
	 * @author aub
	 * @param table
	 */
	void generate(Table table);

	/**
	 * 生成配置
	 * @param tableList
	 */
	void generateRes(List<Table> tableList);

}
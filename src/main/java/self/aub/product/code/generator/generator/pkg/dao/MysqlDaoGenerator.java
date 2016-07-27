package self.aub.product.code.generator.generator.pkg.dao;

import org.apache.velocity.VelocityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import self.aub.product.code.generator.bean.Table;
import self.aub.product.code.generator.generator.Generator;
import self.aub.product.code.generator.util.Constant;

public class MysqlDaoGenerator extends Generator {
	private static final Logger LOG = LoggerFactory.getLogger(MysqlDaoGenerator.class);

	public static void generate(Table table, String basePackage, String systemPackage, String outputDir) {
		String tableNameClass = table.getTableNameClass();
		LOG.debug("generate dao : {}Dao.java", tableNameClass);

		VelocityContext context = new VelocityContext();
		context.put("basePackage", basePackage);
		context.put("systemPackage", systemPackage);
		context.put("tableNameClass", tableNameClass);
		context.put("tableNameVariable", table.getTableNameVariable());
		context.put("primaryKey", table.getPrimaryKey());

		String outputFilePath = generateOutputFilePath(tableNameClass, outputDir, Constant.Layer.DAO, Constant.LayerClassSuffix.DAO);
		write2FileBySchema("/dao/MysqlDaoTemp.vm", context, outputFilePath);
	}
}

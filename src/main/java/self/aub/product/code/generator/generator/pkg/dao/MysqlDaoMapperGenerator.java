package self.aub.product.code.generator.generator.pkg.dao;

import org.apache.velocity.VelocityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import self.aub.product.code.generator.bean.Table;
import self.aub.product.code.generator.generator.Generator;
import self.aub.product.code.generator.util.Constant;

public class MysqlDaoMapperGenerator extends Generator {
	private static final Logger LOG = LoggerFactory.getLogger(MysqlDaoMapperGenerator.class);

	public static void generate(Table table, String systemPackage, String outputDir) {
		String tableNameClass = table.getTableNameClass();
		LOG.debug("generate mapper: {}.xml", tableNameClass);

		VelocityContext context = new VelocityContext();
		context.put("systemPackage", systemPackage);
		context.put("tableNameClass", tableNameClass);
		context.put("tableNameDb", table.getTableNameDb());
		context.put("primaryKey", table.getPrimaryKey());
		context.put("columnList", table.getColumnList());
		context.put("columnSize", table.getColumnList().size());

		StringBuilder outputFilePath = new StringBuilder(outputDir);
		outputFilePath.append(Constant.SIGN_SLASH);
		outputFilePath.append(tableNameClass);
		outputFilePath.append(".xml");

		write2FileBySchema("/dao/MysqlMapperXmlTemp.vm", context, outputFilePath.toString());
	}
}

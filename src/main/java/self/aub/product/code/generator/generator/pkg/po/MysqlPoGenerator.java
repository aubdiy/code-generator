package self.aub.product.code.generator.generator.pkg.po;

import org.apache.velocity.VelocityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import self.aub.product.code.generator.bean.Table;
import self.aub.product.code.generator.generator.Generator;
import self.aub.product.code.generator.util.Constant;

public class MysqlPoGenerator extends Generator {
	private static final Logger LOG = LoggerFactory.getLogger(MysqlPoGenerator.class);

	public static void generate(Table table, String systemPackage, String outputDir) {
		String tableNameClass = table.getTableNameClass();
		LOG.debug("generate ent : {}.java", tableNameClass);

		VelocityContext context = new VelocityContext();
		context.put("systemPackage", systemPackage);
		context.put("tableNameClass", tableNameClass);
		context.put("columnList", table.getColumnList());

		String outputFilePath = generateOutputFilePath(tableNameClass, outputDir, Constant.Layer.PO, Constant.LayerClassSuffix.PO);
		write2FileBySchema("/po/MysqlPoTemp.vm", context, outputFilePath);
	}
}

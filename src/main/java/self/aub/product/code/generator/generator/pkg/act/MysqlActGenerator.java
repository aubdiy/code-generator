package self.aub.product.code.generator.generator.pkg.act;

import org.apache.velocity.VelocityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import self.aub.product.code.generator.bean.Table;
import self.aub.product.code.generator.generator.Generator;
import self.aub.product.code.generator.util.Constant.Layer;
import self.aub.product.code.generator.util.Constant.LayerClassSuffix;
import self.aub.product.code.generator.util.ConvertUtil;

public class MysqlActGenerator extends Generator {
	private static final Logger LOG = LoggerFactory.getLogger(MysqlActGenerator.class);

	public static void generate(Table table, String basePackage, String systemPackage, String outputDir) {
		String tableNameClass = table.getTableNameClass();
		LOG.debug("generate act : {}Act.java", tableNameClass);

		VelocityContext context = new VelocityContext();
		context.put("basePackage", basePackage);
		context.put("systemPackage", systemPackage);
		context.put("tableNameClass", tableNameClass);
		context.put("tableNameVariable", table.getTableNameVariable());
		context.put("requestMapping", ConvertUtil.conver2RequestMapping(table.getTableNameDb()));
		context.put("primaryKey", table.getPrimaryKey());
		String outputFilePath = generateOutputFilePath(tableNameClass, outputDir, Layer.ACT, LayerClassSuffix.ACT);
		write2FileBySchema("/act/MysqlActTemp.vm", context, outputFilePath);
	}
}

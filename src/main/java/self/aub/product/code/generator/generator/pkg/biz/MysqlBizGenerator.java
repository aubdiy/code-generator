package self.aub.product.code.generator.generator.pkg.biz;

import org.apache.velocity.VelocityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import self.aub.product.code.generator.bean.Layer;
import self.aub.product.code.generator.bean.Table;
import self.aub.product.code.generator.config.GeneratorConfig;
import self.aub.product.code.generator.generator.Generator;

/**
 * @author aub
 */
public class MysqlBizGenerator extends Generator {
    private static final Logger LOG = LoggerFactory.getLogger(MysqlBizGenerator.class);

    public static void generate(Table table, String basePackage, String systemPackage, String outputDir) {
        Layer layer = GeneratorConfig.getLayer();
        String tableNameClass = table.getTableNameClass();
        LOG.debug("generate biz : {}{}", tableNameClass, layer.getFileSuffixBiz());

        VelocityContext context = new VelocityContext();
        context.put("basePackage", basePackage);
        context.put("systemPackage", systemPackage);
        context.put("tableNameClass", tableNameClass);
        context.put("tableNameVariable", table.getTableNameVariable());
        context.put("primaryKey", table.getPrimaryKey());
        context.put("layer", layer);

        String outputFilePath = generateOutputFilePath(tableNameClass, outputDir, layer.getLayerNameBiz(), layer.getFileSuffixBiz());
        write2FileBySchema("/biz/MysqlBiz.vm", context, outputFilePath);
    }
}

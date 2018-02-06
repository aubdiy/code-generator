package self.aub.product.code.generator.generator.pkg.po;

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
public class MysqlPoGenerator extends Generator {
    private static final Logger LOG = LoggerFactory.getLogger(MysqlPoGenerator.class);

    public static void generate(Table table, String systemPackage, String outputDir) {
        Layer layer = GeneratorConfig.getLayer();
        String tableNameClass = table.getTableNameClass();
        LOG.debug("generate ent : {}{}", tableNameClass, layer.getFileSuffixPo());

        VelocityContext context = new VelocityContext();
        context.put("systemPackage", systemPackage);
        context.put("tableNameClass", tableNameClass);
        context.put("tableRemarks", table.getTableRemarks());
        context.put("columnList", table.getColumnList());
        context.put("layer", layer);

        String outputFilePath = generateOutputFilePath(tableNameClass, outputDir, layer.getLayerNamePo(), layer.getFileSuffixPo());
        write2FileBySchema("/po/MysqlPo.vm", context, outputFilePath);
    }
}

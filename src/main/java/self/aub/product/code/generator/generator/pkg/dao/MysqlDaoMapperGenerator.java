package self.aub.product.code.generator.generator.pkg.dao;

import org.apache.velocity.VelocityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import self.aub.product.code.generator.bean.Layer;
import self.aub.product.code.generator.bean.Table;
import self.aub.product.code.generator.config.GeneratorConfig;
import self.aub.product.code.generator.generator.Generator;
import self.aub.product.code.generator.util.Constant;

/**
 * @author aub
 */
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

        Layer layer = GeneratorConfig.getLayer();
        context.put("layer", layer);

        String outputFilePath = outputDir + Constant.SIGN_SLASH + tableNameClass + ".xml";
        write2FileBySchema("/dao/MysqlMapperXml.vm", context, outputFilePath);
    }
}

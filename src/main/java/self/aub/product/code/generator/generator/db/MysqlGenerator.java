package self.aub.product.code.generator.generator.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import self.aub.product.code.generator.bean.MybatisMapper;
import self.aub.product.code.generator.bean.Table;
import self.aub.product.code.generator.config.GeneratorConfig;
import self.aub.product.code.generator.generator.pkg.act.MysqlActGenerator;
import self.aub.product.code.generator.generator.pkg.biz.MysqlBizGenerator;
import self.aub.product.code.generator.generator.pkg.dao.MysqlDaoGenerator;
import self.aub.product.code.generator.generator.pkg.dao.MysqlDaoMapperGenerator;
import self.aub.product.code.generator.generator.pkg.po.MysqlPoGenerator;
import self.aub.product.code.generator.generator.resource.MybatisConfigGenerator;
import self.aub.product.code.generator.util.Constant;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author aub
 */
public class MysqlGenerator implements DbGenerator {
    private static final Logger LOG = LoggerFactory.getLogger(MysqlGenerator.class);

    @Override
    public void generate(Table table) {
        String tableNameDb = table.getTableNameDb();
        LOG.info("generate code file for table : {} ", tableNameDb);

        // 获取基本包路径
        String basePackage = GeneratorConfig.getBasePackage();
        // 获取模块包路径
        String modleName = table.getModleName();
        String modlePackage = "";
        String modleMapperPath = "";
        if (modleName.length() > 0) {
            modlePackage = Constant.SIGN_DOT.concat(modleName);
            modleMapperPath = modleName.concat(Constant.SIGN_SLASH);
        }
        // 系统包路径
        String systemPackage = basePackage + modlePackage;

        // 创建输出路径
        String systemPackageDir = systemPackage.replace(Constant.SIGN_DOT, Constant.SIGN_SLASH);

        String javaOutputDir = GeneratorConfig.getOutputDir() + Constant.SOURCE_JAVA + systemPackageDir + Constant.SIGN_SLASH;
        new File(javaOutputDir).mkdirs();
        LOG.debug("generate ouput java dir : {}", javaOutputDir);

        String mapperOutputDir = GeneratorConfig.getOutputDir() + Constant.SOURCE_RESOURCE_MAPPER + modleMapperPath;
        new File(mapperOutputDir).mkdirs();
        LOG.debug("generate ouput mapper dir : {}", mapperOutputDir);

        // 生成act
        if (GeneratorConfig.isGenerateAct()) {
            MysqlActGenerator.generate(table, basePackage, systemPackage, javaOutputDir);
        }
        // 生成biz
        if (GeneratorConfig.isGenerateBiz()) {
            MysqlBizGenerator.generate(table, basePackage, systemPackage, javaOutputDir);
        }
        // 生成dao
        if (GeneratorConfig.isGenerateDao()) {
            MysqlDaoGenerator.generate(table, basePackage, systemPackage, javaOutputDir);
            MysqlDaoMapperGenerator.generate(table, systemPackage, mapperOutputDir);
        }
        // 生成po
        if (GeneratorConfig.isGeneratePo()) {
            MysqlPoGenerator.generate(table, systemPackage, javaOutputDir);
        }
    }

    @Override
    public void generateRes(List<Table> tableList) {
        if (GeneratorConfig.isGenerateResource()) {
            List<MybatisMapper> mybatisMapperList = new ArrayList<>();
            for (Table table : tableList) {
                mybatisMapperList.add(new MybatisMapper(table.getTableNameClass(), table.getModleName()));
            }
            // 获取基本包路径
            String basePackage = GeneratorConfig.getBasePackage();
            String mapperOutputDir = GeneratorConfig.getOutputDir().concat(Constant.SOURCE_RESOURCE);
            MybatisConfigGenerator.generate(mybatisMapperList, basePackage, mapperOutputDir);
        }

    }
}

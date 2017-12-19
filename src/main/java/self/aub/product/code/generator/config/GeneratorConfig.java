package self.aub.product.code.generator.config;

import self.aub.product.code.generator.bean.Layer;
import self.aub.product.code.generator.util.Constant;
import self.aub.product.code.generator.util.Constant.DbType;

import java.util.HashMap;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * @author aub
 */
public class GeneratorConfig {
    private static final HashMap<String, String> CONFIGS = new HashMap<>();
    private static final String CONFIG_FILE_PATH = "config";

    private static final String DB_URL = "db.url";
    private static final String DB_USERNAME = "db.username";
    private static final String DB_PASSWORD = "db.password";
    private static final String DB_TYPE = "db.type";
    private static final String DB_DRIVER = "db.driver";

    private static final String TABLE_PREFIX = "table.prefix";
    private static final String PROJECT_NAME = "project.name";
    private static final String BASE_PACKAGE = "base.package";
    private static final String SEPARATE_MODLE = "separate.modle";

    private static final String SCHEMA = "schema";

    private static final String GEN_ACT = "gen.act";
    private static final String GEN_BIZ = "gen.biz";
    private static final String GEN_DAO = "gen.dao";
    private static final String GEN_PO = "gen.po";
    private static final String GEN_TOOL = "gen.tool";
    private static final String GEN_RESOURCE = "gen.resource";

    private static final String CLASS_SUFFIX_ACT = "class.suffix.act";
    private static final String CLASS_SUFFIX_BIZ = "class.suffix.biz";
    private static final String CLASS_SUFFIX_DAO = "class.suffix.dao";
    private static final String CLASS_SUFFIX_PO = "class.suffix.po";


    private static final String OUTPUT_DIR = "output.dir";


    private static Layer layer;

    public static void init() {
        ResourceBundle resourceBundle = PropertyResourceBundle.getBundle(CONFIG_FILE_PATH);
        for (String key : resourceBundle.keySet()) {
            String value = resourceBundle.getString(key);
            CONFIGS.put(key, value);
        }
        layer = new Layer(CONFIGS.get(CLASS_SUFFIX_ACT), CONFIGS.get(CLASS_SUFFIX_BIZ), CONFIGS.get(CLASS_SUFFIX_DAO), CONFIGS.get(CLASS_SUFFIX_PO));
    }

    public static DbType getDbType() {
        String dbTypeStr = CONFIGS.get(DB_TYPE);
        return DbType.valueOf(dbTypeStr);
    }

    public static String getDbDriver() {
        return CONFIGS.get(DB_DRIVER);
    }

    public static String getDbUrl() {
        return CONFIGS.get(DB_URL);
    }

    public static String getDbUserName() {
        return CONFIGS.get(DB_USERNAME);
    }

    public static String getDbPassword() {
        return CONFIGS.get(DB_PASSWORD);
    }

    public static String getTablePrefix() {
        return CONFIGS.get(TABLE_PREFIX);
    }

    public static String getProjectName() {
        return CONFIGS.get(PROJECT_NAME);
    }

    public static String getBasePackage() {
        return CONFIGS.get(BASE_PACKAGE);
    }

    public static boolean getSeparateModle() {
        return CONFIGS.get(SEPARATE_MODLE).endsWith(Constant.YES);
    }

    public static String getOutputDir() {
        return CONFIGS.get(OUTPUT_DIR);
    }

    public static String getSchema() {
        return CONFIGS.get(SCHEMA);
    }

    public static boolean isGenerateAct() {
        return CONFIGS.get(GEN_ACT).endsWith(Constant.YES);
    }

    public static boolean isGenerateBiz() {
        return CONFIGS.get(GEN_BIZ).endsWith(Constant.YES);
    }

    public static boolean isGenerateDao() {
        return CONFIGS.get(GEN_DAO).endsWith(Constant.YES);
    }

    public static boolean isGeneratePo() {
        return CONFIGS.get(GEN_PO).endsWith(Constant.YES);
    }

    public static boolean isGenerateTool() {
        return CONFIGS.get(GEN_TOOL).endsWith(Constant.YES);
    }

    public static boolean isGenerateResource() {
        return CONFIGS.get(GEN_RESOURCE).endsWith(Constant.YES);
    }

    public static String getClassSuffixAct() {
        return CONFIGS.get(CLASS_SUFFIX_ACT);
    }

    public static String getClassSuffixBiz() {
        return CONFIGS.get(CLASS_SUFFIX_BIZ);
    }

    public static String getClassSuffixDao() {
        return CONFIGS.get(CLASS_SUFFIX_DAO);
    }

    public static String getClassSuffixPo() {
        return CONFIGS.get(CLASS_SUFFIX_PO);
    }

    public static Layer getLayer() {
        return layer;
    }


    public static void set(String key, String value) {
        CONFIGS.put(key, value);
    }
}

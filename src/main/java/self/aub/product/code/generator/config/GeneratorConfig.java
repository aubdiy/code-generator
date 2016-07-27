package self.aub.product.code.generator.config;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import self.aub.product.code.generator.util.Constant;
import self.aub.product.code.generator.util.Constant.DbType;

public class GeneratorConfig {
	private static final HashMap<String, String> configs = new HashMap<String, String>();
	private static final String CONFIG_FILE_PATH = "config";

	private static final String DB_URL = "db.url";
	private static final String DB_USERNAME = "db.username";
	private static final String DB_PASSWORD = "db.password";
	private static final String DB_TYPE = "db.type";
	private static final String DB_DRIVER = "db.driver";

	private static final String TABLE_PREFIX = "table.prefix";
	private static final String BASE_PACKAGE = "base.package";

	private static final String SCHEMA = "schema";
	
	private static final String GEN_ACT = "gen.act";
	private static final String GEN_BIZ = "gen.biz";
	private static final String GEN_DAO = "gen.dao";
	private static final String GEN_PO = "gen.po";
	private static final String GEN_TOOL = "gen.tool";
	private static final String GEN_RESOURCE = "gen.resource";

	private static final String OUTPUT_DIR = "output.dir";

	public static void init() {
		ResourceBundle resourceBundle = PropertyResourceBundle.getBundle(CONFIG_FILE_PATH);
		for (String key : resourceBundle.keySet()) {
			String value = resourceBundle.getString(key);
			configs.put(key, value);
		}
	}

	public static DbType getDbType() {
		String dbTypeStr = configs.get(DB_TYPE);
		return DbType.valueOf(dbTypeStr);
	}

	public static String getDbDriver() {
		return configs.get(DB_DRIVER);
	}

	public static String getDbUrl() {
		return configs.get(DB_URL);
	}

	public static String getDbUserName() {
		return configs.get(DB_USERNAME);
	}

	public static String getDbPassword() {
		return configs.get(DB_PASSWORD);
	}

	public static String getTablePrefix() {
		return configs.get(TABLE_PREFIX);
	}

	public static String getBasePackage() {
		return configs.get(BASE_PACKAGE);
	}

	public static String getOutputDir() {
		return configs.get(OUTPUT_DIR);
	}

	public static String getSchema() {
		return configs.get(SCHEMA);
	}
	public static boolean isGenerateAct() {
		return configs.get(GEN_ACT).endsWith(Constant.YES);
	}

	public static boolean isGenerateBiz() {
		return configs.get(GEN_BIZ).endsWith(Constant.YES);
	}

	public static boolean isGenerateDao() {
		return configs.get(GEN_DAO).endsWith(Constant.YES);
	}

	public static boolean isGeneratePo() {
		return configs.get(GEN_PO).endsWith(Constant.YES);
	}

	public static boolean isGenerateTool() {
		return configs.get(GEN_TOOL).endsWith(Constant.YES);
	}

	public static boolean isGenerateResource() {
		return configs.get(GEN_RESOURCE).endsWith(Constant.YES);
	}



	public static void set(String key, String value) {
		configs.put(key, value);
	}

	public static void main(String[] args) {
		init();
		for (Entry<String, String> entry : configs.entrySet()) {
			System.out.print("[" + entry.getKey() + "]	=	");
			System.out.println("[" + entry.getValue() + "]");
		}
	}
}

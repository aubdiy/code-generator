package self.aub.product.code.generator.generator.db;

import self.aub.product.code.generator.config.GeneratorConfig;

public class DbGeneratorFactory {

	public static DbGenerator createDbGenerator() {
		DbGenerator dbGenerator;
		switch (GeneratorConfig.getDbType()) {
		case MYSQL:
			// MYSQL 生成
			dbGenerator = new MysqlGenerator();
			break;
		case ORACLE:
			// ORACLE 生成
			dbGenerator = null;
			break;
		default:
			dbGenerator = null;
			break;
		}
		return dbGenerator;
	}

}

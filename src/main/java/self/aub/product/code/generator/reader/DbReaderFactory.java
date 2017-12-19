package self.aub.product.code.generator.reader;

import self.aub.product.code.generator.config.GeneratorConfig;

/**
 * @author aub
 */
public class DbReaderFactory {

    public static DbReader createDbReader() {
        DbReader dbReader;
        switch (GeneratorConfig.getDbType()) {
            case MYSQL:
                // MYSQL
                dbReader = new MysqlDbReader();
                break;
            default:
                dbReader = null;
                break;
        }
        return dbReader;
    }
}

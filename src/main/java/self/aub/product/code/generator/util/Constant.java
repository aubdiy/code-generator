package self.aub.product.code.generator.util;

/**
 * @author aub
 */
public class Constant {

    public static final String NOT = "0";
    public static final String YES = "1";

    public static final String SIGN_DOT = ".";
    public static final String SIGN_SLASH = "/";
    public static final String SIGN_UNDERLINE = "_";
    public static final String JAVA_FILE_SUFFIX = ".java";

    public static final String SOURCE_JAVA = "src/main/java/";
    public static final String SOURCE_RESOURCE = "src/main/resources/";
    public static final String SOURCE_RESOURCE_MAPPER = "src/main/resources/mapper/";

    public static final String LAYER_COMMON = "common";


    public enum DbType {
        /**
         * mysql 数据库
         */
        MYSQL,
        /**
         * oracle 数据库
         */
        ORACLE
    }
}

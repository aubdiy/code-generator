package self.aub.product.code.generator.util;

import java.sql.Types;

/**
 * @author aub
 */
public class ConvertUtil {

    /**
     * <B>将数据库命名转换为骆驼命名</B><br>
     * 例如，“sys_user” 转换为 “SysUser”
     *
     * @param nameInDb
     * @return
     */
    public static String convert2CamelCase(String nameInDb) {
        StringBuilder amelCaseName = new StringBuilder();
        String[] camelCaseNamePartArr = nameInDb.split(Constant.SIGN_UNDERLINE);
        for (String enumNamePart : camelCaseNamePartArr) {
            if (enumNamePart.length() == 0) {
                continue;
            }
            char firstChar = enumNamePart.charAt(0);
            firstChar = toUpperCase(firstChar);
            amelCaseName.append(firstChar);
            if (enumNamePart.length() > 1) {
                amelCaseName.append(enumNamePart.substring(1));
            }
        }
        return amelCaseName.toString();
    }

    /**
     * <B>将骆驼命名转换为变量名</B><br>
     * 例如, “SysUser” 装换为 “sysUser”
     *
     * @param camelCaseName
     * @return
     */
    public static String conver2VariableName(String camelCaseName) {
        char firstChar = camelCaseName.charAt(0);
        firstChar = toLowerCase(firstChar);
        StringBuilder result = new StringBuilder();
        result.append(firstChar);
        if (camelCaseName.length() > 1) {
            result.append(camelCaseName.substring(1));
        }
        return result.toString();
    }

    /**
     * <B>将数据库命名转换为url路径</B><br>
     * 例如, “sys_user” 装换为 “sys/user”
     *
     * @param nameInDb 数据库命名
     * @return
     */
    public static String conver2RequestMapping(String nameInDb) {
        StringBuilder requestMapping = new StringBuilder();
        String[] requestMappingArr = nameInDb.split(Constant.SIGN_UNDERLINE);
        for (String requestMappingPart : requestMappingArr) {
            if (requestMappingPart.length() == 0) {
                continue;
            }
            requestMapping.append(requestMappingPart);
            requestMapping.append(Constant.SIGN_SLASH);
        }
        return requestMapping.toString();
    }

    /**
     * <B>将数据库类型转换为java类型</B><br>
     *
     * @param dbDateType 数据库数据类型
     * @return java 数据类型
     */
    public static String conver2JavaType(int dbDateType) {
        String javaType;
        switch (dbDateType) {
            case Types.TINYINT:
                javaType = "short";
                break;
            case Types.SMALLINT:
                javaType = "short";
                break;
            case Types.INTEGER:
                javaType = "int";
                break;
            case Types.BIGINT:
                javaType = "long";
                break;
            case Types.FLOAT:
                javaType = "float";
                break;
            case Types.DOUBLE:
                javaType = "double";
                break;
            case Types.CHAR:
                javaType = "String";
                break;
            case Types.VARCHAR:
                javaType = "String";
                break;
            case Types.TIME:
                javaType = "Date";
                break;
            case Types.DATE:
                javaType = "Date";
                break;
            case Types.TIMESTAMP:
                javaType = "Date";
                break;
            case Types.BOOLEAN:
                javaType = "boolean";
                break;
            default:
                javaType = "String";
                break;
        }
        return javaType;
    }

    private static char toUpperCase(char c) {
        if (c >= 'a' && c <= 'z') {
            c = (char) (c - 32);
        }
        return c;
    }

    private static char toLowerCase(char c) {
        if (c >= 'A' && c <= 'Z') {
            c = (char) (c + 32);
        }
        return c;
    }
}

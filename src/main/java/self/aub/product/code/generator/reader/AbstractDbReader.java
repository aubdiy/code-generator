package self.aub.product.code.generator.reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import self.aub.product.code.generator.bean.Table;
import self.aub.product.code.generator.config.GeneratorConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author aub
 */
public abstract class AbstractDbReader implements DbReader {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractDbReader.class);

    /**
     * <B>获取TableBean</B><br>
     *
     * @return list
     * @author aub
     */
    @Override
    public List<Table> getTableBeans() {
        List<Table> tables = new ArrayList<>();
        Map<String, String> tableInfos = getTableInfo();
        for (Map.Entry<String, String> entry : tableInfos.entrySet()) {
            String tableName = entry.getKey();
            String tableRemarks = entry.getValue();
            Table table = new Table(tableName, tableRemarks, getPrimaryKeyName(tableName), getColumns(tableName));
            tables.add(table);
        }
        return tables;
    }

    Connection getConn() {
        try {
            Class.forName(GeneratorConfig.getDbDriver());
        } catch (ClassNotFoundException e) {
            LOG.error("find driver fail :　", e);
        }
        String url = GeneratorConfig.getDbUrl();
        Properties props = new Properties();
        props.put("user", GeneratorConfig.getDbUserName());
        props.put("password", GeneratorConfig.getDbPassword());
        //可以读取表描述
        props.put("useInformationSchema", "true");
//        props.put("nullNamePatternMatchesAll", "true");


        try {
            return DriverManager.getConnection(url, props);
        } catch (SQLException e) {
            LOG.error("get connection fail : ", e);
        }
        return null;
    }

    void closeConn(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                LOG.error("close connect fail : ", e);
            }
        }
    }

    void closeRS(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                LOG.error("close result set fail : ", e);
            }
        }
    }
}

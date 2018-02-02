package self.aub.product.code.generator.config;

import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import java.util.Properties;

/**
 * @author aub
 */
public class VelocityConfig {

    private VelocityConfig() {
    }

    public static void init() {
        Velocity.init(generateProperties());
    }

    private static Properties generateProperties() {
        Properties properties = new Properties();
        properties.setProperty(VelocityEngine.INPUT_ENCODING, "UTF-8");
        properties.setProperty(VelocityEngine.OUTPUT_ENCODING, "UTF-8");
        String path = VelocityConfig.class.getResource("/").getPath();
        if (System.getProperty("os.name").toLowerCase().startsWith("windows")) {
            path = path.substring(1);
        }
        properties.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, path.concat("template"));
        return properties;
    }
}

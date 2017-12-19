package self.aub.product.code.generator.generator.resource;

import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import self.aub.product.code.generator.config.GeneratorConfig;
import self.aub.product.code.generator.generator.Generator;
import self.aub.product.code.generator.util.Constant;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author aub
 */
public class LogConfigGenerator extends Generator {
    private static final Logger LOG = LoggerFactory.getLogger(LogConfigGenerator.class);

    public static void generateRes() throws IOException {
        if (GeneratorConfig.isGenerateResource()) {
            LOG.debug("generate log config");

            String resourcePath = Velocity.getProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH) + Constant.SIGN_SLASH + GeneratorConfig.getSchema() + "/resource";
            File file = new File(resourcePath);
            File[] logConfigFiles = file.listFiles((dir, name) -> name.startsWith("log"));
            if (logConfigFiles == null) {
                return;
            }
            for (File logConfigFile : logConfigFiles) {
                Files.copy(Paths.get(logConfigFile.getPath()), Paths.get(GeneratorConfig.getOutputDir() + Constant.SOURCE_RESOURCE + logConfigFile.getName()));
            }

        }
    }
}

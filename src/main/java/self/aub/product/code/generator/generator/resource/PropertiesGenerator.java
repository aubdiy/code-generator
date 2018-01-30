package self.aub.product.code.generator.generator.resource;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import self.aub.product.code.generator.config.GeneratorConfig;
import self.aub.product.code.generator.generator.Generator;
import self.aub.product.code.generator.util.Constant;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author aub
 */
public class PropertiesGenerator extends Generator {
    private static final Logger LOG = LoggerFactory.getLogger(PropertiesGenerator.class);

    public static void generateRes() throws IOException {
        if (GeneratorConfig.isGenerateResource()) {
            LOG.debug("generate properties ...");
            String outputDir = GeneratorConfig.getOutputDir().concat(Constant.SOURCE_RESOURCE);

            String resourcePath = Velocity.getProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH) + Constant.SIGN_SLASH + GeneratorConfig.getSchema() + "/resource";
            Files.copy(Paths.get(resourcePath + "/application.properties"), Paths.get(outputDir + "application.properties"));

            VelocityContext context = new VelocityContext();
            context.put("dbUrl", GeneratorConfig.getDbUrl());
            context.put("dbUserName", GeneratorConfig.getDbUserName());
            context.put("dbPassword", GeneratorConfig.getDbPassword());
            context.put("basePackage", GeneratorConfig.getBasePackage());
            write2FileBySchema("/resource/application-dev.vm", context, outputDir + "application-dev.properties");
        }
    }
}

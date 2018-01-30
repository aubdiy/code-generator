package self.aub.product.code.generator.generator.pkg.scaffolding;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import self.aub.product.code.generator.config.GeneratorConfig;
import self.aub.product.code.generator.generator.Generator;
import self.aub.product.code.generator.util.Constant;

import java.io.File;

/**
 * @author aub
 */
public class ScaffoldingGenerator extends Generator {
    private static final Logger LOG = LoggerFactory.getLogger(ScaffoldingGenerator.class);

    public static void generateToolClass() {
        if (GeneratorConfig.isGenerateTool()) {
            LOG.debug("generate scaffolding ...");
            String basePackage = GeneratorConfig.getBasePackage();

            VelocityContext context = new VelocityContext();
            context.put("basePackage", basePackage);
            String outputDir = GeneratorConfig.getOutputDir() + Constant.SOURCE_JAVA + basePackage.replace(Constant.SIGN_DOT, Constant.SIGN_SLASH) + Constant.SIGN_SLASH;
            String scaffoldingPath = Velocity.getProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH) + Constant.SIGN_SLASH + GeneratorConfig.getSchema() + "/scaffolding";

            File file = new File(scaffoldingPath);
            for (File temp : file.listFiles()) {
                String tempName = temp.getName();
                String className = tempName.substring(0, tempName.length() - 3);
                LOG.debug("generate scaffolding : {}.java", className);
                String outputFilePath = generateOutputFilePath(className, outputDir, Constant.LAYER_COMMON, Constant.JAVA_FILE_SUFFIX);
                write2FileBySchema("/scaffolding/" + tempName, context, outputFilePath);
            }
        }
    }
}
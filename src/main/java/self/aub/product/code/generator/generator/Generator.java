package self.aub.product.code.generator.generator;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import self.aub.product.code.generator.config.GeneratorConfig;
import self.aub.product.code.generator.util.Constant;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author aub
 */
public class Generator {
    private static final Logger LOG = LoggerFactory.getLogger(Generator.class);

    protected Generator() {
    }

    protected static String generateOutputFilePath(String className, String outputDir, String layer, String layerClassSuffix) {
        StringBuilder outputFilePath = new StringBuilder(outputDir);
        outputFilePath.append(layer);
        new File(outputFilePath.toString()).mkdir();
        outputFilePath.append(Constant.SIGN_SLASH);
        outputFilePath.append(className);
        outputFilePath.append(layerClassSuffix);
        return outputFilePath.toString();
    }

    protected static void write2FileBySchema(String templateFile, VelocityContext context, String outputFilePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFilePath))) {
            Template template = Velocity.getTemplate(GeneratorConfig.getSchema().concat(templateFile));
            template.merge(context, bufferedWriter);
        } catch (IOException e) {
            LOG.error("write file exception: ", e);
        }
    }

}

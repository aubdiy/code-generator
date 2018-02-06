package self.aub.product.code.generator.generator.pom;

import org.apache.velocity.VelocityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import self.aub.product.code.generator.config.GeneratorConfig;
import self.aub.product.code.generator.generator.Generator;

public class PomGenerator extends Generator {
    private static final Logger LOG = LoggerFactory.getLogger(PomGenerator.class);

    public static void generate() {
        LOG.debug("generate pom ...");
        VelocityContext context = new VelocityContext();
        context.put("projectName", GeneratorConfig.getProjectName());
        context.put("basePackage", GeneratorConfig.getBasePackage());
        context.put("layer", GeneratorConfig.getLayer());
        write2FileBySchema("/pom.vm", context, GeneratorConfig.getOutputDir().concat("pom.xml"));
    }
}

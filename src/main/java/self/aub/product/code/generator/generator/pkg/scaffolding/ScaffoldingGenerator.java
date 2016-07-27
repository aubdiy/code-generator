package self.aub.product.code.generator.generator.pkg.scaffolding;

import self.aub.product.code.generator.config.GeneratorConfig;
import self.aub.product.code.generator.generator.Generator;
import self.aub.product.code.generator.util.Constant;
import self.aub.product.code.generator.util.Constant.Layer;
import self.aub.product.code.generator.util.Constant.LayerClassSuffix;
import org.apache.velocity.VelocityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScaffoldingGenerator extends Generator {
	private static final Logger LOG = LoggerFactory.getLogger(ScaffoldingGenerator.class);

	public static void generateToolClass() {
		if (GeneratorConfig.isGenerateTool()) {
			String basePackage = GeneratorConfig.getBasePackage();
			StringBuilder javaOutputDirSb = new StringBuilder(GeneratorConfig.getOutputDir());
			javaOutputDirSb.append(Constant.SOURCE_JAVA);
			javaOutputDirSb.append(basePackage.replace(Constant.SIGN_DOT, Constant.SIGN_SLASH));
			javaOutputDirSb.append(Constant.SIGN_SLASH);
			
			String outputDir = javaOutputDirSb.toString();

			LOG.debug("generate scaffolding : Page.java");

			VelocityContext context = new VelocityContext();
			context.put("basePackage", basePackage);

			String outputFilePath = generateOutputFilePath("Page", outputDir, Layer.SCAFFOLDING, LayerClassSuffix.JAVA);
			write2File("scaffolding/PageTemp.vm", context, outputFilePath);

			outputFilePath = generateOutputFilePath("PageUtil", outputDir, Layer.SCAFFOLDING, LayerClassSuffix.JAVA);
			write2File("scaffolding/PageUtilToolClassTemp.vm", context, outputFilePath);

			outputFilePath = generateOutputFilePath("BaseDao", outputDir, Layer.SCAFFOLDING, LayerClassSuffix.JAVA);
			write2File("scaffolding/BaseDaoTemp.vm", context, outputFilePath);

			outputFilePath = generateOutputFilePath("Constant", outputDir, Layer.SCAFFOLDING, LayerClassSuffix.JAVA);
			write2File("scaffolding/ConstantTemp.vm", context, outputFilePath);

			outputFilePath = generateOutputFilePath("RestfulController", outputDir, Layer.SCAFFOLDING, LayerClassSuffix.JAVA);
			write2File("scaffolding/RestfulControllerTemp.vm", context, outputFilePath);

			outputFilePath = generateOutputFilePath("RestfulParam", outputDir, Layer.SCAFFOLDING, LayerClassSuffix.JAVA);
			write2File("scaffolding/RestfulParamTemp.vm", context, outputFilePath);

			outputFilePath = generateOutputFilePath("RestfulResultStatus", outputDir, Layer.SCAFFOLDING, LayerClassSuffix.JAVA);
			write2File("scaffolding/RestfulResultStatusTemp.vm", context, outputFilePath);

			outputFilePath = generateOutputFilePath("RestfulResult", outputDir, Layer.SCAFFOLDING, LayerClassSuffix.JAVA);
			write2File("scaffolding/RestfulResultTemp.vm", context, outputFilePath);

			outputFilePath = generateOutputFilePath("SpringContext", outputDir, Layer.SCAFFOLDING, LayerClassSuffix.JAVA);
			write2File("scaffolding/SpringContextTemp.vm", context, outputFilePath);

		}
	}
}
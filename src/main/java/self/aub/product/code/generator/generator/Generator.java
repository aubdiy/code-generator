package self.aub.product.code.generator.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import self.aub.product.code.generator.config.GeneratorConfig;
import self.aub.product.code.generator.util.Constant;
import self.aub.product.code.generator.util.Constant.Layer;
import self.aub.product.code.generator.util.Constant.LayerClassSuffix;

public class Generator {
	private static final Logger LOG = LoggerFactory.getLogger(Generator.class);

	protected static String generateOutputFilePath(String className, String outputDir, Layer layer, LayerClassSuffix layerClassSuffix) {
		StringBuilder outputFilePath = new StringBuilder(outputDir);
		outputFilePath.append(layer);
		new File(outputFilePath.toString()).mkdir();
		outputFilePath.append(Constant.SIGN_SLASH);
		outputFilePath.append(className);
		outputFilePath.append(layerClassSuffix);
		return outputFilePath.toString();
	}

	protected static void write2File(String templateFile, VelocityContext context, String outputFilepath) {
		Template template = getTemplate(templateFile);
		Writer writer = getWriter(outputFilepath);
		template.merge(context, writer);
		try {
			writer.close();
		} catch (IOException e) {
			LOG.error("write data fail, exception : ", e);
		}
	}

	protected static void write2FileBySchema(String templateFile, VelocityContext context, String outputFilepath) {
		Template template = getTemplate(GeneratorConfig.getSchema().concat(templateFile));
		Writer writer = getWriter(outputFilepath);
		template.merge(context, writer);
		try {
			writer.close();
		} catch (IOException e) {
			LOG.error("write data fail, exception : ", e);
		}
	}

	private static Writer getWriter(String filePath) {
		try {
			return new BufferedWriter(new FileWriter(filePath));
		} catch (IOException e) {
			LOG.error("generate file fail : {}", e);
			throw new RuntimeException();
		}
	}

	private static Template getTemplate(String templateFile) {
		Template template = null;
		try {
			template = Velocity.getTemplate(templateFile);
		} catch (ResourceNotFoundException rnfe) {
			rnfe.printStackTrace();
			LOG.error("can not find template " + templateFile);
		} catch (ParseErrorException pee) {
			LOG.error("syntax error in template " + templateFile + ":" + pee);
		}
		return template;
	}

}

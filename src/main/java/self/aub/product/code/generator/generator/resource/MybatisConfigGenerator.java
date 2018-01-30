package self.aub.product.code.generator.generator.resource;

import org.apache.velocity.VelocityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import self.aub.product.code.generator.bean.Layer;
import self.aub.product.code.generator.bean.MybatisMapper;
import self.aub.product.code.generator.config.GeneratorConfig;
import self.aub.product.code.generator.generator.Generator;

import java.util.List;

public class MybatisConfigGenerator extends Generator {
	private static final Logger LOG = LoggerFactory.getLogger(MybatisConfigGenerator.class);

	public static void generate(List<MybatisMapper> mybatisMapperList, String basePackage, String outputDir) {
		LOG.debug("generate mybatis config");
		VelocityContext context = new VelocityContext();
		context.put("basePackage", basePackage);
		context.put("mybatisMapperList", mybatisMapperList);
		Layer layer = GeneratorConfig.getLayer();
		context.put( "layer", layer );
		write2FileBySchema("/resource/MysqlMybatisConfig.vm", context, outputDir.concat("mybatis.xml"));
	}
}

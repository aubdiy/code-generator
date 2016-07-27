package self.aub.product.code.generator.generator.resource;

import self.aub.product.code.generator.bean.MybatisMapper;
import self.aub.product.code.generator.generator.Generator;
import org.apache.velocity.VelocityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MybatisConfigGenerator extends Generator {
	private static final Logger LOG = LoggerFactory.getLogger(MybatisConfigGenerator.class);

	public static void generate(List<MybatisMapper> mybatisMapperList, String basePackage, String outputDir) {
		LOG.debug("generate mybatis config");
		VelocityContext context = new VelocityContext();
		context.put("basePackage", basePackage);
		context.put("mybatisMapperList", mybatisMapperList);
		write2FileBySchema("/resource/MysqlMybatisConfigTemp.vm", context, outputDir.concat("mybatis.xml"));
	}
}

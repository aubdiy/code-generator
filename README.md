# 代码生成器
对于码农，想到那无止境的增删改查、粘贴复制，胃里顿时翻江倒海，血雨腥风。。。

现在，告别这样苦X的机会来了，咱们一起从零开始写代码生成器。

此工具，以实例介绍思路，只是抛砖引玉，请根据自身架构，自行扩展。

## 所用技术
1. JDK1.6+
2. JDBC工具包（mysql-connector-java）
3. velocity模板工具

## 实现方案
其实非常简单，读取模型（库、表）的元数据信息，生成相应的代码。

此工具使用mysql作为元数据来源，利用JDBC工具读取元数据信息，然后使用velocity模板工具生产工程代码。

## 2分钟快速入门
示例程序，将生成一个基于spring、spring-mvc、mybatis，包含基本CURD操作代码的工程maven工程。

* 第一步：导入此工具工程到IDE(Intellij IDEA 或者Eclipse)
* 第二步：修改配置文件“src/main/resources/config.properties”

	| 属性名           | 描述  | 
	|:--------------- |:----------------- | 
	| db.url          | 数据库连接URL       |
	| db.driver       | 数据库驱动          |
	| db.username     | 数据库用户名        |
	| db.password     | 数据库密码          |
	| db.type         | 目前仅支持MYSQL（可自行扩展)  |
	| table.prefix    | 需要生成代码的表前缀  |
	| base.package    | 基础包名            |
	| schema          | 模板包（可自行扩展），对应 resources/template下的模板目录  |
	| gen.act         | 是否生成 action（controler）层，0:false，1:true |
	| gen.biz         | 是否生成 business（service）层，0:false，1:true |
	| gen.dao         | 是否生成 dao层 ，0:false，1:true |
	| gen.po          | 是否生成 po（entry）层  0:false，1:true |
	| gen.tool        | 是否生成 工具类（scaffolding），0:false，1:true |
	| gen.resource    | 是否生成 资源文件 ，0:false，1:true |
	| output.dir      | 代码输出目录 |


* 第三步：执行“self.aub.product.code.generator.Launcher”，开始生成代码
* 第四步：到“output.dir”指定的目录，将代码导入到你的项目工程

## 如何扩展
1. 自定义模板，请根据自己的工程框架，添加自己的工程模板，模板中的变量请参考template/2_common模板包中的模板变量，变量含义请参考“self/aub/product/code/generator/bean”包中的bean类

2. 如果想增加对其他数据库的支持， 分两步
	- 请扩展 “self.aub.product.code.generator.reader.AbstractDbReader”类，请参考“MysqlDbReader”，并在“DbReaderFactory”类中增加对其的支持
	- 请实现“ self.aub.product.code.generator.generator.db. DbGenerator”接口，可参考MysqlGenerator类，并在“DbGeneratorFactory”类中增加对其的支持

3. 如果想增加对其他数据源（非数据库）的支持，根据整个生成器架构，自行实现 reader和generator(好像是废话，别打我! ^_^) 

			
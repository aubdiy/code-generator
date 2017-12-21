# 代码生成器
对于码农，想到那无止境的增删改查、粘贴复制，胃里顿时翻江倒海，血雨腥风。。。

现在，告别这样苦X的机会来了，咱们一起从零开始写代码生成器。

此工具，以实例介绍思路，只是抛砖引玉，请根据自身架构，自行扩展。

## 所用技术
1. JDK1.8
2. JDBC工具包（mysql-connector-java）
3. velocity模板工具

## 实现方案
其实非常简单，读取模型（库、表）的元数据信息，生成相应的代码。

此工具使用mysql作为元数据来源，利用JDBC工具读取元数据信息，然后使用 `velocity` 模板工具生产工程代码。

## 2分钟快速入门
示例程序，将生成一个基于 spring-boot、mybatis，包含基本 `CURD` 操作代码的工程 `maven` 工程。

* 第一步：导入此工具工程到 IDE(Intellij IDEA 或者Eclipse)
* 第二步：修改配置文件 `src/main/resources/config.properties`

	| 属性名           | 描述  | 
	|:--------------- |:----------------- | 
	| db.url          | 数据库连接URL       |
	| db.driver       | 数据库驱动          |
	| db.username     | 数据库用户名        |
	| db.password     | 数据库密码          |
	| db.type         | 目前仅支持MYSQL（可自行扩展)  |
	| table.prefix    | 需要生成代码的表的前缀  |
	| separate.modle  | 是否分离模块，0:no,1:yes，例如：sys_user 表，包路径上会增加一层 `sys` |
	| project.name    | 要生成的工程名       |
	| base.package    | 基础包名            |
	| schema          | 模板包（可自行扩展），对应 resources/template下的模板目录  |
	| gen.act         | 是否生成 action（controler）层，0:false，1:true |
	| gen.biz         | 是否生成 business（service）层，0:false，1:true |
	| gen.dao         | 是否生成 dao层 ，0:false，1:true |
	| gen.po          | 是否生成 po（entry）层  0:false，1:true |
	| gen.tool        | 是否生成 工具类（scaffolding），0:false，1:true |
	| gen.resource    | 是否生成 资源文件 ，0:false，1:true |
	| class.suffix.act| 控制层后缀，例如：Ctl 将会生成 xx.xx.ctl.xxxCtl.java|
	| class.suffix.biz| 业务层后缀，例如：Service 将会生成 xx.xx.service.xxxService.java |
	| class.suffix.dao| 映射层后缀，例如：Mapper 将会生成 xx.xx.mapper.xxxMapper.java |
	| class.suffix.po | 实体层后缀，例如：Po 将会生成 xx.xx.po.xxxPo.java |
	| output.dir      | 代码输出目录 |


* 第三步：执行 `self.aub.product.code.generator.Launcher`，开始生成代码
* 第四步：到 `output.dir` 指定的目录，将代码导入到你的项目工程

## 生成结果

```
├── output                                 // 生成结果输入目录，对应：${output.dir}
├── src                                    
│   ├── main                               
│   │   ├── java                           
│   │   │   └── self.aub.product.cgt       // 基础包名，对应：${base.package}
│   │   │       ├── modle1                 // 模块名，${separate.modle} 设置为 1 时，有可能产生模块层
│   │   │       │   ├── common             // 工具类包，${gen.tool} 设置为 1 时，生成对应的工具类
│   │   │       │   ├── ctl                // 控制层包，对应：${class.suffix.act}
│   │   │       │   ├── service            // 业务层包，对应：${class.suffix.biz}
│   │   │       │   ├── mapper             // 映射层包，对应：${class.suffix.dao}
│   │   │       │   └── do                 // 实体层包，对应：${class.suffix.po}
│   │   │       └── modle2                 // 模块名
│   │   └── resources                      
│   │       ├── mapper                     // mybatis 映射文件包
│   │       ├── application.properties     // 基础资源文件
│   │       ├── application-dev.properties // 开发环境资源文件
│   │       ├── log4j2-dev.xml             // 开发环境 log4j2 配置
│   │       ├── log4j2-spring.xml          // 非开发环境 log4j2 配置
│   │       └── mybatis.xml                // mybatis 配置文件
│   └── test                               // 计划生成使用 mockito 的单元测试...还未开发
└── pom.xml                                // maven 打包文件

```

## 如何扩展
1. 自定义模板，请根据自己的工程框架，添加自己的工程模板，模板中的变量请参考 `template/4_spring_boot` 模板包中的模板变量，变量含义请参考 `self/aub/product/code/generator/bean` 包中的定义

2. 如果想增加对其他数据库的支持， 分两步
	- 请扩展 `self.aub.product.code.generator.reader.AbstractDbReader` 类，请参考 `MysqlDbReader`，并在 `DbReaderFactory` 中增加对其的支持
	- 请实现 `self.aub.product.code.generator.generator.db. DbGenerator` 接口，可参考 `MysqlGenerator` ，并在 `DbGeneratorFactory` 中增加对其的支持

3. 如果想增加对其他数据源（非数据库）的支持，根据整个生成器架构，自行实现 `reader` 和 `generator`(好像是废话，别打我! ^_^) 
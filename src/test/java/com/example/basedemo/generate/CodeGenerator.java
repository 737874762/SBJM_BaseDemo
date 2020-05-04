package com.example.basedemo.generate;



import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

import static com.baomidou.mybatisplus.generator.config.rules.DateType.ONLY_DATE;

/**
 * mybatis plus自动生成器基本版
 */
public class CodeGenerator {

    private static final String projDir  = System.getProperty("user.dir");//项目所在路径
    private static final String author  = "klchen";//作者
    private static final String dbUrl = "jdbc:mysql://localhost:3306/crm?useUnicode=true&characterEncoding=UTF-8&sessionVariables=time_zone='%2B8:00'";//数据库连接url
    private static final String dbDriver = "com.mysql.cj.jdbc.Driver";//数据库驱动
    private static final String dbUsername = "root";//数据库账号
    private static final String dbPassword = "root";//数据库密码
    private static final String basePackage = "com.example.basedemo";//项目包路径
    private static final String genPos = "/src/main";//根目录


    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();

        gc.setOutputDir(projDir + genPos + "/java/");//生成文件输出路径
        gc.setAuthor(author);//作者
        gc.setOpen(false);
        gc.setFileOverride(true);//多次生成文件覆盖
        gc.setDateType(ONLY_DATE);//日期类型
        gc.setEntityName("%sPo");//实体类后缀名
        gc.setMapperName("%sDao");//mapper层后缀名
        gc.setServiceName("%sService");//service接口后缀名
        gc.setServiceImplName("%sServiceImpl");//service实现类后缀名
        gc.setBaseColumnList(true);//生成的xml文件中添加查询的结果内容行
        gc.setBaseResultMap(true);//生成的xml文件中添加查询的结果集映射map
        gc.setSwagger2(true); //实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(dbUrl);
        dsc.setDriverName(dbDriver);
        dsc.setUsername(dbUsername);
        dsc.setPassword(dbPassword);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig() {
            @Override
            public String getParent() {
                return basePackage;
            }
        };
        pc.setModuleName("");
        pc.setParent(basePackage);
        pc.setMapper("dao");
        pc.setXml("dao.xml");
        pc.setEntity("entity.po");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };


        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
         //entity
        focList.add(new FileOutConfig("/templates/entity.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projDir + genPos + "/java/" + basePackage.replace(".", "/")
                        + "/entity/po/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + StringPool.DOT_JAVA;
            }
        });
        // mapper xml
        focList.add(new FileOutConfig("templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projDir + genPos + "/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getMapperName() + StringPool.DOT_XML;
            }
        });
        // dao
        focList.add(new FileOutConfig("/templates/mapper.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projDir + genPos + "/java/" + basePackage.replace(".", "/")
                        + "/dao/" + pc.getModuleName()
                        + "/" + tableInfo.getMapperName() + StringPool.DOT_JAVA;
            }
        });
        // service
        focList.add(new FileOutConfig("/templates/service.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projDir + genPos + "/java/" + basePackage.replace(".", "/")
                        + "/service/" + pc.getModuleName()
                        + "/" + tableInfo.getServiceName() + StringPool.DOT_JAVA;
            }
        });
        // serviceImpl
        focList.add(new FileOutConfig("/templates/serviceImpl.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projDir + genPos + "/java/" + basePackage.replace(".", "/")
                        + "/service/impl/" + pc.getModuleName()
                        + "/" + tableInfo.getServiceImplName() + StringPool.DOT_JAVA;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        templateConfig.setMapper(null);
        templateConfig.setService(null);
        templateConfig.setServiceImpl(null);
        templateConfig.setController(null);
        templateConfig.setEntity(null);
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
       //需要生成的表名,以，隔开
        strategy.setInclude("tn_user_info".split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}

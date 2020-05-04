

## 创建一个Spring Boot项目
开发工具使用idea
采用idea中的Spring Initializr创建项目（如果第一次使用下载依赖会比较慢）

- 选择 Spring Initializr方式构建
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200503203912383.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTcwMTAy,size_16,color_FFFFFF,t_70)
- 配合项目名包路径
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200503204103546.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTcwMTAy,size_16,color_FFFFFF,t_70)
- 依赖就选择一个web的就可以，需要什么依赖之后手动加入
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200503204141831.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTcwMTAy,size_16,color_FFFFFF,t_70)
- 设置项目存放位置，选择自己的工作空间
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200503204231785.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTcwMTAy,size_16,color_FFFFFF,t_70)
- 点击finish开始创建，第一次可能会比较久
- 创建完成后的目录结构
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200503204357917.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTcwMTAy,size_16,color_FFFFFF,t_70)
- 修改maven仓库位置，默认创建的是在C盘中的仓库，重新定位到自己的仓库（可不改）
file - > settings ->搜索maven
选中自己的本地仓库地址，点击apply
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200503204545583.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTcwMTAy,size_16,color_FFFFFF,t_70)
一个Spring Boot的项目就创建好了

## 基础配置编写
- 引入常用Maven依赖

```xml
		<!--mybatis-->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.1.2</version>
        </dependency>
        <!--mysql驱动-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
        <!--lombok-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <!--mybatis-plus-->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>3.3.1.tmp</version>
        </dependency>
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-generator</artifactId>
            <version>3.3.1.tmp</version>
        </dependency>
        <dependency>
            <groupId>org.freemarker</groupId>
            <artifactId>freemarker</artifactId>
            <version>2.3.30</version>
        </dependency>
        <!--模板引擎-->
        <dependency>
            <groupId>org.apache.velocity</groupId>
            <artifactId>velocity-engine-core</artifactId>
            <version>2.1</version>
        </dependency>

        <!--guava-->
        <dependency>
            <groupId>com.google.guava</groupId>
            <artifactId>guava</artifactId>
            <version>29.0-jre</version>
        </dependency>
        <!-- pagehelper -->
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper-spring-boot-starter</artifactId>
            <version>1.2.5</version>
        </dependency>
        <!--通用工具包commons-lang3 -->
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-lang3</artifactId>
            <version>3.7</version>
        </dependency>
        <!--数据源-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.1.10</version>
        </dependency>
        <!--swagger2-->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.8.0</version>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.8.0</version>
        </dependency>
        <!-- 引入swagger-bootstrap-ui包 -->
        <dependency>
            <groupId>com.github.xiaoymin</groupId>
            <artifactId>swagger-bootstrap-ui</artifactId>
            <version>1.8.5</version>
        </dependency>
        <!--热部署-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <!--依赖不传递-->
            <optional>true</optional>
        </dependency>
        <!--jwt-->
        <dependency>
            <groupId>com.auth0</groupId>
            <artifactId>java-jwt</artifactId>
            <version>3.2.0</version>
        </dependency>
```

- 创建常用的包
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200503212817850.png)

- 配置BasedemoApplication
	BasedemoApplication是整个web项目的启动类
配置一下mapper接口的扫描
```java
@SpringBootApplication
@MapperScan("com.example.basedemo.dao")
public class BasedemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasedemoApplication.class, args);
    }
}
```
- 创建配置文件
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200503212955574.png)
默认创建了application.properties
手动创建开发环境配置：application-dev.properties
手动创建生产环境配置：application-prov.properties
application.properties内容：

	```java
	spring.profiles.active=dev
	```
application-dev.properties和application-prov.properties根据需求自己配置
```java
#端口
server.port = 3036
#xml文件路径
mybatis.mapper-locations=classpath:mapper/*.xml
#数据类连接
spring.datasource.url=jdbc:mysql://localhost:3306/crm?useUnicode=true&characterEncoding=UTF-8&sessionVariables=time_zone='%2B8:00'
spring.datasource.username=root
spring.datasource.password=root
#使用druid数据源
spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
#连接驱动
spring.datasource.driver-class-name= com.mysql.cj.jdbc.Driver
        
#时间格式
spring.jackson.date-format=yyyy-MM-dd HH:mm:ss
spring.jackson.time-zone=GMT+8
```
## 日志配置
Spring Boot默认采用的是SLF4J + LogBack，这也是比较优的一种搭配了，就直接用这个
引入配置文件logback-spring.xml
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200503213840370.png)
日志写入根目录下的log目录，每天生成一个日志文件
具体配置如下：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration debug="false">

    <!--定义日志文件的存储地址 勿在 LogBack 的配置中使用相对路径-->
    <property name="LOG_HOME" value="log" />

    <!--控制台日志， 控制台输出 -->
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
            <!--格式化输出：%d表示日期，%thread表示线程名，%-5level：级别从左显示5个字符宽度,%msg：日志消息，%n是换行符-->
            <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} - %msg%n</pattern>
        </encoder>
    </appender>

    <!--文件日志， 按照每天生成日志文件 -->
    <appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <!--日志文件输出的文件名-->
            <FileNamePattern>${LOG_HOME}/klchen_summary.log.%d{yyyy-MM-dd}.log</FileNamePattern>
            <!--日志文件保留天数-->
            <MaxHistory>30</MaxHistory>
        </rollingPolicy>
        <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
            <!--格式化输出：%d表示日期，%thread表示线程名，%-5level：级别从左显示5个字符宽度%msg：日志消息，%n是换行符-->
            <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} - %msg%n</pattern>
        </encoder>
        <!--日志文件最大的大小-->
        <triggeringPolicy class="ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy">
            <MaxFileSize>10MB</MaxFileSize>
        </triggeringPolicy>
    </appender>


    <!--myibatis log configure-->
    <logger name="com.apache.ibatis" level="TRACE"/>
    <logger name="java.sql.Connection" level="DEBUG"/>
    <logger name="java.sql.Statement" level="DEBUG"/>
    <logger name="java.sql.PreparedStatement" level="DEBUG"/>

    <!-- 日志输出级别 -->
    <root level="INFO">
        <appender-ref ref="STDOUT" />
        <appender-ref ref="FILE"/>
    </root>
</configuration>
```

## 接口文档Swagger2配置
在utils目录下创建Swagger2类，在里面编写配置文件，内容如下：
必须要修改的是`basePackage("com.klchen.hos.controller"))`
修改为自己的接口包的路径，才能被扫描到
apiInfo内配置的是文档上显示的参数
```java
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.klchen.hos.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("存储系统API文档")
                .description("基于HBase的文件存储系统API文档")
                .contact(new Contact("klChen","https://blog.csdn.net/qq_41170102","737874762@qq.com"))
                .version("2.0.1")
                .build();
    }
}
```
启动我们的项目，可以查看一下文档
官方的ui的路径是：`http://localhost:3036/swagger-ui.html`，其中3036是配置的项目的port，swagger-ui.html是路径
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200503214604620.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTcwMTAy,size_16,color_FFFFFF,t_70)
在前面引包里面我们引入了一个包，如下

```java
		 <!-- 引入swagger-bootstrap-ui包 -->
        <dependency>
            <groupId>com.github.xiaoymin</groupId>
            <artifactId>swagger-bootstrap-ui</artifactId>
            <version>1.8.5</version>
        </dependency>
```
这个包是一个比较简洁的ui，访问路由是`http://localhost:3036/doc.html`
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020050321484560.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTcwMTAy,size_16,color_FFFFFF,t_70)
swagger2常用注解：

- @Api()用于类； 
表示标识这个类是swagger的资源 
- @ApiOperation()用于方法； 
表示一个http请求的操作 
- @ApiParam()用于方法，参数，字段说明； 
表示对参数的添加元数据（说明或是否必填等） 
- @ApiModel()用于类 
表示对类进行说明，用于参数用实体类接收 
- @ApiModelProperty()用于方法，字段 
表示对model属性的说明或者数据操作更改 
- @ApiIgnore()用于类，方法，方法参数 
表示这个方法或者类被忽略 
- @ApiImplicitParam() 用于方法 
表示单独的请求参数 
- @ApiImplicitParams() 用于方法，包含多个 @ApiImplicitParam
## 自定义全局异常处理配置
首先定义一个接口CommonError，里面定义三个方法，分别是设置错误信息，获取错误信息，获取错误编码的方法

```java
public interface CommonError {
    public int getErrCode();
    public String getErrMsg();
    public CommonError setErrMsg(String errMsg);
}
```
定义一个枚举类，在里面可以定义我们常用的异常，并实现自定义的CommonError 接口，方便通过枚举类来获取错误编码和错误信息

```java
public enum EmBusinssError implements CommonError{

    //通用错误类型
    PARAMETER_VALIDATION_ERROR(10001,"参数不合法"),
    UNKNOWN_ERROR(10002,"未知错误"),
    NOTFIND(10003,"查询结果为空"),
    //以20000开头为用户信息相关错误定义
    USER_NOT_EXIST(20001,"用户不存在"),
    PRIMARY_KEY_EXIST(20002,"主键冲突"),
    USER_Login_Fail(20003,"用户账号或密码不正确"),
    LOGINOUTTIME(30001,"登录状态过期，请重新登录"),

    ERROR_PERMISSION_DENIED(403,"权限错误"),
    ERROR_FILE_NOT_FOUND(404,"未能找到"),
    ERROR_HBASE(500,"hbase发生错误"),
    ERROR_HDFS(501,"hdfs发出错误")
    ;

    private int errCode;
    private String errMsg;

    EmBusinssError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
```
创建一个包装器业务异常类，用来包装异常信息，抛出异常时可以统一使用BusinessException 就可以了

```java
//包装器业务异常类实现
public class  BusinessException extends Exception implements CommonError {

    private CommonError commonError;

    //直接接收embussinesserror的传参，用于构造业务异常
    public BusinessException(CommonError commonError) {
        super();
        this.commonError = commonError;
    }
    //接收自定义errMsg的方式构造业务异常
    public BusinessException(CommonError commonError ,String errMsg){
        super();
        this.commonError = commonError;
        this.commonError.setErrMsg(errMsg);
    }

    @Override
    public int getErrCode() {
        return this.commonError.getErrCode();
    }

    @Override
    public String getErrMsg() {
        return this.commonError.getErrMsg();
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.commonError.setErrMsg(errMsg);
        return this;
    }
}
```
项目中把他们放在error目录下
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200503220015229.png)
为了捕获异常，还需要定义个一个顶层的捕获器 ，将其定义在BaseController中，所有的Controller都继承BaseController，所有业务抛出的异常最终都会到BaseController进行处理，然后将错误信息返回

```java
public class BaseController {


    //定义exceptionhandler解决未被controller层吸收的exception
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerException(HttpServletRequest request, Exception ex){
        Map<String, Object> responseData = new HashMap<>();

        if (ex instanceof BusinessException){
            BusinessException businessException = (BusinessException)ex;
            responseData.put("errCode",businessException.getErrCode());
            responseData.put("errMsg",businessException.getErrMsg());

        }else {
            responseData.put("errCode", EmBusinssError.UNKNOWN_ERROR.getErrCode());
            responseData.put("errMsg",EmBusinssError.UNKNOWN_ERROR.getErrMsg());
        }

        return CommonreturnType.create(responseData,"fail");


    }

}
```

## 通用返回包装类配置
为了统一返回的JSON数据的格式，方便使用，需要定义一个通用的返回包装类
包装类中
- 定义了两个字段，请求状态和返回数据
如果是正常的请求，状态码为success，如果是抛出了异常，状态码是fail
- 定义了两个构造方法，一个是传入参数为一个Object的方法，默认为成功的请求返回，请求状态是success；一个是传入两个参数的方法，可指定请求的状态

这里的@Data注解是lambok中的，可以生成所有属性的getter，setter，tostring方法，使用时需要安装lambok插件并导入包，后面专门写一篇lambok使用的文章
```java
@Data
@ApiModel(value = "通用返回类型")
public class CommonreturnType<T> {
    //表明请求的返回处理结果“success”或“fail”
    @ApiModelProperty(value = "状态码")
    private String status;

    //若status为success，返回前端需要的json数据
    //若status为fail，返回data内使用通用的错误格式码
    @ApiModelProperty(value = "返回数据")
    private T data;

    //定义一个通用的创建方法
    public static CommonreturnType create(Object result){
        return CommonreturnType.create(result,"success");
    }
    public static CommonreturnType create(Object result, String status){
        CommonreturnType type = new CommonreturnType();
        type.setStatus(status);
        type.setData(result);
        return type;
    }
}
```

## PageHelper分页插件配置
我们主要是使用Mybatis Plus来实现CRUD，并且Mybatis Plus已经存在了只需要配置就能用的分页插件，但是Mybatis Plus只针对单表操作很方便，多表联查的场景还是需要自己实现，出于编码习惯，多表联查的分页查询还是使用pagehelper的分页插件
首先要导入对应的依赖，前面也已经导入过了

```java
		<!-- pagehelper -->
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper-spring-boot-starter</artifactId>
            <version>1.2.5</version>
        </dependency>
```
编写一个自定义的PageInfo用于包装返回数据，如果不自己设置就是使用默认的，参数会比较多而且名字不能变
为了方便接口调用者，我们把PageInfo内的参数名尽量和Mybatis Plus中的分页的参数名一致

```java
@SuppressWarnings({"rawtypes", "unchecked"})
@Data
public class PageInfo<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    //当前页
    private int current;
    //每页的数量
    private int size;
    //总记录数
    private long total;
    //总页数
    private int pages;
    //结果集
    private List<T> records;
    //是否为第一页
    private boolean isFirstPage = false;
    //是否为最后一页
    private boolean isLastPage = false;


    public PageInfo() {
    }

    /**
     * 包装Page对象
     *
     * @param records
     */
    public PageInfo(List<T> records) {
        if (records instanceof Page) {
            Page page = (Page) records;
            this.current = page.getPageNum();
            this.size = page.getPageSize();

            this.pages = page.getPages();
            this.records = page;
            this.total = page.getTotal();
        } else if (records instanceof Collection) {
            this.current = 1;
            this.size = records.size();

            this.pages = 1;
            this.records = records;
            this.total = records.size();
        }
        if (records instanceof Collection) {
            //判断页面边界
            judgePageBoudary();
        }
    }

    /**
     * 判定页面边界
     */
    private void judgePageBoudary() {
        isFirstPage = current == 1;
        isLastPage = current == pages;
    }
    
}
```
经过以上两步匹配，之后就可以使用了

## Mybatis Plus分页配置
这是Mybatis Plus自带的分页插件，用起来非常方便，只需要注入一个bean就可以了

```java
@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
```
## Mybatis Plus自动生成模板与配置
Mybatis Plus之所以强大，一方面就是他的自动生成模板，只需少量配置，就可以生成可以实现几乎所有单表查询的dao层和server层，让程序猿可以专注于业务逻辑而不是繁琐的编码

在test下的根目录下添加如下的文件，文件可以在我的[github](https://github.com/737874762/SBJM_BaseDemo/tree/master/src/test/java/com/example/basedemo)
中下载
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200503221855915.png)
templates下的模板都是配置好的，基本不需要修改，我觉得是非常好用

CodeGenerator就是我们的代码生成器了，配置好了之后运行就可以生成我们的通用dao层和通用server层，只需要学会他的调用方法就可以了

如果只是简单使用，需要配置的内容如下

将数据库连接和项目根路径修改为自己的
```java
	private static final String dbUrl = "jdbc:mysql://localhost:3306/crm?useUnicode=true&characterEncoding=UTF-8&sessionVariables=time_zone='%2B8:00'";//数据库连接url
    private static final String dbDriver = "com.mysql.cj.jdbc.Driver";//数据库驱动
    private static final String dbUsername = "root";//数据库账号
    private static final String dbPassword = "root";//数据库密码
    private static final String basePackage = "cn.chenkl";//项目包路径
```
在最下面找到这一行代码，将需要自动生成的表名加入到里面，以逗号隔开
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200503222758972.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTcwMTAy,size_16,color_FFFFFF,t_70)
完成上面两步配置就可以启动CodeGenerator了，处于测试，我就只生成一张表tn_user_info的。启动后，生成了如下的五个文件，对应了实体类，dao层和service层的接口和实现类
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200503223223733.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTcwMTAy,size_16,color_FFFFFF,t_70)
自动生成就配置完毕，后面的实际操作中会讲解具体的用法

相比之前用过的Mybatis-generator和通用mapper，针对单表操作，Mybatis-Plus真的太强大了
从别的博主处搬来一张对比图，感兴趣的可以去看看对比的博文
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200503222512821.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTcwMTAy,size_16,color_FFFFFF,t_70)
图片出处[https://blog.csdn.net/m0_37524586/article/details/88351833](https://blog.csdn.net/m0_37524586/article/details/88351833)


## JWT加密解密配置
JSON Web Token（JWT）是目前最流行的无状态跨域身份验证解决方案。

JWT又三部分组成，第一部分我们称它为头部（header),第二部分我们称其为载荷（payload, 类似于飞机上承载的物品)，第三部分是签证（signature).

- header
头部承载了两部分信息，分别是令牌类型和签名算法

```java
{
  'typ': 'JWT',
  'alg': 'HS256'
}
```
头部进行base64加密形式第一部分的密文
- playload

载荷就是存放有效信息的地方。分为标准中注册的声明，公共的声明，私有的声明

- 注册中的声明包括以下七种

	iss: jwt签发者
	sub: jwt所面向的用户
	aud: 接收jwt的一方
	exp: jwt的过期时间，这个过期时间必须要大于签发时间
	nbf: 定义在什么时间之前，该jwt都是不可用的.
	iat: jwt的签发时间
	jti: jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击。

不强制被要求使用

- 公共的声明 ：
公共的声明可以添加任何的信息，一般添加用户的相关信息或其他业务需要的必要信息.但不建议添加敏感信息，因为该部分在客户端可解密.

- 私有的声明 ：
私有声明是提供者和消费者所共同定义的声明，一般不建议存放敏感信息，因为base64是对称解密的，意味着该部分信息可以归类为明文信息。


将所有的声明进行base64加密生成第二部分密文

- signature
jwt的第三部分是一个签证信息，这个签证信息由三部分组成：

	header (base64后的)
	payload (base64后的)
	secret

将加密后的header和加密后的payload进行字符串拼接，之后通过头部声明的算法进行再次加密，加密时加盐secret

secret是服务器端私有的一个密匙，不能泄露，因为base64加密是对称加密，有了secret之后可以将token破解，导致信息泄露

实践一下：

创建一个playload实体用于存储我们的声明

```java
@Data
public class Payload {
    private String issuer;//发布者
    private String subject;//主题
    private List<String> audience;//签名的观众 也可以理解谁接受签名的
    private Date issuedAt;//发布时间
    private Date expiresAt;//过期时间
    private Date notBefore;//开始使用时间
    private Map<String, String> claims;

    //重载这个方法
    public void setAudience(List<String> audience) {
        this.audience = audience;
    }
    public void setAudience(String... audienceStr) {
        List<String> audiences = new ArrayList<String>();
        for (String string : audienceStr) {
            audiences.add(string);
        }
        this.audience = audiences;
    }
}
```
声明参数采用的是注册中的声明，claims中可以自定义存放数据，通常是业务相关的一些非重要信息，如用户名，用户角色等

创建一个加密解密业务类JWTService，在里面创建生成签名和翻译签名的方法方便调用

生成签名的过程：封装Payload 属性，对头部加密，对负荷加密，对签名加密

```java
 /**
     * 创建 hour小时后过期的Token
     *
     * @param claims
     * @param hour
     * @return
     */
    public String createToken(Map<String, String> claims, int hour) throws UnsupportedEncodingException {
        Payload createPayload = this.createPayload(hour);//封装公有负载
        createPayload.setClaims(claims);//封装私有负载
        Algorithm hmac256 = Algorithm.HMAC256(this.getSecret());//构建密匙信息
        return createToken(createPayload, hmac256);
    }

    /**
     * 根据负载和算法创建Token
     *
     * @param payload
     * @param algorithm
     * @return
     */
    public String createToken(Payload payload, Algorithm algorithm) {

        Builder headBuilder = createHeaderBuilder(algorithm);//头部加密
        Builder publicClaimbuilder = addPublicClaimBuilder(headBuilder, payload);//公有负载加密
        Builder privateClaimbuilder = addPrivateClaimbuilder(publicClaimbuilder, payload);//私有负载加密
        String token = privateClaimbuilder.sign(algorithm);//生成签名
        return token;
    }
```
校验（解密）token的过程：解码签名获得payload，解析payload获取对应的负荷信息封装到payload对象

```java
	/**
     * 校验Token
     *
     * @param token
     * @return
     */
    public Payload verifyToken(String token) throws UnsupportedEncodingException {
        DecodedJWT jwt = null;
        Payload payload = null;
        try {
            jwt = getDecodedJWT(token);//解码token获得jwt
            payload = getPublicClaim(jwt);//jwt解析出公有负载
            payload = getPrivateClaim(jwt, payload);//jwt解析出私有负载
        } catch (AlgorithmMismatchException e) {
            throw e;
        }
        return payload;//返回解析对象
    }
```
具体的方法实现参照我的[github](https://github.com/737874762/SBJM_BaseDemo/blob/master/src/main/java/com/example/basedemo/jwt/JWTService.java)

## 登录拦截器配置
定义一个登陆拦截器LoginInterceptor实现HandlerInterceptor接口

只需要具体实现下preHandle方法

从header中获取token的信息

```java
String token = request.getHeader("X-Auth-Token");
```
如果token为空重定向到一个返回没有登录的信息的接口

```java
  //token is null
  if (StringUtils.isEmpty(token)) {
       String url = "/toLogin";
       response.sendRedirect(url);
       return false;
  }
```
为了实现退出登录功能，登录完成后需要将token存放到ServletContext中，所以我们还需要看一下ServletContext中有没有数据，如果没有，说明调用过退出登录的接口，当前token就逻辑上失效了

```java
		String tokenInServletContext = (String)request.getServletContext().getAttribute(token);

        //未登录或者过期   ServletContext中找不到这个token
        if(StringUtils.isEmpty(tokenInServletContext)) {
            String url = "/toLogin";
            response.sendRedirect(url);
            return false;
        }
```
通过上面两层校验之后，调用JWTServer中的解密的方法将JWT解密，并捕获异常，如果发生异常说明解密失败。token不正确，如果正确解密，返回一个Payload对象，可以存入ThreadLocal中，方便调用其中的属性

```java
	//校验token，如果无误放行
    Payload payload = jwtService.verifyToken(token);
    ContextUtil.setCurrentplayLoad(payload);
```

定义一个拦截器配置类InterceptorConfig，实现WebMvcConfigurer接口

首先定义一个Map存放免验证的url
将不需要jwt验证的接口放在里面
```java
 //请求无需验证登录的url
    List<String> passingUrl = new ArrayList<String>(){
        {
            //登录
            add("/login");
            //未登录跳转提醒
            add("/toLogin");

            //swagger 相关
            add("/swagger-ui.html");
            add("/webjars/**");
            add("/v2/**");
            add("/swagger-resources/**");
            add("/doc.html/**");
        }
    };
```
注入一个LoginInterceptor实例

```java
@Autowired
private LoginInterceptor loginInterceptor ;
```
添加一个拦截器将LoginInterceptor 和passingUrl注入进去

```java
	/**
     * 拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).
                addPathPatterns("/**").
                excludePathPatterns(passingUrl);
    }
```
 同时，还有两个常用的拦截配置需要加入
- SpringBoot中默认只支持"GET", "POST", "PUT", "DELETE"中的Get和Post请求，想要实现Restful的Api，并解决跨域问题，所有需要配置下addCorsMappings
- 系统中常用到静态资源映射，映射之后可以通过url访问服务器上映射的资源，

```java
 /**
     * 配置跨域和支持restoful接口
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }

    /**
     * 设置图片映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //addResourceHandler是指你想在url请求的路径
        //addResourceLocations是图片存放的真实路径
        registry.addResourceHandler("/image/**").addResourceLocations("file:"+System.getProperty("user.dir")+"/image/");
    }
```


## 线程局部变量ThreadLocal使用
还不了解ThreadLocal的可以看一看我写过的一篇[关于ThreadLocal的博文](https://blog.csdn.net/qq_41170102/article/details/104778024)

使用时，创建一个工具类ContextUtil操作ThreadLocal

```java
/**
 * ThreadLocal工具类，用来获取请求用户的信息
 */
public class ContextUtil {

    //线程局部变量
    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public static String getCurrentUser() {
        return threadLocal.get();
    }

    public static void setCurrentUser(String openId) {
        threadLocal.set(openId);
    }

    public static void clear() {
        threadLocal.remove();
    }
    
}
```
当jwt验证通过后，将Payload对象存入到ThreadLocal中，在一次请求调用到的代码的任何地方都可以获取到Payload对象，从而获取到封装的业务属性

## 热部署
使用热部署可以在代码修改后不用重启服务器，只需要保存代码就会自动的重新加载

首先 导入依赖

```xml
		<!--热部署-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <!--依赖不传递-->
            <optional>true</optional>
        </dependency>
```
在配置文件中添加配置

```java
#热部署生效
spring.devtools.restart.enabled=true
#设置重启的目录，添加那个目录的文件需要restart
spring.devtools.restart.additional-paths=src/main/java
```
修改idea配置
File-Settings-Build-Compiler-Build Project automatically
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200504101243812.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTcwMTAy,size_16,color_FFFFFF,t_70)
ctrl + shift + alt + / ,选择Registry,勾上 Compiler autoMake allow when app running
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200504101430874.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTcwMTAy,size_16,color_FFFFFF,t_70)

## ssl证书配置
（这个需要https时才配）
写了一篇[使用博客](https://blog.csdn.net/qq_41170102/article/details/105837477)

## 登录接口实现
从这里开始就要将之前配置的所有东西都用起来了

定义一个LoginController继承自BaseController

注入JWTService方便调用

```java
	 @Autowired
    private JWTService jwtService;
```
编写登录的接口，首先校验是否为空，然后调用方法校验密码，如果不满足，就直接抛出BusinessException

验证通过后，将自定义参数加入到map中，调用createToken方法生成token，并存储到ServletContext 中，并返回给接口调用方token
```java
	@ApiOperation("登录")
    @PostMapping("/login")
    public CommonreturnType login(@RequestParam(value = "username") String username,
                                  @RequestParam(value = "password") String password,
                                  HttpServletRequest request) throws BusinessException, UnsupportedEncodingException {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new BusinessException(EmBusinssError.USER_Login_Fail);
        }
        if (!checked(username,password)){
            throw new BusinessException(EmBusinssError.USER_Login_Fail);
        }

        Map<String, String> userInfo = new HashMap<String, String>() {
            {
                put("username", username);
                //自定义参数
            }
        };

        String token = jwtService.createToken(userInfo, 1);
        ServletContext context = request.getServletContext();
        context.setAttribute(token, token);

        return CommonreturnType.create(token);
    }
```
退出登录方法
只需要清除掉ServletContext 中的token，就可以使token逻辑上失效，也可以存入到redis中，这里就不演示了
```java
	@ApiOperation("退出登录")
    @GetMapping("/logout")
    public CommonreturnType logout(String token, HttpServletRequest request) {
        ServletContext context = request.getServletContext();
        context.removeAttribute(token);
        return CommonreturnType.create("logout");
    }
```
token验证不通过重定向方法

```java
	@ApiIgnore
    @GetMapping("/toLogin")
    public CommonreturnType toLogin() throws BusinessException {
        throw new BusinessException(EmBusinssError.LOGINOUTTIME);
    }
```
## 单表CRUD实现
Mybatis Plus的常用操作可以去看[官方的文档](https://mp.baomidou.com/)

慕课网上也有一个不错的免费课程，可以跟着熟悉下API，[MyBatis-Plus入门](https://www.imooc.com/learn/1130)

以用户表为例，对用户表进行增删改查和分页查询，代码如下

```java
@RestController
@RequestMapping("/api")
public class BaseDataController extends BaseController {

    @Autowired
    private TnUserInfoService tnUserInfoService;

    @ApiOperation(value = "insert", notes = "")
    @PostMapping("/user")
    public CommonreturnType insertUser(@RequestBody TnUserInfoPo tnUserInfoPo) throws BusinessException {
        Integer count = tnUserInfoService.lambdaQuery().
                eq(TnUserInfoPo::getUserCode, tnUserInfoPo.getUserCode()).
                count();//判断主键是否已经存在
        if (count > 0) {//主键冲突
            throw new BusinessException(EmBusinssError.PRIMARY_KEY_EXIST);
        }
        boolean save = tnUserInfoService.save(tnUserInfoPo);
        return CommonreturnType.create(save);
    }

    @ApiOperation(value = "update", notes = "")
    @PutMapping("/user")
    public CommonreturnType updateUser(@RequestBody TnUserInfoPo tnUserInfoPo) {
        // 通过传入实体进行修改，默认策略会排除空字段
//        boolean update = tnUserInfoService.updateById(tnUserInfoPo);
        // 通过条件修改指定的字段 lambda表达式
        boolean update = tnUserInfoService.lambdaUpdate().
                eq(TnUserInfoPo::getUserCode, tnUserInfoPo.getUserCode()).
                set(TnUserInfoPo::getUserName, tnUserInfoPo.getUserName()).update();
        return CommonreturnType.create(update);
    }

    @ApiOperation(value = "delete", notes = "")
    @DeleteMapping("/user")
    public CommonreturnType deleteUser(@RequestParam(value = "userCode") String userCode) {
        boolean remove = tnUserInfoService.lambdaUpdate().
                eq(TnUserInfoPo::getUserCode, userCode).
                remove();
        return CommonreturnType.create(remove);
    }

    @ApiOperation(value = "get", notes = "")
    @GetMapping("/user/{userCode}")
    public CommonreturnType getUser(@PathVariable String userCode) {
        TnUserInfoPo tnUserInfoPo = tnUserInfoService.
                getOne(Wrappers.<TnUserInfoPo>lambdaQuery().
                        eq(TnUserInfoPo::getUserCode, userCode));
        return CommonreturnType.create(tnUserInfoPo);
    }

    @ApiOperation(value = "getPage", notes = "")
    @GetMapping(value = "/user/pageNum/{pageNum}/pageSize/{pageSize}")
    public CommonreturnType getUserByPage(@PathVariable Integer pageNum,
                                          @PathVariable Integer pageSize) {
        IPage<TnUserInfoPo> page = new Page<>(pageNum, pageSize);
        IPage<TnUserInfoPo> pageInfo = tnUserInfoService.lambdaQuery().
                select(TnUserInfoPo.class,info->!info.getColumn().equals("PASSWORD")).//排除密码被查询
                page(page);
        return CommonreturnType.create(pageInfo);
    }
    
}
```

## 多表CRUD实现
用户表的字段如下：

```java
	 @TableId("USER_CODE")
    private String userCode;

    @TableField("USER_NAME")
    private String userName;

    @TableField("UNIT_CODE")
    private String unitCode;

    @TableField("ChineseName")
    private String ChineseName;

    @TableField("PASSWORD")
    private String password;

    @TableField("CREATE_TIME")
    private Date createTime;
```
其中的UNIT_CODE对应部门表的部门id，查询用户信息时应该把部门名称也一同查询出来，所以查询需要关联上部门表

联表查询的Sql如下，不仅要查出来，我们还需要分页查询

```sql
SELECT
	u.USER_CODE,
	u.USER_NAME,
	u.ChineseName,
	u.UNIT_CODE,
	unit.NAME unitName,
	u.CREATE_TIME 
FROM
	`tn_user_info` u
	LEFT JOIN tn_unit unit ON unit.UNIT_CODE = u.UNIT_CODE
```
多表查询可以使用wrapper辅助使用，习惯了原生的Mybatis使用，所以就采用原生的开发

添加一个实体类封装返回数据

```java
@Data
@ApiModel(value="User多表联查结果集映射对象", description="")
public class UserVo implements Serializable {
    private String userCode;

    private String userName;

    private String unitCode;

    private String unitName;

    private String ChineseName;

    private Date createTime;
}
```
Controller层

```java
	@ApiOperation(value = "get2", notes = "多表关联查询")
    @GetMapping("/user2/{userCode}")
    public CommonreturnType getUser2(@PathVariable String userCode) {
        UserVo user = tnUserInfoService.getUser(userCode);
        return CommonreturnType.create(user);
    }
    @ApiOperation(value = "getPage2", notes = "多表关联分页查询")
    @GetMapping(value = "/user2/pageNum/{pageNum}/pageSize/{pageSize}")
    public CommonreturnType getUserByPage2(@PathVariable Integer pageNum,
                                          @PathVariable Integer pageSize) {

        com.github.pagehelper.Page<UserVo> userVos = tnUserInfoService.getUserByPage(pageNum, pageSize);
        PageInfo<UserVo> pageInfo = new PageInfo<>(userVos);
        return CommonreturnType.create(pageInfo);
    }
```
Server层实现类

```java
	@Autowired
    private TnUserInfoDao tnUserInfoDao;

    @Override
    public UserVo getUser(String userCode) {
        return tnUserInfoDao.getUser(userCode);
    }

    @Override
    public Page<UserVo> getUserByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return tnUserInfoDao.getUserByPage();
    }
```
dao层xml文件
<!--自定义结果集-->

```xml
<resultMap id="MyResultMap" type="com.example.basedemo.entity.vo.UserVo">
    <id column="USER_CODE" property="userCode" />
    <result column="USER_NAME" property="userName" />
    <result column="UNIT_CODE" property="unitCode" />
    <result column="unitName" property="unitName" />
    <result column="ChineseName" property="ChineseName" />
    <result column="CREATE_TIME" property="createTime" />
</resultMap>

<select id="getUser" resultMap="MyResultMap">
    SELECT
        u.USER_CODE,
        u.USER_NAME,
        u.ChineseName,
        u.UNIT_CODE,
        unit.NAME unitName,
        u.CREATE_TIME
    FROM
      `tn_user_info` u
    LEFT JOIN tn_unit unit ON unit.UNIT_CODE = u.UNIT_CODE
    WHERE u.USER_CODE = #{userCode}
</select>
<select id="getUserByPage" resultMap="MyResultMap">
    SELECT
        u.USER_CODE,
        u.USER_NAME,
        u.ChineseName,
        u.UNIT_CODE,
        unit.NAME unitName,
        u.CREATE_TIME
    FROM
      `tn_user_info` u
    LEFT JOIN tn_unit unit ON unit.UNIT_CODE = u.UNIT_CODE
</select>
```

## Swagger2测试
测试前可以设置是否启用JWT验证
在登录拦截器中注入当前的配置文件环境

```java
	/**
     * 当前激活的配置文件
     */
    @Value("${spring.profiles.active}")
    private String env;
```

在前置方法里面加上放行判断

```java
		//认证验证
        if ("dev".equals(env)) { //开发环境忽略签名认证
            return true;
        }
```
如果是开发环境下不启动登录拦截器

没有拦截器时swagger-ui.htm的测试文件进行测试，针对上传下载会比较友好，而加上了拦截器需要传token时可以采用doc.html的接口文档，可以设置全局的header，方便测试

登录测试，成功生成token
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200504142313511.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTcwMTAy,size_16,color_FFFFFF,t_70)
分页查询，查询多表关联查询的
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200504142428316.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTcwMTAy,size_16,color_FFFFFF,t_70)
单表的分页查询
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200504142535796.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTcwMTAy,size_16,color_FFFFFF,t_70)
新增用户
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200504142717449.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTcwMTAy,size_16,color_FFFFFF,t_70)


## PostMan测试
相比自动生成的测试接口，使用Postman会更加的灵活
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200504142952299.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTcwMTAy,size_16,color_FFFFFF,t_70)
针对一个项目的接口测试，可以创建一个Collection，然后所有的接口都放在里面
点击new Collection创建一个Collection
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200504143348103.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTcwMTAy,size_16,color_FFFFFF,t_70)
然后再我们刚才编写完测试的页面点击Save
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200504143459626.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTcwMTAy,size_16,color_FFFFFF,t_70)
选中我们新建的Collection
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200504143604287.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTcwMTAy,size_16,color_FFFFFF,t_70)
接口就保存好了
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200504143639771.png)
点击右键可以修改请求的名称，方便管理

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200504143725736.png)
当启用jwt验证时，可以通过给Collection配置全局的header，在里面携带我们的token
点击
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200504143836383.png)
选中Api key
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200504143905282.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTcwMTAy,size_16,color_FFFFFF,t_70)
进行一次登录，然后把token存入header中，保存后再去访问其他接口就会自动携带jwt
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200504144047311.png)
一个较为完善的测试接口文档如下
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200504144156677.png)

## 项目部署
前后端的开发通常都不是一个人能完成的，为了方便接口调用者使用，接口写好后需要部署到服务器
如果是高校学生还没有云服务器的可以去这里看看，[免费领12个月](https://blog.csdn.net/qq_41170102/article/details/105092802)

最简单方便的就是打成一个jar包拖服务器上启动就好了，Spring Boot支持打成Jar包，内置有tomcat，服务器只需要java运行环境就可以了


点击maven-package打包
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200504144742508.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTcwMTAy,size_16,color_FFFFFF,t_70)
在target目录下找到jar包
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020050414485341.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTcwMTAy,size_16,color_FFFFFF,t_70)

将这个jar上传到服务器上
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200504145600531.png)

输入`nohup java -jar basedemo-0.0.1-SNAPSHOT.jar &`
将jar包在后台挂起

为了方便使用，可以编写启动和停止的脚本，或者使用docker进行部署

---
有时间了再来慢慢完善

---
更新 2020年5月4日14:57:34


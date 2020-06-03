# JavaEE

Spring全家桶是指SprintBoot、SpringCloud、SpringMVC等

## Spring Boot

```bash
sdk install springboot
spring init -d=web demo
mvn spring-boot:run
```

MVC -> M :数据， V -> 视图 C - >控制器
Spring MVC中的四个概念： component controller service repository

## MyBatis 

[官方网站](https://mybatis.org/mybatis-3/)
[参考网站](https://www.tutorialspoint.com/mybatis/index.html)

MyBatis是一流的持久性框架，支持自定义SQL，存储过程和高级映射。MyBatis消除了几乎所有的JDBC代码以及参数的手动设置和结果检索。MyBatis可以使用简单的XML或注释进行配置，并将图元，映射接口和Java POJO（普通的旧Java对象）映射到数据库记录。
原理：反射机制

## mybatis + mysql with maven

## myExample

example location at “~/hande” in my Mac
Primary code of pom.xml

```xml
<dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.18</version>
    </dependency>
<dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>3.5.2</version>
    </dependency>

```

mybatis-conf.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
  <environments default="development">
    <environment id="development">
      <transactionManager type="JDBC"/>
      <dataSource type="POOLED">
        <property name="driver" value="org.sqlite.JDBC"/>
        <property name="url" value="jdbc:sqlite:demo.db"/>
      </dataSource>
    </environment>
    <!-- <environment id="development">
      <transactionManager type="JDBC"/>
      <dataSource type="POOLED">
        <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
        <property name="url" value="jdbc:mysql://192.168.43.49:3306/hande"/>
        <property name="username" value="root"/>
        <property name="password" value="maxwit"/>
      </dataSource>
    </environment> -->
  </environments>
  <mappers>
    <mapper resource="com/maxwit/hande/StudentMapper.xml"/>
  </mappers>
</configuration>

```

## mybatis + sqlite3 with maven

Sqlite 自动生成数据库脚本

```bash
cat <<- EOF | sqlite3 demo1.db
create table user (id integer primary key autoincrement, name text);
insert into user (name) values ('Bonnie Young');
insert into user (name) values ('Conke Hu');
EOF
```

mybatis-conf.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
  <environments default="development">
    <environment id="development">
      <transactionManager type="JDBC"/>
      <dataSource type="POOLED">
        <property name="driver" value="org.sqlite.JDBC"/>
        <property name="url" value="jdbc:sqlite:demo.db"/>
      </dataSource>
    </environment>
  </environments>
  <mappers>
    <mapper resource="UserMapper/UserMapper.xml"/>
  </mappers>
</configuration>
```

## Mybatis generator with maven

[官方网址](http://mybatis.org/generator/running/runningWithMaven.html)
[参考网址1](https://blog.csdn.net/qq_40307945/article/details/81351302)
[参考网址2](https://www.jianshu.com/p/310c299846fc)

配置文件

prom.xml
```xml
<plugin>
          <groupId>org.mybatis.generator</groupId>
          <artifactId>mybatis-generator-maven-plugin</artifactId>
          <version>1.3.7</version>
          <executions>
            <execution>
              <id>Generate MyBatis Artifacts</id>
              <goals>
                <goal>generate</goal>
              </goals>
            </execution>
          </executions>
          <dependencies>
	    <dependency>
              <groupId>org.xerial</groupId>
              <artifactId>sqlite-jdbc</artifactId>
              <version>3.28.0</version>
            </dependency>
          </dependencies>
        </plugin>
```

generatorConfig.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
  PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
  "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">

<generatorConfiguration>
  
  <context id="default" targetRuntime="MyBatis3">
    <!-- <jdbcConnection driverClass="com.mysql.cj.jdbc.Driver"
        connectionURL="jdbc:mysql://192.168.123.208:3306/hande?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=true"
        userId="root"
        password="maxwit"> -->
    <jdbcConnection driverClass="org.sqlite.JDBC"
      connectionURL="jdbc:sqlite:demo.db">
    </jdbcConnection>

    <javaTypeResolver >
      <property name="forceBigDecimals" value="false" />
    </javaTypeResolver>

    <javaModelGenerator targetPackage="com.maxwit" targetProject="src/main/java">
      <property name="enableSubPackages" value="true" />
      <property name="trimStrings" value="true" />
    </javaModelGenerator>

    <sqlMapGenerator targetPackage="com.maxwit.mapper"  targetProject="src/main/resources">
      <property name="enableSubPackages" value="true" />
    </sqlMapGenerator>

    <javaClientGenerator type="XMLMAPPER" targetPackage="com.maxwit.mapper"  targetProject="src/main/java">
      <property name="enableSubPackages" value="true" />
    </javaClientGenerator>

    <!-- <table schema="DB2ADMIN" tableName="student" domainObjectName="Student" >
      <property name="useActualColumnNames" value="true"/> -->
    </table>
    <table schema="DB2ADMIN" tableName="user" domainObjectName="User" >
      <property name="useActualColumnNames" value="true"/>
    </table>

  </context>
</generatorConfiguration>


```
```java
String resource = "mybatis-conf.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectByPrimaryKey(1);
        System.out.println(user.getName());
        session.close();
```
```bash
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
```

## springboot + mybatis generaotr + sqlite3

新建一个springboot项目或者一个maven项目
spring init -d=web,mybatis --package-name com.maxwit demo
在porm.xml中注入驱动

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.2.0.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.example</groupId>
    <artifactId>Springboot-generator</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>demo</name>
    <description>Demo project for Spring Boot</description>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.1.1</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.18</version>
        </dependency>
        <dependency>
            <groupId>org.xerial</groupId>
            <artifactId>sqlite-jdbc</artifactId>
            <version>3.28.0</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
            <exclusions>
                <exclusion>
                    <groupId>org.junit.vintage</groupId>
                    <artifactId>junit-vintage-engine</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>org.mybatis.generator</groupId>
                <artifactId>mybatis-generator-maven-plugin</artifactId>
                <version>1.3.7</version>
                <dependencies>
                    <dependency>
                        <groupId>org.xerial</groupId>
                        <artifactId>sqlite-jdbc</artifactId>
                        <version>3.28.0</version>
                    </dependency>
                    
                </dependencies>
            </plugin>
        </plugins>
    </build>

</project>

```
新建一个generatorConfig.xml
示例见上文generator
根据数据库自动生成配置文件和代码
```bash
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
```
主函数

## Java 反射和注解

## 反射

https://cloud.tencent.com/developer/article/1368281

```java
import java.lang.reflect.Field;
import java.lang.reflect.Method;
class Person {
    private String name;
    private String IDcode;
    private String sex;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setIDcode(String code) {
        this.IDcode = code;
    }

    public String getIDcode() {
        return this.IDcode;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return this.sex;
    }

    public static void main(String[] args) {
        try {
            Class<?> gcls = Class.forName("Person");

            System.out.println("Method List");
            Method[] methods = gcls.getMethods();
            for (Method m : methods) {
                System.out.println(m);
            }

            System.out.println("Field List");
            Field[] fields = gcls.getFields();
            for (Field f : fields) {
                System.out.println(f);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

```

## Controller & RestController

```
两者最主要的区别是：
controller返回的是一个文件，restcontroller返回的是一个字符串，但是restcontroller也可返回文件，如下
```

```java
@RequestMapping("/home")
    public void tohome(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.sendRedirect("/home.html");
    }
```

## mybatis dynamic sql

```bash
spring init -d=mybatis -g com.maxwit demo1
```

[Document](http://mybatis.org/generator/quickstart.html)

```bash
vi prom.xml
```

```xml
	<dependency>
			<groupId>org.mariadb.jdbc</groupId>
			<artifactId>mariadb-java-client</artifactId>
			<version>2.5.2</version>
	</dependency>
	
	<dependency>
			<groupId>org.mybatis.dynamic-sql</groupId>
			<artifactId>mybatis-dynamic-sql</artifactId>
			<version>1.1.4</version>
	</dependency>
		<plugin>
                <groupId>org.mybatis.generator</groupId>
                <artifactId>mybatis-generator-maven-plugin</artifactId>
                <version>1.4.0</version>
                <configuration>
                    <overwrite>true</overwrite>
                </configuration>

                <dependencies>
                    <dependency>
                        <groupId>org.mariadb.jdbc</groupId>
                        <artifactId>mariadb-java-client</artifactId>
                        <version>2.5.2</version>
                    </dependency>
                </dependencies>
            </plugin>
```

## 引用项目外的配置文件

```bash
spring init springdemo
```

vi DemoapplicationTest.java

```java
@SpringBootTest
class DemoApplicationTests {
	@Value("${foo}")
	int x;

	@Test
	void contextLoads() {
				System.out.println(x);
	}
}
```

```bash
mkdir -p ~/env
mv src/main/resources/application.properties ~/env
mvn test # fail
mvn -Dspring.config.location=$HOME/env/ test # OK
```


Restful传参格式
	1.	form data
	2.	path variable
	3.	json（in body）


application.properities
```yml
spring.datasource.url=jdbc:mariadb://localhost/ooda
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.datasource.username=hande
spring.datasource.password=maxwit

```


DO, VO, DTO

Mybatis转换过来的对象都加DO


# Security

1.初始化一个带有`spring security`的web应用

```bash
spring init -d=web, security -g com.hande securitydemo
```


# OAthou2

1.dingtalk 第三方扫码login

[API Document](https://ding-doc.dingtalk.com/doc#/serverapi2/kymkv6)

具体见javaee/DingOAtho2

pom加载本地com.ding.top驱动，下载自钉钉开放平台开发前必读，
调用dingtalkAPI必备
```xml
<dependency>
	<groupId>com.taobao.top</groupId>
	<artifactId>top-api-sdk-dev</artifactId>
	<version>ding-open-mc-SNAPSHOT</version>
	<scope>system</scope>
	<systemPath>${pom.basedir}/lib/taobao-sdk-java-auto_1479188381469-20191231.jar</systemPath>
</dependency>
```


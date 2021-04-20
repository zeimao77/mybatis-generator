package top.zeimao77.config;

import org.mybatis.generator.config.*;
import top.zeimao77.resover.MyGenerator;
import top.zeimao77.resover.MyTypeResolverImpl;

public class MysqlGenerateContext extends Context {

    //生成到包
    private static final String TARGET_MODEL_PACKAGE = "com.crv.ucs.model";
    private static final String TARGET_MAPPER_PACKAGE = "com.efuture.mapper";
    private static final String TARGET_PROJECT = "mybatis-generator/src/main/java";

    private static final String DATASOURCEPROPERTIES = "environment.properties";
    //数据库连接
    private static final String DRIVERCLASS = "com.mysql.cj.jdbc.Driver";
    private static final String CONNECTIONURL = "jdbc:mysql://localhost:3306/crv_usercenter";
    private static final String USERID = "huarun";
    private static final String PASSWORD = "Huarun";

    public static final String ID = "MYSQL";

    public MysqlGenerateContext() {
        super(ModelType.FLAT);
        setId(ID);
        setTargetRuntime("MyBatis3Simple");
        setCommentGeneratorConfiguration();
        setJdbcConnectionConfiguration();
        setJavaTypeResolverConfiguration();
        setJavaModelGeneratorConfiguration();
        // 生成mapper.xml
        //setSqlMapGeneratorConfiguration();
    }

    private void setSqlMapGeneratorConfiguration() {
        SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
        sqlMapGeneratorConfiguration.setTargetPackage(TARGET_MAPPER_PACKAGE);
        sqlMapGeneratorConfiguration.setTargetProject(TARGET_PROJECT);
        sqlMapGeneratorConfiguration.addProperty(PropertyRegistry.ANY_ENABLE_SUB_PACKAGES,Boolean.TRUE.toString());
        setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);
    }

    public void addTableConfiguration(String tableName,String domainObjectName) {
        TableConfiguration tc = new TableConfiguration(this);
        addTableConfiguration(tc);
        tc.setTableName(tableName);
        tc.setDomainObjectName(domainObjectName);
        //指定父类;
        //tc.addProperty(PropertyRegistry.ANY_ROOT_CLASS, BaseEntry.class.getName());
        // FALSE:以驼峰命令字段;TRUE:不处理"_";
        tc.addProperty(PropertyRegistry.TABLE_USE_ACTUAL_COLUMN_NAMES,Boolean.FALSE.toString());
    }

    private void setJavaModelGeneratorConfiguration() {
        JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
        javaModelGeneratorConfiguration.setTargetPackage(TARGET_MODEL_PACKAGE);
        javaModelGeneratorConfiguration.setTargetProject(TARGET_PROJECT);
        setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);
    }

    private void setJavaTypeResolverConfiguration() {
        JavaTypeResolverConfiguration javaTypeResolverConfiguration = new JavaTypeResolverConfiguration();
        javaTypeResolverConfiguration.setConfigurationType(MyTypeResolverImpl.class.getName());
        javaTypeResolverConfiguration.addProperty(PropertyRegistry.TYPE_RESOLVER_FORCE_BIG_DECIMALS, Boolean.TRUE.toString());
        setJavaTypeResolverConfiguration(javaTypeResolverConfiguration);
    }

    private void setJdbcConnectionConfiguration(){
        JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
        jdbcConnectionConfiguration.setDriverClass(Environment.getProperties("jdbc.driverClass",DRIVERCLASS));
        jdbcConnectionConfiguration.setConnectionURL(Environment.getProperties("jdbc.url",CONNECTIONURL));
        jdbcConnectionConfiguration.setUserId(Environment.getProperties("jdbc.user",USERID));
        jdbcConnectionConfiguration.setPassword(Environment.getProperties("jdbc.password",PASSWORD));
        setJdbcConnectionConfiguration(jdbcConnectionConfiguration);
    }

    void setCommentGeneratorConfiguration() {
        CommentGeneratorConfiguration commentGeneratorConfiguration = new CommentGeneratorConfiguration();
        commentGeneratorConfiguration.setConfigurationType(MyGenerator.class.getName());
        commentGeneratorConfiguration.addProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS,Boolean.TRUE.toString());
        commentGeneratorConfiguration.addProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE,Boolean.TRUE.toString());
        setCommentGeneratorConfiguration(commentGeneratorConfiguration);
    }

}

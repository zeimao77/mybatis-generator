package top.zeimao77.config;

import org.mybatis.generator.config.Configuration;

public class GenerateConfiguration extends Configuration {

    public GenerateConfiguration() {
        MysqlGenerateContext context = new MysqlGenerateContext();
        addContext(context);
    }

}

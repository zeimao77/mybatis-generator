package top.zeimao77;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.internal.DefaultShellCallback;
import top.zeimao77.config.GenerateConfiguration;
import top.zeimao77.config.MysqlGenerateContext;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JavaCodeConfigGeneratorMain {

    public static final HashMap<String,String> tableMap = new HashMap<>();

    public static void init() {
        tableMap.put("app","App");
    }

    public static void main(String[] args) throws InvalidConfigurationException, InterruptedException, SQLException, IOException {
        init();
        ArrayList<String> warnings = new ArrayList<String>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        DefaultShellCallback shellCallback = new DefaultShellCallback(true);
        Configuration configuration = new GenerateConfiguration();
        MysqlGenerateContext context = ((MysqlGenerateContext) configuration.getContext(MysqlGenerateContext.ID));
        for (Map.Entry<String, String> entry : tableMap.entrySet()) {
            context.addTableConfiguration(entry.getKey(),entry.getValue());
        }
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration, shellCallback, warnings);
        myBatisGenerator.generate(null);
        for(String warning : warnings) {
            System.out.println(warning);
        }
        System.out.println("===========运行结束===========");
    }

}

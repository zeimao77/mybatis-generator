package top.zeimao77;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class XmlConfigGeneratorMain {

    private static final String configPath = "generator/generator_config_mysql.xml";

    public static void main(String[] args) throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException, InvalidConfigurationException, IOException, XMLParserException, SQLException {
        ArrayList<String> warnings = new ArrayList<String>();
        InputStream is = XmlConfigGeneratorMain.class.getClassLoader().getResourceAsStream(configPath);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        DefaultShellCallback shellCallback = new DefaultShellCallback(true);
        Configuration configuration = cp.parseConfiguration(is);
        is.close();
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration, shellCallback, warnings);
        myBatisGenerator.generate(null);
        for(String warning : warnings) {
            System.out.println(warning);
        }
        System.out.println("===========运行结束===========");
    }




}

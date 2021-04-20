package top.zeimao77.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Environment {

    public static final String configfile = "environment.properties";
    public static final Properties properties = new Properties();

    static {
        if(configfile != null && !configfile.isEmpty()) {
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(configfile);
            try {
                properties.load(is);
            } catch (IOException e) {
                throw new RuntimeException("IO Exception",e);
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getProperties(String key,String defaultValue) {
        return properties.getProperty(key,defaultValue);
    }

    public static String getProperties(String key) {
        return properties.getProperty(key);
    }

    public static boolean isEnable() {
        return !properties.isEmpty();
    }
}

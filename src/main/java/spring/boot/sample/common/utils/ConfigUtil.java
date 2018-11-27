package spring.boot.sample.common.utils;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.util.Properties;

/**
 * Created by xuguobing on 2016/11/17 0017.
 */
public class ConfigUtil {

    private static Properties properties = new Properties();

    static {
        String env = ConfigUtil.getProfilesActivie();
        Resource r0 = new DefaultResourceLoader().getResource("application.properties");
        Resource r = new DefaultResourceLoader().getResource("application-" + env + ".properties");
        try {
            properties.load(r0.getInputStream());
            properties.load(r.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProfilesActivie() {
        String env = System.getProperty("spring.profiles.active");
        if (env == null) {
            env = System.getenv("spring.profiles.active");
        }
        return env;
    }

    public static Boolean isProfile(String profile) {
        return profile != null && profile.equals(getProfilesActivie());
    }

    public static String getConfig(String key) {
        return properties.getProperty(key);
    }

}

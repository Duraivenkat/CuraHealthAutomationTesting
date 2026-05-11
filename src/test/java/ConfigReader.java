import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties prop = new Properties();

    static {

        try {

            FileInputStream fis =
                    new FileInputStream("src/test/resources/config.properties");

            prop.load(fis);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static String getBrowser() {

        return prop.getProperty("browser");
    }

    public static String getBaseUrl() {

        return prop.getProperty("baseUrl");
    }

    public static int getTimeout() {

        return Integer.parseInt(prop.getProperty("timeout"));
    }
}
package constant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static constant.Browser.CHROME;
import static util.PropertiesReader.getProperty;

public class commonConstant {
    private static final Logger logger = LoggerFactory.getLogger(commonConstant.class);
    public static final String BROWSER_NAME = getBrowserName();
    public static final String URL = getUrl();
    public static final Duration IMPLICIT_WAIT_IN_SECONDS = Duration.ofSeconds(60);
    public static final Duration EXPLICIT_WAIT_IN_SECONDS = Duration.ofSeconds(60);

    public static String getBrowserName(){
        String browserNameFromProperties = System.getProperty("browser");
        String browserName;

        if (browserNameFromProperties != null)
            browserName = browserNameFromProperties;
        else {
            logger.warn("There is no browser on properties use default");
            browserName = CHROME;
        }

        return browserName.toLowerCase();
    }

    public static String getUrl(){
        String urlFromProperties = System.getProperty("url");
        String url;

        if (urlFromProperties != null)
            url = urlFromProperties;
        else {
            logger.warn("There is no url on properties use default");
            url = getProperty("default");
        }

        return url.toLowerCase();
    }
}

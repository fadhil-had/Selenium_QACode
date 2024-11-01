package constant;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;

import static constant.Browser.CHROME;

public class commonConstant {
    private final static Logger logger = LogManager.getLogger();
    public static final String BROWSER_NAME = getBrowserName();
    public static final Duration IMPLICIT_WAIT_IN_SECONDS = Duration.ofSeconds(60);
    public static final Duration EXPLICIT_WAIT_IN_SECONDS = Duration.ofSeconds(60);

    public static String getBrowserName(){
        String browserNameFromPomXml = System.getProperty("browser");
        String browserName;

        if (browserNameFromPomXml != null)
            browserName = browserNameFromPomXml;
        else {
            logger.warn("There is no browser on properties use default.");
            browserName = CHROME;
        }

        return browserName.toLowerCase();
    }
}

package io.shaneconnolly.java.auto.demo.framework;

import cucumber.api.Scenario;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

/**
 * Created by ubuntu on 09/05/17.
 */
public class TestSession {

    private static final String WEBDRIVER = "WebDriver";
    private static final String ENV_URL = "envUrl";
    private static final String SCENARIO = "scenario";

    protected static final ThreadLocal<HashMap<String, Object>> testSession = new ThreadLocal<HashMap<String, Object>>() {
        protected HashMap<String, Object> initialValue() {
            return new HashMap<>();
        }
    };

    protected static void setObj(String name, Object data) {
        synchronized (testSession) {
            testSession.get().put(name, data);
        }
    }

    protected static Object getObj(String name) {
        synchronized (testSession) {
            return testSession.get().get(name);
        }
    }

    public static String getString(String name) {
        return (String) getObj(name);
    }

    public static void setString(String name, String value) {
        setObj(name, value);
    }

    public static void setWebDriver(WebDriver driver) {
        setObj(WEBDRIVER, driver);
    }

    public static WebDriver getWebDriver() {
        return (WebDriver) getObj(WEBDRIVER);
    }

    public static SCScenario getScenario(){
        return (SCScenario) getObj(SCENARIO);
    }

    public static void setScenario(SCScenario scenario) {
        setObj(SCENARIO, scenario);
    }

    public static void setEnvUrl(String url) {
        setObj(ENV_URL, url);
    }

    public static String getEnvUrl(){
        return (String) getObj(ENV_URL);
    }

}

package io.shaneconnolly.java.auto.demo.framework.webdriver;

import io.shaneconnolly.java.auto.demo.framework.FrameWorkConstants;
import io.shaneconnolly.java.auto.demo.framework.TestSession;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by seany on 24/02/17.
 */
public class BrowserDriver {

    static WebDriver  webDriver;

    public static void setWebDriver() {
        webDriver = setChromeWebDriver();
        webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        TestSession.setWebDriver(webDriver);
    }

    private static WebDriver setChromeWebDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-incognito");
        options.addArguments("--start-maximized");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(FrameWorkConstants.GRID_URL), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    private static WebDriver setFireFoxWebDriver() {
//        ProfilesIni prof = new ProfilesIni();
//        FirefoxProfile ffProfile= prof.getProfile ("Automation");
//
//        Reporter.log("GOT PROFILE " + ffProfile.toString());
//        ffProfile.setAcceptUntrustedCertificates(true);
//        ffProfile.setAssumeUntrustedCertificateIssuer(true);

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        //capabilities.setCapability(FirefoxDriver.PROFILE, capabilities);
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(FrameWorkConstants.GRID_URL), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}

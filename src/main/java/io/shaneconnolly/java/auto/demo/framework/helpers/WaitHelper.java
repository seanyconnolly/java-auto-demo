package io.shaneconnolly.java.auto.demo.framework.helpers;

import io.shaneconnolly.java.auto.demo.framework.TestSession;
import io.shaneconnolly.java.auto.demo.framework.webdriver.SCWebElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ubuntu on 09/05/17.
 */
public class WaitHelper {

    final static Logger logger = Logger.getLogger(WaitHelper.class);
    final static int PAGE_LOAD_TIME_OUT = 45;
    final static int POP_UP_LOAD_TIME_OUT = 2;

    public static void staticWait(int secs){
        logger.info("STATIC WAITING FOR SECS ::: " + secs);
        try {
            Thread.sleep(secs * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            logger.trace(e.getMessage());
        }
    }

    public static void waitForPageLoad(SCWebElement pageLoaderElement){
        logger.info("WAITING PAGE LOAD ::: " + pageLoaderElement.getName());
        new WebDriverWait(TestSession.getWebDriver(),
                PAGE_LOAD_TIME_OUT).until(ExpectedConditions.visibilityOfElementLocated(pageLoaderElement.getBy()));
    }

    public static void waitForPopUpShown(SCWebElement popUpUniqueElement){
        logger.info("WAITING POP UP ::: " + popUpUniqueElement.getName());
        new WebDriverWait(TestSession.getWebDriver(),
                POP_UP_LOAD_TIME_OUT).until(ExpectedConditions.visibilityOfElementLocated(popUpUniqueElement.getBy()));
    }

}

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

    private final static Logger logger = Logger.getLogger(WaitHelper.class);
    private final static int PAGE_LOAD_TIME_OUT = 45;
    private final static int POP_UP_LOAD_TIME_OUT = 2;

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
        waitHelper(pageLoaderElement, PAGE_LOAD_TIME_OUT, "WAITING PAGE LOAD");
    }

    public static void waitForPopUpShown(SCWebElement popUpUniqueElement){
       waitHelper(popUpUniqueElement, POP_UP_LOAD_TIME_OUT, "WAITING FOR POPUP");
    }

    private static void waitHelper(SCWebElement element, int timeOut, String logMessage){
        logger.info(logMessage + " ::: " + element.getName());
        new WebDriverWait(TestSession.getWebDriver(),
                timeOut).until(ExpectedConditions.visibilityOfElementLocated(element.getBy()));
    }

}

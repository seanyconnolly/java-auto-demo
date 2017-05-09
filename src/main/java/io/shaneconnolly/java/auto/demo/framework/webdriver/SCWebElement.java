package io.shaneconnolly.java.auto.demo.framework.webdriver;

import io.shaneconnolly.java.auto.demo.framework.TestSession;
import io.shaneconnolly.java.auto.demo.framework.customexceptions.CustomElementNoFoundException;
import io.shaneconnolly.java.auto.demo.framework.customexceptions.CustomTimeOutException;
import lombok.Data;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Data
public class SCWebElement extends RemoteWebElement {

    static Logger logger = Logger.getLogger(SCWebElement.class);

    private String name;
    private By by;
    private WebElement origWebElement;
    private String type;

    public SCWebElement(String name, String css) throws Exception {
        try {
            this.name = name;
            this.by = By.cssSelector(css);
            new WebDriverWait(TestSession.getWebDriver(), 15).until(ExpectedConditions.visibilityOfElementLocated(this.by));
            this.origWebElement = TestSession.getWebDriver().findElement(this.by);
        } catch (NoSuchElementException ex) {
            logger.info("COULD NOT FIND :: " + this.name);
            logger.error("BY :: " + this.by.toString());
            throw new CustomElementNoFoundException(this.name);
        } catch (TimeoutException tEx) {
            logger.info("COULD NOT FIND :: " + this.name);
            logger.error("BY :: " + this.by.toString());
            throw new CustomTimeOutException(this.name);
        }
    }

    public boolean doClick() {
        logger.info("CLICKING :: " + this.name);
        try {
            this.origWebElement.click();
            return true;
        } catch (NullPointerException ex) {
            logger.info("ISSUE CLICKING :: " + this.name);
            return false;
        }
    }


    private void setType() {
        if (this.name.contains("btn")) {
            this.type = "BUTTON";
        } else if (this.name.contains("label")) {
            this.type = "LABEL";
        }
    }

}
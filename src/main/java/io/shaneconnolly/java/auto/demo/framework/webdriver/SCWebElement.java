package io.shaneconnolly.java.auto.demo.framework.webdriver;

import io.shaneconnolly.java.auto.demo.framework.TestSession;
import io.shaneconnolly.java.auto.demo.framework.customexceptions.CustomElementNotFoundException;
import io.shaneconnolly.java.auto.demo.framework.customexceptions.CustomTimeOutException;
import lombok.Data;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;


import java.util.Optional;

@Data
public class SCWebElement extends RemoteWebElement {

    static Logger logger = Logger.getLogger(SCWebElement.class);

    private String name;
    private By by;
    private Optional<WebElement> origWebElement;
    private String type;

    public SCWebElement(String name, String css) throws Exception {
        try {
            this.name = name;
            this.by = By.cssSelector(css);
            this.origWebElement = Optional.of(TestSession.getWebDriver().findElement(this.by));
        } catch (NoSuchElementException ex) {
            logger.info("COULD NOT FIND :: " + this.name);
            logger.error("BY :: " + this.by.toString());
            throw new CustomElementNotFoundException(this.name);
        } catch (TimeoutException tEx) {
            logger.info("COULD NOT FIND :: " + this.name);
            logger.error("BY :: " + this.by.toString());
            throw new CustomTimeOutException(this.name);
        }
    }

    public boolean doClick() {
        logger.info("CLICKING :: " + this.name);
         if(this.origWebElement.isPresent()) {
             this.origWebElement.get().click();
            return true;
         } else {
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

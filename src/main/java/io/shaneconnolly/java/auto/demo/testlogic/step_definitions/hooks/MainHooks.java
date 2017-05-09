package io.shaneconnolly.java.auto.demo.testlogic.step_definitions.hooks;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.shaneconnolly.java.auto.demo.framework.SCScenario;
import io.shaneconnolly.java.auto.demo.framework.TestSession;
import io.shaneconnolly.java.auto.demo.framework.webdriver.BrowserDriver;
import org.apache.log4j.Logger;


/**
 * Created by ubuntu on 09/05/17.
 */
public class MainHooks {
    final static Logger logger = Logger.getLogger(MainHooks.class);

    @Before
    public void beforeScenario(Scenario scenario) {
        logger.debug("Before");
        BrowserDriver.setWebDriver();
        TestSession.setScenario(new SCScenario(scenario));
    }

    @After
    public void afterScenario() {
        logger.debug("Finished ::: " + TestSession.getScenario().isError());
        TestSession.getWebDriver().quit();
    }



}

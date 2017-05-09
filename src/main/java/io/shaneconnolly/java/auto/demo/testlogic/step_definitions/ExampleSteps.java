package io.shaneconnolly.java.auto.demo.testlogic.step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.shaneconnolly.java.auto.demo.framework.TestSession;
import io.shaneconnolly.java.auto.demo.framework.helpers.WaitHelper;
import io.shaneconnolly.java.auto.demo.testlogic.actions.DocsHomeActions;
import io.shaneconnolly.java.auto.demo.testlogic.pages.DocsHomePage;
import org.apache.log4j.Logger;

/**
 * Created by ubuntu on 09/05/17.
 */
public class ExampleSteps {

    final static Logger logger = Logger.getLogger(ExampleSteps.class);

    @Given("^I am on the Google Docs Page$")
    public void i_am_on_the_Google_Docs_Page() throws Throwable {
        logger.info("Given Step");
        TestSession.getWebDriver().get("https://www.google.com/docs/about");
        WaitHelper.waitForPageLoad(DocsHomePage.divPageLoad());
    }

    @When("^I launch Sheets Application$")
    public void i_launch_Sheets_Application() throws Throwable {
        DocsHomeActions.selectSheets();
    }

    @Then("^I verify Account Login Shown$")
    public void i_verify_Account_Login_Shown() throws Throwable {
        logger.info("Then I GO");
        WaitHelper.staticWait(10);
    }

}

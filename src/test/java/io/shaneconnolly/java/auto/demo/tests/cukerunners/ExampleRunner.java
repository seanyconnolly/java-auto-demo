package io.shaneconnolly.java.auto.demo.tests.cukerunners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by ubuntu on 09/05/17.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"io.shaneconnolly.java.auto.demo.testlogic.step_definitions" },
        features = {"src/main/resources/features/demofeatures/example.feature"},
        format = {"pretty"}
)
public class ExampleRunner {

}

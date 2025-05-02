package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.example.stepdefinitions",
        plugin = {
                "pretty",
                "json:target/cucumber.json",
                "html:target/cucumber-report.html",
                "junit:target/cucumber.xml"
        },
        monochrome = true
                )

public class RunnerTest {

}

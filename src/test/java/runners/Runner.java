package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",

        },
        features = "./src/test/resources/",
        glue = {"stepDefinitions", "Hooks"},
        tags = "@signInBBN",
        dryRun = false
)
public class Runner extends AbstractTestNGCucumberTests {

}

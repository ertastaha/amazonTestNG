package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-reports2.html",
                "json:target/json-reports/cucumber2.json",
                "junit:target/xml-report/cucumber2.xml",

        },
        features = "./src/test/resources/",
        glue = {"stepDefinitions", "hooks"},
        tags = "@registerEmpty",
        dryRun = false
)
public class E2ETestRunner extends AbstractTestNGCucumberTests {


}

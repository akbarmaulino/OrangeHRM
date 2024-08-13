package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature",
        glue = {"steps"},
        monochrome = true,
//        plugin = {"pretty", "html:target/HTMLReports.html"},
        plugin = {"json:target/cucumber.json"}
)

public class runner {
}




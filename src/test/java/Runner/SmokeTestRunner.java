package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.lang.reflect.Field;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue="StepDefinitions",
        monochrome = true,
        dryRun =false,
        tags ={ "@smoke ","@negative"}

)

public class SmokeTestRunner {
    // i want to run all feature file or scenarios which have a smoke tag (annotation)


}

package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/resources/com.Orange/orangehrm.feature",
            glue = "",
            monochrome = false,
            dryRun =false
    )
    public class OrangeRunner{

    }


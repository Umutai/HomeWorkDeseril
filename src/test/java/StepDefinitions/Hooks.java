package StepDefinitions;

import Utils.BrowserUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.fr.Sachant;

import java.io.IOException;

public class Hooks {
    // kind of test Base
    // We  Have before and AFTER annotations.
    //those are coming from Cucumber .
    //They will run before and after each Scenario
    //We have one scenario interface to get the details from every scenario

    @Before
    public  void  setUp(Scenario scenario){
        System.out.println("This will run before each scenario");
        System.out.println(scenario.getName());
    }
    @After
    public  void tearDown(Scenario scenario) throws IOException {
        System.out.println("This one will run after each scenario");
        // after annotation will execute after each scenario  even though they are failed ,undefined .
        if (scenario.isFailed()){
            System.out.println("failed");
            //scenario.log(scenario.getName()+" is failed");
            BrowserUtils.takeScreenshot();
        }

    }
    // im saying run this Before annotation if the scenaroi has @tt
    @Before("@tt")
    public  void conditionalAnnotation(){
        //i want to run this annotation only before @conditioanl tag
        System.out.println("Conditional Annotation");
        // it will run only the scenario which has @conditional tag

    }
}

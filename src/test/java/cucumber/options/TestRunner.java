package cucumber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)

@CucumberOptions(
	    features = "src/test/java/Features",
	    glue = {"MyStepDef"}, 
	    plugin = "json:target/jsonreports/cucumber-report.json" 
	    
	    // tags = "@DeletePlace"
	)

public class TestRunner {
	
	
}









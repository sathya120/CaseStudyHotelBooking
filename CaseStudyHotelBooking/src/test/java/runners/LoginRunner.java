package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src//main//resources//features//LoginPage.feature",
        glue= {"stepdefs"},
        monochrome=true,
        plugin= {"pretty",
                "com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"       
        }               
        )

public class LoginRunner {

}

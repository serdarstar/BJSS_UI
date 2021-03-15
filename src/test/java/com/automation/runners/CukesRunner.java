package com.automation.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports"
        },  //to add an HTML report
        features = "src/test/resources/features",
        glue = "com/automation/step_definitions",
        dryRun = false,
        tags = "@wip"
        //tags = "@driver and @VYT-123" //tags = {"@driver", "@VYT-123"}  ->old version
        //tags = "@driver or @VYT-123"   -> this is the OR version   old version-> tags = "@driver, @store_manager"
        //tags = "@login and not @wip" ->to exclude the ones that has the @wip tag(work in process).
        // we can add other scenarios with "and not"
)
public class CukesRunner {

}

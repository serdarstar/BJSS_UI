package com.automation.step_definitions;

import com.automation.utilities.DBUtils;
import com.automation.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before
    public void setUp(){
        System.out.println("\tThis is coming from before");
    }

    @After
    public void tearDown(Scenario scenario) {

        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        Driver.closeDriver();
    }

    @Before("@db")
    public void setUpdb(){

        System.out.println("\tconnecting to database...");
        DBUtils.createConnection();
    }
//@db tags are triggered if we write them on a scenario just like the other tags
    @After("@db")
    public void closeDb(){
        System.out.println("\tdisconnecting to database...");
        DBUtils.destroy();

    }

}

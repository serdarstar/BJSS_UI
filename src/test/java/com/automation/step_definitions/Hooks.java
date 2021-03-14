package com.automation.step_definitions;

import com.automation.pages.BasePage;
import com.automation.pages.HomePage;
import com.automation.pages.SignInPage;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before
    public void setUp(){
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String url = ConfigurationReader.get("url");
        String email = ConfigurationReader.get("email");
        String password = ConfigurationReader.get("password");
        Driver.get().get(url);
        Driver.get().manage().window().maximize();
        SignInPage signInPage=new SignInPage();
        HomePage loginPage = new HomePage();
        loginPage.signIn.click();
        BrowserUtils.waitFor(3);
        signInPage.email.sendKeys(email);
        signInPage.password.sendKeys(password);
        signInPage.signIn.click();

    }


    @After
    public void tearDown(Scenario scenario) {

        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

        Driver.closeDriver();
    }



}

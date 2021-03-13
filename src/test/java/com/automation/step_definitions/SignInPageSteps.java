package com.automation.step_definitions;

import com.automation.pages.BasePage;
import com.automation.pages.MyAccountPage;
import com.automation.pages.SignInPage;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class SignInPageSteps extends BasePage {

    SignInPage signInPage=new SignInPage();
    MyAccountPage myAccountPage=new MyAccountPage();


    @When("the user logs in using email {string} and password {string}")
    public void theUserLogsInUsingEmailAndPassword(String email, String password) throws InterruptedException {

        signInPage.email.sendKeys(email);
        signInPage.password.sendKeys(password);
        signInPage.signIn.click();

        Thread.sleep(1000);
        myAccountPage.homeButton.click();
        Thread.sleep(1000);


    }
}

package com.automation.step_definitions;

import com.automation.pages.AccountInfo;
import com.automation.pages.BasePage;
import com.automation.pages.MyAccountPage;
import io.cucumber.java.en.When;

public class MyAccountSteps extends BasePage {
    AccountInfo accountInfo=new AccountInfo();
    MyAccountPage myAccountPage=new MyAccountPage();

    @When("the user fills out new account info")
    public void theUserFillsOutNewAccountInfo() throws InterruptedException {
        Thread.sleep(1000);
        myAccountPage.homeButton.click();
        Thread.sleep(2000);
    }
}

package com.automation.step_definitions;

import com.automation.pages.AccountInfo;
import com.automation.pages.BasePage;
import com.automation.pages.MyAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class MyAccountSteps extends BasePage {
    AccountInfo accountInfo=new AccountInfo();
    MyAccountPage myAccountPage=new MyAccountPage();
    String expectedOrderDate;
    String expectedMessage;

    @When("the user fills out new account info")
    public void theUserFillsOutNewAccountInfo() throws InterruptedException {
        Thread.sleep(1000);
        myAccountPage.homeButton.click();
        Thread.sleep(2000);
    }
    //-----------------------------------------------
    @When("the user clicks the Order history and Details button")
    public void theUserClicksTheOrderHistoryAndDetailsButton() {
        myAccountPage.orderHistoryButton.click();
    }

    @When("the user sees the order history")
    public void theUserSeesTheOrderHistory() {
        expectedOrderDate = myAccountPage.expectedOrderDate.getText();
    }

    @When("the user clicks the order reference")
    public void theUserClicksTheOrderReference() {
        myAccountPage.orderReference.click();
    }

    @Then("the user should see the same date as {string}")
    public void theUserShouldSeeTheSameDateAs(String actualOrderDate) {

        Assert.assertEquals(expectedOrderDate,actualOrderDate);

    }

    @Given("the user is on the dashboard page")
    public void theUserIsOnTheDashboardPage() {
    }

    @When("the user adds a comment")
    public void theUserAddsAComment() {

        Select dropdown = new Select(myAccountPage.dropdown);
        dropdown.selectByIndex(1);
        expectedMessage = "Great item.";
        myAccountPage.commentArea.sendKeys(expectedMessage);
        myAccountPage.sendButton.click();
    }

    @Then("the comment should be seen under the messages")
    public void theCommentShouldBeSeenUnderTheMessages() {

        String actualMessage = myAccountPage.messageText.getText();
        Assert.assertEquals(expectedMessage,actualMessage);

    }

    @Then("the user logs out")
    public void theUserLogsOut() {

    }
}

package com.automation.step_definitions;

import com.automation.pages.BasePage;
import com.automation.pages.ConfirmationPage;
import com.automation.pages.MyAccountPage;
import com.automation.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyAccountSteps extends BasePage {
    SimpleDateFormat formatter= new SimpleDateFormat("MM/dd/yyyy");
    Date date = new Date(System.currentTimeMillis());
    MyAccountPage myAccountPage=new MyAccountPage();
    String expectedOrderDate=formatter.format(date);
    String actualOrderDate;
    String expectedMessage;
    ConfirmationPage confirmationPage=new ConfirmationPage();


    @When("the user clicks the Order history and Details button")
    public void theUserClicksTheOrderHistoryAndDetailsButton()
    {

        myAccountPage.orderHistoryButton.click();
    }

    @When("the user sees the order history")
    public void theUserSeesTheOrderHistory() {
        actualOrderDate = myAccountPage.orderDate.getText() ;
    }

    @When("the user clicks the order reference")
    public void theUserClicksTheOrderReference() {
        myAccountPage.orderReference.click();
    }

    @Then("the user should see the same date as {string}")
    public void theUserShouldSeeTheSameDateAs(String date) {

        date=expectedOrderDate;
        Assert.assertEquals(date,actualOrderDate);

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

        BrowserUtils.waitForVisibility(confirmationPage.signOut,10);
        confirmationPage.signOut.click();

    }
}

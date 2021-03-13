package com.automation.step_definitions;

import com.automation.pages.*;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DBUtils;
import com.automation.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class HomePageSteps extends BasePage {

    HomePage homePage=new HomePage();
    @When("the user clicks on quick view")
    public void theUserClicksOnQuickView() throws InterruptedException {

        Actions actions=new Actions(Driver.get());
        actions.moveToElement(homePage.product1).perform();
        homePage.quickView.click();
        Thread.sleep(3000);
    }

    @When("the user changes the size of the item")
    public void theUserChangesTheSizeOfTheItem() {

        Select select=new Select(homePage.sizes);
        List <WebElement> sizes = select.getOptions();
        select.selectByVisibleText("M");

    }

    @When("the user adds the item to cart")
    public void theUserAddsTheItemToCart() {
        homePage.addToCart.click();
    }
}

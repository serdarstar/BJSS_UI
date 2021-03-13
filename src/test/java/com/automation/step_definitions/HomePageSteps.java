package com.automation.step_definitions;

import com.automation.pages.*;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DBUtils;
import com.automation.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HomePageSteps extends BasePage {

    public String size="";

    HomePage homePage=new HomePage();
    @When("the user clicks on quick view of item {int}")
    public void theUserClicksOnQuickView(int itemNo) throws InterruptedException {

        Actions actions=new Actions(Driver.get());
        actions.moveToElement(Driver.get().findElement(By.xpath("(//a[@class='product_img_link']/img)["+itemNo+"]"))).perform();
        Driver.get().findElement(By.xpath("(//span[.='Quick view'])["+itemNo+"]")).click();
       // homePage.quickView.click();
        Thread.sleep(3000);
    }

    @When("the user changes the size of the item")
    public void theUserChangesTheSizeOfTheItem() {

        Driver.get().switchTo().frame(1);
        Select select=new Select(homePage.sizes);
        select.selectByVisibleText("M");
        List<String> supplierNames = new ArrayList<String>();
        supplierNames.add(select.getFirstSelectedOption().getText());


    }

    @When("the user adds the item to cart")
    public void theUserAddsTheItemToCart() throws InterruptedException {
        homePage.addToCart.click();
    }

    @When("the user clicks on continue shopping")
    public void theUserClicksOnContinueShopping() {
        BrowserUtils.waitForVisibility(homePage.continueShopping,10);
        homePage.continueShopping.click();

        BrowserUtils.waitFor(3);

    }

    @When("the proceeds to checkout")
    public void theProceedsToCheckout() {
        homePage.proceedToCheckout.click();
    }
}

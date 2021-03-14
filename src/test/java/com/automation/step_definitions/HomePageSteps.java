package com.automation.step_definitions;

import com.automation.pages.*;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePageSteps extends BasePage {

    private static DecimalFormat df = new DecimalFormat("0.00");
    List<String> selectedSizes = new ArrayList<String>();
    List<Float> itemPrices = new ArrayList<>();

    HomePage homePage=new HomePage();
    CartSummaryPage cartSummaryPage=new CartSummaryPage();
    PaymentAddressPage paymentAddressPage=new PaymentAddressPage();
    PaymentShippingPage paymentShippingPage=new PaymentShippingPage();
    PaymentPage paymentPage=new PaymentPage();
    OrderSummaryPage orderSummaryPage =new OrderSummaryPage();
    ConfirmationPage confirmationPage=new ConfirmationPage();

    @When("the user clicks on quick view of the first item")
    public void theUserClicksOnQuickView() throws InterruptedException {

        Actions actions=new Actions(Driver.get());
        actions.moveToElement(homePage.product1).perform();
        homePage.quickView1.click();
    }

    @When("the user changes the size of the item to {string}")
    public void theUserChangesTheSizeOfTheItemTo(String size) {
        BrowserUtils.waitFor(1);
        Driver.get().switchTo().frame(1);
        Select select=new Select(homePage.sizes);
        select.selectByVisibleText(size);
        selectedSizes.add(select.getFirstSelectedOption().getText());
        itemPrices.add(Float.parseFloat(homePage.price.getText().replace("$","")));
    }


    @When("the user adds the item to cart")
    public void theUserAddsTheItemToCart() throws InterruptedException {
        BrowserUtils.waitForVisibility(homePage.addToCart,10);
        homePage.addToCart.click();
        BrowserUtils.waitFor(1);
    }

    @When("the user clicks on continue shopping")
    public void theUserClicksOnContinueShopping() {
        BrowserUtils.waitForVisibility(homePage.continueShopping,10);
        homePage.continueShopping.click();
        BrowserUtils.waitFor(1);

    }

    @When("the proceeds to checkout")
    public void theProceedsToCheckout() {
        BrowserUtils.waitForVisibility(homePage.proceedToCheckout,10);
        homePage.proceedToCheckout.click();
    }

    @When("the user adds second item to cart")
    public void theUserAddsSecondItemToCart() throws InterruptedException {
        Driver.get().switchTo().frame(1);
        Select select=new Select(homePage.sizes);
        selectedSizes.add(select.getFirstSelectedOption().getText());
        itemPrices.add(Float.parseFloat(homePage.price.getText().replace("$","")));
        selectedSizes.size();
        itemPrices.size();
        BrowserUtils.waitForVisibility(homePage.addToCart,10);
        homePage.addToCart.click();
        BrowserUtils.waitFor(1);
    }

    @When("the user clicks on quick view of the second item")
    public void theUserClicksOnQuickViewOfTheSecondItem() throws InterruptedException {

        Actions actions=new Actions(Driver.get());
        actions.moveToElement(homePage.product2).perform();
        homePage.quickView2.click();
        BrowserUtils.waitFor(1);
    }

    @Then("total price should be total of the items in the cart plus shipping")
    public void totalPriceShouldBeTotalOfTheItemsInTheCartPlusShipping() {
        float total= Float.parseFloat( cartSummaryPage.total.getText().replace("$",""));
        float shippingCost= Float.parseFloat( cartSummaryPage.shippingCost.getText().replace("$",""));
        float totalProduct= Float.parseFloat( cartSummaryPage.totalProduct.getText().replace("$",""));

        float expectedTotal=shippingCost+totalProduct;
        Assert.assertEquals(df.format(total),(df.format(expectedTotal)));

    }

    @Then("selected item sizes should be correct")
    public void selectedItemSizesShouldBeCorrect() {

       List<WebElement> actualSizes=cartSummaryPage.cartSummary.findElements(By.xpath("//a[contains(text(),'Size')]"));
       List<String> actualSizesList=new ArrayList<>();
        for (int i = 1; i < actualSizes.size(); i++) {
            String itemSize=actualSizes.get(i).getText().split(":")[2].replace(" ","");
            actualSizesList.add(itemSize);
        }
        Collections.sort(actualSizesList);

        Assert.assertEquals(actualSizesList,selectedSizes);

    }

    @Then("the prices of the items should be correct")
    public void thePricesOfTheItemsShouldBeCorrect() {

        List<WebElement> actualPrices=cartSummaryPage.cartSummary.findElements(By.xpath("//td[@class='cart_total']"));

        List<Float> actualPricesList=new ArrayList<>();
        for (int i = 0; i < actualPrices.size(); i++) {
            float itemPrice=Float.parseFloat(actualPrices.get(i).getText().replace("$",""));
            actualPricesList.add(itemPrice);
            System.out.println("itemPrice = " + itemPrice);
        }

        Assert.assertEquals(actualPricesList,itemPrices);

    }

    @Then("total products should be total of the added items")
    public void totalProductsShouldBeTotalOfTheAddedItems() {

        float totalProducts=0;
        for (int i = 0; i < itemPrices.size(); i++) {
            totalProducts+=itemPrices.get(i);
        }

        float actualTotal= Float.parseFloat( cartSummaryPage.totalProduct.getText().replace("$",""));

        System.out.println("totalProducts = " + df.format(totalProducts));
        System.out.println("actualTotal = " + actualTotal);

         Assert.assertEquals(df.format(totalProducts),df.format(actualTotal));
    }

    @Then("the user should be able to pay by wire")
    public void theUserShouldBeAbleToPayByWire() {
        BrowserUtils.waitForVisibility(cartSummaryPage.proceedToCheckout,10);
        cartSummaryPage.proceedToCheckout.click();

        BrowserUtils.waitForVisibility(paymentAddressPage.proceedToCheckout,10);
        paymentAddressPage.proceedToCheckout.click();

        BrowserUtils.waitForVisibility(paymentShippingPage.proceedToCheckout,10);
        paymentShippingPage.agreeToTerms.click();
        paymentShippingPage.proceedToCheckout.click();

        BrowserUtils.waitForVisibility(paymentPage.wireTransfer,10);
        paymentPage.wireTransfer.click();

        BrowserUtils.waitForVisibility(orderSummaryPage.confirmation,10);
        orderSummaryPage.confirmation.click();

        BrowserUtils.waitForVisibility(confirmationPage.signOut,10);
        confirmationPage.signOut.click();
     }
}

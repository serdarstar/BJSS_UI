package com.automation.pages;

import com.automation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentAddressPage {

    public PaymentAddressPage(){PageFactory.initElements(Driver.get(), this); }

    @FindBy(xpath="//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
    public WebElement proceedToCheckout;
}
